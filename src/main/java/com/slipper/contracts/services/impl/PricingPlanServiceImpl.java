package com.slipper.contracts.services.impl;

import com.slipper.contracts.repositories.PricingPlanRepository;
import com.slipper.contracts.services.interfaces.PricingPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PricingPlanServiceImpl implements PricingPlanService {
    PricingPlanRepository pricingPlanRepository;

    @Autowired
    public void setPricingPlanRepository(PricingPlanRepository pricingPlanRepository) {
        this.pricingPlanRepository = pricingPlanRepository;
    }
}
