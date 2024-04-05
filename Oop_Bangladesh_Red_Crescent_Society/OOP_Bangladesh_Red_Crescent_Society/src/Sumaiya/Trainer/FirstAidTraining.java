/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sumaiya.Trainer;

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
public class FirstAidTraining extends User implements Serializable{
    private String trainerName, courseTitle, location;
    private int courseDuration;
    public FirstAidTraining(){
        
    }

    public FirstAidTraining(String trainerName, String courseTitle, String location, int courseDuration) {
        this.trainerName = trainerName;
        this.courseTitle = courseTitle;
        this.location = location;
        this.courseDuration = courseDuration;
    }

    public FirstAidTraining(String trainerName, String courseTitle, String location, int courseDuration, String usertype, String username, String email, String password, String gender, LocalDate birthday) {
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
        return "FirstAidTraining{" + "trainerName=" + trainerName + ", courseTitle=" + courseTitle + ", location=" + location + ", courseDuration=" + courseDuration + '}';
    }
    private static final String FTrainingPath = "fAid.bin";
    
    public static void saveFTrainingRecord(String trainerName, String courseTitle, String location, int courseDuration) {
        FirstAidTraining fTrainingReport = new FirstAidTraining(trainerName, courseTitle, location,courseDuration);
        List<FirstAidTraining> existingRepots = loadTrainerReportRecords();
        existingRepots.add(fTrainingReport);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FTrainingPath))) {
            for (FirstAidTraining reports : existingRepots) {
                oos.writeObject(reports);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static List<FirstAidTraining> loadTrainerReportRecords() {
        List<FirstAidTraining> trainerReports = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FTrainingPath))) {
           while (true) {
              try {
                 FirstAidTraining reports = (FirstAidTraining) ois.readObject();
                 trainerReports.add(reports);
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return trainerReports;
    } 
}
