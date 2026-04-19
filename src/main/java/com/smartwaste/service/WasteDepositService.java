package com.smartwaste.service;

import com.smartwaste.dto.request.CreateWasteDepositRequest;
import com.smartwaste.dto.request.IoTDepositRequest;
import com.smartwaste.dto.response.WasteDepositResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service interface untuk manajemen setoran sampah.
 */
public interface WasteDepositService {

    /** Citizen membuat setoran baru via UI */
    WasteDepositResponse createDeposit(String citizenEmail, CreateWasteDepositRequest request);

    /** Robot/Smart bin membuat setoran via IoT endpoint */
    WasteDepositResponse createIoTDeposit(IoTDepositRequest request);

    /** Collector mengkonfirmasi setoran → poin dikreditkan ke wallet */
    WasteDepositResponse confirmDeposit(String depositId, String collectorEmail);

    /** Collector menolak setoran */
    WasteDepositResponse rejectDeposit(String depositId, String collectorEmail, String reason);

    /** Riwayat setoran citizen sendiri */
    Page<WasteDepositResponse> getMyDeposits(String citizenEmail, Pageable pageable);

    /** Semua setoran (admin/collector view) dengan filter tanggal opsional */
    Page<WasteDepositResponse> getAllDeposits(java.time.LocalDateTime startDate, java.time.LocalDateTime endDate, Pageable pageable);

    /** Setoran yang pending (untuk collector) */
    Page<WasteDepositResponse> getPendingDeposits(Pageable pageable);

    WasteDepositResponse getById(String depositId);

    long countByCollector(com.smartwaste.entity.Collector collector);
    long countByCollectorAndStatus(com.smartwaste.entity.Collector collector, com.smartwaste.entity.enums.DepositStatus status);
}
