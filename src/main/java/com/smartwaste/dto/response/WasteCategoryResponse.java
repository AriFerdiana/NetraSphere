package com.smartwaste.dto.response;

import com.smartwaste.entity.enums.WasteType;
import lombok.Builder;
import lombok.Data;

/**
 * DTO response kategori sampah.
 */
@Data
@Builder
public class WasteCategoryResponse {

    private String id;
    private String name;
    private String description;
    private WasteType type;
    private String typeLabel;
    private double pointsPerKg;
    private String iconUrl;
    private boolean active;
    private long totalDeposits;
}
