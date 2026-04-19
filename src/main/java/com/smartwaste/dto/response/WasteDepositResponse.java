package com.smartwaste.dto.response;

import com.smartwaste.entity.enums.DepositStatus;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * DTO response transaksi setoran sampah.
 */
@Data
@Builder
public class WasteDepositResponse {

    private String id;
    private String citizenName;
    private String citizenId;
    private String categoryName;
    private String categoryType;  // WasteType as string
    private String collectorName;
    private double weightKg;
    private double pointsEarned;
    private DepositStatus status;
    private String notes;
    private String imageUrl;
    private boolean fromIoT;
    private String iotDeviceId;
    private String location;
    private LocalDateTime confirmedAt;
    private LocalDateTime createdAt;

    /** Label status dalam Bahasa Indonesia untuk UI */
    public String getStatusLabel() {
        if (status == null) return "-";
        return switch (status) {
            case PENDING   -> "Menunggu Konfirmasi";
            case CONFIRMED -> "Dikonfirmasi";
            case REJECTED  -> "Ditolak";
        };
    }
}
