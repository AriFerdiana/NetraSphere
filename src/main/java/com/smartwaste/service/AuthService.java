package com.smartwaste.service;

import com.smartwaste.dto.request.LoginRequest;
import com.smartwaste.dto.request.RegisterCitizenRequest;
import com.smartwaste.dto.response.AuthResponse;

/**
 * Service interface untuk autentikasi.
 * OOP: Interface memisahkan kontrak dari implementasi.
 */
public interface AuthService {
    AuthResponse register(RegisterCitizenRequest request);
    AuthResponse login(LoginRequest request);
    void changePassword(String email, String oldPassword, String newPassword);
}
