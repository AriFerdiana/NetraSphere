package com.smartwaste.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * DTO untuk request percakapan dengan AI Chatbot Mistral.
 */
public class ChatRequest {

    @NotBlank(message = "Pesan tidak boleh kosong")
    @Size(max = 1000, message = "Pesan maksimal 1000 karakter")
    private String message;

    /** ID sesi untuk percakapan multi-turn */
    private String sessionId;

    /** Identifier anonim untuk pengguna yang belum login */
    private String anonymousIdentifier;

    public ChatRequest() {}

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
    public String getSessionId() { return sessionId; }
    public void setSessionId(String sessionId) { this.sessionId = sessionId; }
    public String getAnonymousIdentifier() { return anonymousIdentifier; }
    public void setAnonymousIdentifier(String anonymousIdentifier) { this.anonymousIdentifier = anonymousIdentifier; }
}
