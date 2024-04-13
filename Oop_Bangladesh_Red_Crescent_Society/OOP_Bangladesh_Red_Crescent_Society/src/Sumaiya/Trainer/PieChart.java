/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sumaiya.Trainer;

import Users.User;
import java.time.LocalDate;

/**
 *
 * @author Muntasir
 */
public class PieChart extends User{
    private int pollution,acid,alkaline;

    public PieChart(int pollution, int acid, int alkaline) {
        this.pollution = pollution;
        this.acid = acid;
        this.alkaline = alkaline;
    }

    public PieChart(int pollution, int acid, int alkaline, String usertype, String username, String email, String password, String gender, LocalDate birthday) {
        super(usertype, username, email, password, gender, birthday);
        this.pollution = pollution;
        this.acid = acid;
        this.alkaline = alkaline;
    }

    public int getPollution() {
        return pollution;
    }

    public void setPollution(int pollution) {
        this.pollution = pollution;
    }

    public int getAcid() {
        return acid;
    }

    public void setAcid(int acid) {
        this.acid = acid;
    }

    public int getAlkaline() {
        return alkaline;
    }

    public void setAlkaline(int alkaline) {
        this.alkaline = alkaline;
    }

    @Override
    public String toString() {
        return "PieChart{" + "pollution=" + pollution + ", acid=" + acid + ", alkaline=" + alkaline + '}';
    }
    
}
