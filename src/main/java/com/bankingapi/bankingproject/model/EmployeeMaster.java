package com.bankingapi.bankingproject.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Employee_Master")
public class EmployeeMaster {
    @Id
    @Column(name = "employeeid")
    int employeeid;
    @Column(name = "name")
    String name;
    @Column(name = "password")
    String password;
    @Column(name = "isactive")
    int isactive;
    public EmployeeMaster() {
    }
    public EmployeeMaster(int employeeid, String name, String password, int isactive) {
        this.employeeid = employeeid;
        this.name = name;
        this.password = password;
        this.isactive = isactive;
    }
    public int getEmployeeid() {
        return employeeid;
    }
    public void setEmployeeid(int employeeid) {
        this.employeeid = employeeid;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public int getIsactive() {
        return isactive;
    }
    public void setIsactive(int isactive) {
        this.isactive = isactive;
    }
   

}
