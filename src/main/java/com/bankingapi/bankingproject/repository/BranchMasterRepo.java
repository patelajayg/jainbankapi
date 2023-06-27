package com.bankingapi.bankingproject.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bankingapi.bankingproject.model.BranchMaster;

@Transactional
public interface BranchMasterRepo extends JpaRepository<BranchMaster,Integer> {
     List<BranchMaster> findByid(Integer id);
}
