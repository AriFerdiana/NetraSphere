package com.smartwaste.dto.request;

import jakarta.validation.constraints.*;
import lombok.Data;

/**
 * DTO untuk membuat setoran sampah baru dari UI citizen.
 */
@Data
public class CreateWasteDepositRequest {

    @NotBlank(message = "Kategori sampah harus dipilih")
    private String categoryId;

    @NotNull(message = "Berat sampah tidak boleh kosong")
    @DecimalMin(value = "0.1", message = "Berat minimal 0.1 kg")
    @DecimalMax(value = "1000.0", message = "Berat maksimal 1000 kg per setoran")
    private Double weightKg;

    @Size(max = 500, message = "Catatan maksimal 500 karakter")
    private String notes;

    private String imageUrl;
}
