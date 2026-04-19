package com.smartwaste.repository;

import com.smartwaste.entity.ChatLog;
import com.smartwaste.entity.Citizen;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository untuk entitas {@link ChatLog}.
 */
@Repository
public interface ChatLogRepository extends JpaRepository<ChatLog, String> {

    Page<ChatLog> findByCitizen(Citizen citizen, Pageable pageable);

    List<ChatLog> findByCitizenAndSessionIdOrderByCreatedAtAsc(Citizen citizen, String sessionId);

    List<ChatLog> findBySessionIdOrderByCreatedAtAsc(String sessionId);
}
