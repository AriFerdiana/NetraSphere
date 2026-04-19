package com.smartwaste.strategy;

import com.smartwaste.entity.WasteCategory;
import org.springframework.stereotype.Component;

/**
 * Strategy untuk perhitungan poin sampah ORGANIK.
 *
 * <p><b>OOP Concept — Polymorphism (Method Overriding / Interface Implementation):</b>
 * Mengimplementasikan {@link PointCalculatorStrategy} dengan multiplier 1.0x
 * untuk sampah organik (sisa makanan, daun, ranting, dll).</p>
 *
 * <p>Alasan multiplier 1.0 (tanpa bonus):
 * Sampah organik adalah yang paling umum dan paling mudah diproses
 * menjadi kompos — tidak memerlukan insentif ekstra.</p>
 *
 * <p>Formula: {@code poin = weightKg × category.pointsPerKg × 1.0}</p>
 *
 * <p>Contoh: 3 kg sampah daun (pointsPerKg = 5.0) → 3 × 5.0 × 1.0 = <b>15 poin</b></p>
 */
@Component
public class OrganicPointCalculator implements PointCalculatorStrategy {

    /**
     * Multiplier poin khusus untuk sampah organik.
     * Nilai 1.0 berarti tidak ada bonus tambahan.
     */
    private static final double ORGANIC_MULTIPLIER = 1.0;

    /**
     * Menghitung poin untuk setoran sampah organik.
     *
     * <p>Ini adalah implementasi konkret dari method abstract di interface —
     * demonstrasi <b>Runtime Polymorphism</b>.</p>
     *
     * @param weightKg berat sampah organik dalam kilogram
     * @param category kategori sampah organik dengan pointsPerKg
     * @return poin yang diperoleh (weightKg × pointsPerKg × 1.0)
     */
    @Override
    public double calculatePoints(double weightKg, WasteCategory category) {
        if (weightKg <= 0 || category == null) {
            return 0.0;
        }
        return Math.round(weightKg * category.getPointsPerKg() * ORGANIC_MULTIPLIER * 100.0) / 100.0;
    }

    @Override
    public String getStrategyName() {
        return "ORGANIC_CALCULATOR";
    }
}
