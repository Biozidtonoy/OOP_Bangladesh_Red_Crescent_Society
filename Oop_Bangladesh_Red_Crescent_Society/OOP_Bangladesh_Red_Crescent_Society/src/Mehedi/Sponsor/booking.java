/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mehedi.Sponsor;

/**
 *
 * @author Elitebook 830
 */
class booking {
    private int sponsor_Id;
    private String sponsor_Name;
    private String event_Name;
    private int paymentamount;

    public void setSponsor_Id(int sponsor_Id) {
        this.sponsor_Id = sponsor_Id;
    }

    public void setSponsor_Name(String sponsor_Name) {
        this.sponsor_Name = sponsor_Name;
    }

    public void setEvent_Name(String event_Name) {
        this.event_Name = event_Name;
    }

    public void setPaymentamount(int paymentamount) {
        this.paymentamount = paymentamount;
    }

    public int getSponsor_Id() {
        return sponsor_Id;
    }

    public String getSponsor_Name() {
        return sponsor_Name;
    }

    public String getEvent_Name() {
        return event_Name;
    }

    public int getPaymentamount() {
        return paymentamount;
    }

    public booking(int sponsor_Id, String sponsor_Name, String event_Name, int paymentamount) {
        this.sponsor_Id = sponsor_Id;
        this.sponsor_Name = sponsor_Name;
        this.event_Name = event_Name;
        this.paymentamount = paymentamount;
    }
    
}
