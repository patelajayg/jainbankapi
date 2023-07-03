package com.bankingapi.bankingproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bankingapi.bankingproject.model.CustomerLogin;

public interface CustomerLoginRepo extends JpaRepository<CustomerLogin, Integer> {
    
}
