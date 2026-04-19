package com.smartwaste.service.impl;

import com.smartwaste.dto.response.WalletResponse;
import com.smartwaste.entity.Citizen;
import com.smartwaste.entity.GreenWallet;
import com.smartwaste.entity.PointRedemption;
import com.smartwaste.entity.enums.RedemptionStatus;
import com.smartwaste.exception.ResourceNotFoundException;
import com.smartwaste.repository.CitizenRepository;
import com.smartwaste.repository.GreenWalletRepository;
import com.smartwaste.repository.PointRedemptionRepository;
import com.smartwaste.service.GreenWalletService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementasi service Green Wallet dengan alur approval yang benar.
 *
 * <p><b>OOP — Encapsulation:</b> Logika penambahan/pengurangan poin
 * dilakukan via method di entity ({@link GreenWallet#addPoints(double)} dan
 * {@link GreenWallet#redeemPoints(double)}), bukan langsung mengubah field.</p>
 *
 * <p><b>Alur Redemption yang Benar:</b>
 * <pre>
 *   Citizen request → PointRedemption[PENDING] → Admin review
 *       ├── approve → poin dikurangi dari wallet → [APPROVED]
 *       └── reject  → poin tetap utuh → [REJECTED]
 * </pre>
 * </p>
 */
@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class GreenWalletServiceImpl implements GreenWalletService {

    private final CitizenRepository citizenRepository;
    private final GreenWalletRepository walletRepository;
    private final PointRedemptionRepository redemptionRepository;

    @Override
    public WalletResponse getMyWallet(String citizenEmail) {
        Citizen citizen = citizenRepository.findByEmail(citizenEmail)
                .orElseThrow(() -> new ResourceNotFoundException("Citizen", "email", citizenEmail));
        GreenWallet wallet = walletRepository.findByCitizen(citizen)
                .orElseThrow(() -> new ResourceNotFoundException("GreenWallet", "citizenEmail", citizenEmail));
        return mapToResponse(wallet);
    }

    @Override
    public WalletResponse getWalletByCitizenId(String citizenId) {
        GreenWallet wallet = walletRepository.findByCitizenId(citizenId)
                .orElseThrow(() -> new ResourceNotFoundException("GreenWallet", "citizenId", citizenId));
        return mapToResponse(wallet);
    }

    /**
     * Mengajukan permintaan penukaran poin — POIN BELUM DIKURANGI.
     * Status PENDING sampai admin approve/reject.
     */
    @Override
    @Transactional
    public PointRedemption requestRedemption(String citizenEmail, double points, String description) {
        Citizen citizen = citizenRepository.findByEmail(citizenEmail)
                .orElseThrow(() -> new ResourceNotFoundException("Citizen", "email", citizenEmail));
        GreenWallet wallet = walletRepository.findByCitizen(citizen)
                .orElseThrow(() -> new ResourceNotFoundException("GreenWallet", "citizenEmail", citizenEmail));

        // Validasi saldo cukup sebelum request (tapi belum dikurangi)
        if (points > wallet.getAvailablePoints()) {
            throw new com.smartwaste.exception.InsufficientPointsException(points, wallet.getAvailablePoints());
        }
        if (points <= 0) {
            throw new IllegalArgumentException("Jumlah poin harus lebih dari 0.");
        }

        // Buat redemption request dengan status PENDING
        PointRedemption redemption = new PointRedemption(citizen, points, description);
        PointRedemption saved = redemptionRepository.save(redemption);
        log.info("Permintaan penukaran {} poin oleh {} — status PENDING", points, citizenEmail);
        return saved;
    }

    /**
     * Admin menyetujui penukaran — poin dikurangi sekarang.
     */
    @Override
    @Transactional
    public WalletResponse approveRedemption(String redemptionId, String adminNotes) {
        PointRedemption redemption = redemptionRepository.findById(redemptionId)
                .orElseThrow(() -> new ResourceNotFoundException("PointRedemption", "id", redemptionId));

        if (redemption.getStatus() != RedemptionStatus.PENDING) {
            throw new IllegalStateException("Hanya penukaran berstatus PENDING yang bisa disetujui.");
        }

        GreenWallet wallet = walletRepository.findByCitizen(redemption.getCitizen())
                .orElseThrow(() -> new ResourceNotFoundException("GreenWallet", "citizenId", redemption.getCitizen().getId()));

        // Kurangi poin dari wallet (encapsulation: validasi di dalam entity)
        wallet.redeemPoints(redemption.getPointsRedeemed());
        walletRepository.save(wallet);

        // Update status redemption
        redemption.setStatus(RedemptionStatus.APPROVED);
        redemption.setAdminNotes(adminNotes);
        redemption.setRewardCode("RWD-" + System.currentTimeMillis());
        redemptionRepository.save(redemption);

        log.info("Penukaran {} poin untuk {} disetujui.",
                redemption.getPointsRedeemed(), redemption.getCitizen().getEmail());

        return mapToResponse(wallet);
    }

    /**
     * Admin menolak penukaran — poin tetap utuh di wallet.
     */
    @Override
    @Transactional
    public WalletResponse rejectRedemption(String redemptionId, String adminNotes) {
        PointRedemption redemption = redemptionRepository.findById(redemptionId)
                .orElseThrow(() -> new ResourceNotFoundException("PointRedemption", "id", redemptionId));

        if (redemption.getStatus() != RedemptionStatus.PENDING) {
            throw new IllegalStateException("Hanya penukaran berstatus PENDING yang bisa ditolak.");
        }

        redemption.setStatus(RedemptionStatus.REJECTED);
        redemption.setAdminNotes(adminNotes != null ? adminNotes : "Ditolak oleh admin.");
        redemptionRepository.save(redemption);

        log.info("Penukaran {} poin untuk {} ditolak.",
                redemption.getPointsRedeemed(), redemption.getCitizen().getEmail());

        GreenWallet wallet = walletRepository.findByCitizen(redemption.getCitizen())
                .orElseThrow(() -> new ResourceNotFoundException("GreenWallet", "citizenId", redemption.getCitizen().getId()));
        return mapToResponse(wallet);
    }

    @Override
    public Page<PointRedemption> getPendingRedemptions(Pageable pageable) {
        return redemptionRepository.findByStatus(RedemptionStatus.PENDING, pageable);
    }

    @Override
    public Page<PointRedemption> getAllRedemptions(Pageable pageable) {
        return redemptionRepository.findAll(pageable);
    }

    @Override
    public Page<PointRedemption> getMyRedemptions(String citizenEmail, Pageable pageable) {
        Citizen citizen = citizenRepository.findByEmail(citizenEmail)
                .orElseThrow(() -> new ResourceNotFoundException("Citizen", "email", citizenEmail));
        return redemptionRepository.findByCitizen(citizen, pageable);
    }

    private WalletResponse mapToResponse(GreenWallet wallet) {
        return WalletResponse.builder()
                .walletId(wallet.getId())
                .citizenId(wallet.getCitizen().getId())
                .citizenName(wallet.getCitizen().getName())
                .totalPoints(wallet.getTotalPoints())
                .redeemedPoints(wallet.getRedeemedPoints())
                .availablePoints(wallet.getAvailablePoints())
                .build();
    }
}
