/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package startPage;

import Users.User;
import helperClass.Utility;
import helperClass.loginData;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
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
public class ForgotPasswordController implements Initializable {

    @FXML
    private TextField usernameTextF;
    @FXML
    private PasswordField passwordTF;
    @FXML
    private ComboBox<String> userTypeCB;
    @FXML
    private TextField emailTF;
    @FXML
    private RadioButton maleRadio;
    @FXML
    private RadioButton femaleRadio;
    @FXML
    private RadioButton otherRadio;
    @FXML
    private DatePicker birthdayTF;

    ToggleGroup tg =new ToggleGroup();
    Alert failure = new Alert(Alert.AlertType.WARNING, "Error, passeord change  failed!");
    Alert unfilled = new Alert(Alert.AlertType.WARNING,"Please Enter Everything!");
    Alert success = new Alert(Alert.AlertType.INFORMATION,"Congratulation ! password has been changed ");
    
    
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        maleRadio.setToggleGroup(tg);
        femaleRadio.setToggleGroup(tg);
        otherRadio.setToggleGroup(tg);
        userTypeCB.getItems().addAll("Director","Donor","Manager","Sponsor","Member","Treasure","Trainer","Volunteer","Media and publication","Event Organizer");
    }    

    @FXML
    private void resetButton(ActionEvent event) {
        String usertype = userTypeCB.getSelectionModel().getSelectedItem();
        String userName = usernameTextF.getText();
        String email = emailTF.getText();
        String userPass = passwordTF.getText();
        LocalDate birthday = birthdayTF.getValue();
        String gender = "";

        if(maleRadio.isSelected())
            gender = "male";
        else if( femaleRadio.isSelected())
            gender = "female";
        else if (otherRadio.isSelected())
            gender = " other";
        

        loginData L1;
        if (userTypeCB==null||userName.isEmpty()||email.isEmpty()||userPass.isEmpty()||birthday==null){
            unfilled.show();
            return;
        }

        L1= new loginData(usertype,userName,email,userPass,gender,birthday);
        if(L1.register(L1)){
            success.show();
           
        }else{
            failure.show();
        }
        userTypeCB.setValue(null);
        usernameTextF.clear();
        emailTF.clear();
        passwordTF.clear();
    }
    @FXML
    private void backButton(ActionEvent event) throws Exception {
         Utility.sceneSwitch (getClass(),event,"loginScene.fxml");
    }
    
}
