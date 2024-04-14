/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Sumaiya.Trainer;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Cell;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Muntasir
 */
public class CourseController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void bookButtonOnClick(ActionEvent event) throws IOException, URISyntaxException {
     Desktop.getDesktop().browse(new URI("https://drive.google.com/drive/folders/1z2Cnl_KX4jmijr_syO_D1AKmNYWSU9DS?usp=sharing"));

    }

    @FXML
    private void outLineButtonOnClick(ActionEvent event) throws IOException, URISyntaxException {
    Desktop.getDesktop().browse(new URI("https://drive.google.com/drive/folders/1W3qZKYWSEvcfNGkEWlgomx9F3gLpPxY7?usp=sharing"));
    }

                                
    
    @FXML
    private void yesButtonOnClick(ActionEvent event) throws IOException {
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("test.fxml"));
        Parent parent = loader.load();
        Scene newScene = new Scene(parent);

        currentStage.setScene(newScene);
        currentStage.show();
        
    }

    @FXML
    private void noButtonOnClick(ActionEvent event) throws IOException {
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("trainer.fxml"));
        Parent parent = loader.load();
        Scene newScene = new Scene(parent);

        currentStage.setScene(newScene);
        currentStage.show();
    }
    
}
