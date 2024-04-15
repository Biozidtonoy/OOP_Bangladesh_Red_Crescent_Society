/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sumya.EventOrganizer;

/**
 *
 * @author sumya
 */
public class Budget {
    private String eventname;
    private String budget;

    @Override
    public String toString() {
        return "Budget{" + "eventname=" + eventname + ", budget=" + budget + '}';
    }

    public String getEventname() {
        return eventname;
    }

    public void setEventname(String eventname) {
        this.eventname = eventname;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public Budget(String eventname, String budget) {
        this.eventname = eventname;
        this.budget = budget;
    }
    
}
