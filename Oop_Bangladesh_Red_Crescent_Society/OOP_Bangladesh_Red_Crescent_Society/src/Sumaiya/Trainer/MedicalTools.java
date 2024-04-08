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
public class MedicalTools extends ResourceMobilization implements Serializable{
    private String toolName, condition, category;
    private int modelNumber;

    public MedicalTools(String toolName, String condition, String category, int modelNumber) {
        this.toolName = toolName;
        this.condition = condition;
        this.category = category;
        this.modelNumber = modelNumber;
    }

    public MedicalTools(String toolName, String condition, String category, int modelNumber, String name, String material) {
        super(name, material);
        this.toolName = toolName;
        this.condition = condition;
        this.category = category;
        this.modelNumber = modelNumber;
    }

    public MedicalTools(String toolName, String condition, String category, int modelNumber, String name, String material, String usertype, String username, String email, String password, String gender, LocalDate birthday) {
        super(name, material, usertype, username, email, password, gender, birthday);
        this.toolName = toolName;
        this.condition = condition;
        this.category = category;
        this.modelNumber = modelNumber;
    }

    public String getToolName() {
        return toolName;
    }

    public void setToolName(String toolName) {
        this.toolName = toolName;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(int modelNumber) {
        this.modelNumber = modelNumber;
    }

    @Override
    public String toString() {
        return "MedicalTools{" + "toolName=" + toolName + ", condition=" + condition + ", category=" + category + ", modelNumber=" + modelNumber + '}';
    }
    public boolean creatMdedical(MedicalTools  fb1) {


        System.out.println("materials made:" + fb1.toString());

        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {

            f = new File("medical.bin");

            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);

            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            fb1 = new MedicalTools(toolName, condition, category, modelNumber);

            oos.writeObject(fb1);
            oos.close();
            return true;

        } catch (IOException e) {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException ex) {
                    Logger.getLogger(MedicalTools .class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            System.out.println("Error writing Object to binary file");
            return false;

        }
    }

    public static ObservableList<MedicalTools> medical(){
        ObservableList<MedicalTools> materialList1 = FXCollections.observableArrayList();
        MedicalTools fb3;
        ObjectInputStream ois = null;
        try{
            ois = new ObjectInputStream (new FileInputStream("medical.bin"));
            while(true){
               fb3 = (MedicalTools) ois.readObject();
                System.out.println("The programbin u read: "+fb3.toString());
                materialList1.add(fb3);
            }
        }
        catch(IOException | ClassNotFoundException e){System.out.println("File reading done");}
        System.out.println(materialList1);
        return materialList1;
    }
    
}
