package com.smartwaste.dto.request;

import jakarta.validation.constraints.*;
import lombok.Data;

/**
 * DTO untuk registrasi warga (Citizen) baru.
 * Encapsulation: semua field private, validasi via anotasi Bean Validation.
 */
@Data
public class RegisterCitizenRequest {

    @NotBlank(message = "Nama tidak boleh kosong")
    @Size(min = 2, max = 100, message = "Nama harus antara 2-100 karakter")
    private String name;

    @NotBlank(message = "Email tidak boleh kosong")
    @Email(message = "Format email tidak valid")
    private String email;

    @NotBlank(message = "Password tidak boleh kosong")
    @Size(min = 8, message = "Password minimal 8 karakter")
    private String password;

    @Pattern(regexp = "^[0-9]{10,13}$", message = "Format nomor telepon tidak valid (10-13 digit)")
    private String phone;

    @Size(min = 16, max = 16, message = "NIK harus tepat 16 digit")
    @Pattern(regexp = "^[0-9]{16}$", message = "NIK harus berupa 16 digit angka")
    private String nik;

    private String address;
    private String rtRw;
    private String kelurahan;
}
