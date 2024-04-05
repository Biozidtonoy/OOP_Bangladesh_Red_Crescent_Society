/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sumaiya.Volunteer;

import Users.User;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Muntasir
 */
public class Shelter extends User implements Serializable{
     private String typeOfShelter, location, leaderName;
    private int volunteerAmount,id, contactNumber;

    public Shelter(){
        
    }

    public Shelter(String typeOfShelter, String location, String leaderName, int volunteerAmount, int id, int contactNumber) {
        this.typeOfShelter = typeOfShelter;
        this.location = location;
        this.leaderName = leaderName;
        this.volunteerAmount = volunteerAmount;
        this.id = id;
        this.contactNumber = contactNumber;
    }

    public Shelter(String typeOfShelter, String location, String leaderName, int volunteerAmount, int id, int contactNumber, String usertype, String username, String email, String password, String gender, LocalDate birthday) {
        super(usertype, username, email, password, gender, birthday);
        this.typeOfShelter = typeOfShelter;
        this.location = location;
        this.leaderName = leaderName;
        this.volunteerAmount = volunteerAmount;
        this.id = id;
        this.contactNumber = contactNumber;
    }

    public String getTypeOfShelter() {
        return typeOfShelter;
    }

    public void setTypeOfShelter(String typeOfShelter) {
        this.typeOfShelter = typeOfShelter;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLeaderName() {
        return leaderName;
    }

    public void setLeaderName(String leaderName) {
        this.leaderName = leaderName;
    }

    public int getVolunteerAmount() {
        return volunteerAmount;
    }

    public void setVolunteerAmount(int volunteerAmount) {
        this.volunteerAmount = volunteerAmount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(int contactNumber) {
        this.contactNumber = contactNumber;
    }

    @Override
    public String toString() {
        return "Shelter{" + "typeOfShelter=" + typeOfShelter + ", location=" + location + ", leaderName=" + leaderName + ", volunteerAmount=" + volunteerAmount + ", id=" + id + ", contactNumber=" + contactNumber + '}';
    }
 private static final String shelterListPath = "shelter.bin";
    
    public static void saveShelterReportRecord(String typeOfShelter, String location, String leaderName, int volunteerAmount, int id, int contactNumber) {
        Shelter shelterReport = new Shelter(typeOfShelter, location, leaderName,volunteerAmount,id,contactNumber);
        List<Shelter> existingRepots = loadShelterReportRecords();
        existingRepots.add(shelterReport);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(shelterListPath))) {
            for (Shelter reports : existingRepots) {
                oos.writeObject(reports);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static List<Shelter> loadShelterReportRecords() {
        List<Shelter> shelterReports = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(shelterListPath))) {
           while (true) {
              try {
                 Shelter reports = (Shelter) ois.readObject();
                 shelterReports.add(reports);
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return shelterReports;
    } 
  
    
}
