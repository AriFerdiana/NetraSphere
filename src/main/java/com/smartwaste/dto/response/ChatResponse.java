package com.smartwaste.dto.response;

import java.time.LocalDateTime;

/**
 * DTO response percakapan chatbot Mistral AI.
 */
public class ChatResponse {

    private String message;          // Respons dari AI
    private String sessionId;        // ID sesi percakapan
    private String aiModel;          // Model yang digunakan
    private boolean success;
    private LocalDateTime timestamp;

    // Bonus: estimasi poin jika pertanyaan terkait kalkulasi
    private Double estimatedPoints;
    private String estimationNote;

    public ChatResponse() {}

    public static ChatResponseBuilder builder() {
        return new ChatResponseBuilder();
    }

    public static class ChatResponseBuilder {
        private ChatResponse r = new ChatResponse();
        public ChatResponseBuilder message(String m) { r.message = m; return this; }
        public ChatResponseBuilder sessionId(String id) { r.sessionId = id; return this; }
        public ChatResponseBuilder aiModel(String model) { r.aiModel = model; return this; }
        public ChatResponseBuilder success(boolean s) { r.success = s; return this; }
        public ChatResponseBuilder timestamp(LocalDateTime t) { r.timestamp = t; return this; }
        public ChatResponseBuilder estimatedPoints(Double p) { r.estimatedPoints = p; return this; }
        public ChatResponseBuilder estimationNote(String n) { r.estimationNote = n; return this; }
        public ChatResponse build() { return r; }
    }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
    public String getSessionId() { return sessionId; }
    public void setSessionId(String sessionId) { this.sessionId = sessionId; }
    public String getAiModel() { return aiModel; }
    public void setAiModel(String aiModel) { this.aiModel = aiModel; }
    public boolean isSuccess() { return success; }
    public void setSuccess(boolean success) { this.success = success; }
    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
    public Double getEstimatedPoints() { return estimatedPoints; }
    public void setEstimatedPoints(Double estimatedPoints) { this.estimatedPoints = estimatedPoints; }
    public String getEstimationNote() { return estimationNote; }
    public void setEstimationNote(String estimationNote) { this.estimationNote = estimationNote; }
}
