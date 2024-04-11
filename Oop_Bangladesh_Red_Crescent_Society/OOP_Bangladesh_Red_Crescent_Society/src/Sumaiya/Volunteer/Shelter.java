/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sumaiya.Volunteer;

import Sumaiya.Trainer.HealthEducationTraining;
import Users.User;
import helperClass.AppendableObjectOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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

     public boolean creatShelter(Shelter  fb1) {


        System.out.println("shelter made:" + fb1.toString());

        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {

            f = new File("shelter.bin");

            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);

            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            fb1 = new Shelter(typeOfShelter, location, leaderName, volunteerAmount, id, contactNumber);

            oos.writeObject(fb1);
            oos.close();
            return true;

        } catch (IOException e) {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException ex) {
                    Logger.getLogger(Shelter .class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            System.out.println("Error writing Object to binary file");
            return false;

        }
    }

    public static ObservableList<Shelter> shelter(){
        ObservableList<Shelter> shelterList = FXCollections.observableArrayList();
        Shelter fb3;
        ObjectInputStream ois = null;
        try{
            ois = new ObjectInputStream (new FileInputStream("shelter.bin"));
            while(true){
               fb3 = (Shelter) ois.readObject();
                System.out.println("The healthbin u read: "+fb3.toString());
                shelterList.add(fb3);
            }
        }
        catch(IOException | ClassNotFoundException e){System.out.println("File reading done");}
        System.out.println(shelterList);
        return shelterList;
    }
    
}
