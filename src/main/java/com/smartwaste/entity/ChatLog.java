package com.smartwaste.entity;

import jakarta.persistence.*;

/**
 * Entitas ChatLog — Log Percakapan AI Chatbot Mistral.
 */
@Entity
@Table(name = "chat_logs",
       indexes = {
           @Index(name = "idx_chatlog_citizen", columnList = "citizen_id"),
           @Index(name = "idx_chatlog_session", columnList = "session_id")
       })
public class ChatLog extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "citizen_id")
    private Citizen citizen;

    @Column(name = "user_message", columnDefinition = "TEXT", nullable = false)
    private String userMessage;

    @Column(name = "bot_response", columnDefinition = "TEXT")
    private String botResponse;

    @Column(name = "session_id", length = 100)
    private String sessionId;

    @Column(name = "anonymous_identifier", length = 100)
    private String anonymousIdentifier;

    @Column(name = "ai_model_used", length = 50)
    private String aiModelUsed;

    @Column(name = "success", nullable = false)
    private boolean success = true;

    public ChatLog() {
        super();
    }

    public ChatLog(Citizen citizen, String userMessage, String botResponse,
                   String sessionId, String aiModelUsed) {
        this.citizen = citizen;
        this.userMessage = userMessage;
        this.botResponse = botResponse;
        this.sessionId = sessionId;
        this.aiModelUsed = aiModelUsed;
        this.success = botResponse != null;
    }

    public ChatLog(String anonymousIdentifier, String userMessage,
                   String botResponse, String sessionId) {
        this.anonymousIdentifier = anonymousIdentifier;
        this.userMessage = userMessage;
        this.botResponse = botResponse;
        this.sessionId = sessionId;
        this.success = botResponse != null;
    }

    public Citizen getCitizen() { return citizen; }
    public void setCitizen(Citizen citizen) { this.citizen = citizen; }
    public String getUserMessage() { return userMessage; }
    public void setUserMessage(String userMessage) { this.userMessage = userMessage; }
    public String getBotResponse() { return botResponse; }
    public void setBotResponse(String botResponse) { this.botResponse = botResponse; }
    public String getSessionId() { return sessionId; }
    public void setSessionId(String sessionId) { this.sessionId = sessionId; }
    public String getAnonymousIdentifier() { return anonymousIdentifier; }
    public void setAnonymousIdentifier(String anonymousIdentifier) { this.anonymousIdentifier = anonymousIdentifier; }
    public String getAiModelUsed() { return aiModelUsed; }
    public void setAiModelUsed(String aiModelUsed) { this.aiModelUsed = aiModelUsed; }
    public boolean isSuccess() { return success; }
    public void setSuccess(boolean success) { this.success = success; }
}
