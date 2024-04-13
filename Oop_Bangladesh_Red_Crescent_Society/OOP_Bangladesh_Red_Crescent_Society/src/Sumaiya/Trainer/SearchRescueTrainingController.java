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
public class SearchRescueTrainingController implements Initializable {

    @FXML
    private TextField trainerNameTextField;
    @FXML
    private ComboBox<String> courseTitleComboBox;
    @FXML
    private TextField courseDurationTextField;
    @FXML
    private TextField locationTextField;
    @FXML
    private TextArea coursedDescriptionTextArea;
    @FXML
    private TableView<SearchAndRescueTraining> tableView;
    @FXML
    private TableColumn<SearchAndRescueTraining, String> trainerNameTableColumn;
    @FXML
    private TableColumn<SearchAndRescueTraining, String> courseTitleTableCloumn;
    @FXML
        private TableColumn<SearchAndRescueTraining, Integer> durationTableColumn;
    @FXML
    private TableColumn<SearchAndRescueTraining, String> locationTableColumn;
    Alert successful = new Alert(Alert.AlertType.INFORMATION, "Successfully registered");
    Alert unfilled = new Alert(Alert.AlertType.WARNING, "Error, try again!");
    Alert invalid = new Alert(Alert.AlertType.WARNING, "Try Again");
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        coursedDescriptionTextArea.setText("Search and Rescue Training equips participants with essential skills for locating and aiding individuals in emergency situations. "
                + "\nCovering topics such as first aid, navigation, and rescue techniques, "
                + "\nthis course prepares individuals to respond effectively to various crises, "
                + "\nensuring the safety and well-being of those in need.");
            
    trainerNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("trainerName"));
    courseTitleTableCloumn.setCellValueFactory(new PropertyValueFactory<>("courseTitle"));
    durationTableColumn.setCellValueFactory(new PropertyValueFactory<>("courseDuration"));
    locationTableColumn.setCellValueFactory(new PropertyValueFactory<>("location"));
    
    courseTitleComboBox.getItems().addAll("Basic Search and Rescue", "Wilderness Search and Rescue ", "Urban Search and Rescue", "Swiftwater Search and Rescue", "Technical Rope Rescue Training");    
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

            SearchAndRescueTraining info = new SearchAndRescueTraining(trainerName, courseTitle, location, trainerName, courseDuration);
            info.creatSearchTrainig(info);
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
    private void courseButtonOnClick(ActionEvent event) throws IOException {
        
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("searchCourse.fxml"));
        Parent parent = loader.load();
        Scene newScene = new Scene(parent);

        currentStage.setScene(newScene);
        currentStage.show();
    }

    @FXML
    private void viewDetailsButtonOnClick(ActionEvent event) {
        ObservableList<SearchAndRescueTraining> records = FXCollections.observableList(SearchAndRescueTraining.searchRescue());
         tableView.setItems(records);
        
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
    
}
