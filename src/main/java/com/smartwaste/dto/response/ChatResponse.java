package com.smartwaste.dto.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * DTO response percakapan chatbot Mistral AI.
 */
@Data
@Builder
public class ChatResponse {

    private String message;          // Respons dari AI
    private String sessionId;        // ID sesi percakapan
    private String aiModel;          // Model yang digunakan
    private boolean success;
    private LocalDateTime timestamp;

    // Bonus: estimasi poin jika pertanyaan terkait kalkulasi
    private Double estimatedPoints;
    private String estimationNote;
}
