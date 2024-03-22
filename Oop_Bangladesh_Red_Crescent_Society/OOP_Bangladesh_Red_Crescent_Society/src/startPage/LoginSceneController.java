/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package startPage;

import helperClass.Utility;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void loginButton(ActionEvent event) throws Exception {
//        Utility.sceneSwitch (getClass(),event,"/Tonoy/Director/directorDashboard.fxml");
    }

    @FXML
    private void registerButton(ActionEvent event) throws Exception {
        Utility.sceneSwitch (getClass(),event,"registerScene.fxml");
    }
    
}
