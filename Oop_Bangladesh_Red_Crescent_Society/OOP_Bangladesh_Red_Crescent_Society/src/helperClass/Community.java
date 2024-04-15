/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helperClass;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author tonoy
 */
public class Community implements Serializable{
    public String district ,bloodCenter,time;
    public LocalDate date;

    public Community(String district, String bloodCenter, String time, LocalDate date) {
        this.district = district;
        this.bloodCenter = bloodCenter;
        this.time = time;
        this.date = date;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getBloodCenter() {
        return bloodCenter;
    }

    public void setBloodCenter(String bloodCenter) {
        this.bloodCenter = bloodCenter;
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
        return "Community{" + "district=" + district + ", bloodCenter=" + bloodCenter + ", time=" + time + ", date=" + date + '}';
    }

    
    
}
