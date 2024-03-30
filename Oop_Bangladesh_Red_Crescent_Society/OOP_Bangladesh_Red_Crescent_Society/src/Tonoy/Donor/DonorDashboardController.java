/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Tonoy.Donor;

import helperClass.Utility;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author tonoy
 */
public class DonorDashboardController implements Initializable {

    @FXML
    private MenuBar menubarDonor;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void donorCardBT(ActionEvent event) {
    }

    @FXML
    private void logoutMitem(ActionEvent event) throws IOException {
        Parent sceneParent = FXMLLoader.load(getClass().getResource("/mainpkg/startScene.fxml"));
        Scene scene = new Scene(sceneParent);
        Stage window = (Stage) menubarDonor.getScene().getWindow(); 
        window.setScene(scene);
        window.show();
    }
    
}
