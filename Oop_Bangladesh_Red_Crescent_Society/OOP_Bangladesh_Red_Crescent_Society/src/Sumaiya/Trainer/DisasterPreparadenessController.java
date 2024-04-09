/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Sumaiya.Trainer;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Muntasir
 */
public class DisasterPreparadenessController implements Initializable {

    @FXML
    private TextField trainerNameTextField;
    @FXML
    private TextField courseDurationTextField;
    @FXML
    private ComboBox<String> courseTitleComboBox;
    @FXML
    private TextField locationTextField;
    @FXML
    private TextArea courseDecriptionTextArea;
    @FXML
    private TableColumn<DisasterPreparednessTraining, String> trainerNameTableColumn;
    @FXML
    private TableColumn<DisasterPreparednessTraining, String> courseTitleTableCloumn;
    @FXML
    private TableColumn<DisasterPreparednessTraining, Integer> durationTableColumn;
    @FXML
    private TableColumn<DisasterPreparednessTraining, String> locationTableColumn;
    @FXML
    private TableView<DisasterPreparednessTraining> tableView;
    Alert successful = new Alert(Alert.AlertType.INFORMATION, "Successfully registered");
    Alert unfilled = new Alert(Alert.AlertType.WARNING, "Error, try again!");
    Alert invalid = new Alert(Alert.AlertType.WARNING, "Try Again");
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       courseDecriptionTextArea.setText("Eat balanced, exercise regularly, hydrate, sleep well, \nmanage stress for overall well-being and longevity"
               + "\nMaintain a balanced diet rich in fruits, vegetables, lean proteins, and whole grains"
               + "Practice stress-relief techniques like meditation or deep breathing for mental well-being.");
       
    trainerNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("trainerName"));
    courseTitleTableCloumn.setCellValueFactory(new PropertyValueFactory<>("courseTitle"));
    durationTableColumn.setCellValueFactory(new PropertyValueFactory<>("courseDuration"));
    locationTableColumn.setCellValueFactory(new PropertyValueFactory<>("location"));
    
    courseTitleComboBox.getItems().addAll("Emergency Preparedness ", "Disaster Management", "Community Disaster Preparedness", "Crisis Response ", "Natural Disaster");    
    }    

    @FXML
    private void returnHomeButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void saveButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void viewDetailsButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void courseButtonOnClick(ActionEvent event) {
    }
    
}
