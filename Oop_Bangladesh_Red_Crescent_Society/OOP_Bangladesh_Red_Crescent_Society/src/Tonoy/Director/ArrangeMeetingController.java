/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Tonoy.Director;

import Users.director;
import helperClass.ScheduleMeeting;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author tonoy
 */
public class ArrangeMeetingController implements Initializable {

    @FXML
    private TextField timeMeetingTF;
    @FXML
    private DatePicker dateMeetingTF;
    @FXML
    private ComboBox<String> participantCB;
    @FXML
    private TableView<ScheduleMeeting> viewMeetingTableView;
    @FXML
    private TableColumn<ScheduleMeeting,String> participantTC;
    @FXML
    private TableColumn<ScheduleMeeting,LocalDate> dateTC;
    @FXML
    private TableColumn<ScheduleMeeting,String> timeTC;
//    private ObservableList<ScheduleMeeting> scheduleMeetingDetails;
    private static  ArrayList<ScheduleMeeting> sm ;
    Alert success = new Alert(Alert.AlertType.INFORMATION,"meeting arrange successfuly ");
    Alert unfilled = new Alert(Alert.AlertType.WARNING,"Please Enter Everything!");
//    Alert failure = new Alert(Alert.AlertType.WARNING, "file is not created");

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        sm = new ArrayList<ScheduleMeeting>();
        
        participantCB.getItems().addAll("Treasure","Manager","trainer","event organizer","Donor");
        participantTC.setCellValueFactory(new PropertyValueFactory<ScheduleMeeting,String>("participant"));
        timeTC.setCellValueFactory(new PropertyValueFactory<ScheduleMeeting,String>("time"));
        dateTC.setCellValueFactory(new PropertyValueFactory<ScheduleMeeting,LocalDate>("date"));
        
        viewMeetingTableView.setEditable(true);
        participantTC.setCellFactory(TextFieldTableCell.forTableColumn());
        timeTC.setCellFactory(TextFieldTableCell.forTableColumn());
//      dateTC.setCellFactory(TextFieldTableCell.forTableColumn());
        viewMeetingTableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        viewMeetingTableView.setItems(this.scheduleMeetingDetails());
    }
        public ObservableList<ScheduleMeeting> scheduleMeetingDetails(){
        ObservableList<ScheduleMeeting> meetingdetails = FXCollections.observableArrayList();
        meetingdetails.add(new ScheduleMeeting("Treasure","03:00 PM",LocalDate.of(2024, Month.MARCH,3 )));
        meetingdetails.add(new ScheduleMeeting("Manager","10:00 AM",LocalDate.of(2024, Month.MARCH,20 )));
        return meetingdetails;
    }
    

    @FXML
    private void createMeetingBT(ActionEvent event) {
        String meetingTime = timeMeetingTF.getText();
        String participants = participantCB.getValue();
        LocalDate meetingDate = dateMeetingTF.getValue();
        ScheduleMeeting s1 ;
//        director d ;
        
        if (participantCB==null||meetingTime.isEmpty()||meetingDate ==null){
            unfilled.show();
            return;
        }
        s1= new ScheduleMeeting(participants,meetingTime,meetingDate);
        s1.scheduleMeeting(s1);
//        d.viewScheduleMeeting(participants,meetingTime, meetingDate);
        viewMeetingTableView.getItems().add(s1);
        
        success.show();
        
    }

    
    @FXML
    private void backBT(ActionEvent event) throws IOException {
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("directorDashboard.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow(); 
        window.setScene(scene1);
        window.show();
    }

    @FXML
    private void deleteMeetingBT(ActionEvent event) {
        ObservableList<ScheduleMeeting> selectedMeeting, allUsers;
        allUsers = viewMeetingTableView.getItems();
        selectedMeeting = viewMeetingTableView.getSelectionModel().getSelectedItems();
        
        for(ScheduleMeeting s: selectedMeeting){
            allUsers.remove(s);
        }
    }
    

    
}
