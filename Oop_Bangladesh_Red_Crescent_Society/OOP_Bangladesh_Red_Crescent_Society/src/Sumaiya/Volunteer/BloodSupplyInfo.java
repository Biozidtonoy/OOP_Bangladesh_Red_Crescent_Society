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
public class BloodSupplyInfo extends User{
    private String recipientName, donorName, bloodGroup;
    private int bagAmount;

    public BloodSupplyInfo(){
        
    }

    public BloodSupplyInfo(String recipientName, String donorName, String bloodGroup, int bagAmount) {
        this.recipientName = recipientName;
        this.donorName = donorName;
        this.bloodGroup = bloodGroup;
        this.bagAmount = bagAmount;
    }

    public BloodSupplyInfo(String recipientName, String donorName, String bloodGroup, int bagAmount, String usertype, String username, String email, String password, String gender, LocalDate birthday) {
        super(usertype, username, email, password, gender, birthday);
        this.recipientName = recipientName;
        this.donorName = donorName;
        this.bloodGroup = bloodGroup;
        this.bagAmount = bagAmount;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public String getDonorName() {
        return donorName;
    }

    public void setDonorName(String donorName) {
        this.donorName = donorName;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public int getBagAmount() {
        return bagAmount;
    }

    public void setBagAmount(int bagAmount) {
        this.bagAmount = bagAmount;
    }

    @Override
    public String toString() {
        return "BloodSupplyInfo{" + "recipientName=" + recipientName + ", donorName=" + donorName + ", bloodGroup=" + bloodGroup + ", bagAmount=" + bagAmount + '}';
    }
   
}
    