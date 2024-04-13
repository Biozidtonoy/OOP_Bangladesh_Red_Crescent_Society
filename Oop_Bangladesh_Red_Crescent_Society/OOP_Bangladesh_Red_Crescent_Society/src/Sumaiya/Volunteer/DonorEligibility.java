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
public class DonorEligibility extends User implements Serializable{
    private String name, medicalHistory;
    private int age, weight, bloodPressure;

    public DonorEligibility() {
   
    }

    public DonorEligibility(String name, String medicalHistory, int age, int weight, int bloodPressure) {
        this.name = name;
        this.medicalHistory = medicalHistory;
        this.age = age;
        this.weight = weight;
        this.bloodPressure = bloodPressure;
    }

    public DonorEligibility(String name, String medicalHistory, int age, int weight, int bloodPressure, String usertype, String username, String email, String password, String gender, LocalDate birthday) {
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
        return "DonorEligibility{" + "name=" + name + ", medicalHistory=" + medicalHistory + ", age=" + age + ", weight=" + weight + ", bloodPressure=" + bloodPressure + '}';
    }
    private static final String donorListPath = "eligible.bin";
    
    public static void saveDonorReportRecord(String name, String medicalHistory, int age, int weight, int bloodPressure) {
        DonorEligibility donorEligibleReport = new DonorEligibility(name, medicalHistory, age,weight,bloodPressure);
        List<DonorEligibility> existingRepots = loadDonorReportRecords();
        existingRepots.add(donorEligibleReport);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(donorListPath))) {
            for (DonorEligibility reports : existingRepots) {
                oos.writeObject(reports);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static List<DonorEligibility> loadDonorReportRecords() {
        List<DonorEligibility> donorReports = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(donorListPath))) {
           while (true) {
              try {
                 DonorEligibility reports = (DonorEligibility) ois.readObject();
                 donorReports.add(reports);
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return donorReports;
    } 
}
