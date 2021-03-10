package com.slipper.contracts.services.impl;

import com.slipper.contracts.entities.Contract;
import com.slipper.contracts.repositories.ContractRepository;
import com.slipper.contracts.services.interfaces.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractServiceImpl implements ContractService {
    ContractRepository contractRepository;

    @Autowired
    public void setContractRepository(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    @Override
    public List<Contract> getAllContracts() {
        return contractRepository.findAll();
    }

    @Override
    public Contract getContractByContractNumber(String contractNumber) {
        return contractRepository.findByContractNumber(contractNumber);
    }
}
