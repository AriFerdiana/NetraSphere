package com.smartwaste.entity.enums;

/**
 * Status dari transaksi penukaran poin ({@code PointRedemption}) di Green Wallet.
 *
 * <ul>
 *   <li>{@code PENDING} — Permintaan penukaran baru dibuat, menunggu persetujuan admin.</li>
 *   <li>{@code APPROVED} — Poin berhasil ditukarkan dengan reward/insentif.</li>
 *   <li>{@code REJECTED} — Permintaan penukaran ditolak (mis. saldo tidak cukup).</li>
 * </ul>
 */
public enum RedemptionStatus {

    /** Permintaan penukaran sedang diproses */
    PENDING,

    /** Penukaran berhasil disetujui dan reward diberikan */
    APPROVED,

    /** Penukaran ditolak oleh Admin */
    REJECTED
}
