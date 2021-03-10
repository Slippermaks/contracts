package com.slipper.contracts.repositories;

import com.slipper.contracts.entities.AccrualByPricingPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Repository
public interface AccrualByPricingPlanRepository extends JpaRepository<AccrualByPricingPlan, Long> {

    @Transactional(readOnly = true)
    @Query(value = "select * from accrual_by_pricing_plan app left join pricing_plan_status pps on app.pricing_plan_status_id = pps.pricing_plan_status_id " +
        "where contract_id=?1", nativeQuery = true)
    List<AccrualByPricingPlan> findAllByContractId(Long contractId);

    @Transactional(readOnly = true)
    @Query(value = "select * from accrual_by_pricing_plan app " +
        "where pricing_plan_status_id = :pricing_plan_status_id and date_accrual <= :date", nativeQuery = true)
    List<AccrualByPricingPlan> findByPricingPlanStatusIdAndByDate(@Param("pricing_plan_status_id") Long pricingPlanStatusId, @Param("date") Date date);

    @Transactional(readOnly = true)
    @Query(value = "select sum(amount) from accrual_by_pricing_plan app left join pricing_plan_status pps " +
        "on app.pricing_plan_status_id = pps.pricing_plan_status_id where contract_id=?1 and pps.pricing_plan_status_id=?2 " +
        "and date_accrual <= ?3", nativeQuery = true)
    Double amountSumByContractIdAndPPIdAndDateAccrual(Long contractId, Long pricingPlanId, Date dateAccrual);
}
