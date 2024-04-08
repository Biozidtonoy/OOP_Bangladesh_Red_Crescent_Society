/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sumaiya.Trainer;

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
public class Materials extends ResourceMobilization implements Serializable{
    private String handNote, courseOutline, visualAids, trainingEquipment;

    public Materials(String handNote, String courseOutline, String visualAids, String trainingEquipment) {
        this.handNote = handNote;
        this.courseOutline = courseOutline;
        this.visualAids = visualAids;
        this.trainingEquipment = trainingEquipment;
    }

    public Materials(String handNote, String courseOutline, String visualAids, String trainingEquipment, String name, String material) {
        super(name, material);
        this.handNote = handNote;
        this.courseOutline = courseOutline;
        this.visualAids = visualAids;
        this.trainingEquipment = trainingEquipment;
    }

    public Materials(String handNote, String courseOutline, String visualAids, String trainingEquipment, String name, String material, String usertype, String username, String email, String password, String gender, LocalDate birthday) {
        super(name, material, usertype, username, email, password, gender, birthday);
        this.handNote = handNote;
        this.courseOutline = courseOutline;
        this.visualAids = visualAids;
        this.trainingEquipment = trainingEquipment;
    }

    public String getHandNote() {
        return handNote;
    }

    public void setHandNote(String handNote) {
        this.handNote = handNote;
    }

    public String getCourseOutline() {
        return courseOutline;
    }

    public void setCourseOutline(String courseOutline) {
        this.courseOutline = courseOutline;
    }

    public String getVisualAids() {
        return visualAids;
    }

    public void setVisualAids(String visualAids) {
        this.visualAids = visualAids;
    }

    public String getTrainingEquipment() {
        return trainingEquipment;
    }

    public void setTrainingEquipment(String trainingEquipment) {
        this.trainingEquipment = trainingEquipment;
    }

    @Override
    public String toString() {
        return "Materials{" + "handNote=" + handNote + ", courseOutline=" + courseOutline + ", visualAids=" + visualAids + ", trainingEquipment=" + trainingEquipment + '}';
    }

   public boolean creatMaterials(Materials  fb1) {


        System.out.println("materials made:" + fb1.toString());

        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {

            f = new File("program.bin");

            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);

            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            fb1 = new Materials(handNote, courseOutline, visualAids, trainingEquipment);

            oos.writeObject(fb1);
            oos.close();
            return true;

        } catch (IOException e) {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException ex) {
                    Logger.getLogger(Materials .class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            System.out.println("Error writing Object to binary file");
            return false;

        }
    }

    public static ObservableList<Materials> materials(){
        ObservableList<Materials> materialList1 = FXCollections.observableArrayList();
        Materials fb3;
        ObjectInputStream ois = null;
        try{
            ois = new ObjectInputStream (new FileInputStream("program.bin"));
            while(true){
               fb3 = (Materials) ois.readObject();
                System.out.println("The programbin u read: "+fb3.toString());
                materialList1.add(fb3);
            }
        }
        catch(IOException | ClassNotFoundException e){System.out.println("File reading done");}
        System.out.println(materialList1);
        return materialList1;
    }
    
}
