/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sumya.MediaAndPublication;

import java.time.LocalDate;

/**
 *
 * @author sumya
 */
public class Report   {
    
    
    private String Report;

    public Report(String Report, LocalDate Date) {
        this.Report = Report;
        this.Date = Date;
    }

    public String getReport() {
        return Report;
    }

    public void setReport(String Report) {
        this.Report = Report;
    }

    public LocalDate getDate() {
        return Date;
    }

    public void setDate(LocalDate Date) {
        this.Date = Date;
    }

    @Override
    public String toString() {
        return "Report{" + "Report=" + Report + ", Date=" + Date + '}';
    }
    private LocalDate Date;
}
    
   
   
    