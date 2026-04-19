package com.smartwaste.dto.response;

import lombok.Builder;
import lombok.Data;

/**
 * DTO response Green Wallet — saldo poin warga.
 */
@Data
@Builder
public class WalletResponse {

    private String walletId;
    private String citizenId;
    private String citizenName;
    private double totalPoints;
    private double redeemedPoints;
    private double availablePoints;

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
