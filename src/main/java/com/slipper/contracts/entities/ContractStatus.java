package com.slipper.contracts.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "contract_status")
public class ContractStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contract_status_id")
    Long contractStatusId;

    @Column(name = "status")
    String status;

    @OneToMany(mappedBy = "contractStatus")
    List<Contract> contractList;

    public ContractStatus() {
    }

    public ContractStatus(Long contractStatusId, String status, List<Contract> contractList) {
        this.contractStatusId = contractStatusId;
        this.status = status;
        this.contractList = contractList;
    }

    public Long getContractStatusId() {
        return contractStatusId;
    }

    public void setContractStatusId(Long contractStatusId) {
        this.contractStatusId = contractStatusId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Contract> getContractList() {
        return contractList;
    }

    public void setContractList(List<Contract> contractList) {
        this.contractList = contractList;
    }
}
