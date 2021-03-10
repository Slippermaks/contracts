package com.slipper.contracts.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "profit")
public class Profit {

    @Id
    @Column(name = "profit_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long profitId;

    @Column(name = "amount")
    Double amount;

    @Column(name = "date_profit")
    Date dateProfit;

    @ManyToOne
    @JoinColumn(name = "pricing_plan_status_id")
    PricingPlanStatus pricingPlanStatus;

    public Profit() {
    }

    public Profit(Long profitId, Double amount, Date dateProfit, PricingPlanStatus pricingPlanStatus) {
        this.profitId = profitId;
        this.amount = amount;
        this.dateProfit = dateProfit;
        this.pricingPlanStatus = pricingPlanStatus;
    }

    public Long getProfitId() {
        return profitId;
    }

    public void setProfitId(Long profitId) {
        this.profitId = profitId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getDateProfit() {
        return dateProfit;
    }

    public void setDateProfit(Date dateProfit) {
        this.dateProfit = dateProfit;
    }

    public PricingPlanStatus getPricingPlanStatus() {
        return pricingPlanStatus;
    }

    public void setPricingPlanStatus(PricingPlanStatus pricingPlanStatus) {
        this.pricingPlanStatus = pricingPlanStatus;
    }
}
