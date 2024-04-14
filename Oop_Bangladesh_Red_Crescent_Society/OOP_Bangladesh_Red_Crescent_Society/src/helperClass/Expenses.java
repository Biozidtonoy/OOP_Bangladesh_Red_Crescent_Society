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
public class Expenses implements Serializable {
    private int id;
    private String amount,spendReason,detailsexpenses;
    private LocalDate date;

    public Expenses(int id, String amount, String spendReason, String detailsexpenses, LocalDate date) {
        this.id = id;
        this.amount = amount;
        this.spendReason = spendReason;
        this.detailsexpenses = detailsexpenses;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getSpendReason() {
        return spendReason;
    }

    public void setSpendReason(String spendReason) {
        this.spendReason = spendReason;
    }

    public String getDetailsexpenses() {
        return detailsexpenses;
    }

    public void setDetailsexpenses(String detailsexpenses) {
        this.detailsexpenses = detailsexpenses;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Expenses{" + "id=" + id + ", amount=" + amount + ", spendReason=" + spendReason + ", detailsexpenses=" + detailsexpenses + ", date=" + date + '}';
    }
    
    

    public String getDetails() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    
}
