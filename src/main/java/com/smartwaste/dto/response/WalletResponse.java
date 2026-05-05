package com.smartwaste.dto.response;

/**
 * DTO response Green Wallet — saldo poin warga.
 */
public class WalletResponse {

    private String walletId;
    private String citizenId;
    private String citizenName;
    private double totalPoints;
    private double redeemedPoints;
    private double availablePoints;

    public WalletResponse() {}

    public static WalletResponseBuilder builder() {
        return new WalletResponseBuilder();
    }

    public static class WalletResponseBuilder {
        private WalletResponse r = new WalletResponse();
        public WalletResponseBuilder walletId(String id) { r.walletId = id; return this; }
        public WalletResponseBuilder citizenId(String id) { r.citizenId = id; return this; }
        public WalletResponseBuilder citizenName(String name) { r.citizenName = name; return this; }
        public WalletResponseBuilder totalPoints(double p) { r.totalPoints = p; return this; }
        public WalletResponseBuilder redeemedPoints(double p) { r.redeemedPoints = p; return this; }
        public WalletResponseBuilder availablePoints(double p) { r.availablePoints = p; return this; }
        public WalletResponse build() { return r; }
    }

    public String getWalletId() { return walletId; }
    public void setWalletId(String walletId) { this.walletId = walletId; }
    public String getCitizenId() { return citizenId; }
    public void setCitizenId(String citizenId) { this.citizenId = citizenId; }
    public String getCitizenName() { return citizenName; }
    public void setCitizenName(String citizenName) { this.citizenName = citizenName; }
    public double getTotalPoints() { return totalPoints; }
    public void setTotalPoints(double totalPoints) { this.totalPoints = totalPoints; }
    public double getRedeemedPoints() { return redeemedPoints; }
    public void setRedeemedPoints(double redeemedPoints) { this.redeemedPoints = redeemedPoints; }
    public double getAvailablePoints() { return availablePoints; }
    public void setAvailablePoints(double availablePoints) { this.availablePoints = availablePoints; }

    /** Level gamifikasi berdasarkan total poin */
    public String getLevel() {
        if (totalPoints >= 10000) return "🏆 Platinum Eco Warrior";
        if (totalPoints >= 5000)  return "🥇 Gold Eco Hero";
        if (totalPoints >= 1000)  return "🥈 Silver Green Star";
        if (totalPoints >= 500)   return "🥉 Bronze Recycler";
        return "🌱 Green Starter";
    }

    /** Persentase menuju level berikutnya (untuk progress bar) */
    public int getProgressToNextLevel() {
        if (totalPoints >= 10000) return 100;
        if (totalPoints >= 5000)  return (int) ((totalPoints - 5000) / 50);
        if (totalPoints >= 1000)  return (int) ((totalPoints - 1000) / 40);
        if (totalPoints >= 500)   return (int) ((totalPoints - 500) / 5);
        return (int) (totalPoints / 5);
    }
}
