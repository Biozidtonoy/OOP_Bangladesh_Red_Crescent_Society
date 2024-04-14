/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mehedi.Manager;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author Elitebook 830
 */
public class training implements Serializable{
    private String workshopName;
    private LocalDate startingDate;
    private LocalDate endingDate;
    // Constructor
    public training(String workshopName, LocalDate startingDate, LocalDate endingDate) {
        this.workshopName = workshopName;
        this.startingDate = startingDate;
        this.endingDate = endingDate;
    }

    public String getWorkshopName() {
        return workshopName;
    }

    public LocalDate getStartingDate() {
        return startingDate;
    }

    public LocalDate getEndingDate() {
        return endingDate;
    }

    public void setWorkshopName(String workshopName) {
        this.workshopName = workshopName;
    }

    public void setStartingDate(LocalDate startingDate) {
        this.startingDate = startingDate;
    }

    public void setEndingDate(LocalDate endingDate) {
        this.endingDate = endingDate;
    }

    @Override
    public String toString() {
        return "training{" + "workshopName=" + workshopName + ", startingDate=" + startingDate + ", endingDate=" + endingDate + '}';
    }
}

   

   
    
