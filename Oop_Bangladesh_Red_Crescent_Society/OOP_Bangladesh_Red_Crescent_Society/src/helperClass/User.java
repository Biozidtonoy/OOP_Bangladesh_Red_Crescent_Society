/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helperClass;

import java.time.LocalDate;

/**
 *
 * @author tonoy
 */
public class User {
    public String fullname,username,email,password,gender;
    public LocalDate birthday;

    public User(String fullname, String username, String email, String password,LocalDate birthday,String gender) {
        this.fullname = fullname;
        this.username = username;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.birthday = birthday;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
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
        return "User{" + "fullname=" + fullname + ", username=" + username + ", email=" + email + ", password=" + password + ", gender=" + gender + ", birthday=" + birthday + '}';
    }
    
    
   
}



