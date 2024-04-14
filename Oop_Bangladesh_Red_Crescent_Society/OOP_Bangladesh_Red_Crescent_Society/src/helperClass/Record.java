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
public class Record implements Serializable{
    private String name,recordType,status;
    private LocalDate date;

    public Record(String name, String recordType, String status, LocalDate date) {
        this.name = name;
        this.recordType = recordType;
        this.status = status;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRecordType() {
        return recordType;
    }

    public void setRecordType(String recordType) {
        this.recordType = recordType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Record{" + "name=" + name + ", recordType=" + recordType + ", status=" + status + ", date=" + date + '}';
    }
     
}
