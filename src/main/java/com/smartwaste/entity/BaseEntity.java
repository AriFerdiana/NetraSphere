package com.smartwaste.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Base class untuk semua entity JPA dalam aplikasi Smart Community Waste System.
 *
 * <p><b>OOP Concept — Inheritance:</b> Kelas ini adalah pondasi dari hierarki inheritance.
 * Semua entity mewarisi field universal (id, createdAt, updatedAt) dari kelas ini,
 * menghindari duplikasi kode (DRY Principle).</p>
 *
 * <p>Menggunakan {@code @MappedSuperclass} sehingga JPA memetakan field-field ini
 * ke dalam tabel masing-masing subclass (bukan sebagai tabel tersendiri).</p>
 *
 * <p>Lifecycle callbacks {@code @PrePersist} dan {@code @PreUpdate} memastikan
 * timestamp diisi secara otomatis tanpa perlu dipanggil manual di service.</p>
 *
 * <p>Diagram Hierarki Inheritance:</p>
 * <pre>
 *   BaseEntity (abstract, @MappedSuperclass)
 *       ├── User (abstract, @Entity, @Inheritance JOINED)
 *       │       ├── Admin (@Entity)
 *       │       ├── Citizen (@Entity)
 *       │       └── Collector (@Entity)
 *       ├── WasteCategory (@Entity)
 *       ├── GreenWallet (@Entity)
 *       ├── WasteDeposit (@Entity)
 *       ├── PointRedemption (@Entity)
 *       └── ChatLog (@Entity)
 * </pre>
 */
@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity {

    /**
     * Primary key berupa UUID string yang di-generate secara otomatis.
     * Menggunakan UUID untuk scalability dan keamanan (tidak predictable seperti integer).
     */
    @Id
    @Column(name = "id", updatable = false, nullable = false, length = 36)
    private String id;

    /**
     * Timestamp saat record pertama kali dibuat.
     * Di-set otomatis oleh {@link #onCreate()} dan tidak bisa diperbarui.
     */
    @Column(name = "created_at", updatable = false, nullable = false)
    private LocalDateTime createdAt;

    /**
     * Timestamp terakhir kali record dimodifikasi.
     * Di-set otomatis oleh {@link #onCreate()} dan diperbarui oleh {@link #onUpdate()}.
     */
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    /**
     * Lifecycle callback yang dijalankan tepat sebelum entity di-INSERT ke database.
     * Mengisi id (UUID), createdAt, dan updatedAt secara otomatis.
     */
    @PrePersist
    protected void onCreate() {
        if (this.id == null) {
            this.id = UUID.randomUUID().toString();
        }
        LocalDateTime now = LocalDateTime.now();
        this.createdAt = now;
        this.updatedAt = now;
    }

    /**
     * Lifecycle callback yang dijalankan tepat sebelum entity di-UPDATE di database.
     * Memperbarui timestamp updatedAt secara otomatis.
     */
    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
