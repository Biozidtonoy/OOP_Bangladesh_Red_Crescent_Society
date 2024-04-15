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
public class training implements Serializable{
    private int phoneNumber;
    private String name,eamil,district,password,confirm,bloodGroup,about;

    public training(int phoneNumber, String name, String eamil, String district, String password, String confirm, String bloodGroup, String about) {
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.eamil = eamil;
        this.district = district;
        this.password = password;
        this.confirm = confirm;
        this.bloodGroup = bloodGroup;
        this.about = about;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirm() {
        return confirm;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    @Override
    public String toString() {
        return "training{" + "phoneNumber=" + phoneNumber + ", name=" + name + ", eamil=" + eamil + ", district=" + district + ", password=" + password + ", confirm=" + confirm + ", bloodGroup=" + bloodGroup + ", about=" + about + '}';
    }
    
    
    
}
