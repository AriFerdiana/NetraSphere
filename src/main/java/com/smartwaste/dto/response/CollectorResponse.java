package com.smartwaste.dto.response;

import java.time.LocalDateTime;

/**
 * DTO Response untuk data Collector.
 */
public class CollectorResponse {
    private String id;
    private String name;
    private String email;
    private String phone;
    private String vehicleNumber;
    private String assignedArea;
    private boolean available;
    private boolean iotDevice;
    private String iotDeviceId;
    private boolean active;
    private long totalConfirmed;
    private LocalDateTime createdAt;

    public CollectorResponse() {}

    public static CollectorResponseBuilder builder() {
        return new CollectorResponseBuilder();
    }

    public static class CollectorResponseBuilder {
        private CollectorResponse r = new CollectorResponse();
        public CollectorResponseBuilder id(String id) { r.id = id; return this; }
        public CollectorResponseBuilder name(String name) { r.name = name; return this; }
        public CollectorResponseBuilder email(String email) { r.email = email; return this; }
        public CollectorResponseBuilder phone(String phone) { r.phone = phone; return this; }
        public CollectorResponseBuilder vehicleNumber(String vehicleNumber) { r.vehicleNumber = vehicleNumber; return this; }
        public CollectorResponseBuilder assignedArea(String assignedArea) { r.assignedArea = assignedArea; return this; }
        public CollectorResponseBuilder available(boolean available) { r.available = available; return this; }
        public CollectorResponseBuilder iotDevice(boolean iotDevice) { r.iotDevice = iotDevice; return this; }
        public CollectorResponseBuilder iotDeviceId(String iotDeviceId) { r.iotDeviceId = iotDeviceId; return this; }
        public CollectorResponseBuilder active(boolean active) { r.active = active; return this; }
        public CollectorResponseBuilder totalConfirmed(long totalConfirmed) { r.totalConfirmed = totalConfirmed; return this; }
        public CollectorResponseBuilder createdAt(LocalDateTime createdAt) { r.createdAt = createdAt; return this; }
        public CollectorResponse build() { return r; }
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getVehicleNumber() { return vehicleNumber; }
    public void setVehicleNumber(String vehicleNumber) { this.vehicleNumber = vehicleNumber; }
    public String getAssignedArea() { return assignedArea; }
    public void setAssignedArea(String assignedArea) { this.assignedArea = assignedArea; }
    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }
    public boolean isIotDevice() { return iotDevice; }
    public void setIotDevice(boolean iotDevice) { this.iotDevice = iotDevice; }
    public String getIotDeviceId() { return iotDeviceId; }
    public void setIotDeviceId(String iotDeviceId) { this.iotDeviceId = iotDeviceId; }
    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
    public long getTotalConfirmed() { return totalConfirmed; }
    public void setTotalConfirmed(long totalConfirmed) { this.totalConfirmed = totalConfirmed; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
