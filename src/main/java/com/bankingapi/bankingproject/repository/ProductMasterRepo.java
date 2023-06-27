package com.bankingapi.bankingproject.repository;
//import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

//import com.bankingapi.bankingproject.model.BranchMaster;
import com.bankingapi.bankingproject.model.ProductMaster;
import com.bankingapi.bankingproject.model.ProductMasterPk;

public interface ProductMasterRepo extends JpaRepository<ProductMaster,ProductMasterPk> {
    //List<ProductMaster> findByid(ProductMasterPk id);
    //List<ProductMaster> findBybranchId(ProductMasterPk id);
}
