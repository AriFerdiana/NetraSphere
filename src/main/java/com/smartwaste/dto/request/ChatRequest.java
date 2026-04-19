package com.smartwaste.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * DTO untuk request percakapan dengan AI Chatbot Mistral.
 */
@Data
public class ChatRequest {

    @NotBlank(message = "Pesan tidak boleh kosong")
    @Size(max = 1000, message = "Pesan maksimal 1000 karakter")
    private String message;

    /** ID sesi untuk percakapan multi-turn */
    private String sessionId;

    /** Identifier anonim untuk pengguna yang belum login */
    private String anonymousIdentifier;
}
