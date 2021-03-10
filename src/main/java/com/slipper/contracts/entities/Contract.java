package com.slipper.contracts.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "contract")
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contract_id")
    Long contractId;

    @Column(name = "contract_number")
    String contractNumber;

    @Column(name = "first_name")
    String firstName;

    @Column(name = "last_name")
    String lastName;

    @Column(name = "patronymic")
    String patronymic;

    @Column(name = "is_individual")
    Boolean isIndividual;

    @ManyToOne
    @JoinColumn(name = "address_id")
    Address address;

    @ManyToOne
    @JoinColumn(name = "contract_status_id")
    ContractStatus contractStatus;

    @OneToMany(mappedBy = "contract")
    List<PricingPlanStatus> pricingPlanStatus;

    public Contract() {
    }

    public Contract(Long contractId, String contractNumber, String firstName, String lastName, String patronymic, Boolean isIndividual,
        Address address, ContractStatus contractStatus, List<PricingPlanStatus> pricingPlanStatus) {
        this.contractId = contractId;
        this.contractNumber = contractNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.isIndividual = isIndividual;
        this.address = address;
        this.contractStatus = contractStatus;
        this.pricingPlanStatus = pricingPlanStatus;
    }

    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Boolean getIndividual() {
        return isIndividual;
    }

    public void setIndividual(Boolean individual) {
        isIndividual = individual;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public ContractStatus getContractStatus() {
        return contractStatus;
    }

    public void setContractStatus(ContractStatus contractStatus) {
        this.contractStatus = contractStatus;
    }

    public List<PricingPlanStatus> getPricingPlanStatus() {
        return pricingPlanStatus;
    }

    public void setPricingPlanStatus(List<PricingPlanStatus> pricingPlanStatus) {
        this.pricingPlanStatus = pricingPlanStatus;
    }
}
