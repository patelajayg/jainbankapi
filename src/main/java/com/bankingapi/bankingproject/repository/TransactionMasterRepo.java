package com.bankingapi.bankingproject.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.bankingapi.bankingproject.model.TransactionMaster;

public interface TransactionMasterRepo extends JpaRepository<TransactionMaster, Integer> {
    
}
