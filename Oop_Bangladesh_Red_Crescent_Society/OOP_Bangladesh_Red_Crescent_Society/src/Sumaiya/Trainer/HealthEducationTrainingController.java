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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Muntasir
 */
public class HealthEducationTrainingController implements Initializable {

    @FXML
    private TextField trainerNameTextField1;
    @FXML
    private TextField courseDurationTextField;
    @FXML
    private TextField locationTextField;
    @FXML
    private ComboBox<String> courseTitleComboBox;
    @FXML
    private TableView<HealthEducationTraining> tableView;
    @FXML
    private TableColumn<HealthEducationTraining, String> trainerNameTableColumn;
    @FXML
    private TableColumn<HealthEducationTraining, String> courseTitleTableColumn;
    @FXML
    private TableColumn<HealthEducationTraining, String> locationTableColumn;
    @FXML
    private TableColumn<HealthEducationTraining, Integer> courseDurationTableColumn;
    @FXML
    private TableColumn<HealthEducationTraining, String> courseDescriptionTableColumn;
    @FXML
    private TextArea courseDecriptionTextArea;
    Alert successful = new Alert(Alert.AlertType.INFORMATION, "Successfully registered");
    Alert unfilled = new Alert(Alert.AlertType.WARNING, "Error, try again!");
    Alert invalid = new Alert(Alert.AlertType.WARNING, "Try Again");
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    trainerNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("trainerName"));
    courseTitleTableColumn.setCellValueFactory(new PropertyValueFactory<>("courseTitle"));
    courseDurationTableColumn.setCellValueFactory(new PropertyValueFactory<>("courseDuration"));
    locationTableColumn.setCellValueFactory(new PropertyValueFactory<>("location"));
    courseDescriptionTableColumn.setCellValueFactory(new PropertyValueFactory<>("courseDescription"));
    courseTitleComboBox.getItems().addAll("Healthy Living", "Health and Wellness", "Physical Fitness", "Mental Health Awareness", "Personal Hygiene");
    }    

    @FXML
    private void saveButtonOnClick(ActionEvent event) {
        try {
           
            String trainerName = trainerNameTextField1.getText();
            String courseTitle = courseTitleComboBox.getValue();
            String location = locationTextField.getText();
            int courseDuration = Integer.parseInt(courseDurationTextField.getText());
            String courseDescription= courseDecriptionTextArea.getText();

            if (trainerName.isEmpty() || courseTitle.isEmpty() || location.isEmpty() || courseDuration == 0  ||courseDescription.isEmpty()) {
                unfilled.show();
                return;
            }

            HealthEducationTraining info = new HealthEducationTraining(trainerName, courseTitle, location, courseDescription, courseDuration);
            info.creatHealthTrainig(info);
            tableView.getItems().add(info);
            
            trainerNameTextField1.clear();
            courseTitleComboBox.getSelectionModel().clearSelection();
            locationTextField.clear();
            courseDurationTextField.clear();
            courseDecriptionTextArea.clear();
            

            successful.show();
            
        } catch (NumberFormatException e) {
            invalid.show();
    }
    }

    @FXML
    private void courseButtonOnClick(ActionEvent event) throws IOException {
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("heaCourse.fxml"));
        Parent parent = loader.load();
        Scene newScene = new Scene(parent);

        currentStage.setScene(newScene);
        currentStage.show();
    }

    @FXML
    private void viewDetailsButtonOnClick(ActionEvent event) {
        ObservableList<HealthEducationTraining> records = FXCollections.observableList(HealthEducationTraining.healthEducation());
        tableView.setItems(records);
    }
    
}
