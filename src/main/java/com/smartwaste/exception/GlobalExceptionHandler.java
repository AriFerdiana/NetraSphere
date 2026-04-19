package com.smartwaste.exception;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * Global Exception Handler — Terpusat menangani semua exception di seluruh aplikasi.
 *
 * <p>Menggunakan {@code @RestControllerAdvice} untuk mengembalikan response JSON yang rapi
 * dan konsisten ke client, bukan stack trace mentah. Ini adalah best practice
 * untuk REST API production-grade.</p>
 *
 * <p><b>OOP Concept:</b> Ini adalah implementasi nyata dari <b>Exception Handling</b> yang
 * terpusat (Single Responsibility Principle) — semua error handling dikumpulkan di satu
 * tempat dan tidak tersebar di setiap controller.</p>
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    // ==================== Error Response Builder ====================

    /**
     * Membangun struktur response error yang konsisten.
     *
     * @param status  HTTP status code
     * @param message pesan error utama
     * @param details detail tambahan (bisa null)
     * @param request request web
     * @return Map yang akan diserialisasi menjadi JSON
     */
    private ResponseEntity<Map<String, Object>> buildErrorResponse(
            HttpStatus status, String message, Object details, WebRequest request) {

        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now().toString());
        body.put("status", status.value());
        body.put("error", status.getReasonPhrase());
        body.put("message", message);
        body.put("path", request.getDescription(false).replace("uri=", ""));

        if (details != null) {
            body.put("details", details);
        }

        return new ResponseEntity<>(body, status);
    }

    // ==================== Custom Application Exceptions ====================

    /**
     * Menangani resource tidak ditemukan (404 Not Found).
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleResourceNotFoundException(
            ResourceNotFoundException ex, WebRequest request) {

        return buildErrorResponse(HttpStatus.NOT_FOUND, ex.getMessage(), null, request);
    }

    /**
     * Menangani saldo poin tidak mencukupi (400 Bad Request).
     */
    @ExceptionHandler(InsufficientPointsException.class)
    public ResponseEntity<Map<String, Object>> handleInsufficientPointsException(
            InsufficientPointsException ex, WebRequest request) {

        Map<String, Object> details = new HashMap<>();
        details.put("requested", ex.getRequested());
        details.put("available", ex.getAvailable());

        return buildErrorResponse(HttpStatus.BAD_REQUEST, ex.getMessage(), details, request);
    }

    /**
     * Menangani duplikasi email saat registrasi (409 Conflict).
     */
    @ExceptionHandler(DuplicateEmailException.class)
    public ResponseEntity<Map<String, Object>> handleDuplicateEmailException(
            DuplicateEmailException ex, WebRequest request) {

        Map<String, Object> details = new HashMap<>();
        details.put("email", ex.getEmail());

        return buildErrorResponse(HttpStatus.CONFLICT, ex.getMessage(), details, request);
    }

    /**
     * Menangani akses tidak sah / RBAC violation (403 Forbidden).
     */
    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<Map<String, Object>> handleUnauthorizedException(
            UnauthorizedException ex, WebRequest request) {

        return buildErrorResponse(HttpStatus.FORBIDDEN, ex.getMessage(), null, request);
    }

    // ==================== Spring Security Exceptions ====================

    /**
     * Menangani kredensial login yang salah (401 Unauthorized).
     */
    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<Map<String, Object>> handleBadCredentialsException(
            BadCredentialsException ex, WebRequest request) {

        return buildErrorResponse(
                HttpStatus.UNAUTHORIZED,
                "Email atau password salah. Silakan coba lagi.",
                null,
                request
        );
    }

    /**
     * Menangani akses ditolak oleh Spring Security (403 Forbidden).
     */
    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<Map<String, Object>> handleAccessDeniedException(
            AccessDeniedException ex, WebRequest request) {

        return buildErrorResponse(
                HttpStatus.FORBIDDEN,
                "Akses ditolak. Role Anda tidak memiliki izin untuk operasi ini.",
                null,
                request
        );
    }

    // ==================== Validation Exceptions ====================

    /**
     * Menangani error validasi DTO (400 Bad Request) — misal: field kosong, format email salah.
     * Mengembalikan map field → pesan error untuk setiap field yang gagal validasi.
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidationException(
            MethodArgumentNotValidException ex, WebRequest request) {

        Map<String, String> validationErrors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            validationErrors.put(fieldName, errorMessage);
        });

        return buildErrorResponse(
                HttpStatus.BAD_REQUEST,
                "Validasi gagal. Periksa kembali input Anda.",
                validationErrors,
                request
        );
    }

    /**
     * Menangani constraint violation dari JPA/Bean Validation.
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Map<String, Object>> handleConstraintViolationException(
            ConstraintViolationException ex, WebRequest request) {

        Map<String, String> violations = new HashMap<>();
        ex.getConstraintViolations().forEach(cv -> {
            String field = cv.getPropertyPath().toString();
            violations.put(field, cv.getMessage());
        });

        return buildErrorResponse(
                HttpStatus.BAD_REQUEST,
                "Pelanggaran constraint validasi data.",
                violations,
                request
        );
    }

    // ==================== Generic Fallback ====================

    /**
     * Fallback handler untuk semua exception yang tidak tertangani secara spesifik.
     * Mengembalikan 500 Internal Server Error dengan pesan generik (tidak bocorkan stack trace).
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGenericException(
            Exception ex, WebRequest request) {

        return buildErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR,
                "Terjadi kesalahan internal pada server. Silakan hubungi administrator.",
                null,
                request
        );
    }
}
