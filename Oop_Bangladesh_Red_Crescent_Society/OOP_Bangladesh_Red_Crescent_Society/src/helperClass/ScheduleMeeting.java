/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helperClass;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Month;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author tonoy
 */
public class ScheduleMeeting implements Serializable{
    public String participant,time;
    public LocalDate date;

 
    public ScheduleMeeting(String participant,String time, LocalDate date) {
        this.time = time;
        this.date = date;
        this.participant = participant;
    }

    public String getParticipant() {
        return participant;
    }

    public void setParticipant(String participant) {
        this.participant = participant;
    }
    

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "ScheduleMeeting{" + "participant=" + participant + ", time=" + time + ", date=" + date + '}';
    }

    
    public void scheduleMeeting(ScheduleMeeting s){
        
        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            f = new File("database.bin");
            if (f.exists()) {
                System.out.println("details insert in bin file");
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            s = new ScheduleMeeting(participant,time, date); // Create a ScheduleMeeting object with provided time and date
            oos.writeObject(s);
            System.out.println("Meeting scheduled successfully");
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    
//    public ObservableList<ScheduleMeeting> scheduleMeetingDetails(){
//        ObservableList<ScheduleMeeting> meetingdetails = FXCollections.observableArrayList();
//        meetingdetails.add(new ScheduleMeeting("Treasure","03",LocalDate.of(2024, Month.MARCH,3 )));
//        return meetingdetails;
//    }
}
