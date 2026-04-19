package com.smartwaste.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO response setelah login/register sukses.
 * Berisi JWT token dan informasi dasar user.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse {

    private String token;

    @Builder.Default
    private String tokenType = "Bearer";

    private String userId;
    private String name;
    private String email;
    private String role;
    private long expiresIn; // dalam milidetik
}
