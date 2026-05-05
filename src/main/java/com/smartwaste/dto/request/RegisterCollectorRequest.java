package com.smartwaste.dto.request;

import jakarta.validation.constraints.*;

/**
 * DTO untuk registrasi Collector baru.
 */
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

    public RegisterCollectorRequest() {}

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getVehicleNumber() { return vehicleNumber; }
    public void setVehicleNumber(String vehicleNumber) { this.vehicleNumber = vehicleNumber; }
    public String getAssignedArea() { return assignedArea; }
    public void setAssignedArea(String assignedArea) { this.assignedArea = assignedArea; }
}
