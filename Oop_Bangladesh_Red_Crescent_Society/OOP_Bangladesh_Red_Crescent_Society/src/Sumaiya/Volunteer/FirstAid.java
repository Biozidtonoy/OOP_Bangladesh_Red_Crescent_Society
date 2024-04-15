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
public class FirstAid extends User implements Serializable{
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

    public boolean creatAid(FirstAid  fb1) {


        System.out.println("firstaid made:" + fb1.toString());

        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {

            f = new File("aid.bin");

            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);

            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            fb1 = new FirstAid(patientName, gender1, injuryType, age, firtAidProvidingDate);

            oos.writeObject(fb1);
            oos.close();
            return true;

        } catch (IOException e) {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException ex) {
                    Logger.getLogger(FirstAid .class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            System.out.println("Error writing Object to binary file");
            return false;

        }
    }

    public static ObservableList<FirstAid> firstAid(){
        ObservableList<FirstAid> aidList = FXCollections.observableArrayList();
        FirstAid fb3;
        ObjectInputStream ois = null;
        try{
            ois = new ObjectInputStream (new FileInputStream("aid.bin"));
            while(true){
               fb3 = (FirstAid) ois.readObject();
                System.out.println("The aidbin u read: "+fb3.toString());
                aidList.add(fb3);
            }
        }
        catch(IOException | ClassNotFoundException e){System.out.println("File reading done");}
        System.out.println(aidList);
        return aidList;
    }
}
