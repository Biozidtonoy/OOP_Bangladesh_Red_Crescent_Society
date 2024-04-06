/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helperClass;

import java.io.Serializable;

/**
 *
 * @author tonoy
 */
public class bloodCenter implements Serializable {
    private String bloodCenterName,district,location,volunteerName;
    private String number ;

    public bloodCenter(String bloodCenterName, String district, String location, String volunteerName, String number) {
        this.bloodCenterName = bloodCenterName;
        this.district = district;
        this.location = location;
        this.volunteerName = volunteerName;
        this.number = number;
    }

    public String getBloodCenterName() {
        return bloodCenterName;
    }

    public void setBloodCenterName(String bloodCenterName) {
        this.bloodCenterName = bloodCenterName;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getVolunteerName() {
        return volunteerName;
    }

    public void setVolunteerName(String volunteerName) {
        this.volunteerName = volunteerName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "bloodCenter{" + "bloodCenterName=" + bloodCenterName + ", district=" + district + ", location=" + location + ", volunteerName=" + volunteerName + ", number=" + number + '}';
    }
    
}
