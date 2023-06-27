package com.bankingapi.bankingproject.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.bankingapi.bankingproject.model.AccountMaster;

public interface AccountMasterRepo  extends JpaRepository<AccountMaster, Integer> {
    
}
