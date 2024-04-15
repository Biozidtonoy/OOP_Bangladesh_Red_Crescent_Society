/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helperClass;

import java.io.Serializable;

/**
 *
 * @author HP
 */
public class BloodDonate implements Serializable{

    public static int get;
    private int id,phoneNumber;
    private String name,password,eamil,district,bloodGroup;

    public BloodDonate(int id, int phoneNumber, String name, String password, String eamil, String district, String bloodGroup) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.password = password;
        this.eamil = eamil;
        this.district = district;
        this.bloodGroup = bloodGroup;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    public String getEamil() {
        return eamil;
    }

    public void setEamil(String eamil) {
        this.eamil = eamil;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    @Override
    public String toString() {
        return "BloodDonate{" + "id=" + id + ", phoneNumber=" + phoneNumber + ", name=" + name + ", password=" + password + ", eamil=" + eamil + ", district=" + district + ", bloodGroup=" + bloodGroup + '}';
    }
    
    
    
}
