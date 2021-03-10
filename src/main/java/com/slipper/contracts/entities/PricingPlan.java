package com.slipper.contracts.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "pricing_plan")
public class PricingPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pricing_plan_id")
    Long pricingPlanId;

    @Column(name = "title")
    String title;

    @Column(name = "price")
    Float price;

    @OneToMany(mappedBy = "pricingPlan", orphanRemoval = true)
    List<PricingPlanStatus> pricingPlanStatusList;

    public PricingPlan() {
    }

    public PricingPlan(Long pricingPlanId, String title, Float price, List<PricingPlanStatus> pricingPlanStatusList) {
        this.pricingPlanId = pricingPlanId;
        this.title = title;
        this.price = price;
        this.pricingPlanStatusList = pricingPlanStatusList;
    }

    public Long getPricingPlanId() {
        return pricingPlanId;
    }

    public void setPricingPlanId(Long pricingPlanId) {
        this.pricingPlanId = pricingPlanId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public List<PricingPlanStatus> getPricingPlanStatusList() {
        return pricingPlanStatusList;
    }

    public void setPricingPlanStatusList(List<PricingPlanStatus> pricingPlanStatusList) {
        this.pricingPlanStatusList = pricingPlanStatusList;
    }
}
