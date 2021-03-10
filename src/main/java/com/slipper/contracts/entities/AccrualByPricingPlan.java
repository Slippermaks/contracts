package com.slipper.contracts.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "accrual_by_pricing_plan")
public class AccrualByPricingPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "accrual_id")
    Long accrualId;

    @ManyToOne
    @JoinColumn(name = "pricing_plan_status_id")
    PricingPlanStatus pricingPlanStatus;

    @Column(name = "amount")
    Double amount;

    @Column(name = "date_accrual")
    Date dateAccrual;

    public AccrualByPricingPlan() {
    }

    public AccrualByPricingPlan(Long accrualId, PricingPlanStatus pricingPlanStatus, Double amount, Date dateAccrual) {
        this.accrualId = accrualId;
        this.pricingPlanStatus = pricingPlanStatus;
        this.amount = amount;
        this.dateAccrual = dateAccrual;
    }

    public Long getAccrualId() {
        return accrualId;
    }

    public void setAccrualId(Long accrualId) {
        this.accrualId = accrualId;
    }

    public PricingPlanStatus getPricingPlanStatus() {
        return pricingPlanStatus;
    }

    public void setPricingPlanStatus(PricingPlanStatus pricingPlanStatus) {
        this.pricingPlanStatus = pricingPlanStatus;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getDateAccrual() {
        return dateAccrual;
    }

    public void setDateAccrual(Date dateAccrual) {
        this.dateAccrual = dateAccrual;
    }
}
