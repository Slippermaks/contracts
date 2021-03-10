package com.slipper.contracts.controllers;

import com.slipper.contracts.entities.Contract;
import com.slipper.contracts.services.impl.ContractServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ContractsController {

    private ContractServiceImpl contractService;

    @Autowired
    public void setContractService(ContractServiceImpl contractService) {
        this.contractService = contractService;
    }

    @GetMapping("/contracts")
    public String showInfo(Model model) {
        List<Contract> contracts = contractService.getAllContracts();
        model.addAttribute("contracts", contracts);

        return "contracts";
    }
}
