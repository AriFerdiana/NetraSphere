package com.smartwaste.repository;

import com.smartwaste.entity.Collector;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository untuk entitas {@link Collector}.
 */
@Repository
public interface CollectorRepository extends JpaRepository<Collector, String> {

    Optional<Collector> findByEmail(String email);

    boolean existsByEmail(String email);

    List<Collector> findByAvailableTrue();

    Optional<Collector> findByIotDeviceId(String iotDeviceId);

    boolean existsByIotDeviceId(String iotDeviceId);

    long countByActiveTrue();

    Page<Collector> findByActiveTrue(Pageable pageable);

    @Query("SELECT c FROM Collector c WHERE c.active = true AND c.iotDevice = false AND " +
           "(LOWER(c.name) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
           " LOWER(c.email) LIKE LOWER(CONCAT('%', :keyword, '%')))")
    Page<Collector> searchCollectors(@Param("keyword") String keyword, Pageable pageable);
}
