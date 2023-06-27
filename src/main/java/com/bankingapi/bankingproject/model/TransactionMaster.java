package com.bankingapi.bankingproject.model;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transaction_master")
public class TransactionMaster  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int txnid;
    private int branchid;
    private Date txndate;
    private int accountid;
    private String instrno;
    private String narration;
    private int maker;
    private String drcr;
    private float openingbalance;
    private float txnamount;
    private float clossingbalance;
    public TransactionMaster() {
    }
    public TransactionMaster(int txnid, int branchid, Date txndate, int accountid, String instrno, String narration,
            int maker, String drcr, float openingbalance, float txnamount, float clossingbalance) {
        this.txnid = txnid;
        this.branchid = branchid;
        this.txndate = txndate;
        this.accountid = accountid;
        this.instrno = instrno;
        this.narration = narration;
        this.maker = maker;
        this.drcr = drcr;
        this.openingbalance = openingbalance;
        this.txnamount = txnamount;
        this.clossingbalance = clossingbalance;
    }
    public int getTxnid() {
        return txnid;
    }
    public void setTxnid(int txnid) {
        this.txnid = txnid;
    }
    public int getBranchid() {
        return branchid;
    }
    public void setBranchid(int branchid) {
        this.branchid = branchid;
    }
    public Date getTxndate() {
        return txndate;
    }
    public void setTxndate(Date txndate) {
        this.txndate = txndate;
    }
    public int getAccountid() {
        return accountid;
    }
    public void setAccountid(int accountid) {
        this.accountid = accountid;
    }
    public String getInstrno() {
        return instrno;
    }
    public void setInstrno(String instrno) {
        this.instrno = instrno;
    }
    public String getNarration() {
        return narration;
    }
    public void setNarration(String narration) {
        this.narration = narration;
    }
    public int getMaker() {
        return maker;
    }
    public void setMaker(int maker) {
        this.maker = maker;
    }
    public String getDrcr() {
        return drcr;
    }
    public void setDrcr(String drcr) {
        this.drcr = drcr;
    }
    public float getOpeningbalance() {
        return openingbalance;
    }
    public void setOpeningbalance(float openingbalance) {
        this.openingbalance = openingbalance;
    }
    public float getTxnamount() {
        return txnamount;
    }
    public void setTxnamount(float txnamount) {
        this.txnamount = txnamount;
    }
    public float getClossingbalance() {
        return clossingbalance;
    }
    public void setClossingbalance(float clossingbalance) {
        this.clossingbalance = clossingbalance;
    }
    

}
