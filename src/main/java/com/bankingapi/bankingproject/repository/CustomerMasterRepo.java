package com.bankingapi.bankingproject.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.bankingapi.bankingproject.model.CustomerMaster;

public interface CustomerMasterRepo extends JpaRepository<CustomerMaster, Integer>  {
    List<CustomerMaster> findBycustomerid(Integer id);
}
