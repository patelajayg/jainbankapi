package com.bankingapi.bankingproject.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bankingapi.bankingproject.model.TransactionMaster;
import com.bankingapi.bankingproject.repository.TransactionMasterRepo;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/transaction")
public class TransactionMasterController {

    @Autowired
    TransactionMasterRepo _TransactionMasterRepo;

    @PostMapping("/transaction")
    public ResponseEntity<TransactionMaster> UpdateProduct(@RequestBody TransactionMaster cm) {
        List<TransactionMaster> ObjAccount = new ArrayList<TransactionMaster>();
        _TransactionMasterRepo.findAll().forEach(ObjAccount::add);
        TransactionMaster Obj = new TransactionMaster();
        Obj.setBranchid(cm.getBranchid());
        Obj.setTxndate(cm.getTxndate());
        Obj.setTxnid(cm.getTxnid());
        Obj.setAccountid(cm.getAccountid());
        Obj.setInstrno(cm.getInstrno());
        Obj.setNarration(cm.getNarration());
        Obj.setMaker(cm.getMaker());
        Obj.setDrcr(cm.getDrcr());
        Obj.setOpeningbalance(cm.getOpeningbalance());
        Obj.setTxnamount(cm.getTxnamount());
        Obj.setClossingbalance(cm.getClossingbalance());
        _TransactionMasterRepo.save(Obj);
        return new ResponseEntity<>(Obj, HttpStatus.OK);
    }

}
