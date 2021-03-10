package com.slipper.contracts.services.interfaces;

import com.slipper.contracts.entities.Contract;

import java.util.List;

public interface ContractService {

    List<Contract> getAllContracts();

    Contract getContractByContractNumber(String contractNumber);
}
