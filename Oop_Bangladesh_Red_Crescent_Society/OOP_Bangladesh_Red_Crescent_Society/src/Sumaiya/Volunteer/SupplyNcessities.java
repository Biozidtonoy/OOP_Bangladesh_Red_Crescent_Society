/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sumaiya.Volunteer;

/**
 *
 * @author Muntasir
 */
public class SupplyNcessities {
    private String nameOfSupply, gender;
    private int amount;

    public SupplyNcessities(String nameOfSupply, String gender, int amount) {
        this.nameOfSupply = nameOfSupply;
        this.gender = gender;
        this.amount = amount;
    }

    public String getNameOfSupply() {
        return nameOfSupply;
    }

    public void setNameOfSupply(String nameOfSupply) {
        this.nameOfSupply = nameOfSupply;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Supply{" + "nameOfSupply=" + nameOfSupply + ", gender=" + gender + ", amount=" + amount + '}';
    }
   
    
}
