/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mehedi.Manager;

/**
 *
 * @author Elitebook 830
 */
public class Volunteer {
     private String name;
    private int volunteerId;
    private String mail;

    public Volunteer(String name, int volunteerId, String mail) {
        this.name = name;
        this.volunteerId = volunteerId;
        this.mail = mail;
    }

    Volunteer(String name, String volunteerID, String email) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getName() {
        return name;
    }

    public int getVolunteerId() {
        return volunteerId;
    }

    public String getMail() {
        return mail;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVolunteerId(int volunteerId) {
        this.volunteerId = volunteerId;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}

   
