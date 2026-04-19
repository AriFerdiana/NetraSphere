package com.smartwaste.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception untuk request yang tidak memiliki hak akses yang cukup.
 *
 * <p>Dilempar ketika user mencoba mengakses resource yang bukan miliknya
 * atau di luar role-nya (RBAC violation).</p>
 *
 * <p>HTTP response: 403 Forbidden</p>
 */
@ResponseStatus(HttpStatus.FORBIDDEN)
public class UnauthorizedException extends RuntimeException {

    /**
     * Konstruktor dengan pesan kustom.
     *
     * @param message deskripsi alasan akses ditolak
     */
    public UnauthorizedException(String message) {
        super(message);
    }

    /**
     * Konstruktor default untuk akses yang secara umum ditolak.
     */
    public UnauthorizedException() {
        super("Akses ditolak. Anda tidak memiliki hak untuk melakukan operasi ini.");
    }
}
