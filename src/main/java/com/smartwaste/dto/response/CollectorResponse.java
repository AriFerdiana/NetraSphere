package com.smartwaste.dto.response;

import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;

/**
 * DTO Response untuk data Collector.
 */
@Data
@Builder
public class CollectorResponse {
    private String id;
    private String name;
    private String email;
    private String phone;
    private String vehicleNumber;
    private String assignedArea;
    private boolean available;
    private boolean iotDevice;
    private String iotDeviceId;
    private boolean active;
    private long totalConfirmed;
    private LocalDateTime createdAt;
}
