package com.smartwaste.dto.response;

import com.smartwaste.entity.enums.DepositStatus;
import java.time.LocalDateTime;

/**
 * DTO response transaksi setoran sampah.
 */
public class WasteDepositResponse {

    private String id;
    private String citizenName;
    private String citizenId;
    private String citizenPhone;
    private String categoryName;
    private String categoryType;  // WasteType as string
    private String collectorName;
    private double weightKg;
    private double pointsEarned;
    private double pointsPerKg;
    private DepositStatus status;
    private String notes;
    private String imageUrl;
    private String pickupProofUrl;
    private boolean fromIoT;
    private String iotDeviceId;
    private String location;
    private LocalDateTime confirmedAt;
    private LocalDateTime createdAt;
    private long citizenDepositCount;
    private double citizenTotalWeight;

    public WasteDepositResponse() {}

    public static WasteDepositResponseBuilder builder() {
        return new WasteDepositResponseBuilder();
    }

    public static class WasteDepositResponseBuilder {
        private WasteDepositResponse response = new WasteDepositResponse();

        public WasteDepositResponseBuilder id(String id) { response.id = id; return this; }
        public WasteDepositResponseBuilder citizenName(String name) { response.citizenName = name; return this; }
        public WasteDepositResponseBuilder citizenId(String id) { response.citizenId = id; return this; }
        public WasteDepositResponseBuilder citizenPhone(String phone) { response.citizenPhone = phone; return this; }
        public WasteDepositResponseBuilder categoryName(String name) { response.categoryName = name; return this; }
        public WasteDepositResponseBuilder categoryType(String type) { response.categoryType = type; return this; }
        public WasteDepositResponseBuilder collectorName(String name) { response.collectorName = name; return this; }
        public WasteDepositResponseBuilder weightKg(double weight) { response.weightKg = weight; return this; }
        public WasteDepositResponseBuilder pointsEarned(double points) { response.pointsEarned = points; return this; }
        public WasteDepositResponseBuilder pointsPerKg(double points) { response.pointsPerKg = points; return this; }
        public WasteDepositResponseBuilder status(DepositStatus status) { response.status = status; return this; }
        public WasteDepositResponseBuilder notes(String notes) { response.notes = notes; return this; }
        public WasteDepositResponseBuilder imageUrl(String url) { response.imageUrl = url; return this; }
        public WasteDepositResponseBuilder pickupProofUrl(String url) { response.pickupProofUrl = url; return this; }
        public WasteDepositResponseBuilder fromIoT(boolean fromIoT) { response.fromIoT = fromIoT; return this; }
        public WasteDepositResponseBuilder iotDeviceId(String id) { response.iotDeviceId = id; return this; }
        public WasteDepositResponseBuilder location(String loc) { response.location = loc; return this; }
        public WasteDepositResponseBuilder confirmedAt(LocalDateTime time) { response.confirmedAt = time; return this; }
        public WasteDepositResponseBuilder createdAt(LocalDateTime time) { response.createdAt = time; return this; }
        public WasteDepositResponseBuilder citizenDepositCount(long count) { response.citizenDepositCount = count; return this; }
        public WasteDepositResponseBuilder citizenTotalWeight(double weight) { response.citizenTotalWeight = weight; return this; }
        
        public WasteDepositResponse build() { return response; }
    }

    // Getters
    public String getId() { return id; }
    public String getCitizenName() { return citizenName; }
    public String getCitizenId() { return citizenId; }
    public String getCitizenPhone() { return citizenPhone; }
    public String getCategoryName() { return categoryName; }
    public String getCategoryType() { return categoryType; }
    public String getCollectorName() { return collectorName; }
    public double getWeightKg() { return weightKg; }
    public double getPointsEarned() { return pointsEarned; }
    public double getPointsPerKg() { return pointsPerKg; }
    public DepositStatus getStatus() { return status; }
    public String getNotes() { return notes; }
    public String getImageUrl() { return imageUrl; }
    public String getPickupProofUrl() { return pickupProofUrl; }
    public boolean isFromIoT() { return fromIoT; }
    public String getIotDeviceId() { return iotDeviceId; }
    public String getLocation() { return location; }
    public LocalDateTime getConfirmedAt() { return confirmedAt; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public long getCitizenDepositCount() { return citizenDepositCount; }
    public double getCitizenTotalWeight() { return citizenTotalWeight; }

    /** Label status dalam Bahasa Indonesia untuk UI */
    public String getStatusLabel() {
        if (status == null) return "-";
        return switch (status) {
            case PENDING   -> "Menunggu Konfirmasi";
            case CONFIRMED -> "Dikonfirmasi";
            case REJECTED  -> "Ditolak";
        };
    }
}
