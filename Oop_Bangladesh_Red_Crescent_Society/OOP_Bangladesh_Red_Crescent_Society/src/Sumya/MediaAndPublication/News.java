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
public class News {
    
    private String News;
    private LocalDate Date;

    public News(String News, LocalDate Date) {
        this.News = News;
        this.Date = Date;
    }

    public String getNews() {
        return News;
    }

    public void setNews(String News) {
        this.News = News;
    }

    public LocalDate getDate() {
        return Date;
    }

    public void setDate(LocalDate Date) {
        this.Date = Date;
    }

    @Override
    public String toString() {
        return "News{" + "News=" + News + ", Date=" + Date + '}';
    }

  
    
}
