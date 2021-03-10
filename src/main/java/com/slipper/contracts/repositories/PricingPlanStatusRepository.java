package com.slipper.contracts.repositories;

import com.slipper.contracts.entities.PricingPlanStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PricingPlanStatusRepository extends JpaRepository<PricingPlanStatus, Long> {

    @Query(value = "SELECT * FROM PRICING_PLAN_STATUS WHERE CONTRACT_ID = :contract_id " +
        "AND now() BETWEEN date_start AND date_end", nativeQuery = true)
    List<PricingPlanStatus> findCurrentByContractId(@Param("contract_id") Long contractId);
}
