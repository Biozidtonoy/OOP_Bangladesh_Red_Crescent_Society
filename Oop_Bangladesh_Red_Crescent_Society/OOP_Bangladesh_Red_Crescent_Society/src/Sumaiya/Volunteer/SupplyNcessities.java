/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sumaiya.Volunteer;

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
public class SupplyNcessities  extends User{
    private String nameOfSupply, gender1;
    private String amount;

    public SupplyNcessities(){
        
    }

    public SupplyNcessities(String nameOfSupply, String gender1, String amount) {
        this.nameOfSupply = nameOfSupply;
        this.gender1 = gender1;
        this.amount = amount;
    }

    public SupplyNcessities(String nameOfSupply, String gender1, String amount, String usertype, String username, String email, String password, String gender, LocalDate birthday) {
        super(usertype, username, email, password, gender, birthday);
        this.nameOfSupply = nameOfSupply;
        this.gender1 = gender1;
        this.amount = amount;
    }

    public String getNameOfSupply() {
        return nameOfSupply;
    }

    public void setNameOfSupply(String nameOfSupply) {
        this.nameOfSupply = nameOfSupply;
    }

    public String getGender1() {
        return gender1;
    }

    public void setGender1(String gender1) {
        this.gender1 = gender1;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "SupplyNcessities{" + "nameOfSupply=" + nameOfSupply + ", gender1=" + gender1 + ", amount=" + amount + '}';
    }

    
    public boolean creatSupplyList(SupplyNcessities  fb1) {


        System.out.println("list made:" + fb1.toString());

        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {

            f = new File("supply.bin");

            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);

            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            fb1 = new SupplyNcessities(nameOfSupply, gender1, amount);

            oos.writeObject(fb1);
            oos.close();
            return true;

        } catch (IOException e) {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException ex) {
                    Logger.getLogger(SupplyNcessities .class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            System.out.println("Error writing Object to binary file");
            return false;

        }
    }

    public static ObservableList<SupplyNcessities> supplyInfo(){
        ObservableList<SupplyNcessities> supplyList = FXCollections.observableArrayList();
        SupplyNcessities fb3;
        ObjectInputStream ois = null;
        try{
            ois = new ObjectInputStream (new FileInputStream("supply.bin"));
            while(true){
               fb3 = (SupplyNcessities) ois.readObject();
                System.out.println("The peoplebin u read: "+fb3.toString());
                supplyList.add(fb3);
            }
        }
        catch(IOException | ClassNotFoundException e){System.out.println("File reading done");}
        System.out.println(supplyList);
        return supplyList;
    }
    
}