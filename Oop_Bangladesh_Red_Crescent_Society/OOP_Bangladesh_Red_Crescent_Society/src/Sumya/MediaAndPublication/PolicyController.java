/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Sumya.MediaAndPublication;

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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author sumya
 */
public class PolicyController implements Initializable {

    /**
     * Initializes the controller class.
     * @param url
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
       @FXML
    void backbuttonaction(ActionEvent event) throws IOException {  
        FXMLLoader loader = new FXMLLoader(getClass().getResource("mediaPublicationDashboard.fxml"));
        Parent parent = loader.load();


        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();


        Scene nextScene = new Scene(parent);

        currentStage.setScene(nextScene);
        currentStage.show();
  

    } 
}





