package com.smartwaste.dto.request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * DTO untuk penukaran poin Green Wallet.
 */
@Data
public class RedeemPointsRequest {

    @NotNull(message = "Jumlah poin tidak boleh kosong")
    @DecimalMin(value = "10.0", message = "Minimum penukaran adalah 10 poin")
    private Double points;

    @NotBlank(message = "Deskripsi reward tidak boleh kosong")
    @Size(max = 500, message = "Deskripsi maksimal 500 karakter")
    private String description;
}
