package com.smartwaste.strategy;

import com.smartwaste.entity.WasteCategory;
import org.springframework.stereotype.Component;

/**
 * Strategy untuk perhitungan poin sampah ANORGANIK.
 *
 * <p><b>OOP Concept — Polymorphism:</b>
 * Implementasi kedua dari {@link PointCalculatorStrategy}. Multiplier 1.5x
 * memberikan bonus 50% lebih banyak dibanding organik sebagai insentif warga
 * untuk memilah dan menyetor sampah anorganik yang sulit terurai.</p>
 *
 * <p>Jenis sampah: botol plastik, kaleng aluminium, kertas, kardus,
 * kaca, karet, logam campuran, dll.</p>
 *
 * <p>Formula: {@code poin = weightKg × category.pointsPerKg × 1.5}</p>
 *
 * <p>Contoh: 2 kg botol plastik (pointsPerKg = 10.0)
 * → 2 × 10.0 × 1.5 = <b>30 poin</b></p>
 */
@Component
public class InorganicPointCalculator implements PointCalculatorStrategy {

    /**
     * Multiplier bonus 50% untuk sampah anorganik.
     * Memberikan insentif lebih tinggi karena sampah ini memerlukan
     * proses daur ulang khusus dan lebih sulit terurai secara alami.
     */
    private static final double INORGANIC_MULTIPLIER = 1.5;

    /**
     * Menghitung poin untuk setoran sampah anorganik.
     *
     * @param weightKg berat sampah anorganik dalam kilogram
     * @param category kategori sampah dengan pointsPerKg
     * @return poin dengan bonus 1.5x multiplier
     */
    @Override
    public double calculatePoints(double weightKg, WasteCategory category) {
        if (weightKg <= 0 || category == null) {
            return 0.0;
        }
        return Math.round(weightKg * category.getPointsPerKg() * INORGANIC_MULTIPLIER * 100.0) / 100.0;
    }

    @Override
    public String getStrategyName() {
        return "INORGANIC_CALCULATOR";
    }
}
