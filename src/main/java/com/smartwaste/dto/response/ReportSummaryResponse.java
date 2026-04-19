package com.smartwaste.dto.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * DTO response laporan ringkasan sistem (untuk Admin Dashboard).
 */
@Data
@Builder
public class ReportSummaryResponse {

    // Statistik Keseluruhan
    private long totalCitizens;
    private long totalCollectors;
    private long totalDeposits;
    private long pendingDeposits;
    private long confirmedDeposits;
    private double totalWeightKg;
    private double totalPointsDistributed;

    // Breakdown per kategori
    private Map<String, Double> weightByCategory;    // categoryName -> totalWeightKg
    private Map<String, Long> depositsByCategory;    // categoryName -> count

    // Statistik bulanan (untuk grafik)
    private List<MonthlyStatDto> monthlyStats;

    // Top 5 Citizen by poin
    private List<CitizenLeaderboard> topCitizens;

    @Data
    @Builder
    public static class MonthlyStatDto {
        private String monthYear;  // "Jan 2024"
        private long depositCount;
        private double totalWeightKg;
        private double totalPoints;
    }

    @Data
    @Builder
    public static class CitizenLeaderboard {
        private String name;
        private double totalPoints;
        private long totalDeposits;
        private String level;
    }
}
