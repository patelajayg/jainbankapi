package com.bankingapi.bankingproject.controller;

import java.util.ArrayList;
import java.util.List;
//import java.util.Optional;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bankingapi.bankingproject.model.BranchMaster;
import com.bankingapi.bankingproject.model.ProductMaster;
import com.bankingapi.bankingproject.model.ProductMasterPk;
//import com.bankingapi.bankingproject.model.ProductMasterPk;
import com.bankingapi.bankingproject.repository.BranchMasterRepo;
import com.bankingapi.bankingproject.repository.ProductMasterRepo;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductMasterRepo _ProductMasterRepo;
	@Autowired
	BranchMasterRepo _BranchMasterRepo;

	// Add/update Product for All Branches
	@GetMapping("/product/{branchid}/{productid}")
	public ResponseEntity<ProductMaster> getciruclarsbyId(@PathVariable("branchid") Integer branchid,
			@PathVariable("productid") Integer productid) {
		ProductMasterPk pk = new ProductMasterPk(branchid, productid);
		Optional<ProductMaster> ObjData = _ProductMasterRepo.findById(pk);
		if (ObjData.isPresent()) {
			return new ResponseEntity<>(ObjData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/product")
	public ResponseEntity<List<ProductMaster>> getbranch(@RequestParam(required = false) Integer branchid,
			@RequestParam(required = false) Integer productid) {
		try {
			List<ProductMaster> ObjData = new ArrayList<ProductMaster>();
			if (branchid == null) {
				_ProductMasterRepo.findAll().forEach(ObjData::add);
			} else {
				ProductMasterPk pk = new ProductMasterPk(branchid, productid);
				_ProductMasterRepo.findById(pk);
			}
			if (ObjData.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(ObjData, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/product")
	public ResponseEntity<ProductMaster> UpdateProduct(@RequestBody ProductMaster cm) {
		List<BranchMaster> ObjBranch = new ArrayList<BranchMaster>();
		_BranchMasterRepo.findAll().forEach(ObjBranch::add);
		ProductMaster Obj = new ProductMaster();
		for (BranchMaster branchMaster : ObjBranch) {
			Obj.setBranchId(branchMaster.getId());
			Obj.setProductCode(cm.getProductCode());
			Obj.setModuleType(cm.getModuleType());
			Obj.setProductName(cm.getProductName());
			Obj.setProductStatus(cm.getProductStatus());
			_ProductMasterRepo.save(Obj);
		}
		return new ResponseEntity<>(Obj, HttpStatus.OK);
	}

}
