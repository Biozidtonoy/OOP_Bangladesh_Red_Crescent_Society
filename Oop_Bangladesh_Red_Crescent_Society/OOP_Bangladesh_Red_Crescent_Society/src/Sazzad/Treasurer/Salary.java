/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sazzad.Treasurer;

import java.io.Serializable;

/**
 *
 * @author HP
 */
public class Salary implements Serializable{
    private String name;
    private int id;
    private double hourlyRate,workHour;

    public Salary(String name, int id, double hourlyRate, double workHour) {
        this.name = name;
        this.id = id;
        this.hourlyRate = hourlyRate;
        this.workHour = workHour;
    }

    Salary(String text) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public double getWorkHour() {
        return workHour;
    }

    public void setWorkHour(double workHour) {
        this.workHour = workHour;
    }

    @Override
    public String toString() {
        return "Salary{" + "name=" + name + ", id=" + id + ", hourlyRate=" + hourlyRate + ", workHour=" + workHour + '}';
    }

    int geSalary() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
    
}
