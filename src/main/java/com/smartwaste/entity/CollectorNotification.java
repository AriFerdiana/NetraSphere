package com.smartwaste.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "collector_notifications")
public class CollectorNotification extends BaseEntity {

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, length = 1000)
    private String message;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "collector_id")
    private Collector collector; // Jika null = broadcast ke semua collector

    @Column(nullable = false)
    private boolean readStatus = false;
    
    public CollectorNotification() {
        super();
    }

    public CollectorNotification(String title, String message, Collector collector) {
        this.title = title;
        this.message = message;
        this.collector = collector;
    }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
    public Collector getCollector() { return collector; }
    public void setCollector(Collector collector) { this.collector = collector; }
    public boolean isReadStatus() { return readStatus; }
    public void setReadStatus(boolean readStatus) { this.readStatus = readStatus; }
}
