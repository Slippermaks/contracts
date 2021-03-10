package com.slipper.contracts.services.interfaces;

import com.slipper.contracts.entities.Profit;

import java.util.Date;
import java.util.List;

public interface ProfitService {

    List<Profit> findByPricingPlanStatusIdAndByDate(Long pricingPlanStatusId, Date date);

    Double balanceByContractIdAndPPSIdAndDateProfit(Long contractId, Long pricingPlanStatusId, Date dateProfit);

    Double amountSumByContractIdAndPPSIdAndDateProfit(Long contractId, Long pricingPlanStatusId, Date dateProfit);
}
