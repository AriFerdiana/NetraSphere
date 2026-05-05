package com.smartwaste.repository;

import com.smartwaste.entity.CollectorNotification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CollectorNotificationRepository extends JpaRepository<CollectorNotification, String> {

    @Query("SELECT n FROM CollectorNotification n LEFT JOIN n.collector c WHERE c.id = :collectorId OR n.collector IS NULL ORDER BY n.createdAt DESC")
    List<CollectorNotification> findByCollectorIdOrBroadcast(@Param("collectorId") String collectorId);
    
    @Query("SELECT COUNT(n) FROM CollectorNotification n LEFT JOIN n.collector c WHERE (c.id = :collectorId OR n.collector IS NULL) AND n.readStatus = false")
    long countUnreadByCollectorId(@Param("collectorId") String collectorId);
}
