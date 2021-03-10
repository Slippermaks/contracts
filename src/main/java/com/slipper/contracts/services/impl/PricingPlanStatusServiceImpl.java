package com.slipper.contracts.services.impl;

import com.slipper.contracts.entities.PricingPlanStatus;
import com.slipper.contracts.repositories.PricingPlanStatusRepository;
import com.slipper.contracts.services.interfaces.PricingPlanStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PricingPlanStatusServiceImpl implements PricingPlanStatusService {
    PricingPlanStatusRepository pricingPlanStatusRepository;

    @Autowired
    public void setPricingPlanStatusRepository(PricingPlanStatusRepository pricingPlanStatusRepository) {
        this.pricingPlanStatusRepository = pricingPlanStatusRepository;
    }

    @Override
    public List<PricingPlanStatus> findCurrentByContractId(Long contractId) {
        return pricingPlanStatusRepository.findCurrentByContractId(contractId);
    }
}
