/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Sumaiya.Trainer;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Muntasir
 */
public class WaterMonitoringController implements Initializable {

    @FXML
    private TextField trainerNameTextField;
    @FXML
    private TextField locationTextField;
    @FXML
    private ComboBox<String> courseTitleComboBox;
    @FXML
    private TextField courseDurationTextField;
    @FXML
    private TableView<WaterQualityMonitoring> tableView;
    @FXML
    private TableColumn<WaterQualityMonitoring, String> trainerNameTableColumn;
    @FXML
    private TableColumn<WaterQualityMonitoring, String> courseTitleTableColumn;
    @FXML
    private TableColumn<WaterQualityMonitoring, String> locationTableColumn;
    @FXML
    private TableColumn<WaterQualityMonitoring, Integer> courseDurationTableColumn;
    Alert successful = new Alert(Alert.AlertType.INFORMATION, "Successfully registered");
    Alert unfilled = new Alert(Alert.AlertType.WARNING, "Error, try again!");
    Alert invalid = new Alert(Alert.AlertType.WARNING, "Invalid input!");
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    trainerNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("trainerName"));
    courseTitleTableColumn.setCellValueFactory(new PropertyValueFactory<>("courseTitle"));
    courseDurationTableColumn.setCellValueFactory(new PropertyValueFactory<>("courseDuration"));
    locationTableColumn.setCellValueFactory(new PropertyValueFactory<>("location"));
    courseTitleComboBox.getItems().addAll("Water Quality","Environmental Sampling","Pollution Control","Data Analysis","Sampling Techniques");
    }    

    @FXML
    private void returnHomeButtonOnClick(ActionEvent event) throws IOException {
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("trainer.fxml"));
        Parent parent = loader.load();
        Scene newScene = new Scene(parent);

        currentStage.setScene(newScene);
        currentStage.show();
    }

    @FXML
    private void saveButtonOnClick(ActionEvent event) {
        try {
            String trainerName = trainerNameTextField.getText();
            String courseTitle = courseTitleComboBox.getValue();
            String location = locationTextField.getText();
            
            int courseDuration = Integer.parseInt(courseDurationTextField.getText());

            if (trainerName.isEmpty() || courseTitle.isEmpty() || location.isEmpty() || courseDuration == 0) {
                unfilled.show();
                return;
            }

            WaterQualityMonitoring info = new WaterQualityMonitoring(trainerName, courseTitle, location, location, courseDuration);
            info.creatWaterTrainig(info);
            tableView.getItems().add(info);

            trainerNameTextField.clear();
            courseTitleComboBox.getSelectionModel().clearSelection();
            locationTextField.clear();
            courseDurationTextField.clear();

            successful.show();
        } catch (NumberFormatException e) {
            invalid.show();
        }
    }

    @FXML
    private void viewDetailsButtonOnClick(ActionEvent event) {
        ObservableList<WaterQualityMonitoring> records = FXCollections.observableList(WaterQualityMonitoring.waterMonitoring());
         tableView.setItems(records);
    }

    @FXML
    private void courseButtonOnClick(ActionEvent event) throws IOException {
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("waterCourse.fxml"));
        Parent parent = loader.load();
        Scene newScene = new Scene(parent);

        currentStage.setScene(newScene);
        currentStage.show();
    }
    
}
