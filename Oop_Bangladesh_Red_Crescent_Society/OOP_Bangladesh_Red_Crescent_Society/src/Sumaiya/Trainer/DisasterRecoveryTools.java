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
public class DisasterRecoveryTools extends ResourceMobilization implements Serializable{
    private String firstAidKit, communicationEquipment, rescueEquipment, shelterMaterials;

    public DisasterRecoveryTools(String firstAidKit, String communicationEquipment, String rescueEquipment, String shelterMaterials) {
        this.firstAidKit = firstAidKit;
        this.communicationEquipment = communicationEquipment;
        this.rescueEquipment = rescueEquipment;
        this.shelterMaterials = shelterMaterials;
    }

    public DisasterRecoveryTools(String firstAidKit, String communicationEquipment, String rescueEquipment, String shelterMaterials, String name, String material) {
        super(name, material);
        this.firstAidKit = firstAidKit;
        this.communicationEquipment = communicationEquipment;
        this.rescueEquipment = rescueEquipment;
        this.shelterMaterials = shelterMaterials;
    }

    public DisasterRecoveryTools(String firstAidKit, String communicationEquipment, String rescueEquipment, String shelterMaterials, String name, String material, String usertype, String username, String email, String password, String gender, LocalDate birthday) {
        super(name, material, usertype, username, email, password, gender, birthday);
        this.firstAidKit = firstAidKit;
        this.communicationEquipment = communicationEquipment;
        this.rescueEquipment = rescueEquipment;
        this.shelterMaterials = shelterMaterials;
    }

    public String getFirstAidKit() {
        return firstAidKit;
    }

    public void setFirstAidKit(String firstAidKit) {
        this.firstAidKit = firstAidKit;
    }

    public String getCommunicationEquipment() {
        return communicationEquipment;
    }

    public void setCommunicationEquipment(String communicationEquipment) {
        this.communicationEquipment = communicationEquipment;
    }

    public String getRescueEquipment() {
        return rescueEquipment;
    }

    public void setRescueEquipment(String rescueEquipment) {
        this.rescueEquipment = rescueEquipment;
    }

    public String getShelterMaterials() {
        return shelterMaterials;
    }

    public void setShelterMaterials(String shelterMaterials) {
        this.shelterMaterials = shelterMaterials;
    }

    @Override
    public String toString() {
        return "DisasterRecoveryTools{" + "firstAidKit=" + firstAidKit + ", communicationEquipment=" + communicationEquipment + ", rescueEquipment=" + rescueEquipment + ", shelterMaterials=" + shelterMaterials + '}';
    }
    public boolean creatTools(DisasterRecoveryTools  fb1) {


        System.out.println("tools made:" + fb1.toString());

        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {

            f = new File("tool.bin");

            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);

            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            fb1 = new DisasterRecoveryTools(firstAidKit, communicationEquipment, rescueEquipment, shelterMaterials);

            oos.writeObject(fb1);
            oos.close();
            return true;

        } catch (IOException e) {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException ex) {
                    Logger.getLogger(DisasterRecoveryTools .class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            System.out.println("Error writing Object to binary file");
            return false;

        }
    }

    public static ObservableList<DisasterRecoveryTools> tools(){
        ObservableList<DisasterRecoveryTools> toolList1 = FXCollections.observableArrayList();
        DisasterRecoveryTools fb3;
        ObjectInputStream ois = null;
        try{
            ois = new ObjectInputStream (new FileInputStream("tool.bin"));
            while(true){
               fb3 = (DisasterRecoveryTools) ois.readObject();
                System.out.println("The programbin u read: "+fb3.toString());
                toolList1.add(fb3);
            }
        }
        catch(IOException | ClassNotFoundException e){System.out.println("File reading done");}
        System.out.println(toolList1);
        return toolList1;
    }
    
}
