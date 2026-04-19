package com.smartwaste.dto.request;

import jakarta.validation.constraints.*;
import lombok.Data;

/**
 * DTO untuk setoran sampah dari perangkat IoT (smart bin / robot NetraDUMP).
 *
 * <p>Endpoint: POST /api/v1/iot/dump</p>
 * <p>Autentikasi via header X-IoT-Api-Key (bukan JWT).</p>
 */
@Data
public class IoTDepositRequest {

    @NotBlank(message = "Device ID tidak boleh kosong")
    private String deviceId;

    @NotBlank(message = "Citizen ID tidak boleh kosong")
    private String citizenId;

    @NotBlank(message = "Category ID tidak boleh kosong")
    private String categoryId;

    @NotNull(message = "Berat tidak boleh kosong")
    @DecimalMin(value = "0.01", message = "Berat minimal 0.01 kg")
    private Double weightKg;

    /** Koordinat GPS atau nama lokasi smart bin */
    private String location;

    /** Raw sensor data (JSON string opsional untuk audit) */
    @Size(max = 2000)
    private String sensorData;
}
