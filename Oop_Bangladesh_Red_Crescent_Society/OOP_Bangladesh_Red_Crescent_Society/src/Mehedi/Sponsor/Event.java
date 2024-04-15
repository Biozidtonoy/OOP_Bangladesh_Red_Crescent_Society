/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mehedi.Sponsor;

import java.time.LocalDate;
import javafx.scene.control.DatePicker;

/**
 *
 * @author Elitebook 830
 */
public class Event {
    private  String eventName;
        private  LocalDate eventDate;
        private  String location;

    public Event(String eventName, LocalDate eventDate, String location) {
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.location = location;
    }

    
    

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Event{" + "eventName=" + eventName + ", eventDate=" + eventDate + ", location=" + location + '}';
    }
}

    
        




