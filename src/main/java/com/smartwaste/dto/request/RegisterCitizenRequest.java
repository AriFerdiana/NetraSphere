package com.smartwaste.dto.request;

import jakarta.validation.constraints.*;

/**
 * DTO untuk registrasi warga (Citizen) baru.
 */
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

    public RegisterCitizenRequest() {}

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getNik() { return nik; }
    public void setNik(String nik) { this.nik = nik; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public String getRtRw() { return rtRw; }
    public void setRtRw(String rtRw) { this.rtRw = rtRw; }
    public String getKelurahan() { return kelurahan; }
    public void setKelurahan(String kelurahan) { this.kelurahan = kelurahan; }
}
