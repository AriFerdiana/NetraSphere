package com.smartwaste.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception yang dilempar ketika warga mencoba menukar poin melebihi saldo
 * yang tersedia di {@code GreenWallet}.
 *
 * <p>Dihandle oleh {@link GlobalExceptionHandler} dan mengembalikan HTTP 400 Bad Request.</p>
 *
 * <p>Contoh penggunaan di {@code GreenWallet.redeemPoints()}:</p>
 * <pre>{@code
 *   if (points > getAvailablePoints()) {
 *       throw new InsufficientPointsException(points, getAvailablePoints());
 *   }
 * }</pre>
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InsufficientPointsException extends RuntimeException {

    private final double requested;
    private final double available;

    /**
     * Konstruktor dengan informasi poin diminta vs tersedia.
     *
     * @param requested poin yang diminta untuk ditukar
     * @param available saldo poin yang tersedia di wallet
     */
    public InsufficientPointsException(double requested, double available) {
        super(String.format(
                "Saldo poin tidak mencukupi. Diminta: %.0f poin, Tersedia: %.0f poin.",
                requested, available
        ));
        this.requested = requested;
        this.available = available;
    }

    /**
     * Konstruktor dengan pesan kustom.
     *
     * @param message pesan error kustom
     */
    public InsufficientPointsException(String message) {
        super(message);
        this.requested = 0;
        this.available = 0;
    }

    public double getRequested() {
        return requested;
    }

    public double getAvailable() {
        return available;
    }
}
