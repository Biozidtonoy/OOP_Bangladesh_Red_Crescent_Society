/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sumya.EventOrganizer;

import java.time.LocalDate;

/**
 *
 * @author sumya
 */
public class Event {
    private String EventName;
    private LocalDate Date;

    public Event(String EventName, LocalDate Date) {
        this.EventName = EventName;
        this.Date = Date;
    }

    public String getEventName() {
        return EventName;
    }

    public void setEventName(String EventName) {
        this.EventName = EventName;
    }

    public LocalDate getDate() {
        return Date;
    }

    public void setDate(LocalDate Date) {
        this.Date = Date;
    }

    @Override
    public String toString() {
        return "Event{" + "EventName=" + EventName + ", Date=" + Date + '}';
    }

   
    
}
