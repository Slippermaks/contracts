package com.slipper.contracts.services.impl;

import com.slipper.contracts.entities.Profit;
import com.slipper.contracts.repositories.AccrualByPricingPlanRepository;
import com.slipper.contracts.repositories.ProfitRepository;
import com.slipper.contracts.services.interfaces.ProfitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProfitServiceImpl implements ProfitService {
    ProfitRepository profitRepository;
    AccrualByPricingPlanRepository accrualByPricingPlanRepository;

    @Autowired
    public void setProfitRepository(ProfitRepository profitRepository) {
        this.profitRepository = profitRepository;
    }

    @Autowired
    public void setAccrualByPricingPlanRepository(AccrualByPricingPlanRepository accrualByPricingPlanRepository) {
        this.accrualByPricingPlanRepository = accrualByPricingPlanRepository;
    }

    @Override
    public List<Profit> findByPricingPlanStatusIdAndByDate(Long pricingPlanStatusId, Date date) {
        return profitRepository.findByPricingPlanStatusIdAndByDate(pricingPlanStatusId, date);
    }

    @Override
    public Double balanceByContractIdAndPPSIdAndDateProfit(Long contractId, Long pricingPlanStatusId, Date dateProfit) {
        Double balance = profitRepository.amountSumByContractIdAndPPSIdAndDateProfit(contractId, pricingPlanStatusId, dateProfit);
        Double accrual = accrualByPricingPlanRepository.amountSumByContractIdAndPPIdAndDateAccrual(contractId, pricingPlanStatusId, dateProfit);
        balance -= accrual;
        return balance;
    }

    @Override
    public Double amountSumByContractIdAndPPSIdAndDateProfit(Long contractId, Long pricingPlanStatusId, Date dateProfit) {
        return profitRepository.amountSumByContractIdAndPPSIdAndDateProfit(contractId, pricingPlanStatusId, dateProfit);
    }
}
