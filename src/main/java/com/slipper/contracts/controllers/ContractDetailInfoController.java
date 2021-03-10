package com.slipper.contracts.controllers;

import com.slipper.contracts.entities.AccrualByPricingPlan;
import com.slipper.contracts.entities.Contract;
import com.slipper.contracts.entities.PricingPlanStatus;
import com.slipper.contracts.entities.Profit;
import com.slipper.contracts.services.impl.AccrualByPricingPlanServiceImpl;
import com.slipper.contracts.services.impl.ContractServiceImpl;
import com.slipper.contracts.services.impl.PricingPlanStatusServiceImpl;
import com.slipper.contracts.services.impl.ProfitServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class ContractDetailInfoController {

    private ContractServiceImpl contractService;
    private AccrualByPricingPlanServiceImpl accrualByPricingPlanService;
    private PricingPlanStatusServiceImpl pricingPlanStatusService;
    private ProfitServiceImpl profitService;

    @Autowired
    public void setContractService(ContractServiceImpl contractService) {
        this.contractService = contractService;
    }

    @Autowired
    public void setAccrualByPricingPlanService(AccrualByPricingPlanServiceImpl accrualByPricingPlanService) {
        this.accrualByPricingPlanService = accrualByPricingPlanService;
    }

    @Autowired
    public void setPricingPlanStatusService(PricingPlanStatusServiceImpl pricingPlanStatusService) {
        this.pricingPlanStatusService = pricingPlanStatusService;
    }

    @Autowired
    public void setProfitService(ProfitServiceImpl profitService) {
        this.profitService = profitService;
    }

    @GetMapping("/contract_detail_info")
    public String showDetailInfo(Model model) {
        return "contract_detail_info";
    }

    @GetMapping("/contract_detail_info/find_by_contract_number")
    public String detailPageByContractNumber(Model model, @RequestParam("contract_number") String contractNumber,
        @RequestParam("current_pricing_plan_status_id") String currentPricingPlanStatusId, @RequestParam("date") String date) {

        try {
            model.addAttribute("currentPricingPlan", currentPricingPlanStatusId);
            model.addAttribute("date", date);

            Contract selectedContract = contractService.getContractByContractNumber(contractNumber);
            model.addAttribute("selectedContract", selectedContract);

            List<PricingPlanStatus> pricingPlanStatusList = pricingPlanStatusService.findCurrentByContractId(selectedContract.getContractId());
            model.addAttribute("pricingPlanStatusList", pricingPlanStatusList);

            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            if (date != "") {

                Date parsed = format.parse(date);

                Long pricingPlanStatusId = Long.parseLong(currentPricingPlanStatusId);
                List<AccrualByPricingPlan> accrualByPricingPlanList =
                    accrualByPricingPlanService.findByPricingPlanStatusIdAndByDate(pricingPlanStatusId, parsed);
                model.addAttribute("accruals", accrualByPricingPlanList);

                List<Profit> profitList = profitService.findByPricingPlanStatusIdAndByDate(pricingPlanStatusId, parsed);
                model.addAttribute("profits", profitList);

                Double profitSum = profitService.amountSumByContractIdAndPPSIdAndDateProfit(selectedContract.getContractId(), pricingPlanStatusId, parsed);
                model.addAttribute("profitSum", profitSum);
                Double amountSum =
                    accrualByPricingPlanService.amountSumByContractIdAndPPIdAndDateAccrual(selectedContract.getContractId(), pricingPlanStatusId, parsed);
                model.addAttribute("amountSum", amountSum);
                Double balance = profitService.balanceByContractIdAndPPSIdAndDateProfit(selectedContract.getContractId(), pricingPlanStatusId, parsed);
                model.addAttribute("balance", balance);
            }
        } catch (Exception e) {
            String msg = "Sorry, we can't find contract with this contract number [" + contractNumber + "]";
            model.addAttribute("msg", msg);
        }

        //[a-zA-Z0-9\/\-]{10}

        return "contract_detail_info";
    }
}
