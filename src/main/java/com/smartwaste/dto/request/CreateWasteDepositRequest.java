package com.smartwaste.dto.request;

import jakarta.validation.constraints.*;

/**
 * DTO untuk membuat setoran sampah baru dari UI citizen.
 */
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

    public CreateWasteDepositRequest() {}

    public String getCategoryId() { return categoryId; }
    public void setCategoryId(String categoryId) { this.categoryId = categoryId; }
    public Double getWeightKg() { return weightKg; }
    public void setWeightKg(Double weightKg) { this.weightKg = weightKg; }
    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
}
