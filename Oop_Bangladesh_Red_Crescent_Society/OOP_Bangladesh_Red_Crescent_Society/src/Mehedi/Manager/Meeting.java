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
public class Meeting implements Serializable {
    private int time;
    private LocalDate date;
    private String participantName;

    public Meeting(int time, LocalDate date, String participantName) {
        this.time = time;
        this.date = date;
        this.participantName = participantName;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getParticipantName() {
        return participantName;
    }

    public void setParticipantName(String participantName) {
        this.participantName = participantName;
    }

    @Override
    public String toString() {
        return "Meeting{" + "time=" + time + ", date=" + date + ", participantName=" + participantName + '}';
    }
}


    