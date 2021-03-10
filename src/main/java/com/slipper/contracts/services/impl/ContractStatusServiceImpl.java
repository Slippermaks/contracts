package com.slipper.contracts.services.impl;

import com.slipper.contracts.repositories.ContractStatusRepository;
import com.slipper.contracts.services.interfaces.ContractStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContractStatusServiceImpl implements ContractStatusService {
    ContractStatusRepository contractStatusRepository;

    @Autowired
    public void setContractStatusRepository(ContractStatusRepository contractStatusRepository) {
        this.contractStatusRepository = contractStatusRepository;
    }
}
