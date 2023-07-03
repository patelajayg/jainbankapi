package com.bankingapi.bankingproject.Service;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bankingapi.bankingproject.model.CustomerLogin;
import com.bankingapi.bankingproject.repository.CustomerLoginRepo;

@Service
@Transactional
public class CustomerService {
     @Autowired
     CustomerLoginRepo _CustomerLoginRepo;

    public CustomerLogin save(CustomerLogin ObjCustLogin)
    {       
        return _CustomerLoginRepo.save(ObjCustLogin);
    }
}
