/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sumya.MediaAndPublication;

import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author sumya
 */
public class Media {
    
    private String News ;
    private String Notice;
   
    private String Report;
    private LocalDate Date;

    public Media(String News, String Notice, String Report, LocalDate Date) {
        this.News = News;
        this.Notice = Notice;
        this.Report = Report;
        this.Date = Date;
    }

    @Override
    public String toString() {
        return "Media{" + "News=" + News + ", Notice=" + Notice + ", Report=" + Report + ", Date=" + Date + '}';
    }

    public String getNews() {
        return News;
    }

    public void setNews(String News) {
        this.News = News;
    }

    public String getNotice() {
        return Notice;
    }

    public void setNotice(String Notice) {
        this.Notice = Notice;
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
     public int getAge(){
        return Period.between(Date, LocalDate.now()).getYears();
    }

    void setUsername(String toString) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
  
    
}
