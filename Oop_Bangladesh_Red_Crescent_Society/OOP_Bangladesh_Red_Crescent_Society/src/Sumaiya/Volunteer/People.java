/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sumaiya.Volunteer;

import Sumaiya.Trainer.HealthEducationTraining;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import Users.User;
import helperClass.AppendableObjectOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;



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
     
    public boolean creatPeopleList(People  fb1) {


        System.out.println("list made:" + fb1.toString());

        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {

            f = new File("people.bin");

            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);

            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            fb1 = new People(firstName, lastName, contactInfornamtion, registrationDate);

            oos.writeObject(fb1);
            oos.close();
            return true;

        } catch (IOException e) {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException ex) {
                    Logger.getLogger(People .class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            System.out.println("Error writing Object to binary file");
            return false;

        }
    }

    public static ObservableList<People> peopleInfo(){
        ObservableList<People> peopleList = FXCollections.observableArrayList();
        People fb3;
        ObjectInputStream ois = null;
        try{
            ois = new ObjectInputStream (new FileInputStream("people.bin"));
            while(true){
               fb3 = (People) ois.readObject();
                System.out.println("The peoplebin u read: "+fb3.toString());
                peopleList.add(fb3);
            }
        }
        catch(IOException | ClassNotFoundException e){System.out.println("File reading done");}
        System.out.println(peopleList);
        return peopleList;
    }
}
