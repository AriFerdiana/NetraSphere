package com.smartwaste.entity.enums;

/**
 * Status dari sebuah transaksi setoran sampah ({@code WasteDeposit}).
 *
 * <ul>
 *   <li>{@code PENDING} — Setoran baru diajukan, menunggu konfirmasi petugas/robot.</li>
 *   <li>{@code CONFIRMED} — Setoran telah dikonfirmasi; poin otomatis masuk ke Green Wallet.</li>
 *   <li>{@code REJECTED} — Setoran ditolak (mis. berat tidak sesuai, foto tidak valid).</li>
 * </ul>
 */
public enum DepositStatus {

    /** Menunggu konfirmasi dari Collector atau sistem IoT */
    PENDING,

    /** Dikonfirmasi; poin sudah dikreditkan ke GreenWallet warga */
    CONFIRMED,

    /** Ditolak oleh Collector atau Admin */
    REJECTED
}
