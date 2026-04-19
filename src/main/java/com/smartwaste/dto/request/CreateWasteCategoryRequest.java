package com.smartwaste.dto.request;

import jakarta.validation.constraints.*;
import lombok.Data;

/**
 * DTO untuk membuat kategori sampah baru via REST API.
 * Menggantikan @RequestParam scattered — best practice menggunakan @RequestBody + DTO.
 */
@Data
public class CreateWasteCategoryRequest {

    @NotBlank(message = "Nama kategori tidak boleh kosong")
    @Size(max = 100, message = "Nama maksimal 100 karakter")
    private String name;

    private String description;

    @NotBlank(message = "Tipe sampah wajib diisi (ORGANIC / INORGANIC / B3)")
    private String type;

    @Positive(message = "Poin per kg harus lebih dari 0")
    private double pointsPerKg;

    private String iconUrl;
}
