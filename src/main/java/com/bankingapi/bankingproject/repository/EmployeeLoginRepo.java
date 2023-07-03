package com.bankingapi.bankingproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bankingapi.bankingproject.model.EmployeeLogin;

public interface EmployeeLoginRepo extends JpaRepository<EmployeeLogin,Integer> {
     
}
