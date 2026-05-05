package com.smartwaste.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "chat_messages")
public class ChatMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne
    private User sender;

    @ManyToOne
    private User receiver;

    private String message;

    private LocalDateTime sentAt;

    private boolean isRead;

    public ChatMessage() {}

    public static ChatMessageBuilder builder() {
        return new ChatMessageBuilder();
    }

    public static class ChatMessageBuilder {
        private ChatMessage m = new ChatMessage();
        public ChatMessageBuilder id(String id) { m.id = id; return this; }
        public ChatMessageBuilder sender(User u) { m.sender = u; return this; }
        public ChatMessageBuilder receiver(User u) { m.receiver = u; return this; }
        public ChatMessageBuilder message(String msg) { m.message = msg; return this; }
        public ChatMessageBuilder sentAt(LocalDateTime t) { m.sentAt = t; return this; }
        public ChatMessageBuilder isRead(boolean r) { m.isRead = r; return this; }
        public ChatMessage build() { return m; }
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public User getSender() { return sender; }
    public void setSender(User sender) { this.sender = sender; }
    public User getReceiver() { return receiver; }
    public void setReceiver(User receiver) { this.receiver = receiver; }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
    public LocalDateTime getSentAt() { return sentAt; }
    public void setSentAt(LocalDateTime sentAt) { this.sentAt = sentAt; }
    public boolean isRead() { return isRead; }
    public void setRead(boolean read) { isRead = read; }
}
