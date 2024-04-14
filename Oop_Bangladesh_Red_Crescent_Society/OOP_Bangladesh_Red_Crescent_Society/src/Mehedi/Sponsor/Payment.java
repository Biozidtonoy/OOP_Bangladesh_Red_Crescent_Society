/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mehedi.Sponsor;

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
 * @author Elitebook 830
 */
public class Payment implements Serializable {
   public String sponsorID,sponsorName,amount,paymentmethod;
   public LocalDate paymentDate;

    public Payment(String sponsorID, String sponsorName, String amount, String paymentmethod, LocalDate paymentDate) {
        this.sponsorID = sponsorID;
        this.sponsorName = sponsorName;
        this.amount = amount;
        this.paymentmethod = paymentmethod;
        this.paymentDate = paymentDate;
    }

    public String getSponsorID() {
        return sponsorID;
    }

    public void setSponsorID(String sponsorID) {
        this.sponsorID = sponsorID;
    }

    public String getSponsorName() {
        return sponsorName;
    }

    public void setSponsorName(String sponsorName) {
        this.sponsorName = sponsorName;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPaymentmethod() {
        return paymentmethod;
    }

    public void setPaymentmethod(String paymentmethod) {
        this.paymentmethod = paymentmethod;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    @Override
    public String toString() {
        return "Payment{" + "sponsorID=" + sponsorID + ", sponsorName=" + sponsorName + ", amount=" + amount + ", paymentmethod=" + paymentmethod + ", paymentDate=" + paymentDate + '}';
    }
   
    public boolean createPayment(Payment fb1) {

        System.out.println("Payment made:" + fb1.toString());

        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {

            f = new File("Payment.bin");

            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);

            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            fb1 = new Payment(sponsorID,sponsorName,amount, paymentmethod, paymentDate);

            oos.writeObject(fb1);
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
    
    public static ObservableList<Payment> readPaymentList1(){
        ObservableList<Payment> PaymentList1 = FXCollections.observableArrayList();
        Payment fb3;
        ObjectInputStream ois = null;
        try{
            ois = new ObjectInputStream (new FileInputStream("Payment.bin"));
            while(true){
               fb3 = (Payment) ois.readObject();
                System.out.println("The Payment u read: "+fb3.toString());
                PaymentList1.add(fb3);
            }
        }
        catch(IOException | ClassNotFoundException e){System.out.println("File reading done");}
        System.out.println(PaymentList1);
        return PaymentList1;
    }

}


