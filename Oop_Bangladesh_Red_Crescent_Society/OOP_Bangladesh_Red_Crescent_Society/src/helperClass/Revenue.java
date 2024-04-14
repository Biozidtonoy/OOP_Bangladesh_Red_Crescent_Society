/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helperClass;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author HP
 */
public class Revenue implements Serializable{
    private int id;
    private String name;
    private double amount;
    private LocalDate date;

    public Revenue(int id, String name, double amount, LocalDate date) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Revenue{" + "id=" + id + ", name=" + name + ", amount=" + amount + ", date=" + date + '}';
    }

    public String getDetails() {
      
        return null;
      
}
}
