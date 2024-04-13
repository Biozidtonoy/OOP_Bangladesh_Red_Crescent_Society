/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sumaiya.Trainer;

import Users.User;
import helperClass.AppendableObjectOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Muntasir
 */
public class WaterQualityMonitoring extends User implements Serializable{
    private String trainerName, courseTitle, location, courseDescription;
    private int courseDuration;
    
public WaterQualityMonitoring(){
    
}
    public WaterQualityMonitoring(String trainerName, String courseTitle, String location, String courseDescription, int courseDuration) {
        this.trainerName = trainerName;
        this.courseTitle = courseTitle;
        this.location = location;
        this.courseDescription = courseDescription;
        this.courseDuration = courseDuration;
    }

    public WaterQualityMonitoring(String trainerName, String courseTitle, String location, String courseDescription, int courseDuration, String usertype, String username, String email, String password, String gender, LocalDate birthday) {
        super(usertype, username, email, password, gender, birthday);
        this.trainerName = trainerName;
        this.courseTitle = courseTitle;
        this.location = location;
        this.courseDescription = courseDescription;
        this.courseDuration = courseDuration;
    }

    public String getTrainerName() {
        return trainerName;
    }

    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public int getCourseDuration() {
        return courseDuration;
    }

    public void setCourseDuration(int courseDuration) {
        this.courseDuration = courseDuration;
    }

    @Override
    public String toString() {
        return "WaterQualityMonitoring{" + "trainerName=" + trainerName + ", courseTitle=" + courseTitle + ", location=" + location + ", courseDescription=" + courseDescription + ", courseDuration=" + courseDuration + '}';
    }
    
    public boolean creatWaterTrainig(WaterQualityMonitoring  fb1) {


        System.out.println("training made:" + fb1.toString());

        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {

            f = new File("water.bin");

            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);

            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            fb1 = new WaterQualityMonitoring(trainerName, courseTitle, location, courseDescription, courseDuration);

            oos.writeObject(fb1);
            oos.close();
            return true;

        } catch (IOException e) {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException ex) {
                    Logger.getLogger(WaterQualityMonitoring .class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            System.out.println("Error writing Object to binary file");
            return false;

        }
    }

    public static ObservableList<WaterQualityMonitoring> waterMonitoring(){
        ObservableList<WaterQualityMonitoring> waterList = FXCollections.observableArrayList();
        WaterQualityMonitoring fb3;
        ObjectInputStream ois = null;
        try{
            ois = new ObjectInputStream (new FileInputStream("water.bin"));
            while(true){
               fb3 = (WaterQualityMonitoring) ois.readObject();
                System.out.println("The waterbin u read: "+fb3.toString());
                waterList.add(fb3);
            }
        }
        catch(IOException | ClassNotFoundException e){System.out.println("File reading done");}
        System.out.println(waterList);
        return waterList;
    }
}
