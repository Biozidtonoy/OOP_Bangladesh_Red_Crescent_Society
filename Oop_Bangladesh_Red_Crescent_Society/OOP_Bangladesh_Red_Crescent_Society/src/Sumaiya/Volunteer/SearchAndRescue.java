/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sumaiya.Volunteer;

import Users.User;
import helperClass.AppendableObjectOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Muntasir
 */
public class SearchAndRescue extends User implements Serializable {
    private String name, location;
    private int age;
    private LocalDate rescuedDate;

    public SearchAndRescue(String name, String location, int age, LocalDate rescuedDate) {
        this.name = name;
        this.location = location;
        this.age = age;
        this.rescuedDate = rescuedDate;
    }

    public SearchAndRescue(String name, String location, int age, LocalDate rescuedDate, String usertype, String username, String email, String password, String gender, LocalDate birthday) {
        super(usertype, username, email, password, gender, birthday);
        this.name = name;
        this.location = location;
        this.age = age;
        this.rescuedDate = rescuedDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getRescuedDate() {
        return rescuedDate;
    }

    public void setRescuedDate(LocalDate rescuedDate) {
        this.rescuedDate = rescuedDate;
    }

    @Override
    public String toString() {
        return "SearchAndRescue{" + "name=" + name + ", location=" + location + ", age=" + age + ", rescuedDate=" + rescuedDate + '}';
    }
    public boolean creatSearch(SearchAndRescue  fb1) {


        System.out.println("training made:" + fb1.toString());

        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {

            f = new File("search.bin");

            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);

            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            fb1 = new SearchAndRescue(name, location, age, rescuedDate);

            oos.writeObject(fb1);
            oos.close();
            return true;

        } catch (IOException e) {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException ex) {
                    Logger.getLogger(SearchAndRescue .class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            System.out.println("Error writing Object to binary file");
            return false;

        }
    }

    public static ObservableList<SearchAndRescue> searchRecord(){
        ObservableList<SearchAndRescue> searchList1 = FXCollections.observableArrayList();
        SearchAndRescue fb3;
        ObjectInputStream ois = null;
        try{
            ois = new ObjectInputStream (new FileInputStream("search.bin"));
            while(true){
               fb3 = (SearchAndRescue) ois.readObject();
                System.out.println("The aidbin u read: "+fb3.toString());
                searchList1.add(fb3);
            }
        }
        catch(IOException | ClassNotFoundException e){System.out.println("File reading done");}
        System.out.println(searchList1);
        return searchList1;
    }
    public static ObservableList<SearchAndRescue> readRescueList(){
        ObservableList<SearchAndRescue> rescueList = FXCollections.observableArrayList();
        SearchAndRescue fb3;
        ObjectInputStream ois = null;
        try{
            ois = new ObjectInputStream (new FileInputStream("search.bin"));
            while(true){
               fb3 = (SearchAndRescue) ois.readObject();
                System.out.println("The rescue u read: "+fb3.toString());
                rescueList.add(fb3);
            }
        }
        catch(IOException | ClassNotFoundException e){System.out.println("File reading done");}
        System.out.println(rescueList);
        return rescueList;
    }
    }






