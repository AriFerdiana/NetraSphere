package com.smartwaste.dto.request;

import jakarta.validation.constraints.*;
import lombok.Data;

/**
 * DTO untuk registrasi Collector baru oleh Admin.
 */
@Data
public class RegisterCollectorRequest {

    @NotBlank(message = "Nama tidak boleh kosong")
    @Size(min = 2, max = 100)
    private String name;

    @NotBlank(message = "Email tidak boleh kosong")
    @Email(message = "Format email tidak valid")
    private String email;

    @NotBlank(message = "Password tidak boleh kosong")
    @Size(min = 8, message = "Password minimal 8 karakter")
    private String password;

    @Pattern(regexp = "^[0-9]{10,13}$", message = "Format nomor telepon tidak valid (10-13 digit)")
    private String phone;

    private String vehicleNumber;

    @Size(max = 200)
    private String assignedArea;
}
