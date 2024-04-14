/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sumaiya.Volunteer;

import Sumaiya.Trainer.HealthEducationTraining;
import Users.User;
import helperClass.AppendableObjectOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Muntasir
 */
public class BloodSupplyInfo extends User{
    private String recipientName, donorName, bloodGroup;
    private int bagAmount;

    public BloodSupplyInfo(){
        
    }

    public BloodSupplyInfo(String recipientName, String donorName, String bloodGroup, int bagAmount) {
        this.recipientName = recipientName;
        this.donorName = donorName;
        this.bloodGroup = bloodGroup;
        this.bagAmount = bagAmount;
    }

    public BloodSupplyInfo(String recipientName, String donorName, String bloodGroup, int bagAmount, String usertype, String username, String email, String password, String gender, LocalDate birthday) {
        super(usertype, username, email, password, gender, birthday);
        this.recipientName = recipientName;
        this.donorName = donorName;
        this.bloodGroup = bloodGroup;
        this.bagAmount = bagAmount;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public String getDonorName() {
        return donorName;
    }

    public void setDonorName(String donorName) {
        this.donorName = donorName;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public int getBagAmount() {
        return bagAmount;
    }

    public void setBagAmount(int bagAmount) {
        this.bagAmount = bagAmount;
    }

    @Override
    public String toString() {
        return "BloodSupplyInfo{" + "recipientName=" + recipientName + ", donorName=" + donorName + ", bloodGroup=" + bloodGroup + ", bagAmount=" + bagAmount + '}';
    }
    
    
     public boolean creatBloodInfo(BloodSupplyInfo  fb1) {


        System.out.println("training made:" + fb1.toString());

        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {

            f = new File("bloodsupply.bin");

            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);

            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            fb1 = new BloodSupplyInfo(recipientName, donorName, bloodGroup, bagAmount);

            oos.writeObject(fb1);
            oos.close();
            return true;

        } catch (IOException e) {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException ex) {
                    Logger.getLogger(BloodSupplyInfo .class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            System.out.println("Error writing Object to binary file");
            return false;

        }
    }

    public static ObservableList<BloodSupplyInfo> bloodinfo(){
        ObservableList<BloodSupplyInfo> supplyList1 = FXCollections.observableArrayList();
        BloodSupplyInfo fb3;
        ObjectInputStream ois = null;
        try{
            ois = new ObjectInputStream (new FileInputStream("bloodsupply.bin"));
            while(true){
               fb3 = (BloodSupplyInfo) ois.readObject();
                System.out.println("The healthbin u read: "+fb3.toString());
                supplyList1.add(fb3);
            }
        }
        catch(IOException | ClassNotFoundException e){System.out.println("File reading done");}
        System.out.println(supplyList1);
        return supplyList1;
    }
   
}
    