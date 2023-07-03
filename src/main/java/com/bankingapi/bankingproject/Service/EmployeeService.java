package com.bankingapi.bankingproject.Service;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankingapi.bankingproject.model.EmployeeMaster;
import com.bankingapi.bankingproject.repository.EmployeeMasterRepo;

@Service
@Transactional
public class EmployeeService {
  
    @Autowired
    EmployeeMasterRepo _EmployeeMasterRepo;

    public EmployeeMaster save(EmployeeMaster emp)
    {       
        return _EmployeeMasterRepo.save(emp);
    }

    
}
