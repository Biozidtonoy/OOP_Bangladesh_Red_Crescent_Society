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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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
    private TableColumn<Event, String> EventNameTableview;
    @FXML
    private TableColumn<Event, String> eventdatetableview;
    @FXML
    private TableColumn<Event, String> locationtableview;
    @FXML
    private TableColumn<Event, String> physicallyorvirtuallytableview;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         eventChoiceBox.setItems(FXCollections.observableArrayList(
            "Event 1", "Event 2", "Event 3", "Event 4", "Event 5"));
        ObservableList<Event> eventData = null;
         eventTableView.setItems(eventData);
         
         
            
    }    

    @FXML
    private void registerPhysical(ActionEvent event) {
        String selectedEvent = eventChoiceBox.getValue();
       // event.add(new Event(selectedEvent, "Date", "Physical"));
        //showAlert("Register Physical", "You have registered for physical attendance for " + selectedEvent);
       
    }

    @FXML
    private void registerVirtual(ActionEvent event) {
        String selectedEvent = eventChoiceBox.getValue();
       // eventData.add(new Event(selectedEvent, "Date", "Virtual"));
        //showAlert("Register Virtual", "You have registered for virtual attendance for " + selectedEvent);
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
