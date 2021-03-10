package com.slipper.contracts.repositories;

import com.slipper.contracts.entities.PricingPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PricingPlanRepository extends JpaRepository<PricingPlan, Long> {

    @Transactional(readOnly = true)
    PricingPlan findByPricingPlanId(Long pricingPlanId);
}
