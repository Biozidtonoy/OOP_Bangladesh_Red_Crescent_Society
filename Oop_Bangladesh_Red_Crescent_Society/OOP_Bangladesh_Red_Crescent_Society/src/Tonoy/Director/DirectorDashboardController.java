/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Tonoy.Director;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author tonoy
 */
public class DirectorDashboardController implements Initializable {

  
    @FXML
    private MenuBar menuBar;

    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
   

    @FXML
    private void arrangeMeetingsBT(ActionEvent event) throws IOException {
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("arrangeMeeting.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow(); 
        window.setScene(scene1);
        window.show();
    }

    @FXML
    private void jobCircularBT(ActionEvent event) throws IOException {
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("jobCircular.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow(); 
        window.setScene(scene1);
        window.show();
    }

    @FXML
    private void trainningBT(ActionEvent event) throws IOException {
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("training.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow(); 
        window.setScene(scene1);
        window.show();
    }


    @FXML
    private void oversightBT(ActionEvent event) {
    }

    @FXML
    private void emergencyBT(ActionEvent event) throws IOException {
         Parent mainSceneParent = FXMLLoader.load(getClass().getResource("emergency.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow(); 
        window.setScene(scene1);
        window.show();
    }
    

    @FXML
    private void viewReportMitem(ActionEvent event) {
    }

    @FXML
    private void feedbackItem(ActionEvent event) throws IOException {
         Parent mainSceneParent = FXMLLoader.load(getClass().getResource("viewFeedback.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage)menuBar.getScene().getWindow(); 
        window.setScene(scene1);
        window.show();
        
    }

    @FXML
    private void logoutMitem(ActionEvent event) throws IOException {
       Parent sceneParent = FXMLLoader.load(getClass().getResource("/mainpkg/startScene.fxml"));
        Scene scene = new Scene(sceneParent);
        Stage window = (Stage) menuBar.getScene().getWindow(); 
        window.setScene(scene);
        window.show();
    }
    
    @FXML
    private void fileMItem(ActionEvent event) {
    }

//    private void userDetailsMitem(ActionEvent event) throws IOException {
//        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("userDetails.fxml"));
//        Scene scene1 = new Scene(mainSceneParent);
//        Stage window = (Stage) menuBar.getScene().getWindow(); 
//        window.setScene(scene1);
//        window.show();
//    }
    
}
