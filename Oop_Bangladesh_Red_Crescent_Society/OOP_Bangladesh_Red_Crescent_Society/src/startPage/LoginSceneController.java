/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package startPage;

import Users.User;
import helperClass.Utility;
import java.net.URL;
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
    Alert error = new Alert(Alert.AlertType.ERROR, "Invalid username or password");

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
        
     
            if (enteredUserName .isEmpty()||enteredPassword.isEmpty()){
                error.show();
               
            }else{
                 int logIn = User.tryTologin(enteredUserName,enteredPassword);
                switch (logIn) {
                    case 1:
                        System.out.println("something");
                        Parent directorDashboard = null;
                        FXMLLoader directorLoader = new FXMLLoader(getClass().getResource("/Tonoy/Director/directorDashboard.fxml"));
                        directorDashboard = (Parent) directorLoader.load(); 
                        Scene directorScene = new Scene(directorDashboard);
                        
                        Stage doctorStage = (Stage)((Node)event.getSource()).getScene().getWindow();
                        doctorStage.setScene(directorScene);
                        doctorStage.show();
                        break;
                        
                    case 2:
                        Utility.sceneSwitch(getClass(), event, "/Tonoy/Donor/donorDashboard.fxml");
                        break;
                    case 3:
                        Utility.sceneSwitch(getClass(), event, "/Mehedi/Manager/managerDashboard.fxml");
                         break;
                    case 4:
                        Utility.sceneSwitch(getClass(), event, "/Mehedi/Sponsor/sponsorDashboard.fxml");
                         break;
                    case 5:
                        Utility.sceneSwitch(getClass(), event, "/Sazzad/Member/memberDashboard.fxml");
                         break;
                    case 6:
                        Parent treasurerDashboard = null;
                        FXMLLoader treasurerLoader = new FXMLLoader(getClass().getResource("/Sazzad/Treasurer/treasurerDashboard.fxml"));
                        treasurerDashboard = (Parent) treasurerLoader.load(); 
                        Scene treasurerScene = new Scene(treasurerDashboard);
                        
                        Stage treasurerStage = (Stage)((Node)event.getSource()).getScene().getWindow();
                        treasurerStage.setScene(treasurerScene);
                        treasurerStage.show();
                        break;
                         
                    case 7:
                        Utility.sceneSwitch(getClass(), event, "/Sumaiya/Trainer/trainerDashboard.fxml");
                         break;
                    case 8:
                        Utility.sceneSwitch(getClass(), event, "/Sumaiya/Volunteer/volunteerDashboard.fxml");
                         break;
                    case 9:
                        Utility.sceneSwitch(getClass(), event, "/Sumya/EventOrganizer/eventOrganizerDashboard.fxml");
                         break;
                    case 10:
                        Utility.sceneSwitch(getClass(), event, "/Sumya/MediaAndPublication/mediaPublicationDashboard.fxml");
                         break;
                    case 11:
                        System.out.println("user not found");
                        break;
               
                }
            }

        

        



   }

    @FXML
    private void registerButton(ActionEvent event) throws Exception {
        Utility.sceneSwitch (getClass(),event,"registerScene.fxml");
    }

    @FXML
    private void forgotPasswordButton(ActionEvent event) throws Exception {
        Utility.sceneSwitch (getClass(),event,"forgotPassword.fxml");
    }
    
}
