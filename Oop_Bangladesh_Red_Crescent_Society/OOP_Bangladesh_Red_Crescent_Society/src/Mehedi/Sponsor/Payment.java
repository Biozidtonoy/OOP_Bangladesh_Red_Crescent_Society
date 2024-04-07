/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mehedi.Sponsor;

/**
 *
 * @author Elitebook 830
 */
public class Payment {
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
        return "Payment{" +
                "sponsorId=" + sponsorId +
                ", sponsorName='" + sponsorName + '\'' +
                ", eventName='" + eventName + '\'' +
                ", paymentAmount=" + paymentAmount +
                '}';
    }

    public static void main(String[] args) {
        Payment payment = new Payment(1, "Sponsor X", "Event A", 1000);
        System.out.println(payment);
    }
}

