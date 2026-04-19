package com.smartwaste.entity.enums;

/**
 * Enum untuk tipe/kategori sampah.
 *
 * <p>Digunakan sebagai dasar pemilihan Strategy pada perhitungan poin
 * (Pattern Polymorphism): {@code PointCalculatorStrategy}.</p>
 *
 * <ul>
 *   <li>{@code ORGANIC} — Sampah organik (sisa makanan, daun, dll). Multiplier: 1.0x</li>
 *   <li>{@code INORGANIC} — Sampah anorganik (plastik, logam, kertas). Multiplier: 1.5x</li>
 *   <li>{@code B3} — Bahan Berbahaya dan Beracun (baterai, elektronik). Multiplier: 2.0x</li>
 * </ul>
 */
public enum WasteType {

    /** Sampah organik — mudah terurai, incentive rendah */
    ORGANIC,

    /** Sampah anorganik — perlu daur ulang, incentive sedang */
    INORGANIC,

    /** Bahan Berbahaya dan Beracun — penanganan khusus, incentive tinggi */
    B3
}
