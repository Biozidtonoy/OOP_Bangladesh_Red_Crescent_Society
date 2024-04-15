/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helperClass;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author HP
 */
public class Donor implements Serializable{
    private int id;
    private String name;
    private double donation,accountNo;
    private LocalDate date;

    public Donor(int id, String name, double donation, double accountNo, LocalDate date) {
        this.id = id;
        this.name = name;
        this.donation = donation;
        this.accountNo = accountNo;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDonation() {
        return donation;
    }

    public void setDonation(double donation) {
        this.donation = donation;
    }

    public double getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(double accountNo) {
        this.accountNo = accountNo;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Donor{" + "id=" + id + ", name=" + name + ", donation=" + donation + ", accountNo=" + accountNo + ", date=" + date + '}';
    }
    
    
    
    
}
