package com.smartwaste.strategy;

import com.smartwaste.entity.WasteCategory;
import com.smartwaste.entity.enums.WasteType;
import org.springframework.stereotype.Component;

/**
 * Context class dari Strategy Pattern — Pemilih Kalkulator Poin.
 *
 * <p><b>OOP Concept — Polymorphism (Strategy Pattern Context):</b></p>
 *
 * <p>Kelas ini adalah "otak" dari Strategy Pattern. Berdasarkan {@link WasteType}
 * dari kategori sampah, kelas ini memilih implementasi {@link PointCalculatorStrategy}
 * yang tepat secara otomatis:</p>
 *
 * <pre>
 *   WasteType.ORGANIC   → OrganicPointCalculator  (multiplier 1.0x)
 *   WasteType.INORGANIC → InorganicPointCalculator (multiplier 1.5x)
 *   WasteType.B3        → B3PointCalculator        (multiplier 2.0x + bonus)
 * </pre>
 *
 * <p><b>Mengapa ini demonstrasi Polymorphism yang sempurna?</b>
 * Method {@link #calculate(double, WasteCategory)} hanya perlu memanggil
 * {@code strategy.calculatePoints()} — tanpa peduli implementasi mana yang dipilih.
 * Inilah esensi <b>program to an interface, not an implementation</b>.</p>
 *
 * <p>Penggunaan di {@code WasteDepositServiceImpl}:</p>
 * <pre>{@code
 *   double points = pointCalculatorContext.calculate(deposit.getWeightKg(), category);
 *   wallet.addPoints(points);
 * }</pre>
 */
@Component
public class PointCalculatorContext {

    private final OrganicPointCalculator organicCalculator;
    private final InorganicPointCalculator inorganicCalculator;
    private final B3PointCalculator b3Calculator;

    /**
     * Constructor injection — Spring menginject semua strategy via DI.
     *
     * @param organicCalculator    kalkulator untuk sampah organik
     * @param inorganicCalculator  kalkulator untuk sampah anorganik
     * @param b3Calculator         kalkulator untuk sampah B3
     */
    public PointCalculatorContext(OrganicPointCalculator organicCalculator,
                                  InorganicPointCalculator inorganicCalculator,
                                  B3PointCalculator b3Calculator) {
        this.organicCalculator = organicCalculator;
        this.inorganicCalculator = inorganicCalculator;
        this.b3Calculator = b3Calculator;
    }

    /**
     * Menghitung poin berdasarkan kategori sampah menggunakan strategy yang tepat.
     *
     * <p>Ini adalah inti dari Polymorphism — method yang sama ({@code calculatePoints})
     * dipanggil pada strategy yang berbeda, menghasilkan output berbeda sesuai implementasi.</p>
     *
     * @param weightKg berat sampah yang disetor dalam kilogram
     * @param category kategori sampah (menentukan strategy yang dipilih)
     * @return total poin yang diperoleh
     * @throws IllegalArgumentException jika WasteType tidak dikenali
     */
    public double calculate(double weightKg, WasteCategory category) {
        PointCalculatorStrategy strategy = selectStrategy(category.getType());
        return strategy.calculatePoints(weightKg, category);
    }

    /**
     * Estimasi poin tanpa transaksi aktual — digunakan oleh AI Chatbot untuk
     * menjawab pertanyaan seperti "Berapa poin untuk 2 kg botol plastik?".
     *
     * @param weightKg     berat estimasi
     * @param category     kategori sampah
     * @return estimasi poin
     */
    public double estimatePoints(double weightKg, WasteCategory category) {
        return calculate(weightKg, category);
    }

    /**
     * Memilih strategy yang tepat berdasarkan {@link WasteType}.
     *
     * <p><b>OOP Note:</b> Switch ini adalah satu-satunya tempat pemilihan strategy.
     * Semua kode lain hanya menggunakan interface {@link PointCalculatorStrategy}
     * tanpa tahu implementasi spesifiknya.</p>
     *
     * @param wasteType tipe sampah
     * @return implementasi strategy yang sesuai
     */
    private PointCalculatorStrategy selectStrategy(WasteType wasteType) {
        return switch (wasteType) {
            case ORGANIC   -> organicCalculator;
            case INORGANIC -> inorganicCalculator;
            case B3        -> b3Calculator;
        };
    }

    /**
     * Mendapatkan nama strategy yang akan digunakan untuk tipe sampah tertentu.
     * Berguna untuk logging dan audit.
     *
     * @param wasteType tipe sampah
     * @return nama strategy
     */
    public String getStrategyName(WasteType wasteType) {
        return selectStrategy(wasteType).getStrategyName();
    }
}
