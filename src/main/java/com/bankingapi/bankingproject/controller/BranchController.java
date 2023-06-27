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

import com.bankingapi.bankingproject.model.BranchMaster;
import com.bankingapi.bankingproject.repository.BranchMasterRepo;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/branch")
public class BranchController {
    @Autowired
	BranchMasterRepo _BranchMasterRepo;

    @GetMapping("/branch/{id}")
	public ResponseEntity<BranchMaster> getciruclarsbyId(@PathVariable("id") Integer id) {
		Optional<BranchMaster> ObjData = _BranchMasterRepo.findById(id);
		if (ObjData.isPresent()) {
			return new ResponseEntity<>(ObjData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

   @GetMapping("/branch")
	public ResponseEntity<List<BranchMaster>> getbranch(@RequestParam(required = false) Integer id) {
		try {
			List<BranchMaster> Obj = new ArrayList<BranchMaster>();
			if (id == null) {
				_BranchMasterRepo.findAll().forEach(Obj::add);
			} else {
                _BranchMasterRepo.findByid(id).forEach(Obj::add);
			}
			if (Obj.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(Obj, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/branch")
	public ResponseEntity<BranchMaster> AddUpdateBranch(@RequestBody BranchMaster cm) {
		List<BranchMaster> ObjBranch = new ArrayList<BranchMaster>();
		_BranchMasterRepo.findAll().forEach(ObjBranch::add);
		BranchMaster Obj = new BranchMaster();
			Obj.setId(cm.getId());
			Obj.setName(cm.getName());
			_BranchMasterRepo.save(Obj);
		return new ResponseEntity<>(Obj, HttpStatus.OK);
	}
}
