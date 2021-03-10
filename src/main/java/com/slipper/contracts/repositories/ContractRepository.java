package com.slipper.contracts.repositories;

import com.slipper.contracts.entities.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ContractRepository extends JpaRepository<Contract, Long> {
    Contract findByContractNumber(String contractNumber);


}
