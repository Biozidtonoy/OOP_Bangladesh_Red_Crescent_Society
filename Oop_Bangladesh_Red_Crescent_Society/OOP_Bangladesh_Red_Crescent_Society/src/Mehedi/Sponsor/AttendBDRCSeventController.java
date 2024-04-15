/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Mehedi.Sponsor;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Elitebook 830
 */
public class AttendBDRCSeventController implements Initializable {

    @FXML
    private ChoiceBox<String> eventChoiceBox;
    @FXML
    private TableView<Event> eventTableView;
    @FXML
    private TableColumn<Event, String> eventNameTableview;
    @FXML
    private TableColumn<Event, LocalDate> eventDateTableview;
    @FXML
    private TableColumn<Event, String> locationTableview;
    @FXML
    private DatePicker eventDatePicker;
    @FXML
    private TextField locationTextField;

    private ObservableList<Event> eventList;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Initialize event list
        eventList = FXCollections.observableArrayList();

        // Initialize table columns
        eventNameTableview.setCellValueFactory(new PropertyValueFactory<>("eventName"));
        eventDateTableview.setCellValueFactory(new PropertyValueFactory<>("eventDate"));
        locationTableview.setCellValueFactory(new PropertyValueFactory<>("location"));
    }

    @FXML
    private void registerPhysical(ActionEvent event) {
//        try {
//            String eventName = eventChoiceBox.getValue();
//            LocalDate eventDate = eventDatePicker.getValue();
//            String location = locationTextField.getText();
//
//            // Validate input
//            if (location.isEmpty() || eventDate == null || eventName == null) {
//                // Show an error message if any of the fields are empty
//                showAlert("Error", "Please fill in all fields.");
//                return;
//            }
//
//            Event e = new Event(eventName,eventDate,location);
//            eventList.add(e);
//            eventTableView.getItems().add(e);
//        } catch (Exception e) {
//        }
    }

    @FXML
    private void returnToDashboardButton(ActionEvent event) throws IOException {
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("sponsorDashboard.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow(); 
        window.setScene(scene1);
        window.show();
        
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}