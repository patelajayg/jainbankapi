package com.bankingapi.bankingproject.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class EmployeeLogin {

    @Id
    int userid;
    String password;
    
    public EmployeeLogin(int userid, String password) {
        this.userid = userid;
        this.password = password;
    }

    public EmployeeLogin() {
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    

    
}
