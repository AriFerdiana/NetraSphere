package com.smartwaste.repository;

import com.smartwaste.entity.WasteCategory;
import com.smartwaste.entity.enums.WasteType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository untuk entitas {@link WasteCategory}.
 */
@Repository
public interface WasteCategoryRepository extends JpaRepository<WasteCategory, String> {

    List<WasteCategory> findByActiveTrue();

    List<WasteCategory> findByTypeAndActiveTrue(WasteType type);

    boolean existsByNameIgnoreCase(String name);
}
