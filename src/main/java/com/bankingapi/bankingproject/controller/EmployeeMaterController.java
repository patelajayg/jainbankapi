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
import com.bankingapi.bankingproject.Service.EmployeeService;
import com.bankingapi.bankingproject.model.EmployeeLogin;
import com.bankingapi.bankingproject.model.EmployeeMaster;
import com.bankingapi.bankingproject.repository.EmployeeLoginRepo;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/employee")
public class EmployeeMaterController {

    @Autowired
    EmployeeService _EmployeeService;

    @Autowired
    EmployeeLoginRepo _EmployeeLoginRepo;

    @PostMapping("/save")
    public ResponseEntity<EmployeeMaster> SaveEmployee(@RequestBody EmployeeMaster emp){
        return  new ResponseEntity<>( _EmployeeService.save(emp), HttpStatus.OK); 
    }

    @GetMapping("/login")
    public ResponseEntity<EmployeeLogin> EmployeeLogin(@RequestBody EmployeeLogin UserObj){      
        Optional<EmployeeLogin> ObjData = _EmployeeLoginRepo.findById(UserObj.getUserid());
        if(ObjData.isPresent())
        {
            EmployeeLogin Emp = ObjData.get();
            if(Emp.getPassword()==UserObj.getPassword())
            {
                return  new ResponseEntity<>(UserObj,HttpStatus.OK); 
            }
        }
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT); 
    }
    


}
