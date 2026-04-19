package com.smartwaste.strategy;

import com.smartwaste.entity.WasteCategory;
import org.springframework.stereotype.Component;

/**
 * Strategy untuk perhitungan poin sampah B3 (Bahan Berbahaya dan Beracun).
 *
 * <p><b>OOP Concept — Polymorphism:</b>
 * Implementasi ketiga dari {@link PointCalculatorStrategy}. Memberikan multiplier
 * tertinggi (2.0x) sebagai insentif paling signifikan untuk mendorong warga
 * menyetor sampah berbahaya ke tempat yang tepat daripada membuangnya sembarangan.</p>
 *
 * <p>Jenis sampah B3: baterai bekas, lampu neon/LED, elektronik rusak (e-waste),
 * cat bekas, oli motor, obat-obatan kadaluarsa, bahan kimia rumah tangga, dll.</p>
 *
 * <p>Formula: {@code poin = weightKg × category.pointsPerKg × 2.0}</p>
 *
 * <p>Contoh: 0.5 kg baterai bekas (pointsPerKg = 25.0)
 * → 0.5 × 25.0 × 2.0 = <b>25 poin</b></p>
 *
 * <p><b>Catatan Tambahan:</b> Untuk B3, ada bonus poin minimum karena bahkan
 * jumlah kecil pun sangat berarti bagi keselamatan lingkungan.</p>
 */
@Component
public class B3PointCalculator implements PointCalculatorStrategy {

    /**
     * Multiplier 2x untuk sampah B3 — insentif tertinggi dalam sistem.
     * Dirancang untuk mendorong penanganan yang benar terhadap limbah berbahaya.
     */
    private static final double B3_MULTIPLIER = 2.0;

    /**
     * Poin minimum yang diberikan untuk setiap setoran B3, terlepas dari berat.
     * Sebagai apresiasi karena mau repot mengumpulkan limbah berbahaya.
     */
    private static final double B3_MINIMUM_BONUS = 5.0;

    /**
     * Menghitung poin untuk setoran sampah B3.
     *
     * <p>Menggunakan multiplier tertinggi (2.0x) ditambah bonus minimum {@value B3_MINIMUM_BONUS} poin
     * untuk setiap setoran B3 yang valid.</p>
     *
     * @param weightKg berat sampah B3 dalam kilogram
     * @param category kategori sampah B3 dengan pointsPerKg
     * @return poin dengan multiplier 2.0x + bonus minimum 5 poin
     */
    @Override
    public double calculatePoints(double weightKg, WasteCategory category) {
        if (weightKg <= 0 || category == null) {
            return 0.0;
        }
        double basePoints = weightKg * category.getPointsPerKg() * B3_MULTIPLIER;
        // B3 mendapat bonus minimum sebagai insentif ekstra
        double totalPoints = basePoints + B3_MINIMUM_BONUS;
        return Math.round(totalPoints * 100.0) / 100.0;
    }

    @Override
    public String getStrategyName() {
        return "B3_CALCULATOR";
    }
}
