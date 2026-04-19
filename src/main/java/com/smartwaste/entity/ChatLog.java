package com.smartwaste.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitas ChatLog — Log Percakapan AI Chatbot Mistral.
 *
 * <p>Menyimpan setiap pasangan pesan (user → bot) dari interaksi warga dengan
 * chatbot AI berbasis Mistral. Digunakan untuk audit, analitik, dan
 * menampilkan riwayat percakapan di dashboard warga.</p>
 *
 * <p>Chatbot bisa melayani pertanyaan seperti:</p>
 * <ul>
 *   <li>"Berapa poin untuk 2 kg botol plastik?"</li>
 *   <li>"Bagaimana cara memilah sampah B3?"</li>
 *   <li>"Kapan jadwal pengambilan sampah di RT 03?"</li>
 * </ul>
 *
 * <p><b>Design Note:</b> Field {@code citizen} nullable untuk mendukung percakapan
 * anonim (dari landing page tanpa login). Dalam kasus itu, {@code sessionId} digunakan
 * sebagai identifier sesi anonim.</p>
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "chat_logs",
       indexes = {
           @Index(name = "idx_chatlog_citizen", columnList = "citizen_id"),
           @Index(name = "idx_chatlog_session", columnList = "session_id")
       })
public class ChatLog extends BaseEntity {

    /**
     * Warga yang mengirim pesan. Nullable (bisa null untuk guest/anonim).
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "citizen_id")
    private Citizen citizen;

    /**
     * Pesan yang dikirim oleh user/warga ke chatbot.
     * Menggunakan TEXT untuk mendukung pesan yang panjang.
     */
    @Column(name = "user_message", columnDefinition = "TEXT", nullable = false)
    private String userMessage;

    /**
     * Respons yang diberikan oleh AI Mistral.
     * Bisa null sementara (saat sedang diproses secara async).
     */
    @Column(name = "bot_response", columnDefinition = "TEXT")
    private String botResponse;

    /**
     * ID sesi percakapan untuk mengelompokkan pesan dalam satu sesi.
     * Digunakan untuk membangun konteks percakapan multi-turn.
     */
    @Column(name = "session_id", length = 100)
    private String sessionId;

    /**
     * Identifier anonim (UUID browser lokal) untuk pengguna yang tidak login.
     */
    @Column(name = "anonymous_identifier", length = 100)
    private String anonymousIdentifier;

    /**
     * Model AI yang digunakan untuk menghasilkan respons ini.
     * Berguna untuk auditing dan A/B testing model.
     * Contoh: "mistral-small-latest", "mistral-large-latest".
     */
    @Column(name = "ai_model_used", length = 50)
    private String aiModelUsed;

    /**
     * Apakah respons AI berhasil dihasilkan atau terjadi error.
     */
    @Column(name = "success", nullable = false)
    private boolean success = true;

    /**
     * Konstruktor untuk log percakapan dari warga yang sudah login.
     *
     * @param citizen       warga yang bercakap
     * @param userMessage   pesan dari warga
     * @param botResponse   respons dari Mistral AI
     * @param sessionId     ID sesi percakapan
     * @param aiModelUsed   model AI yang digunakan
     */
    public ChatLog(Citizen citizen, String userMessage, String botResponse,
                   String sessionId, String aiModelUsed) {
        this.citizen = citizen;
        this.userMessage = userMessage;
        this.botResponse = botResponse;
        this.sessionId = sessionId;
        this.aiModelUsed = aiModelUsed;
        this.success = botResponse != null;
    }

    /**
     * Konstruktor untuk log percakapan dari pengguna anonim (tidak login).
     *
     * @param anonymousIdentifier identifier unik browser pengunjung anonim
     * @param userMessage         pesan dari pengunjung
     * @param botResponse         respons dari Mistral AI
     * @param sessionId           ID sesi percakapan
     */
    public ChatLog(String anonymousIdentifier, String userMessage,
                   String botResponse, String sessionId) {
        this.anonymousIdentifier = anonymousIdentifier;
        this.userMessage = userMessage;
        this.botResponse = botResponse;
        this.sessionId = sessionId;
        this.success = botResponse != null;
    }
}
