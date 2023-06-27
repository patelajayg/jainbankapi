package com.bankingapi.bankingproject.model;
import java.io.Serializable;

public class ProductMasterPk implements Serializable{
    private int BranchId;
    private int ProductCode;
    
    public ProductMasterPk() {}
    public ProductMasterPk(int branchId, int productCode) {
        BranchId = branchId;
        ProductCode = productCode;
    }
    public int getBranchId() {
        return BranchId;
    }
    public void setBranchId(int branchId) {
        BranchId = branchId;
    }
    public int getProductCode() {
        return ProductCode;
    }
    public void setProductCode(int productCode) {
        ProductCode = productCode;
    }
      
    
}
