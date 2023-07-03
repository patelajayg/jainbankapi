package com.bankingapi.bankingproject.controller;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bankingapi.bankingproject.model.CustomerLogin;
import com.bankingapi.bankingproject.model.CustomerMaster;
import com.bankingapi.bankingproject.repository.CustomerLoginRepo;
import com.bankingapi.bankingproject.repository.CustomerMasterRepo;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/customerlogin")
public class CustomerLoginController {

    @Autowired
    CustomerLoginRepo _CustomerLoginRepo;
    @Autowired
    CustomerMasterRepo _CustomerMasterRepo;

    @GetMapping("/login")
    public ResponseEntity<CustomerLogin> CustomerLogin(@RequestBody CustomerLogin UserObj) {
        Optional<CustomerLogin> ObjData = _CustomerLoginRepo.findById(UserObj.getCustomerid());
        if (ObjData.isPresent()) {
            CustomerLogin Emp = ObjData.get();
            if (Emp.getPassword() == UserObj.getPassword()) {
                return new ResponseEntity<>(UserObj, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PostMapping("/signup")
    public ResponseEntity<CustomerLogin> SignUp(@RequestBody CustomerLogin cm) {
        Optional<CustomerMaster> ObjData = _CustomerMasterRepo.findById(cm.getCustomerid());
        if (ObjData.isPresent()) {
            //List<CustomerLogin> Obj = new ArrayList<CustomerLogin>();
            //_CustomerLoginRepo.findAll().forEach(Obj::add);
            CustomerLogin Cust = new CustomerLogin();
            Cust.setCustomerid(cm.getCustomerid());
            Cust.setPassword(cm.getPassword());
            _CustomerLoginRepo.save(Cust);
            return new ResponseEntity<>(Cust, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
