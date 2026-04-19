package com.smartwaste.service.impl;

import com.smartwaste.dto.response.ReportSummaryResponse;
import com.smartwaste.entity.GreenWallet;
import com.smartwaste.repository.CitizenRepository;
import com.smartwaste.repository.CollectorRepository;
import com.smartwaste.repository.GreenWalletRepository;
import com.smartwaste.repository.WasteDepositRepository;
import com.smartwaste.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static com.smartwaste.entity.enums.DepositStatus.*;

/**
 * Implementasi service laporan administratif.
 */
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReportServiceImpl implements ReportService {

    private final CitizenRepository citizenRepository;
    private final CollectorRepository collectorRepository;
    private final WasteDepositRepository depositRepository;
    private final GreenWalletRepository walletRepository;

    @Override
    public ReportSummaryResponse getSummary() {
        // Hitung statistik utama
        long totalCitizens = citizenRepository.countByActiveTrue();
        long totalCollectors = collectorRepository.countByActiveTrue();
        long totalDeposits = depositRepository.count();
        long pending = depositRepository.countByStatus(PENDING);
        long confirmed = depositRepository.countByStatus(CONFIRMED);
        double totalWeight = depositRepository.sumTotalWeightConfirmed();
        double totalPoints = depositRepository.sumTotalPointsDistributed();

        // Statistik bulanan
        List<ReportSummaryResponse.MonthlyStatDto> monthlyStats = new ArrayList<>();
        List<Object[]> rawMonthly = depositRepository.findMonthlyStats();
        for (Object[] row : rawMonthly) {
            monthlyStats.add(ReportSummaryResponse.MonthlyStatDto.builder()
                    .monthYear((String) row[0])
                    .depositCount(((Number) row[1]).longValue())
                    .totalWeightKg(row[2] != null ? ((Number) row[2]).doubleValue() : 0)
                    .totalPoints(row[3] != null ? ((Number) row[3]).doubleValue() : 0)
                    .build());
        }

        // Top 5 citizen berdasarkan poin
        List<ReportSummaryResponse.CitizenLeaderboard> topCitizens = new ArrayList<>();
        citizenRepository.findTopByPoints(PageRequest.of(0, 5)).forEach(c -> {
            GreenWallet w = walletRepository.findByCitizen(c).orElse(null);
            double pts = w != null ? w.getTotalPoints() : 0;
            long deps = depositRepository.findByCitizen(c, Pageable.unpaged()).getTotalElements();
            topCitizens.add(ReportSummaryResponse.CitizenLeaderboard.builder()
                    .name(c.getName())
                    .totalPoints(pts)
                    .totalDeposits(deps)
                    .level(getEcoLevel(pts))
                    .build());
        });

        // Breakdown per kategori
        java.util.Map<String, Double> weightByCategory = new java.util.HashMap<>();
        java.util.Map<String, Long> depositsByCategory = new java.util.HashMap<>();
        List<Object[]> categoryStats = depositRepository.findCategoryStats();
        for (Object[] row : categoryStats) {
            weightByCategory.put((String) row[0], ((Number) row[1]).doubleValue());
            depositsByCategory.put((String) row[0], ((Number) row[2]).longValue());
        }

        return ReportSummaryResponse.builder()
                .totalCitizens(totalCitizens)
                .totalCollectors(totalCollectors)
                .totalDeposits(totalDeposits)
                .pendingDeposits(pending)
                .confirmedDeposits(confirmed)
                .totalWeightKg(totalWeight)
                .totalPointsDistributed(totalPoints)
                .monthlyStats(monthlyStats)
                .topCitizens(topCitizens)
                .weightByCategory(weightByCategory)
                .depositsByCategory(depositsByCategory)
                .build();
    }

    private String getEcoLevel(double pts) {
        if (pts >= 10000) return "Platinum Eco Warrior";
        if (pts >= 5000)  return "Gold Eco Hero";
        if (pts >= 1000)  return "Silver Green Star";
        if (pts >= 500)   return "Bronze Recycler";
        return "Green Starter";
    }
}
