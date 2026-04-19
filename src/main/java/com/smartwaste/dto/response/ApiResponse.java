package com.smartwaste.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Generic API Response Wrapper — Encapsulates semua response REST API.
 *
 * <p><b>OOP Concept — Encapsulation & Generic:</b>
 * Menggunakan Java Generics (T) agar satu class bisa membungkus data tipe apapun.
 * Memastikan semua response memiliki format konsisten: success, message, data, timestamp.</p>
 *
 * <p>Contoh response sukses:</p>
 * <pre>
 * {
 *   "success": true,
 *   "message": "Data berhasil diambil",
 *   "data": { ... },
 *   "timestamp": "2024-01-15T10:30:00"
 * }
 * </pre>
 *
 * @param <T> tipe data payload
 */
@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {

    private boolean success;
    private String message;
    private T data;
    private LocalDateTime timestamp;

    private ApiResponse(boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
        this.timestamp = LocalDateTime.now();
    }

    /** Factory method untuk response sukses dengan data */
    public static <T> ApiResponse<T> success(String message, T data) {
        return new ApiResponse<>(true, message, data);
    }

    /** Factory method untuk response sukses tanpa data */
    public static <T> ApiResponse<T> success(String message) {
        return new ApiResponse<>(true, message, null);
    }

    /** Factory method untuk response error */
    public static <T> ApiResponse<T> error(String message) {
        return new ApiResponse<>(false, message, null);
    }
}
