package com.bankingapi.bankingproject.model;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "Product_Master")
@IdClass(ProductMasterPk.class)
public class ProductMaster  implements Serializable{
    @Id
    private int BranchId;
    @Id
    private int ProductCode;
    private String ProductName;
    private int ModuleType;
    private int ProductStatus;
    public ProductMaster() {
    }
    
    public ProductMaster(int branchId, int productCode, String productName, int moduleType, int productStatus) {
        BranchId = branchId;
        ProductCode = productCode;
        ProductName = productName;
        ModuleType = moduleType;
        ProductStatus = productStatus;
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
    public String getProductName() {
        return ProductName;
    }
    public void setProductName(String productName) {
        ProductName = productName;
    }
    public int getModuleType() {
        return ModuleType;
    }
    public void setModuleType(int moduleType) {
        ModuleType = moduleType;
    }
    public int getProductStatus() {
        return ProductStatus;
    }
    public void setProductStatus(int productStatus) {
        ProductStatus = productStatus;
    }
    


    }
