package com.slipper.contracts.services.interfaces;

import com.slipper.contracts.entities.AccrualByPricingPlan;

import java.util.Date;
import java.util.List;

public interface AccrualByPricingPlanService {

    List<AccrualByPricingPlan> findByPricingPlanStatusIdAndByDate(Long pricingPlanStatusId, Date date);

    Double amountSumByContractIdAndPPIdAndDateAccrual(Long contractId, Long pricingPlanId, Date dateAccrual);
}
