/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sumaiya.Trainer;

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
public class firstAidTraining extends User implements Serializable {

//    static void saveAidRecord(firstAidTraining info) {
//        throw new UnsupportedOperationException("Not supported yet."); 
//    }
    private String trainerName, courseTitle, location;
    private int courseDuration;

    public firstAidTraining(String trainerName, String courseTitle, String location, int courseDuration) {
        this.trainerName = trainerName;
        this.courseTitle = courseTitle;
        this.location = location;
        this.courseDuration = courseDuration;
    }

    public firstAidTraining(String trainerName, String courseTitle, String location, int courseDuration, String usertype, String username, String email, String password, String gender, LocalDate birthday) {
        super(usertype, username, email, password, gender, birthday);
        this.trainerName = trainerName;
        this.courseTitle = courseTitle;
        this.location = location;
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

    public int getCourseDuration() {
        return courseDuration;
    }

    public void setCourseDuration(int courseDuration) {
        this.courseDuration = courseDuration;
    }

    @Override
    public String toString() {
        return "firstAidTraining{" + "trainerName=" + trainerName + ", courseTitle=" + courseTitle + ", location=" + location + ", courseDuration=" + courseDuration + '}';
    }
        public boolean creatTrainig(firstAidTraining  fb1) {


        System.out.println("training made:" + fb1.toString());

        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {

            f = new File("firstaid.bin");

            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);

            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            fb1 = new firstAidTraining(trainerName, courseTitle, location, courseDuration);

            oos.writeObject(fb1);
            oos.close();
            return true;

        } catch (IOException e) {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException ex) {
                    Logger.getLogger(firstAidTraining .class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            System.out.println("Error writing Object to binary file");
            return false;

        }
    }

    public static ObservableList<firstAidTraining> firstAid(){
        ObservableList<firstAidTraining> aidList1 = FXCollections.observableArrayList();
        firstAidTraining fb3;
        ObjectInputStream ois = null;
        try{
            ois = new ObjectInputStream (new FileInputStream("firstaid.bin"));
            while(true){
               fb3 = (firstAidTraining) ois.readObject();
                System.out.println("The aidbin u read: "+fb3.toString());
                aidList1.add(fb3);
            }
        }
        catch(IOException | ClassNotFoundException e){System.out.println("File reading done");}
        System.out.println(aidList1);
        return aidList1;
    }
}
