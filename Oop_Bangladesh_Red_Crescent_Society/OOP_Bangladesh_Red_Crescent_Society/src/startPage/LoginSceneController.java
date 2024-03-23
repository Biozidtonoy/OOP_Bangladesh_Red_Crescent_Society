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

        ArrayList<String> username = RegisterSceneController.username;
        ArrayList<String> userpass = RegisterSceneController.userpass;
        
        boolean validLogin = false;

        for (int i = 0; i < username.size(); i++) {
            if (username.get(i).equals(enteredUserName) && userpass.get(i).equals(enteredPassword)) {
                validLogin = true;
                break;
            }
        }

        if (validLogin) {
//        Scene Switching
          Utility.sceneSwitch (getClass(),event,"/Tonoy/Director/directorDashboard.fxml");
            
        } else {
            invaldInput.show();
        }

    }

    @FXML
    private void registerButton(ActionEvent event) throws Exception {
        Utility.sceneSwitch (getClass(),event,"registerScene.fxml");
    }
    
}
