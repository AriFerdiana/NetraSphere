package com.smartwaste.repository;

import com.smartwaste.entity.Citizen;
import com.smartwaste.entity.GreenWallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository untuk entitas {@link GreenWallet}.
 */
@Repository
public interface GreenWalletRepository extends JpaRepository<GreenWallet, String> {

    Optional<GreenWallet> findByCitizen(Citizen citizen);

    Optional<GreenWallet> findByCitizenId(String citizenId);
}
