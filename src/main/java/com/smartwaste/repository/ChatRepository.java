package com.smartwaste.repository;

import com.smartwaste.entity.ChatMessage;
import com.smartwaste.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ChatRepository extends JpaRepository<ChatMessage, String> {

    @Query("SELECT c FROM ChatMessage c WHERE (c.sender = :user1 AND c.receiver = :user2) OR (c.sender = :user2 AND c.receiver = :user1) ORDER BY c.sentAt ASC")
    List<ChatMessage> findChatHistory(@Param("user1") User user1, @Param("user2") User user2);

    @Query("SELECT COUNT(c) FROM ChatMessage c WHERE c.receiver = :receiver AND c.isRead = false")
    long countUnreadMessages(@Param("receiver") User receiver);

    @Query("SELECT COUNT(c) FROM ChatMessage c WHERE c.receiver = :receiver AND c.sender = :sender AND c.isRead = false")
    long countUnreadFromSender(@Param("receiver") User receiver, @Param("sender") User sender);
}
