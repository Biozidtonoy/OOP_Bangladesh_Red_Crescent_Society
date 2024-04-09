/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mehedi.Sponsor;

import helperClass.AppendableObjectOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Elitebook 830
 */
public class Payment implements Serializable {

    private int sponsorId;
    private String sponsorName;
    private String eventName;
    private int paymentAmount;

    public Payment(int sponsorId, String sponsorName, String eventName, int paymentAmount) {
        this.sponsorId = sponsorId;
        this.sponsorName = sponsorName;
        this.eventName = eventName;
        this.paymentAmount = paymentAmount;
    }

    // Getter methods
    public int getSponsorId() {
        return sponsorId;
    }

    public String getSponsorName() {
        return sponsorName;
    }

    public String getEventName() {
        return eventName;
    }

    public int getPaymentAmount() {
        return paymentAmount;
    }

    // Setter methods
    public void setSponsorId(int sponsorId) {
        this.sponsorId = sponsorId;
    }

    public void setSponsorName(String sponsorName) {
        this.sponsorName = sponsorName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setPaymentAmount(int paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    @Override
    public String toString() {
        return "Payment{"
                + "sponsorId=" + sponsorId
                + ", sponsorName='" + sponsorName + '\''
                + ", eventName='" + eventName + '\''
                + ", paymentAmount=" + paymentAmount
                + '}';
    }

    public boolean createPayment(Payment pay) {

        System.out.println("payment made:" + pay.toString());

        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {

            f = new File("payment.bin");

            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);

            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            pay = new Payment(sponsorId, sponsorName, eventName, paymentAmount);

            oos.writeObject(pay);
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
