package com.smartwaste.strategy;

import com.smartwaste.entity.WasteCategory;

/**
 * Interface Strategy Pattern untuk perhitungan poin Green Wallet.
 *
 * <p><b>OOP Concept — Interface & Polymorphism (Strategy Pattern):</b></p>
 *
 * <p>Interface ini mendefinisikan kontrak ({@link #calculatePoints}) yang wajib
 * diimplementasikan oleh setiap kalkulator poin. Ada tiga implementasi konkret:</p>
 * <ul>
 *   <li>{@link OrganicPointCalculator} — untuk sampah ORGANIC (multiplier 1.0x)</li>
 *   <li>{@link InorganicPointCalculator} — untuk sampah INORGANIC (multiplier 1.5x)</li>
 *   <li>{@link B3PointCalculator} — untuk sampah B3/berbahaya (multiplier 2.0x)</li>
 * </ul>
 *
 * <p><b>Mengapa ini Polymorphism?</b>
 * {@code PointCalculatorContext} menyimpan referensi bertipe {@code PointCalculatorStrategy}.
 * Referensi ini bisa menunjuk ke salah satu dari tiga implementasi, dan
 * pemanggilan {@code calculatePoints()} akan mengeksekusi implementasi yang tepat
 * saat runtime — ini adalah <b>Runtime Polymorphism via Interface</b>.</p>
 *
 * <p>Keuntungan Strategy Pattern: mudah menambah tipe kalkulator baru di masa depan
 * tanpa mengubah kode yang sudah ada (Open-Closed Principle).</p>
 */
public interface PointCalculatorStrategy {

    /**
     * Menghitung total poin yang diperoleh dari setoran sampah.
     *
     * <p>Formula umum: {@code poin = weightKg × category.getPointsPerKg() × multiplier}</p>
     * <p>Dimana {@code multiplier} berbeda-beda tergantung implementasi.</p>
     *
     * @param weightKg berat sampah yang disetor dalam kilogram (harus > 0)
     * @param category kategori sampah beserta nilai pointsPerKg-nya
     * @return total poin yang diperoleh (selalu >= 0)
     */
    double calculatePoints(double weightKg, WasteCategory category);

    /**
     * Mengembalikan nama/label strategy ini untuk keperluan logging dan audit.
     *
     * @return nama strategy (misal: "ORGANIC_CALCULATOR")
     */
    String getStrategyName();
}
