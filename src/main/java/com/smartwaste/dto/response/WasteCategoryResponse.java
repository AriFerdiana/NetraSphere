package com.smartwaste.dto.response;

import com.smartwaste.entity.enums.WasteType;

/**
 * DTO response kategori sampah.
 */
public class WasteCategoryResponse {

    private String id;
    private String name;
    private String description;
    private WasteType type;
    private String typeLabel;
    private double pointsPerKg;
    private String iconUrl;
    private boolean active;
    private long totalDeposits;

    public WasteCategoryResponse() {}

    public static WasteCategoryResponseBuilder builder() {
        return new WasteCategoryResponseBuilder();
    }

    public static class WasteCategoryResponseBuilder {
        private WasteCategoryResponse r = new WasteCategoryResponse();
        public WasteCategoryResponseBuilder id(String id) { r.id = id; return this; }
        public WasteCategoryResponseBuilder name(String name) { r.name = name; return this; }
        public WasteCategoryResponseBuilder description(String desc) { r.description = desc; return this; }
        public WasteCategoryResponseBuilder type(WasteType type) { r.type = type; return this; }
        public WasteCategoryResponseBuilder typeLabel(String label) { r.typeLabel = label; return this; }
        public WasteCategoryResponseBuilder pointsPerKg(double p) { r.pointsPerKg = p; return this; }
        public WasteCategoryResponseBuilder iconUrl(String url) { r.iconUrl = url; return this; }
        public WasteCategoryResponseBuilder active(boolean a) { r.active = a; return this; }
        public WasteCategoryResponseBuilder totalDeposits(long t) { r.totalDeposits = t; return this; }
        public WasteCategoryResponse build() { return r; }
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public WasteType getType() { return type; }
    public void setType(WasteType type) { this.type = type; }
    public String getTypeLabel() { return typeLabel; }
    public void setTypeLabel(String typeLabel) { this.typeLabel = typeLabel; }
    public double getPointsPerKg() { return pointsPerKg; }
    public void setPointsPerKg(double pointsPerKg) { this.pointsPerKg = pointsPerKg; }
    public String getIconUrl() { return iconUrl; }
    public void setIconUrl(String iconUrl) { this.iconUrl = iconUrl; }
    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
    public long getTotalDeposits() { return totalDeposits; }
    public void setTotalDeposits(long totalDeposits) { this.totalDeposits = totalDeposits; }
}
