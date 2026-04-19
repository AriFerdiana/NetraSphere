package com.smartwaste.repository;

import com.smartwaste.entity.Citizen;
import com.smartwaste.entity.PointRedemption;
import com.smartwaste.entity.enums.RedemptionStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository untuk entitas {@link PointRedemption}.
 */
@Repository
public interface PointRedemptionRepository extends JpaRepository<PointRedemption, String> {

    Page<PointRedemption> findByCitizen(Citizen citizen, Pageable pageable);

    Page<PointRedemption> findByStatus(RedemptionStatus status, Pageable pageable);

    long countByStatus(RedemptionStatus status);

    long countByCitizenAndStatus(Citizen citizen, RedemptionStatus status);
}
