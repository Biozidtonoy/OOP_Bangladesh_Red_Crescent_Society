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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author tonoy
 */
public class bloodCenter implements Serializable {
    private String bloodCenterName,district,location,volunteerName;
    private String number ;

    public bloodCenter(String bloodCenterName, String district, String location, String volunteerName, String number) {
        this.bloodCenterName = bloodCenterName;
        this.district = district;
        this.location = location;
        this.volunteerName = volunteerName;
        this.number = number;
    }

    public String getBloodCenterName() {
        return bloodCenterName;
    }

    public void setBloodCenterName(String bloodCenterName) {
        this.bloodCenterName = bloodCenterName;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getVolunteerName() {
        return volunteerName;
    }

    public void setVolunteerName(String volunteerName) {
        this.volunteerName = volunteerName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "bloodCenter{" + "bloodCenterName=" + bloodCenterName + ", district=" + district + ", location=" + location + ", volunteerName=" + volunteerName + ", number=" + number + '}';
    }
    public boolean createbloodCenter(bloodCenter  bc1) {

    
        System.out.println(" urgent bloodCenter made:" + bc1.toString());

        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {

            f = new File("bloodCenterurgent.bin");

            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);

            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            bc1 = new bloodCenter(bloodCenterName,district,location,volunteerName,number);

            oos.writeObject(bc1);
            oos.close();
            return true;

        } catch (IOException e) {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException ex) {
                    Logger.getLogger(bloodCenter .class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            System.out.println("Error writing Object to binary file");
            return false;

        }
    }
    public static ObservableList<bloodCenter> readbloodCenterList1(){
        ObservableList<bloodCenter> bloodCenterList1 = FXCollections.observableArrayList();
        bloodCenter fb3;
        ObjectInputStream ois = null;
        try{
            ois = new ObjectInputStream (new FileInputStream("bloodCenterurgent.bin"));
            while(true){
               fb3 = (bloodCenter) ois.readObject();
                System.out.println("The bloodCenter u read: "+fb3.toString());
                bloodCenterList1.add(fb3);
            }
        }
        catch(IOException | ClassNotFoundException e){System.out.println("File reading done");}
        System.out.println(bloodCenterList1);
        return bloodCenterList1;
    }

    
}
