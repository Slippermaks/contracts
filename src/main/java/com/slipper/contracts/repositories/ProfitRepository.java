package com.slipper.contracts.repositories;

import com.slipper.contracts.entities.Profit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Repository
public interface ProfitRepository extends JpaRepository<Profit, Long> {

    @Transactional(readOnly = true)
    @Query(value = "select * from profit p " +
        "where pricing_plan_status_id = :pricing_plan_status_id and date_profit <= :date", nativeQuery = true)
    List<Profit> findByPricingPlanStatusIdAndByDate(@Param("pricing_plan_status_id") Long pricingPlanStatusId, @Param("date") Date date);

    @Transactional(readOnly = true)
    @Query(value = "select sum(amount) from profit p left join pricing_plan_status pps on pps.pricing_plan_status_id=p.pricing_plan_status_id " +
        "where contract_id=?1 and pps.pricing_plan_status_id=?2 and date_profit <= ?3", nativeQuery = true)
    Double amountSumByContractIdAndPPSIdAndDateProfit(Long contractId, Long pricingPlanStatusId, Date dateProfit);
}
