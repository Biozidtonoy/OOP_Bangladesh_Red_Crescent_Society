///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
// */
//package Sumya.EventOrganizer;
//
//import java.net.URL;
//import java.time.LocalDate;
//import java.time.Month;
//import java.util.ArrayList;
//import java.util.ResourceBundle;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.Initializable;
//import javafx.scene.control.DatePicker;
//import javafx.scene.control.SelectionMode;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableColumn.CellEditEvent;
//import javafx.scene.control.TableView;
//import javafx.scene.control.TextField;
//import javafx.scene.control.cell.PropertyValueFactory;
//import javafx.scene.control.cell.TextFieldTableCell;
//
///**
// * FXML Controller class
// *
// * @author sumya
// */
//public class EventController implements Initializable {
//
//    @FXML
//    private TextField eventName;
//    @FXML
//    private DatePicker datepicker;
//    @FXML
//    private TableView<Event> eventatbleview;
//    @FXML
//    private TableColumn<Event,LocalDate> datecolumn;
//    @FXML
//    private TableColumn<Event, String> eventcolumn;
//     private ArrayList<Event> userArr;
//    
//
//    /**
//     * Initializes the controller class.
//     */
//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//        // TODO
//        
//        
//         userArr = new ArrayList<>();
//        
//      eventcolumn.setCellValueFactory(new PropertyValueFactory<>("Event Name"));
//        
//        datecolumn.setCellValueFactory(new PropertyValueFactory<>("Date"));
//        
//        eventatbleview.setItems(this.getUser());
//        eventatbleview.setEditable(true);
//        eventcolumn.setCellFactory(TextFieldTableCell.forTableColumn());
//        datecolumn.setCellFactory(TextFieldTableCell.forTableColumn());
//        
//        eventtableview.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
//        
//         public ObservableList<Event> getUser(){
//        ObservableList<Event> Events = FXCollections.observableArrayList();
//        
//        Events.add(new Event("Nafis", LocalDate.of(2002, Month.APRIL, 3)));
//        Events.add(new Event("Anika",  LocalDate.of(2005, Month.JUNE, 15)));
//       
//        return Events;
//    }
//    
//    }    
//    
//
//    @FXML
//    private void eventcolumnonedit(CellEditEvent event) {
//    Event  userSelected = eventatbleview.getSelectionModel().getSelectedItem();
//        userSelected.setUsername(event.getNewValue().toString());
//
//       }
//
//
//    @FXML
//    private void savebuttononclick(ActionEvent event) {
//    Event newUser = new Event(eventName.getText(), datepicker.getValue());
//        eventatbleview.getItems().add(newUser);
//    
//   }
//
//    @FXML
//    private void backbuttononclick(ActionEvent event){ 
//    FXMLLoader loader = new FXMLLoader(getClass().getResource("EventOrganizerDashboard.fxml"));
//        Parent parent = loader.load();
//
//
//        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//
//
//        Scene nextScene = new Scene(parent);
//
//        currentStage.setScene(nextScene);
//        currentStage.show();
//    }
//
//
//    private ObservableList<Event> getUser() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//    
//}
package Sumya.EventOrganizer;

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
import javafx.scene.control.DatePicker;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

public class EventController implements Initializable {

    @FXML
    private TextField eventName;
    @FXML
    private DatePicker datepicker;
    @FXML
    private TableView<Event> eventatbleview;
    @FXML
    private TableColumn<Event, LocalDate> datecolumn;
    @FXML
    private TableColumn<Event, String> eventcolumn;
    private ArrayList<Event> userArr;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        userArr = new ArrayList<>();

        eventcolumn.setCellValueFactory(new PropertyValueFactory<>("eventName"));

        datecolumn.setCellValueFactory(new PropertyValueFactory<>("date"));

        eventatbleview.setItems(this.getUser());
        eventatbleview.setEditable(true);
        eventcolumn.setCellFactory(TextFieldTableCell.forTableColumn());
        eventatbleview.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

    @FXML
    private void eventcolumnonedit(CellEditEvent event) {
        Event userSelected = eventatbleview.getSelectionModel().getSelectedItem();
        userSelected.setEventName(event.getNewValue().toString());
    }

    @FXML
    private void savebuttononclick(ActionEvent event) {
        Event newUser = new Event(eventName.getText(), datepicker.getValue());
        eventatbleview.getItems().add(newUser);
    }

    @FXML
    private void backbuttononclick(ActionEvent event) throws IOException, IOException {
       
         FXMLLoader loader = new FXMLLoader(getClass().getResource("eventOrganizerDashboard.fxml"));
        Parent parent = loader.load();


        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();


        Scene nextScene = new Scene(parent);

        currentStage.setScene(nextScene);
        currentStage.show();
        
        
    }

    private ObservableList<Event> getUser() {
        ObservableList<Event> Events = FXCollections.observableArrayList();

        Events.add(new Event("Bdrcs chottogram DISTrict's Activities", LocalDate.of(2024, Month.APRIL, 8)));
        Events.add(new Event("Road safety Awarness campaign by BDRCS", LocalDate.of(2023, Month.JUNE, 15)));

        return Events;
    }
}
