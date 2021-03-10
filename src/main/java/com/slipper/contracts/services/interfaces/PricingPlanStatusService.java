package com.slipper.contracts.services.interfaces;

import com.slipper.contracts.entities.PricingPlanStatus;

import java.util.List;

public interface PricingPlanStatusService {

    List<PricingPlanStatus> findCurrentByContractId(Long contractId);
}
