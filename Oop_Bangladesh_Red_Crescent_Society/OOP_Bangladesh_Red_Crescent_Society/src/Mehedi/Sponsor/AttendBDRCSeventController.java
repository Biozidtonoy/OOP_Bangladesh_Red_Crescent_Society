/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Mehedi.Sponsor;

import java.io.IOException;
import java.net.URL;
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
    private TableView<Event> eventTableView;
    @FXML
    private TableColumn<Event, String> EventNameTableview;
    @FXML
    private TableColumn<Event, String> eventdatetableview;
    @FXML
    private TableColumn<Event, String> locationtableview;
    @FXML
    private TableColumn<Event, String> physicallyorvirtuallytableview;
    @FXML
    private DatePicker eventdatepicker;
    @FXML
    private TextField locationtextfield;
    private ObservableList<Event> events = FXCollections.observableArrayList();
    @FXML
    private TableView<Event> eventtableview;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        EventNameTableview.setCellValueFactory(new PropertyValueFactory<>("eventName"));
        eventdatetableview.setCellValueFactory(new PropertyValueFactory<>("eventDate"));
        locationtableview.setCellValueFactory(new PropertyValueFactory<>("location"));
        physicallyorvirtuallytableview.setCellValueFactory(new PropertyValueFactory<>("physicallyOrVirtually"));

        // Populate ChoiceBox (You need to implement this)
        populateChoiceBox();
    }

    private void populateChoiceBox() {
        // Implement your logic to populate the choice box with event options
        // For example:
        eventChoiceBox.getItems().addAll("Event 1", "Event 2", "Event 3");
      

         
            
    }    

    @FXML
    private void registerPhysical(ActionEvent event) {
        String eventName = eventChoiceBox.getValue();
        String eventDate = eventdatepicker.getValue().toString();
        String location = locationtextfield.getText();
        String physicalVirtual = "Physical"; // Assuming this is a physical registration
        
        // Add to TableView
        //eventTableView.getItems().add(new Event(eventName, eventDate, location, physicalVirtual));
       
       // event.add(new Event(selectedEvent, "Date", "Physical"));
        //showAlert("Register Physical", "You have registered for physical attendance for " + selectedEvent);
       
    }

    @FXML
    private void registerVirtual(ActionEvent event) {
        String eventName = eventChoiceBox.getValue();
        String eventDate = eventdatepicker.getValue().toString();
        String location = locationtextfield.getText();
        String physicalVirtual = "Virtual"; // Assuming this is a virtual registration
        
        // Add to TableView
       // eventTableView.getItems().add(new Event(eventName, eventDate, location, physicalVirtual));
        //String selectedEvent = eventChoiceBox.getValue();
       // eventData.add(new Event(selectedEvent, "Date", "Virtual"));
        //showAlert("Register Virtual", "You have registered for virtual attendance for " + selectedEvent);
    }
    private void addToTableView(String registrationType) {
        String eventName = eventChoiceBox.getValue();
        String eventDate = eventdatepicker.getValue().toString();
        String location = locationtextfield.getText();

        // Validate input fields
        if (eventName == null || eventName.isEmpty() || eventDate.isEmpty() || location.isEmpty()) {
            // Handle invalid input (You may show an alert or something similar)
            return;
        }

        // Add event to the table
        //eventtableview.getItems().add(new Event(eventName, eventDate, location, registrationType));

        // Clear input fields
        eventChoiceBox.getSelectionModel().clearSelection();
        eventdatepicker.getEditor().clear();
        locationtextfield.clear();
    }

    @FXML
    private void returntodashboardnutton(ActionEvent event) throws IOException {
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("sponsorDashboard.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow(); 
        window.setScene(scene1);
        window.show();
    }
    
}
