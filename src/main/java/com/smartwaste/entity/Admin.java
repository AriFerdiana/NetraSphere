package com.smartwaste.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitas Admin — subclass dari {@link User} untuk peran administrator sistem.
 *
 * <p><b>OOP Concept — Inheritance & Polymorphism:</b>
 * Mewarisi semua field dari {@link User} (dan {@link BaseEntity}), lalu
 * meng-override method abstract {@link User#getRole()} dan mengembalikan {@code "ADMIN"}.</p>
 *
 * <p>JPA akan membuat 2 tabel yang ter-JOIN:</p>
 * <ul>
 *   <li>{@code users} — menyimpan field umum (name, email, password, phone, active)</li>
 *   <li>{@code admins} — menyimpan field spesifik admin + foreign key ke {@code users}</li>
 * </ul>
 *
 * <p><b>Hak Akses Admin (RBAC):</b></p>
 * <ul>
 *   <li>Mengelola master data (kategori sampah, warga, petugas)</li>
 *   <li>Melihat laporan keseluruhan</li>
 *   <li>Mengkonfigurasi sistem (poin per kategori, dll)</li>
 *   <li>Menyetujui/menolak penukaran poin</li>
 * </ul>
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "admins")
@DiscriminatorValue("ADMIN")
@PrimaryKeyJoinColumn(name = "user_id")
public class Admin extends User {

    /**
     * Jabatan/posisi admin di sistem (misal: "Super Admin", "Supervisor Area").
     */
    @Column(name = "position", length = 100)
    private String position;

    /**
     * Konstruktor untuk membuat Admin baru dari DTO registrasi.
     *
     * @param name     nama lengkap
     * @param email    alamat email
     * @param password password yang sudah di-hash BCrypt
     * @param phone    nomor telepon
     * @param position jabatan admin
     */
    public Admin(String name, String email, String password, String phone, String position) {
        this.setName(name);
        this.setEmail(email);
        this.setPassword(password);
        this.setPhone(phone);
        this.position = position;
    }

    /**
     * Override method abstract dari {@link User}.
     *
     * <p><b>Polymorphism:</b> Saat variabel bertipe {@code User} menunjuk ke objek
     * {@code Admin}, pemanggilan {@code user.getRole()} akan mengembalikan {@code "ADMIN"}.</p>
     *
     * @return string "ADMIN"
     */
    @Override
    public String getRole() {
        return "ADMIN";
    }
}
