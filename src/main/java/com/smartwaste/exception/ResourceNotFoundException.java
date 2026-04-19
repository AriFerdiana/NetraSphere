package com.smartwaste.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception yang dilempar ketika resource yang diminta tidak ditemukan di database.
 *
 * <p>Dihandle secara terpusat oleh {@link GlobalExceptionHandler} dan mengembalikan
 * HTTP 404 Not Found dengan response JSON yang rapi.</p>
 *
 * <p>Contoh penggunaan di service:</p>
 * <pre>{@code
 *   Citizen citizen = citizenRepository.findById(id)
 *       .orElseThrow(() -> new ResourceNotFoundException("Citizen", "id", id));
 * }</pre>
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    private final String resourceName;
    private final String fieldName;
    private final Object fieldValue;

    /**
     * Konstruktor untuk resource tidak ditemukan berdasarkan field tertentu.
     *
     * @param resourceName nama entity/resource (misal: "Citizen", "WasteDeposit")
     * @param fieldName    nama field pencarian (misal: "id", "email")
     * @param fieldValue   nilai field yang dicari
     */
    public ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue) {
        super(String.format("%s tidak ditemukan dengan %s: '%s'", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public String getResourceName() {
        return resourceName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public Object getFieldValue() {
        return fieldValue;
    }
}
