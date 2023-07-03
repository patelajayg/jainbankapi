package com.bankingapi.bankingproject.model;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "Customer_Login")
public class CustomerLogin {
    @Id
    int customerid;
    String password;
    public CustomerLogin() {
    }
    public CustomerLogin(int customerid, String password) {
        this.customerid = customerid;
        this.password = password;
    }
    public int getCustomerid() {
        return customerid;
    }
    public void setCustomerid(int customerid) {
        this.customerid = customerid;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    

}
