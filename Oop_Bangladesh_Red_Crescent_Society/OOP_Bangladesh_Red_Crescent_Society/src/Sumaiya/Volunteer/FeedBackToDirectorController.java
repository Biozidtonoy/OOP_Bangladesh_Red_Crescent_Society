/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Sumaiya.Volunteer;

import helperClass.feedback;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Muntasir
 */
public class FeedBackToDirectorController implements Initializable {

    @FXML
    private TextField nameTextField;
    @FXML
    private TextField ageTextField;
    @FXML
    private TextField occupationTextField;
    @FXML
    private ComboBox<String> districtComboBox;
    @FXML
    private DatePicker dateTextField;
    @FXML
    private TextArea contentTextArea;
    Alert success = new Alert(Alert.AlertType.INFORMATION,"feedback done");
    Alert unfilled = new Alert(Alert.AlertType.WARNING,"Please Enter Everything!");
    Alert cancel = new Alert(Alert.AlertType.WARNING,"your donation has cancelled");

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    

    @FXML
    private void backButtonOnClick(ActionEvent event) throws IOException {
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("volunteerDashboard.fxml"));
        Parent parent = loader.load();
        Scene newScene = new Scene(parent);

        currentStage.setScene(newScene);
        currentStage.show();
    }

    @FXML
    private void doneButtionOnClick(ActionEvent event) {
        
    
}
}