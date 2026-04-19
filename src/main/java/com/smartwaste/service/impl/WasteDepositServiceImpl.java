package com.smartwaste.service.impl;

import com.smartwaste.dto.request.CreateWasteDepositRequest;
import com.smartwaste.dto.request.IoTDepositRequest;
import com.smartwaste.dto.response.WasteDepositResponse;
import com.smartwaste.entity.*;
import com.smartwaste.entity.enums.DepositStatus;
import com.smartwaste.exception.ResourceNotFoundException;
import com.smartwaste.exception.UnauthorizedException;
import com.smartwaste.repository.*;
import com.smartwaste.service.WasteDepositService;
import com.smartwaste.strategy.PointCalculatorContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementasi service setoran sampah — logika bisnis terpenting dalam sistem.
 *
 * <p><b>OOP Concept — Polymorphism via Strategy Pattern:</b>
 * Method {@link #confirmDeposit} menggunakan {@link PointCalculatorContext}
 * untuk menghitung poin secara polimorfis berdasarkan tipe sampah.</p>
 */
@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class WasteDepositServiceImpl implements WasteDepositService {

    private final WasteDepositRepository depositRepository;
    private final CitizenRepository citizenRepository;
    private final CollectorRepository collectorRepository;
    private final WasteCategoryRepository categoryRepository;
    private final GreenWalletRepository walletRepository;
    private final PointCalculatorContext pointCalculatorContext; // Strategy Pattern

    @Value("${app.iot.api-key}")
    private String iotApiKey;

    // ==================== Create Deposit (Manual) ====================

    @Override
    @Transactional
    public WasteDepositResponse createDeposit(String citizenEmail, CreateWasteDepositRequest request) {
        Citizen citizen = citizenRepository.findByEmail(citizenEmail)
                .orElseThrow(() -> new ResourceNotFoundException("Citizen", "email", citizenEmail));
        WasteCategory category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("WasteCategory", "id", request.getCategoryId()));

        if (!category.isActive()) {
            throw new IllegalArgumentException("Kategori sampah ini sudah tidak aktif.");
        }

        WasteDeposit deposit = new WasteDeposit(citizen, category, request.getWeightKg(), request.getNotes());
        deposit.setImageUrl(request.getImageUrl());

        WasteDeposit saved = depositRepository.save(deposit);
        log.info("Setoran baru dibuat oleh {} - kategori: {}, berat: {} kg",
                citizenEmail, category.getName(), request.getWeightKg());

        return mapToResponse(saved);
    }

    // ==================== Create Deposit (IoT) ====================

    @Override
    @Transactional
    public WasteDepositResponse createIoTDeposit(IoTDepositRequest request) {
        // Temukan robot collector berdasarkan device ID
        Collector iotCollector = collectorRepository.findByIotDeviceId(request.getDeviceId())
                .orElseThrow(() -> new UnauthorizedException(
                        "Device IoT tidak terdaftar: " + request.getDeviceId()));

        Citizen citizen = citizenRepository.findById(request.getCitizenId())
                .orElseThrow(() -> new ResourceNotFoundException("Citizen", "id", request.getCitizenId()));
        WasteCategory category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("WasteCategory", "id", request.getCategoryId()));

        // Buat deposit IoT dan auto-konfirmasi (sensor sudah terverifikasi)
        WasteDeposit deposit = new WasteDeposit(
                citizen, category, request.getWeightKg(),
                request.getDeviceId(), request.getLocation()
        );

        // Hitung poin menggunakan Strategy Pattern (Polymorphism)
        double points = pointCalculatorContext.calculate(request.getWeightKg(), category);

        // Auto-konfirmasi karena dari perangkat IoT terpercaya
        deposit.confirm(iotCollector, points);

        // Kreditkan poin ke Green Wallet citizen
        GreenWallet wallet = walletRepository.findByCitizen(citizen)
                .orElseThrow(() -> new ResourceNotFoundException("GreenWallet", "citizenId", citizen.getId()));
        wallet.addPoints(points);
        walletRepository.save(wallet);

        WasteDeposit saved = depositRepository.save(deposit);
        log.info("IoT Deposit dari {} — citizen: {}, kategori: {}, poin: {}",
                request.getDeviceId(), citizen.getName(), category.getName(), points);

        return mapToResponse(saved);
    }

    // ==================== Confirm Deposit (Polymorphism — Strategy Pattern) ====================

    @Override
    @Transactional
    public WasteDepositResponse confirmDeposit(String depositId, String collectorEmail) {
        WasteDeposit deposit = depositRepository.findById(depositId)
                .orElseThrow(() -> new ResourceNotFoundException("WasteDeposit", "id", depositId));

        if (deposit.getStatus() != DepositStatus.PENDING) {
            throw new IllegalStateException(
                    "Hanya setoran berstatus PENDING yang bisa dikonfirmasi. Status saat ini: " + deposit.getStatus());
        }

        Collector collector = collectorRepository.findByEmail(collectorEmail)
                .orElseThrow(() -> new ResourceNotFoundException("Collector", "email", collectorEmail));

        // POLYMORPHISM VIA STRATEGY PATTERN
        // PointCalculatorContext memilih strategy yang tepat berdasarkan WasteType:
        //   ORGANIC   → OrganicPointCalculator  (1.0x)
        //   INORGANIC → InorganicPointCalculator (1.5x)
        //   B3        → B3PointCalculator        (2.0x + bonus)
        double points = pointCalculatorContext.calculate(
                deposit.getWeightKg(), deposit.getCategory());

        log.info("Menghitung poin dengan strategy: {}",
                pointCalculatorContext.getStrategyName(deposit.getCategory().getType()));

        // Konfirmasi deposit (encapsulated dalam entity method)
        deposit.confirm(collector, points);
        depositRepository.save(deposit);

        // Kreditkan poin ke GreenWallet citizen (Encapsulation: logika di entity)
        GreenWallet wallet = walletRepository.findByCitizen(deposit.getCitizen())
                .orElseThrow(() -> new ResourceNotFoundException("GreenWallet", "citizenId",
                        deposit.getCitizen().getId()));
        wallet.addPoints(points);
        walletRepository.save(wallet);

        log.info("Deposit {} dikonfirmasi. Poin {} dikreditkan ke wallet {}",
                depositId, points, deposit.getCitizen().getEmail());

        return mapToResponse(deposit);
    }

    // ==================== Reject Deposit ====================

    @Override
    @Transactional
    public WasteDepositResponse rejectDeposit(String depositId, String collectorEmail, String reason) {
        WasteDeposit deposit = depositRepository.findById(depositId)
                .orElseThrow(() -> new ResourceNotFoundException("WasteDeposit", "id", depositId));

        if (deposit.getStatus() != DepositStatus.PENDING) {
            throw new IllegalStateException("Hanya setoran berstatus PENDING yang bisa ditolak.");
        }

        Collector collector = collectorRepository.findByEmail(collectorEmail)
                .orElseThrow(() -> new ResourceNotFoundException("Collector", "email", collectorEmail));

        deposit.reject(collector, reason);
        depositRepository.save(deposit);
        return mapToResponse(deposit);
    }

    // ==================== Query Methods ====================

    @Override
    public Page<WasteDepositResponse> getMyDeposits(String citizenEmail, Pageable pageable) {
        Citizen citizen = citizenRepository.findByEmail(citizenEmail)
                .orElseThrow(() -> new ResourceNotFoundException("Citizen", "email", citizenEmail));
        return depositRepository.findByCitizen(citizen, pageable).map(this::mapToResponse);
    }

    @Override
    public Page<WasteDepositResponse> getAllDeposits(java.time.LocalDateTime startDate, java.time.LocalDateTime endDate, Pageable pageable) {
        if (startDate != null && endDate != null) {
            return depositRepository.findByCreatedAtBetween(startDate, endDate, pageable).map(this::mapToResponse);
        }
        return depositRepository.findAll(pageable).map(this::mapToResponse);
    }

    @Override
    public Page<WasteDepositResponse> getPendingDeposits(Pageable pageable) {
        return depositRepository.findByStatus(DepositStatus.PENDING, pageable).map(this::mapToResponse);
    }

    @Override
    public WasteDepositResponse getById(String depositId) {
        WasteDeposit deposit = depositRepository.findById(depositId)
                .orElseThrow(() -> new ResourceNotFoundException("WasteDeposit", "id", depositId));
        return mapToResponse(deposit);
    }

    // ==================== Mapper (Encapsulation) ====================

    /** Mapper: WasteDeposit entity → WasteDepositResponse DTO */
    private WasteDepositResponse mapToResponse(WasteDeposit deposit) {
        return WasteDepositResponse.builder()
                .id(deposit.getId())
                .citizenName(deposit.getCitizen().getName())
                .citizenId(deposit.getCitizen().getId())
                .categoryName(deposit.getCategory().getName())
                .categoryType(deposit.getCategory().getType().name())
                .collectorName(deposit.getCollector() != null ? deposit.getCollector().getName() : null)
                .weightKg(deposit.getWeightKg())
                .pointsEarned(deposit.getPointsEarned())
                .status(deposit.getStatus())
                .notes(deposit.getNotes())
                .imageUrl(deposit.getImageUrl())
                .fromIoT(deposit.isFromIoT())
                .iotDeviceId(deposit.getIotDeviceId())
                .location(deposit.getLocation())
                .confirmedAt(deposit.getConfirmedAt())
                .createdAt(deposit.getCreatedAt())
                .build();
    }

    @Override
    public long countByCollector(com.smartwaste.entity.Collector collector) {
        return depositRepository.countByCollector(collector);
    }

    @Override
    public long countByCollectorAndStatus(com.smartwaste.entity.Collector collector, DepositStatus status) {
        return depositRepository.countByCollectorAndStatus(collector, status);
    }
}
