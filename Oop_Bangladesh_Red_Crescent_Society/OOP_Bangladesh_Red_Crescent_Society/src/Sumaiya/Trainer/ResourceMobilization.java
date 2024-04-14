/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sumaiya.Trainer;

import Users.User;
import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author Muntasir
 */
public class ResourceMobilization extends User implements Serializable {
    private String name,material;
    
     public ResourceMobilization(){
        
    }

    public ResourceMobilization(String name, String material) {
        this.name = name;
        this.material = material;
    }

    public ResourceMobilization(String name, String material, String usertype, String username, String email, String password, String gender, LocalDate birthday) {
        super(usertype, username, email, password, gender, birthday);
        this.name = name;
        this.material = material;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public String toString() {
        return "ResourceMobilization{" + "name=" + name + ", material=" + material + '}';
    }
    
}
