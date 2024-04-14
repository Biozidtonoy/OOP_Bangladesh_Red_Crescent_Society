/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Mehedi.Manager;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
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
public class CallmeetingController implements Initializable {

    @FXML
    private TextField participantnametextfield;
    @FXML
    private TextField timetextfield;
    @FXML
    private DatePicker datetextfield;
    @FXML
    private TableView<Meeting> tableview;
    
    @FXML
    private TableColumn<Meeting,Integer> timecoloumnview;
    @FXML
    
    private TableColumn<Meeting, LocalDate> datetablecoloumnview;
    @FXML
    private TableColumn<Meeting, String> participantnametablecoloumnview;
    
    
    private ObservableList<Meeting> meetingList;
    @FXML
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         meetingList = FXCollections.observableArrayList();
       
        timecoloumnview.setCellValueFactory(new PropertyValueFactory<>("time"));
        datetablecoloumnview.setCellValueFactory(new PropertyValueFactory<>("date"));
        participantnametablecoloumnview.setCellValueFactory(new PropertyValueFactory<>("participantName"));
        tableview.setItems(meetingList);
        

        // prothom dike emeni table view
        
       
        
    }    

    @FXML
    private void assignmeetingbuttonclick(ActionEvent Event) {
        
        // Retrieve data from input fields
        String participantName = participantnametextfield.getText();
        int time = Integer.parseInt(timetextfield.getText());
        LocalDate date = datetextfield.getValue(); 

        // Create  object
        Meeting newMeeting = new Meeting(time, date, participantName);

        // Add the meeting 
        

        // Add the meeting to the TableView
        tableview.getItems().add(newMeeting);

        // Clear input fields
        participantnametextfield.clear();
        timetextfield.clear();
        datetextfield.getEditor().clear();
    }
        
    

    @FXML
    private void returntodashboardbuttonclick(ActionEvent event) throws IOException {
         Parent mainSceneParent = FXMLLoader.load(getClass().getResource("managerDashboard.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();}
    
    
}
