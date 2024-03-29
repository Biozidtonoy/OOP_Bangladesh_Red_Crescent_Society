/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helperClass;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author tonoy
 */
public class loginData implements Serializable {
    public String userType,username,email,password,gender;
    public LocalDate birthday;

    public loginData(String userType, String username, String email, String password, String gender, LocalDate birthday) {
        this.userType = userType;
        this.username = username;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.birthday = birthday;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "loginData{" + "userType=" + userType + ", username=" + username + ", email=" + email + ", password=" + password + ", gender=" + gender + ", birthday=" + birthday + '}';
    }
    
    public boolean register(loginData l) {
       File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        
        try{
            f = new File("registerinfo.bin");
            if(f.exists()){
               fos = new FileOutputStream(f,true);
               oos = new AppendableObjectOutputStream(fos);
               
            }else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos); 
            }
            l = new loginData(userType,username,email,password,gender,birthday);
            oos.writeObject(l);
            System.out.println("Sign up success");
            return true;
            
            
        }catch(IOException ex){
             ex.printStackTrace();
      
        return false;
        } 
    }
   
}    

    


