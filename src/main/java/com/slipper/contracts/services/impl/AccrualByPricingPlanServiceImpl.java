package com.slipper.contracts.services.impl;

import com.slipper.contracts.entities.AccrualByPricingPlan;
import com.slipper.contracts.repositories.AccrualByPricingPlanRepository;
import com.slipper.contracts.services.interfaces.AccrualByPricingPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AccrualByPricingPlanServiceImpl implements AccrualByPricingPlanService {
    AccrualByPricingPlanRepository accrualByPricingPlanRepository;

    @Autowired
    public void setAccrualByPricingPlanRepository(AccrualByPricingPlanRepository accrualByPricingPlanRepository) {
        this.accrualByPricingPlanRepository = accrualByPricingPlanRepository;
    }

    @Override
    public List<AccrualByPricingPlan> findByPricingPlanStatusIdAndByDate(Long pricingPlanStatusId, Date date) {
        return accrualByPricingPlanRepository.findByPricingPlanStatusIdAndByDate(pricingPlanStatusId, date);
    }

    @Override
    public Double amountSumByContractIdAndPPIdAndDateAccrual(Long contractId, Long pricingPlanId, Date dateAccrual) {
        return accrualByPricingPlanRepository.amountSumByContractIdAndPPIdAndDateAccrual(contractId, pricingPlanId, dateAccrual);
    }
}
