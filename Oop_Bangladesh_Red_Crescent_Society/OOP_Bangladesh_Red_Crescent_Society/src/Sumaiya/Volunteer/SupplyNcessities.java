/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sumaiya.Volunteer;

import Users.User;
import java.time.LocalDate;

/**
 *
 * @author Muntasir
 */
public class SupplyNcessities extends User{
    private String nameOfSupply, gender1;
    private int amount;

    public SupplyNcessities(String nameOfSupply, String gender1, int amount) {
        this.nameOfSupply = nameOfSupply;
        this.gender1 = gender1;
        this.amount = amount;
    }

    public SupplyNcessities(String nameOfSupply, String gender1, int amount, String usertype, String username, String email, String password, String gender, LocalDate birthday) {
        super(usertype, username, email, password, gender, birthday);
        this.nameOfSupply = nameOfSupply;
        this.gender1 = gender1;
        this.amount = amount;
    }

    public String getNameOfSupply() {
        return nameOfSupply;
    }

    public void setNameOfSupply(String nameOfSupply) {
        this.nameOfSupply = nameOfSupply;
    }

    public String getGender1() {
        return gender1;
    }

    public void setGender1(String gender1) {
        this.gender1 = gender1;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "SupplyNcessities{" + "nameOfSupply=" + nameOfSupply + ", gender1=" + gender1 + ", amount=" + amount + '}';
    }

}
