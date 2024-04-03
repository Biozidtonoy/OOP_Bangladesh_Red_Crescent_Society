/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sumaiya.Volunteer;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import Users.User;



/**
 *
 * @author Muntasir
 */
public class People extends User implements Serializable{
 private String firstName, lastName;
    private int contactInfornamtion;
    private LocalDate registrationDate;

    public People(String firstName, String lastName, int contactInfornamtion, LocalDate registrationDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactInfornamtion = contactInfornamtion;
        this.registrationDate = registrationDate;
    }

    public People(String firstName, String lastName, int contactInfornamtion, LocalDate registrationDate, String usertype, String username, String email, String password, String gender, LocalDate birthday) {
        super(usertype, username, email, password, gender, birthday);
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactInfornamtion = contactInfornamtion;
        this.registrationDate = registrationDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getContactInfornamtion() {
        return contactInfornamtion;
    }

    public void setContactInfornamtion(int contactInfornamtion) {
        this.contactInfornamtion = contactInfornamtion;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Override
    public String toString() {
        return "People{" + "firstName=" + firstName + ", lastName=" + lastName + ", contactInfornamtion=" + contactInfornamtion + ", registrationDate=" + registrationDate + '}';
    }
     
}
