///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
// */
//package Sumya.EventOrganizer;
//
//import java.net.URL;
//import java.util.ArrayList;
//import java.util.ResourceBundle;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.Initializable;
//import javafx.scene.control.SelectionMode;
//import javafx.scene.control.TableColumn;
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
//public class BudgetController implements Initializable {
//
//    @FXML
//    private TextField nametextfield;
//    @FXML
//    private TextField budgettextfield;
//    @FXML
//    private TableView<Budget> tableview;
//    @FXML
//    private TableColumn<Budget, String> eventnamecolumn;
//    @FXML
//    private TableColumn<Budget, String> budgetcolumn;
//     private ArrayList<Budget> userArr;
//    
//    
//
//    /**
//     * Initializes the controller class.
//     */
//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//        // TODO    public void initialize(URL url, ResourceBundle rb) {
//        // TODO
//        userArr = new ArrayList<>();
//        
//       eventnamecolumn.setCellValueFactory(new PropertyValueFactory<>("Event Name"));
//       budgetcolumn.setCellValueFactory(new PropertyValueFactory<>("Budget"));
//      
//        
//        tableview.setItems(this.getUser());
//        tableview.setEditable(true);
//        eventnamecolumn.setCellFactory(TextFieldTableCell.forTableColumn());
//        budgetcolumn.setCellFactory(TextFieldTableCell.forTableColumn());
//        
//        tableview.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
//        
//    }
//    
//    public ObservableList<Budget> getUser(){
//        ObservableList<Budget> users = FXCollections.observableArrayList();
//        
//        users.add(new Budget("Flood event", "34000/=");
//        
//        return users;
//    }
//    
//    }    
//
//    @FXML
//    private void saveonclick(ActionEvent event) {
//    Budget newUser = new Budget(eventnametextfield.getText(), budgettextfield.getText());
//        tableview.getItems().add(newUser);
//
//
//    
//
//
//    @FXML
//    private void backonclick(ActionEvent event) {
//   
//FXMLLoader loader = new FXMLLoader(getClass().getResource("eventOrganizerDashboard.fxml"));
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
//    
//    
//    }
//
//    @FXML
//    private void eventnameonedit(CellEditEvent event) {
//
//     Budget Selected = tableview.getSelectionModel().getSelectedItem();
//        userSelected.setUsername(event.getNewValue().toString());
//    }
//
//    @FXML
//    private void budgetonedit(TCellEditEvent event) {
//    Budget Selected = tableview.getSelectionModel().getSelectedItem();
//        userSelected.setUsername(event.getNewValue().toString());
//    }
//    
//}
package Sumya.EventOrganizer;

import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

public class BudgetController implements Initializable {

    @FXML
    private TextField nametextfield;
    @FXML
    private TextField budgettextfield;
    @FXML
    private TableView<Budget> tableview;
    @FXML
    private TableColumn<Budget, String> eventnamecolumn;
    @FXML
    private TableColumn<Budget, String> budgetcolumn;
    private ArrayList<Budget> userArr;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        userArr = new ArrayList<>();

        eventnamecolumn.setCellValueFactory(new PropertyValueFactory<>("eventName"));
        budgetcolumn.setCellValueFactory(new PropertyValueFactory<>("budget"));

        tableview.setItems(this.getUser());
        tableview.setEditable(true);
        eventnamecolumn.setCellFactory(TextFieldTableCell.forTableColumn());
        budgetcolumn.setCellFactory(TextFieldTableCell.forTableColumn());

        tableview.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

    public ObservableList<Budget> getUser() {
        ObservableList<Budget> users = FXCollections.observableArrayList();
        
        users.add(new Budget("Flood event", "34000/="));

        return users;
    }

    @FXML
    private void saveonclick(ActionEvent event) {
        Budget newUser = new Budget(nametextfield.getText(), budgettextfield.getText());
        tableview.getItems().add(newUser);
    }

    @FXML
    private void backonclick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("eventOrganizerDashboard.fxml"));
        Parent parent = loader.load();


        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();


        Scene nextScene = new Scene(parent);

        currentStage.setScene(nextScene);
        currentStage.show();
       
    }

 
}
