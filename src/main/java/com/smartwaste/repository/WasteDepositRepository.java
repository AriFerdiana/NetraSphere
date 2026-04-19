package com.smartwaste.repository;

import com.smartwaste.entity.Citizen;
import com.smartwaste.entity.WasteDeposit;
import com.smartwaste.entity.enums.DepositStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository untuk entitas {@link WasteDeposit}.
 * Berisi query JPQL kustom untuk laporan agregasi.
 */
@Repository
public interface WasteDepositRepository extends JpaRepository<WasteDeposit, String> {

    Page<WasteDeposit> findByCitizen(Citizen citizen, Pageable pageable);

    Page<WasteDeposit> findByCitizenAndStatus(Citizen citizen, DepositStatus status, Pageable pageable);

    Page<WasteDeposit> findByStatus(DepositStatus status, Pageable pageable);

    long countByStatus(DepositStatus status);

    /** Total berat semua sampah yang sudah dikonfirmasi */
    @Query("SELECT COALESCE(SUM(d.weightKg), 0) FROM WasteDeposit d WHERE d.status = com.smartwaste.entity.enums.DepositStatus.CONFIRMED")
    double sumTotalWeightConfirmed();

    /** Total poin yang sudah didistribusikan */
    @Query("SELECT COALESCE(SUM(d.pointsEarned), 0) FROM WasteDeposit d WHERE d.status = com.smartwaste.entity.enums.DepositStatus.CONFIRMED")
    double sumTotalPointsDistributed();

    /** Total berat per citizen */
    @Query("SELECT COALESCE(SUM(d.weightKg), 0) FROM WasteDeposit d WHERE d.citizen = :citizen AND d.status = com.smartwaste.entity.enums.DepositStatus.CONFIRMED")
    double sumWeightByCitizen(@Param("citizen") Citizen citizen);

    /** Statistik bulanan untuk grafik admin */
    @Query("SELECT FUNCTION('DATE_FORMAT', d.createdAt, '%Y-%m') AS monthYear, " +
           "COUNT(d) AS depositCount, SUM(d.weightKg) AS totalWeight, SUM(d.pointsEarned) AS totalPoints " +
           "FROM WasteDeposit d WHERE d.status = com.smartwaste.entity.enums.DepositStatus.CONFIRMED " +
           "GROUP BY FUNCTION('DATE_FORMAT', d.createdAt, '%Y-%m') " +
           "ORDER BY monthYear DESC")
    List<Object[]> findMonthlyStats();

    /** Statistik per kategori */
    @Query("SELECT d.category.name, SUM(d.weightKg), COUNT(d) " +
           "FROM WasteDeposit d WHERE d.status = com.smartwaste.entity.enums.DepositStatus.CONFIRMED " +
           "GROUP BY d.category.name")
    List<Object[]> findCategoryStats();

    /** Setoran dari perangkat IoT */
    Page<WasteDeposit> findByFromIoTTrue(Pageable pageable);

    /** Setoran berdasarkan IoT device ID */
    Page<WasteDeposit> findByIotDeviceId(String iotDeviceId, Pageable pageable);

    /** Total setoran yang dikonfirmasi oleh satu collector */
    long countByCollector(com.smartwaste.entity.Collector collector);

    /** Total setoran per status per collector */
    long countByCollectorAndStatus(com.smartwaste.entity.Collector collector, DepositStatus status);

    Page<WasteDeposit> findByCreatedAtBetween(java.time.LocalDateTime start, java.time.LocalDateTime end, Pageable pageable);
}
