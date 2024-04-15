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
public class FeedBackVolunteer extends User implements Serializable{
    private String volunteerName, feedback,emailAddress;

    public FeedBackVolunteer(){
        
    }

    public FeedBackVolunteer(String volunteerName, String feedback, String emailAddress) {
        this.volunteerName = volunteerName;
        this.feedback = feedback;
        this.emailAddress = emailAddress;
    }

    public FeedBackVolunteer(String volunteerName, String feedback, String emailAddress, String usertype, String username, String email, String password, String gender, LocalDate birthday) {
        super(usertype, username, email, password, gender, birthday);
        this.volunteerName = volunteerName;
        this.feedback = feedback;
        this.emailAddress = emailAddress;
    }

    public String getVolunteerName() {
        return volunteerName;
    }

    public void setVolunteerName(String volunteerName) {
        this.volunteerName = volunteerName;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public String toString() {
        return "FeedBackVolunteer{" + "volunteerName=" + volunteerName + ", feedback=" + feedback + ", emailAddress=" + emailAddress + '}';
    }
    public boolean creatFeedBack(FeedBackVolunteer  fb1) {


        System.out.println("feedBack made:" + fb1.toString());

        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {

            f = new File("feedback1.bin");

            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);

            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            fb1 = new FeedBackVolunteer(volunteerName, feedback, emailAddress);

            oos.writeObject(fb1);
            oos.close();
            return true;

        } catch (IOException e) {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException ex) {
                    Logger.getLogger(FeedBackVolunteer .class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            System.out.println("Error writing Object to binary file");
            return false;

        }
    }

    public static ObservableList<FeedBackVolunteer> feedBack(){
        ObservableList<FeedBackVolunteer> aidList1 = FXCollections.observableArrayList();
        FeedBackVolunteer fb3;
        ObjectInputStream ois = null;
        try{
            ois = new ObjectInputStream (new FileInputStream("feedback1.bin"));
            while(true){
               fb3 = (FeedBackVolunteer) ois.readObject();
                System.out.println("The feedbackbin u read: "+fb3.toString());
                aidList1.add(fb3);
            }
        }
        catch(IOException | ClassNotFoundException e){System.out.println("File reading done");}
        System.out.println(aidList1);
        return aidList1;
    }
    public static ObservableList<FeedBackVolunteer> readfeedbackList1(){
        ObservableList<FeedBackVolunteer> feedbackList1 = FXCollections.observableArrayList();
        FeedBackVolunteer fb3;
        ObjectInputStream ois = null;
        try{
            ois = new ObjectInputStream (new FileInputStream("feedback1.bin"));
            while(true){
               fb3 = (FeedBackVolunteer) ois.readObject();
                System.out.println("The feedback u read: "+fb3.toString());
                feedbackList1.add(fb3);
            }
        }
        catch(IOException | ClassNotFoundException e){System.out.println("File reading done");}
        System.out.println(feedbackList1);
        return feedbackList1;
    }
    
}
