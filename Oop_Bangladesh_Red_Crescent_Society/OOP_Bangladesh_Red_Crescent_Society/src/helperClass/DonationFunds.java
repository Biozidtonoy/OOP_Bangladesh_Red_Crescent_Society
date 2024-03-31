
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helperClass;

import java.io.Serializable;

/**
 *
 * @author tonoy
 */
public class DonationFunds implements Serializable{
    private String name,email,country,paymentmethod;
    private int amount,phone;

    public DonationFunds (String name, String email, String country, String paymentmethod, int amount, int phone) {
        this.name = name;
        this.email = email;
        this.country = country;
        this.paymentmethod = paymentmethod;
        this.amount = amount;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPaymentmethod() {
        return paymentmethod;
    }

    public void setPaymentmethod(String paymentmethod) {
        this.paymentmethod = paymentmethod;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "DonationFunds{" + "name=" + name + ", email=" + email + ", country=" + country + ", paymentmethod=" + paymentmethod + ", amount=" + amount + ", phone=" + phone + '}';
    }
    
}
