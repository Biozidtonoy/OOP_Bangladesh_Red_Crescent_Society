/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sumya.EventOrganizer;

/**
 *
 * @author sumya
 */
public class emergency {
    private String Name;
    private int Number;

    emergency(int parseInt, String text, String value) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String toString() {
        return "emergency{" + "Name=" + Name + ", Number=" + Number + '}';
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getNumber() {
        return Number;
    }

    public void setNumber(int Number) {
        this.Number = Number;
    }

    public emergency(String Name, int Number) {
        this.Name = Name;
        this.Number = Number;
    }
    
}
