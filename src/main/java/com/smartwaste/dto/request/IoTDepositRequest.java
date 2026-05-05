package com.smartwaste.dto.request;

import jakarta.validation.constraints.*;

/**
 * DTO untuk setoran sampah dari perangkat IoT.
 */
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

    public IoTDepositRequest() {}

    public String getDeviceId() { return deviceId; }
    public void setDeviceId(String deviceId) { this.deviceId = deviceId; }
    public String getCitizenId() { return citizenId; }
    public void setCitizenId(String citizenId) { this.citizenId = citizenId; }
    public String getCategoryId() { return categoryId; }
    public void setCategoryId(String categoryId) { this.categoryId = categoryId; }
    public Double getWeightKg() { return weightKg; }
    public void setWeightKg(Double weightKg) { this.weightKg = weightKg; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    public String getSensorData() { return sensorData; }
    public void setSensorData(String sensorData) { this.sensorData = sensorData; }
}
