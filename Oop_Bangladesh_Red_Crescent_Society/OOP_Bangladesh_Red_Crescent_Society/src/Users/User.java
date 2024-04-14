/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Users;

import helperClass.AppendableObjectOutputStream;
import helperClass.loginData;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import javafx.scene.control.Alert;

/**
 *
 * @author tonoy
 */
public abstract class User implements Serializable {
    public String usertype,username,email,password,gender;
    public LocalDate birthday;

    public User(String usertype, String username, String email, String password, String gender, LocalDate birthday) {
        this.usertype = usertype;
        this.username = username;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.birthday = birthday;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
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
        return "User{" + "usertype=" + usertype + ", username=" + username + ", email=" + email + ", password=" + password + ", gender=" + gender + ", birthday=" + birthday + '}';
    }
    public static int tryTologin(String usercheck,String passCheck ){
        File f = null ;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        boolean usernameMactched = false;
        boolean passMatched = false;
        int userType=0;
        try{
            f = new File("registerinfo.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            loginData login;
            try{
                while(true){
                    if (usernameMactched){break;}
                    login = (loginData ) ois.readObject();
                    System.out.println(login.toString());
                    if(usercheck.equals(login.getUsername())){
                        usernameMactched= true;
                        if(passCheck.equals(login.getPassword())){
                            passMatched=true;
                            switch(login.getUserType()){
                                case "Director":
                                    userType=1;
                                    break;
                                case "Donor":
                                    userType=2;
                                    break;
                                case "Manager":
                                    userType=3;
                                    break;
                                case "Sponsor":
                                    userType=4;
                                    break;
                                case "Member":
                                    userType=5;
                                    break;
                                case "Treasure":
                                    userType=6;
                                    break;
                                case "Trainer":
                                    userType=7;
                                    break;
                                case "Volunteer":
                                    userType=8;
                                    break;
                                case "Event Organizer":
                                    userType=9;
                                    break;
                                case "Media and publication":
                                    userType=10;
                                    break;
                                default: 
                                    userType = 11;
                                    break;
                            }
                        }
                    }
                }
            }catch(Exception e1){
                System.out.println("something is wrong "+e1.toString());
            }
            
        }catch(Exception e){
            System.out.println("file is not created");
            Alert notFound = new Alert(Alert.AlertType.WARNING, "user not found !\nplease register first!");
            notFound.show();
        }
        return userType;
    }
        public static ArrayList<loginData > readregisterInfoList() {
        ArrayList<loginData > registerInfoList = new ArrayList<>();
        loginData  l1;
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("registerinfo.bin"));
            while (true) {
                l1 = (loginData ) ois.readObject();
                System.out.println("The register info read: " + l1.toString());
                registerInfoList.add(l1);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("File reading done");
        }
        System.out.println(registerInfoList );
        return registerInfoList  ;
    }
        
//       public boolean forgotpass(String userType, String username, String newPassword) {
//        ArrayList<loginData> registerInfoList = readregisterInfoList();
//
//        // Find the user with the matching username and update the password
//        for (loginData data : registerInfoList) {
//            if (data.getUsername().equals(username)) {
//                data.setPassword(newPassword);
//                break; // Once the password is updated, exit the loop
//            }
//        }
//
//        // Write the updated records back to the file
//        try (FileOutputStream fos = new FileOutputStream("registerinfo.bin"); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
//            for (loginData data : registerInfoList) {
//                oos.writeObject(data);
//            }
//            System.out.println("Password changed successfully");
//            return true;
//        } catch (IOException ex) {
//            ex.printStackTrace();
//            return false;
//        }
//}
        
}
