package com.slipper.contracts.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pricing_plan_status")
public class PricingPlanStatus {

    @Id
    @Column(name = "pricing_plan_status_id")
    Long pricingPlanStatusId;

    @ManyToOne
    @JoinColumn(name = "pricing_plan_id")
    PricingPlan pricingPlan;

    @ManyToOne
    @JoinColumn(name = "contract_id")
    Contract contract;

    @Column(name = "date_start")
    Date dateStart;

    @Column(name = "date_end")
    Date dateEnd;

    @OneToMany(mappedBy = "pricingPlanStatus")
    List<AccrualByPricingPlan> accrualByPricingPlanList;

    @OneToMany(mappedBy = "pricingPlanStatus")
    List<Profit> profitList;

    public PricingPlanStatus() {
    }

    public PricingPlanStatus(Long pricingPlanStatusId, PricingPlan pricingPlan,
        List<AccrualByPricingPlan> accrualByPricingPlanList, Contract contract, Date dateStart, Date dateEnd) {
        this.pricingPlanStatusId = pricingPlanStatusId;
        this.pricingPlan = pricingPlan;
        this.accrualByPricingPlanList = accrualByPricingPlanList;
        this.contract = contract;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
    }

    public Long getPricingPlanStatusId() {
        return pricingPlanStatusId;
    }

    public void setPricingPlanStatusId(Long pricingPlanStatusId) {
        this.pricingPlanStatusId = pricingPlanStatusId;
    }

    public PricingPlan getPricingPlan() {
        return pricingPlan;
    }

    public void setPricingPlan(PricingPlan pricingPlan) {
        this.pricingPlan = pricingPlan;
    }

    public List<AccrualByPricingPlan> getAccrualByPricingPlanList() {
        return accrualByPricingPlanList;
    }

    public void setAccrualByPricingPlanList(List<AccrualByPricingPlan> accrualByPricingPlanList) {
        this.accrualByPricingPlanList = accrualByPricingPlanList;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }
}
