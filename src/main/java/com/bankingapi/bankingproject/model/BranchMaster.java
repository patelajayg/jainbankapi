package com.bankingapi.bankingproject.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "branch_master") 
public class BranchMaster {
    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    public BranchMaster() {
    }
    public BranchMaster(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    

}

