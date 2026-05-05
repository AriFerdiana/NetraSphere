package com.smartwaste.dto.response;

import java.time.LocalDateTime;

/**
 * DTO response profil citizen.
 */
public class CitizenProfileResponse {

    private String id;
    private String name;
    private String email;
    private String phone;
    private String nik;
    private String address;
    private String rtRw;
    private String kelurahan;
    private boolean active;
    private LocalDateTime createdAt;

    // Wallet summary (embedded untuk efisiensi)
    private Double totalPoints;
    private Double availablePoints;
    private Double redeemedPoints;
    private Long totalDeposits;
    private Double totalWeightKg;

    public CitizenProfileResponse() {}

    public static CitizenProfileResponseBuilder builder() {
        return new CitizenProfileResponseBuilder();
    }

    public static class CitizenProfileResponseBuilder {
        private CitizenProfileResponse r = new CitizenProfileResponse();
        public CitizenProfileResponseBuilder id(String id) { r.id = id; return this; }
        public CitizenProfileResponseBuilder name(String name) { r.name = name; return this; }
        public CitizenProfileResponseBuilder email(String email) { r.email = email; return this; }
        public CitizenProfileResponseBuilder phone(String phone) { r.phone = phone; return this; }
        public CitizenProfileResponseBuilder nik(String nik) { r.nik = nik; return this; }
        public CitizenProfileResponseBuilder address(String address) { r.address = address; return this; }
        public CitizenProfileResponseBuilder rtRw(String rtRw) { r.rtRw = rtRw; return this; }
        public CitizenProfileResponseBuilder kelurahan(String kelurahan) { r.kelurahan = kelurahan; return this; }
        public CitizenProfileResponseBuilder active(boolean active) { r.active = active; return this; }
        public CitizenProfileResponseBuilder createdAt(LocalDateTime createdAt) { r.createdAt = createdAt; return this; }
        public CitizenProfileResponseBuilder totalPoints(Double totalPoints) { r.totalPoints = totalPoints; return this; }
        public CitizenProfileResponseBuilder availablePoints(Double availablePoints) { r.availablePoints = availablePoints; return this; }
        public CitizenProfileResponseBuilder redeemedPoints(Double redeemedPoints) { r.redeemedPoints = redeemedPoints; return this; }
        public CitizenProfileResponseBuilder totalDeposits(Long totalDeposits) { r.totalDeposits = totalDeposits; return this; }
        public CitizenProfileResponseBuilder totalWeightKg(Double totalWeightKg) { r.totalWeightKg = totalWeightKg; return this; }
        public CitizenProfileResponse build() { return r; }
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
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
    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public Double getTotalPoints() { return totalPoints; }
    public void setTotalPoints(Double totalPoints) { this.totalPoints = totalPoints; }
    public Double getAvailablePoints() { return availablePoints; }
    public void setAvailablePoints(Double availablePoints) { this.availablePoints = availablePoints; }
    public Double getRedeemedPoints() { return redeemedPoints; }
    public void setRedeemedPoints(Double redeemedPoints) { this.redeemedPoints = redeemedPoints; }
    public Long getTotalDeposits() { return totalDeposits; }
    public void setTotalDeposits(Long totalDeposits) { this.totalDeposits = totalDeposits; }
    public Double getTotalWeightKg() { return totalWeightKg; }
    public void setTotalWeightKg(Double totalWeightKg) { this.totalWeightKg = totalWeightKg; }
}
