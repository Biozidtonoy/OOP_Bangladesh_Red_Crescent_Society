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
public class FirstAid extends User{
    private String patientName,gender1,injuryType;
    private int age;
    private LocalDate firtAidProvidingDate;

public FirstAid() {
   
    }

    public FirstAid(String patientName, String gender1, String injuryType, int age, LocalDate firtAidProvidingDate) {
        this.patientName = patientName;
        this.gender1 = gender1;
        this.injuryType = injuryType;
        this.age = age;
        this.firtAidProvidingDate = firtAidProvidingDate;
    }

    public FirstAid(String patientName, String gender1, String injuryType, int age, LocalDate firtAidProvidingDate, String usertype, String username, String email, String password, String gender, LocalDate birthday) {
        super(usertype, username, email, password, gender, birthday);
        this.patientName = patientName;
        this.gender1 = gender1;
        this.injuryType = injuryType;
        this.age = age;
        this.firtAidProvidingDate = firtAidProvidingDate;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getGender1() {
        return gender1;
    }

    public void setGender1(String gender1) {
        this.gender1 = gender1;
    }

    public String getInjuryType() {
        return injuryType;
    }

    public void setInjuryType(String injuryType) {
        this.injuryType = injuryType;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getFirtAidProvidingDate() {
        return firtAidProvidingDate;
    }

    public void setFirtAidProvidingDate(LocalDate firtAidProvidingDate) {
        this.firtAidProvidingDate = firtAidProvidingDate;
    }
    @Override
    public String toString() {
        return "FirstAid{" + "patientName=" + patientName + ", gender1=" + gender1 + ", injuryType=" + injuryType + ", age=" + age + ", firtAidProvidingDate=" + firtAidProvidingDate + '}';
    }

}
