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
public class ReuniteFamily extends User implements Serializable{
    private String location,parentName, parentDescription;
    private LocalDate Date;

    public ReuniteFamily(String location, String parentName, String parentDescription, LocalDate Date) {
        this.location = location;
        this.parentName = parentName;
        this.parentDescription = parentDescription;
        this.Date = Date;
    }

    public ReuniteFamily(String location, String parentName, String parentDescription, LocalDate Date, String usertype, String username, String email, String password, String gender, LocalDate birthday) {
        super(usertype, username, email, password, gender, birthday);
        this.location = location;
        this.parentName = parentName;
        this.parentDescription = parentDescription;
        this.Date = Date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getParentDescription() {
        return parentDescription;
    }

    public void setParentDescription(String parentDescription) {
        this.parentDescription = parentDescription;
    }

    public LocalDate getDate() {
        return Date;
    }

    public void setDate(LocalDate Date) {
        this.Date = Date;
    }

    @Override
    public String toString() {
        return "ReuniteFamily{" + "location=" + location + ", parentName=" + parentName + ", parentDescription=" + parentDescription + ", Date=" + Date + '}';
    }

     public boolean creatReunite(ReuniteFamily  fb1) {


        System.out.println("family made:" + fb1.toString());

        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {

            f = new File("reunite.bin");

            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);

            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            fb1 = new ReuniteFamily(location, parentName, parentDescription, Date);

            oos.writeObject(fb1);
            oos.close();
            return true;

        } catch (IOException e) {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException ex) {
                    Logger.getLogger(ReuniteFamily .class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            System.out.println("Error writing Object to binary file");
            return false;

        }
    }

    public static ObservableList<ReuniteFamily> reunite(){
        ObservableList<ReuniteFamily> resList = FXCollections.observableArrayList();
        ReuniteFamily fb3;
        ObjectInputStream ois = null;
        try{
            ois = new ObjectInputStream (new FileInputStream("reunite.bin"));
            while(true){
               fb3 = (ReuniteFamily) ois.readObject();
                System.out.println("The reunitebin u read: "+fb3.toString());
                resList.add(fb3);
            }
        }
        catch(IOException | ClassNotFoundException e){System.out.println("File reading done");}
        System.out.println(resList);
        return resList;
    }
}
