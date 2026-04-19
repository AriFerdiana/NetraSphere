package com.smartwaste.dto.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * DTO response profil citizen — TIDAK mengekspos password dan data sensitif lainnya.
 * Encapsulation: entity tidak pernah dikembalikan langsung ke client.
 */
@Data
@Builder
public class CitizenProfileResponse {

    private String id;
    private String name;
    private String email;
    private String phone;
    private String nik;
    private String address;
    private String rtRw;
    private String kelurahan;
    private boolean active;
    private LocalDateTime createdAt;

    // Wallet summary (embedded untuk efisiensi)
    private Double totalPoints;
    private Double availablePoints;
    private Double redeemedPoints;
    private Long totalDeposits;
    private Double totalWeightKg;
}
