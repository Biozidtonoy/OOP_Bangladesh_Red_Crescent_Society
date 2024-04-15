/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sumaiya.Volunteer;

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
public class DonorCardCheck extends User implements Serializable{
    private String name, medicalHistory;
    private int age, weight, bloodPressure;

    public DonorCardCheck(String name, String medicalHistory, int age, int weight, int bloodPressure) {
        this.name = name;
        this.medicalHistory = medicalHistory;
        this.age = age;
        this.weight = weight;
        this.bloodPressure = bloodPressure;
    }

    public DonorCardCheck(String name, String medicalHistory, int age, int weight, int bloodPressure, String usertype, String username, String email, String password, String gender, LocalDate birthday) {
        super(usertype, username, email, password, gender, birthday);
        this.name = name;
        this.medicalHistory = medicalHistory;
        this.age = age;
        this.weight = weight;
        this.bloodPressure = bloodPressure;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(int bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    @Override
    public String toString() {
        return "DonorCardCheck{" + "name=" + name + ", medicalHistory=" + medicalHistory + ", age=" + age + ", weight=" + weight + ", bloodPressure=" + bloodPressure + '}';
    }

   

     public boolean creatCheck(DonorCardCheck  fb1) {


        System.out.println("card made:" + fb1.toString());

        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {

            f = new File("eligibility.bin");

            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);

            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            fb1 = new DonorCardCheck(name, medicalHistory, age, weight, bloodPressure);

            oos.writeObject(fb1);
            oos.close();
            return true;

        } catch (IOException e) {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException ex) {
                    Logger.getLogger(DonorCardCheck .class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            System.out.println("Error writing Object to binary file");
            return false;

        }
    }

    public static ObservableList<DonorCardCheck> cardCheck(){
        ObservableList<DonorCardCheck> cardList = FXCollections.observableArrayList();
        DonorCardCheck fb3;
        ObjectInputStream ois = null;
        try{
            ois = new ObjectInputStream (new FileInputStream("eligibility.bin"));
            while(true){
               fb3 = (DonorCardCheck) ois.readObject();
                System.out.println("The cardbin u read: "+fb3.toString());
                cardList.add(fb3);
            }
        }
        catch(IOException | ClassNotFoundException e){System.out.println("File reading done");}
        System.out.println(cardList);
        return cardList;
    }
     
}
