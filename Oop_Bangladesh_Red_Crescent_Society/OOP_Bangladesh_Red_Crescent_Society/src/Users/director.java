/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Users;

import helperClass.AppendableObjectOutputStream;
import helperClass.ScheduleMeeting;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author tonoy
 */
public class director implements Serializable{
    
    public void viewScheduleMeeting(String participant ,String time ,LocalDate date){
        File f = null ;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        ScheduleMeeting s;
        try {
            f = new File("database.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            while(true){
                System.out.println("file read successfully");
                s = (ScheduleMeeting) ois.readObject(); 
                System.out.println("meeting details :"+ s.toString());
            }
        } catch (Exception e) {
        }
    }
}    


