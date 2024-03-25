/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package startPage;

import helperClass.User;
import helperClass.Utility;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author tonoy
 */
public class RegisterSceneController implements Initializable {

    @FXML
    private TextField fullnameTF;
    @FXML
    private TextField usernameTF;
    @FXML
    private PasswordField passwordTF;
    @FXML
    private TextField emailTF;
    @FXML
    private DatePicker birthdayTF;
    @FXML
    private RadioButton maleRadio;
    @FXML
    private RadioButton femaleRadio;
    @FXML
    private RadioButton otherRadio;
    
    ToggleGroup tg =new ToggleGroup();
    Alert unfilled = new Alert(Alert.AlertType.WARNING,"Please Enter Everything!");
    Alert success = new Alert(Alert.AlertType.INFORMATION,"Congratulation your account has been created ");
    
    /**
     *
     */
    public static ArrayList<User> userDetails = new ArrayList<>();
    public static ArrayList<String> username = new ArrayList<>();
    public static ArrayList<String> userpass = new ArrayList<>();
   
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        maleRadio.setToggleGroup(tg);
        femaleRadio.setToggleGroup(tg);
        otherRadio.setToggleGroup(tg);
        
        
    }    

    @FXML
    private void signupButton(ActionEvent event) {
        String fullName = fullnameTF.getText();
        String userName = usernameTF.getText();
        String email = emailTF.getText();
        String userPass = passwordTF.getText();
        LocalDate birthday = birthdayTF.getValue();
        String gender = "";
        
        User u = new User(fullName,userName,email,userPass,birthday,gender);
        userDetails.add(u);

        username.add(userName);
        userpass.add(userPass);


      
        if(maleRadio.isSelected())
            gender = "male";
        else if( femaleRadio.isSelected())
            gender = "female";
        else if (otherRadio.isSelected())
            gender = " other";
        
        if (gender.isEmpty()){
            unfilled.show();
            return;
        }
        
        boolean anyEmpty = false;
            if (fullName.isEmpty()||userName.isEmpty()||email.isEmpty()||userPass.isEmpty()||birthday==null){
                anyEmpty = true;
               
            }
        
        if (anyEmpty){
            unfilled.show();
        }
        
        
//        file handiling 
        try{
            FileOutputStream fos = new FileOutputStream("usersdetails.bin", true);
            DataOutputStream dos = new DataOutputStream(fos);
            
            dos.writeUTF(userName);
            dos.writeUTF(userPass);
        }catch(Exception e){  
        }
        try{
            File f = new File("usersdetails.bin");
            FileInputStream fis = new FileInputStream(f);
            DataInputStream dis = new DataInputStream(fis);
            dis.readUTF();
            dis.readUTF();
            
            success.show();
        }catch(Exception e){
            
        }
       
        


      
    }
    @FXML
    private void backButton(ActionEvent event) throws Exception {
        Utility.sceneSwitch (getClass(),event,"/startPage/loginScene.fxml");
    }

}
