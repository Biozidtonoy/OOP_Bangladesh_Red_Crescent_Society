/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package startPage;

import helperClass.Utility;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import static startPage.RegisterSceneController.username;
import static startPage.RegisterSceneController.userpass;

/**
 * FXML Controller class
 *
 * @author tonoy
 */
public class LoginSceneController implements Initializable {

    @FXML
    private TextField usernameTF;
    @FXML
    private PasswordField passwordTF;
    
    Alert invaldInput = new Alert(Alert.AlertType.INFORMATION,"invalid username and password");
    Alert unfilled = new Alert(Alert.AlertType.WARNING,"Please Enter Everything!");

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void loginButton(ActionEvent event) throws Exception  {
        String enteredUserName = usernameTF.getText();
        String enteredPassword = passwordTF.getText();

//        ArrayList<String> username = RegisterSceneController.username;
//        ArrayList<String> userpass = RegisterSceneController.userpass;
        
        boolean anyEmpty = false;
            if (enteredUserName .isEmpty()||enteredPassword.isEmpty()){
                anyEmpty = true;  
            }
        
        if (anyEmpty){
            unfilled.show();
        }else{
            if (usernameTF.getText().equals("director") && passwordTF.getText().equals("director111")) {
            Utility.sceneSwitch(getClass(), event, "/Tonoy/Director/directorDashboard.fxml");
        } else if (usernameTF.getText().equals("donor") && passwordTF.getText().equals("donor111")) {
            Utility.sceneSwitch(getClass(), event, "/Tonoy/Donor/donorDashboard.fxml");
        } else if (usernameTF.getText().equals("manager") && passwordTF.getText().equals("manager111")) {
            Utility.sceneSwitch(getClass(), event, "/Tonoy/Donor/donorDashboard.fxml");
        } else if (usernameTF.getText().equals("sponsor") && passwordTF.getText().equals("sponsor111")) {
            Utility.sceneSwitch(getClass(), event, "/Tonoy/Donor/donorDashboard.fxml");
        } else if (usernameTF.getText().equals("member") && passwordTF.getText().equals("member111")) {
            Utility.sceneSwitch(getClass(), event, "/Tonoy/Donor/donorDashboard.fxml");
        } else if (usernameTF.getText().equals("treasure") && passwordTF.getText().equals("treasure111")) {
            Utility.sceneSwitch(getClass(), event, "/Tonoy/Donor/donorDashboard.fxml");
        } else if (usernameTF.getText().equals("trainer") && passwordTF.getText().equals("trainer111")) {
            Utility.sceneSwitch(getClass(), event, "/Tonoy/Donor/donorDashboard.fxml");
        } else if (usernameTF.getText().equals("volunteer") && passwordTF.getText().equals("volunteer111")) {
            Utility.sceneSwitch(getClass(), event, "/Tonoy/Donor/donorDashboard.fxml");
        } else if (usernameTF.getText().equals("event") && passwordTF.getText().equals("event111")) {
            Utility.sceneSwitch(getClass(), event, "/Tonoy/Donor/donorDashboard.fxml");
        } else if (usernameTF.getText().equals("media") && passwordTF.getText().equals("media111")) {
            Utility.sceneSwitch(getClass(), event, "/Tonoy/Donor/donorDashboard.fxml");
        } else {
            invaldInput.show();
        }
        }

   }

    @FXML
    private void registerButton(ActionEvent event) throws Exception {
        Utility.sceneSwitch (getClass(),event,"registerScene.fxml");
    }
    
}
