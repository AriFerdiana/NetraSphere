package com.smartwaste.entity;

import com.smartwaste.entity.enums.DepositStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * Entitas WasteDeposit — Transaksi Setoran Sampah.
 *
 * <p>Ini adalah entitas inti sistem. Setiap kali warga (atau robot IoT) menyetorkan
 * sampah, sebuah record {@code WasteDeposit} dibuat dengan status {@code PENDING}.
 * Saat Collector/Robot mengkonfirmasi ({@code CONFIRMED}), poin otomatis dikreditkan
 * ke {@link GreenWallet} warga.</p>
 *
 * <p><b>IoT-Ready Design:</b> Field {@code fromIoT} dan {@code iotDeviceId} memungkinkan
 * sistem ini langsung menerima data dari smart bin atau robot pengumpul sampah
 * melalui endpoint {@code POST /api/v1/iot/dump} tanpa memerlukan interaksi UI manual.</p>
 *
 * <p><b>OOP Concept — Composition:</b>
 * Menghubungkan tiga entitas utama: {@link Citizen} (penyetor), {@link Collector}
 * (pengkonfirmasi), dan {@link WasteCategory} (jenis sampah).</p>
 *
 * <p><b>Relasi:</b></p>
 * <ul>
 *   <li>ManyToOne ke {@link Citizen} — banyak setoran per warga</li>
 *   <li>ManyToOne ke {@link Collector} — banyak setoran dikonfirmasi satu collector</li>
 *   <li>ManyToOne ke {@link WasteCategory} — banyak setoran per kategori</li>
 * </ul>
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "waste_deposits",
       indexes = {
           @Index(name = "idx_deposit_citizen", columnList = "citizen_id"),
           @Index(name = "idx_deposit_status", columnList = "status"),
           @Index(name = "idx_deposit_created", columnList = "created_at")
       })
public class WasteDeposit extends BaseEntity {

    // ==================== Relasi ManyToOne ====================

    /**
     * Warga yang melakukan setoran.
     * ManyToOne: banyak setoran dimungkinkan dari satu citizen.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "citizen_id", nullable = false)
    private Citizen citizen;

    /**
     * Petugas/robot yang mengkonfirmasi setoran ini.
     * Nullable karena saat baru dibuat (PENDING), belum ada collector.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "collector_id")
    private Collector collector;

    /**
     * Kategori/jenis sampah yang disetor.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private WasteCategory category;

    // ==================== Field Data Setoran ====================

    /**
     * Berat sampah dalam kilogram yang dilaporkan warga/sensor IoT.
     */
    @Column(name = "weight_kg", nullable = false)
    private double weightKg;

    /**
     * Poin yang diperoleh dari setoran ini, dihitung oleh {@code PointCalculatorStrategy}.
     * Di-set saat setoran dikonfirmasi (status berubah ke CONFIRMED).
     */
    @Column(name = "points_earned", nullable = false)
    private double pointsEarned = 0.0;

    /**
     * Status transaksi setoran saat ini.
     * Default: PENDING saat pertama dibuat.
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 20)
    private DepositStatus status = DepositStatus.PENDING;

    /**
     * Catatan tambahan dari warga atau petugas (opsional).
     */
    @Column(name = "notes", columnDefinition = "TEXT")
    private String notes;

    /**
     * URL foto bukti setoran sampah (opsional, untuk validasi).
     */
    @Column(name = "image_url", length = 500)
    private String imageUrl;

    /**
     * Timestamp saat setoran dikonfirmasi oleh collector/robot.
     * Null jika masih PENDING atau REJECTED.
     */
    @Column(name = "confirmed_at")
    private LocalDateTime confirmedAt;

    // ==================== IoT Integration Fields ====================

    /**
     * Flag yang menandai apakah setoran ini berasal dari perangkat IoT (smart bin/robot).
     * Digunakan untuk analitik dan audit trail sumber data.
     */
    @Column(name = "from_iot", nullable = false)
    private boolean fromIoT = false;

    /**
     * ID perangkat IoT yang mengirimkan data ini (misal: "NETRADUMP-001").
     * Null jika setoran dilakukan manual oleh warga melalui UI.
     */
    @Column(name = "iot_device_id", length = 50)
    private String iotDeviceId;

    /**
     * Lokasi geografis tempat sampah dikumpulkan (format: "lat,lng" atau nama lokasi).
     * Berguna untuk smart bin yang memiliki GPS.
     */
    @Column(name = "location", length = 200)
    private String location;

    // ==================== Constructor ====================

    /**
     * Konstruktor untuk setoran manual dari UI citizen.
     *
     * @param citizen  warga penyetor
     * @param category kategori sampah
     * @param weightKg berat dalam kilogram
     * @param notes    catatan tambahan
     */
    public WasteDeposit(Citizen citizen, WasteCategory category,
                        double weightKg, String notes) {
        this.citizen = citizen;
        this.category = category;
        this.weightKg = weightKg;
        this.notes = notes;
        this.status = DepositStatus.PENDING;
        this.fromIoT = false;
    }

    /**
     * Konstruktor untuk setoran otomatis dari perangkat IoT.
     *
     * @param citizen      warga yang terdaftar ke smart bin
     * @param category     kategori sampah terdeteksi sensor
     * @param weightKg     berat dari sensor timbangan
     * @param iotDeviceId  ID perangkat IoT
     * @param location     koordinat atau nama lokasi smart bin
     */
    public WasteDeposit(Citizen citizen, WasteCategory category, double weightKg,
                        String iotDeviceId, String location) {
        this.citizen = citizen;
        this.category = category;
        this.weightKg = weightKg;
        this.iotDeviceId = iotDeviceId;
        this.location = location;
        this.status = DepositStatus.PENDING;
        this.fromIoT = true;
    }

    // ==================== Business Logic Methods ====================

    /**
     * Mengkonfirmasi setoran dan mencatat poin yang diperoleh.
     * Status berubah ke CONFIRMED dan waktu konfirmasi dicatat.
     *
     * @param collector    petugas/robot yang mengkonfirmasi
     * @param pointsEarned total poin yang dihitung oleh PointCalculatorStrategy
     */
    public void confirm(Collector collector, double pointsEarned) {
        this.collector = collector;
        this.pointsEarned = pointsEarned;
        this.status = DepositStatus.CONFIRMED;
        this.confirmedAt = LocalDateTime.now();
    }

    /**
     * Menolak setoran dengan alasan tertentu.
     *
     * @param collector petugas yang menolak
     * @param reason    alasan penolakan (disimpan di field notes)
     */
    public void reject(Collector collector, String reason) {
        this.collector = collector;
        this.status = DepositStatus.REJECTED;
        this.notes = (this.notes != null ? this.notes + " | " : "") + "DITOLAK: " + reason;
        this.confirmedAt = LocalDateTime.now();
    }
}
