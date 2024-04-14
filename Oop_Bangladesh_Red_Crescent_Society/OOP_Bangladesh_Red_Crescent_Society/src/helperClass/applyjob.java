/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helperClass;

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
 * @author tonoy
 */
public class applyjob implements Serializable{
    public String name,degree,experience;
    public LocalDate dob;

    public applyjob(String name, String degree, String experience, LocalDate dob) {
        this.name = name;
        this.degree = degree;
        this.experience = experience;
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "applyjob{" + "name=" + name + ", degree=" + degree + ", experience=" + experience + ", dob=" + dob + '}';
    }
    public boolean createapplyjob(applyjob  fb1) {

    
        System.out.println("applyjob made:" + fb1.toString());

        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {

            f = new File("applyjob.bin");

            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);

            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            fb1 = new applyjob(name,degree,experience,dob);

            oos.writeObject(fb1);
            oos.close();
            return true;

        } catch (IOException e) {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException ex) {
                    Logger.getLogger(applyjob.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            System.out.println("Error writing Object to binary file");
            return false;

        }
    }
//    ====>>>read bin files
    public static ObservableList<applyjob> readapplyjobList1(){
        ObservableList<applyjob> applyjobList1 = FXCollections.observableArrayList();
        applyjob fb3;
        ObjectInputStream ois = null;
        try{
            ois = new ObjectInputStream (new FileInputStream("applyjob.bin"));
            while(true){
               fb3 = (applyjob) ois.readObject();
                System.out.println("The applyjob u read: "+fb3.toString());
                applyjobList1.add(fb3);
            }
        }
        catch(IOException | ClassNotFoundException e){System.out.println("File reading done");}
        System.out.println(applyjobList1);
        return applyjobList1;
    }

}
