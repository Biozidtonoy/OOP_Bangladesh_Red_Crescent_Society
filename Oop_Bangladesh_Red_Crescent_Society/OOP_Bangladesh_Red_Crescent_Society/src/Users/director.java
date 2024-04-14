/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Users;

import Mehedi.Sponsor.Payment;
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
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
        public boolean approvedPayment(String sponsorID, String sponsorName,String amount,String paymentmethod, LocalDate  paymentDate) {
        Payment fb2 ;

//        System.out.println("approvedPayment made:" + fb2.toString());

        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {

            f = new File("approvedPayment.bin");

            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);

            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            fb2 = new Payment(sponsorID,sponsorName,amount, paymentmethod, paymentDate);

            oos.writeObject(fb2);
            oos.close();
            return true;

        } catch (IOException e) {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException ex) {
                    Logger.getLogger(Payment.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            System.out.println("Error writing Object to binary file");
            return false;

        }
    }
}    


