package com.smartwaste.dto.response;

import com.smartwaste.entity.enums.RedemptionStatus;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * DTO Response untuk data PointRedemption.
 */
@Data
@Builder
public class PointRedemptionResponse {
    private String id;
    private String citizenId;
    private String citizenName;
    private String citizenEmail;
    private double pointsRedeemed;
    private RedemptionStatus status;
    private String description;
    private String rewardCode;
    private String adminNotes;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
