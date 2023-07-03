package com.bankingapi.bankingproject.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.bankingapi.bankingproject.model.AccountMaster;
import com.bankingapi.bankingproject.repository.AccountMasterRepo;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/account")
public class AccountMasterController {
	@Autowired
	AccountMasterRepo _AccountMasterRepo;

	@GetMapping("/account/account/{account}")
	public ResponseEntity<AccountMaster> getcustomer(@PathVariable("account") Integer account) {
		Optional<AccountMaster> ObjData = _AccountMasterRepo.findById(account);
		if (ObjData.isPresent()) {
			return new ResponseEntity<>(ObjData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/account/{account}")
	public ResponseEntity<List<AccountMaster>> getbranch(@RequestParam(required = false) Integer account) {
		try {
			List<AccountMaster> ObjData = new ArrayList<AccountMaster>();
			if (account == null) {
				_AccountMasterRepo.findAll().forEach(ObjData::add);
			} else {
				_AccountMasterRepo.findById(account);
			}
			if (ObjData.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(ObjData, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/account")
	public ResponseEntity<AccountMaster> UpdateProduct(@RequestBody AccountMaster cm) {
		List<AccountMaster> ObjAccount = new ArrayList<AccountMaster>();
		_AccountMasterRepo.findAll().forEach(ObjAccount::add);
		AccountMaster Obj = new AccountMaster();
		Obj.setBranchid(cm.getBranchid());
		Obj.setAccountno(cm.getAccountno());
		Obj.setProductid(cm.getProductid());
		Obj.setCustomerid(cm.getCustomerid());
		Obj.setAccountstatus(cm.getAccountstatus());
		Obj.setAccountopendate(cm.getAccountopendate());
		Obj.setBalance(cm.getBalance());
		Obj.setAccountclosedate(cm.getAccountclosedate());
		Obj.setModeofoperation(cm.getModeofoperation());
		Obj.setOpenbyuser(cm.getOpenbyuser());
		Obj.setAccountopendate(cm.getAccountopendate());
		Obj.setClosedbyuser(cm.getClosedbyuser());
		_AccountMasterRepo.save(Obj);
		return new ResponseEntity<>(Obj, HttpStatus.OK);
	}

}
