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
public class TrainingProgram extends ResourceMobilization implements Serializable{
    
    private String programName,TrainerName,classType;
    private int duration;

    public TrainingProgram(String programName, String TrainerName, String classType, int duration) {
        this.programName = programName;
        this.TrainerName = TrainerName;
        this.classType = classType;
        this.duration = duration;
    }

    public TrainingProgram(String programName, String TrainerName, String classType, int duration, String name, String material) {
        super(name, material);
        this.programName = programName;
        this.TrainerName = TrainerName;
        this.classType = classType;
        this.duration = duration;
    }

    public TrainingProgram(String programName, String TrainerName, String classType, int duration, String name, String material, String usertype, String username, String email, String password, String gender, LocalDate birthday) {
        super(name, material, usertype, username, email, password, gender, birthday);
        this.programName = programName;
        this.TrainerName = TrainerName;
        this.classType = classType;
        this.duration = duration;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public String getTrainerName() {
        return TrainerName;
    }

    public void setTrainerName(String TrainerName) {
        this.TrainerName = TrainerName;
    }

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "TrainingProgram{" + "programName=" + programName + ", TrainerName=" + TrainerName + ", classType=" + classType + ", duration=" + duration + '}';
    }
        public boolean creatProgram(TrainingProgram  fb1) {


        System.out.println("training made:" + fb1.toString());

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
            fb1 = new TrainingProgram(programName, TrainerName, classType, duration);

            oos.writeObject(fb1);
            oos.close();
            return true;

        } catch (IOException e) {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException ex) {
                    Logger.getLogger(TrainingProgram .class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            System.out.println("Error writing Object to binary file");
            return false;

        }
    }

    public static ObservableList<TrainingProgram> program(){
        ObservableList<TrainingProgram> aidList1 = FXCollections.observableArrayList();
        TrainingProgram fb3;
        ObjectInputStream ois = null;
        try{
            ois = new ObjectInputStream (new FileInputStream("program.bin"));
            while(true){
               fb3 = (TrainingProgram) ois.readObject();
                System.out.println("The programbin u read: "+fb3.toString());
                aidList1.add(fb3);
            }
        }
        catch(IOException | ClassNotFoundException e){System.out.println("File reading done");}
        System.out.println(aidList1);
        return aidList1;
    }

    
    
}
