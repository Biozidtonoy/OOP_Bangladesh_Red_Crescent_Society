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
public class Volunteer implements Serializable{
    private int phoneNumber;
    private String name,email,district,password,confirm,bloodGroup,about;

    public Volunteer(int phoneNumber, String name, String email, String district, String password, String confirm, String bloodGroup, String about) {
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        return "Volunteer{" + "phoneNumber=" + phoneNumber + ", name=" + name + ", email=" + email + ", district=" + district + ", password=" + password + ", confirm=" + confirm + ", bloodGroup=" + bloodGroup + ", about=" + about + '}';
    }
    
    
    
}
