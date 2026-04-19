package com.smartwaste.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception untuk mencegah pendaftaran dengan email yang sudah terdaftar.
 *
 * <p>Dilempar di {@code AuthServiceImpl.register()} atau {@code CitizenServiceImpl.create()}
 * ketika email sudah ada di database.</p>
 *
 * <p>HTTP response: 409 Conflict</p>
 */
@ResponseStatus(HttpStatus.CONFLICT)
public class DuplicateEmailException extends RuntimeException {

    private final String email;

    /**
     * Konstruktor dengan email yang sudah terdaftar.
     *
     * @param email alamat email yang sudah ada di sistem
     */
    public DuplicateEmailException(String email) {
        super(String.format("Email '%s' sudah terdaftar di sistem. Gunakan email lain.", email));
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
