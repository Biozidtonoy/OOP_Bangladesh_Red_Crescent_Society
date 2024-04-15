///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
// */
//package Sumya.EventOrganizer;
//
//import Users.User;
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
//import javafx.scene.control.ComboBox;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableColumn.CellEditEvent;
//import javafx.scene.control.TableView;
//import javafx.scene.control.TextField;
//import javafx.scene.control.cell.PropertyValueFactory;
//
///**
// * FXML Controller class
// *
// * @author sumya
// */
//public class EmergencyeventController implements Initializable {
//
//    @FXML
//    private TextField nametextfield;
//    @FXML
//    private TextField numbertextfield;
//     @FXML
//    private TableColumn<emergency, String> comboconcolumn;
//     @FXML
//    private TableView<emergency> tableview;    
//    @FXML
//    private TableColumn<emergency, String> namecolumn;
//    @FXML
//    private TableColumn<emergency, String> numbercolumn;
//    @FXML
//    private ComboBox<String> combobox;
//    
//    ArrayList<emergency> volunteerList;
//    
//    
//
//    /**
//     * Initializes the controller class.
//     */
//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//        // TODO 
//        volunteerList = new ArrayList<emergency>();
//        
////        usernameColumn.setCellValueFactory(new PropertyValueFactory<emergency, String>("Name"));
////        passwordColumn.setCellValueFactory(new PropertyValueFactory<User, String>("password"));
////        BirthdayColumn.setCellValueFactory(new PropertyValueFactory<User, LocalDate>("birthday"));
////        
////        tableview.setItems(this.getUser());
////        tableview.setEditable(true);
////        usernameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
////        combocolumn.setCellValueFactory(new PropertyValueFactory<>("password"));
////        
//
//
////        
//        
//    //    userTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
//        
//   // }
//  
//        comboBox.getItems().addAll("Yes", "No");
//        
//        volunteerList = new ArrayList<>();
//        
//        namecolumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
//        numbercolumn.setCellValueFactory(new PropertyValueFactory<>("Number"));
//        comboconcolumn.setCellValueFactory(new PropertyValueFactory<>("previous experience"));
//        
////    }    
////      public ObservableList<User> getUser(){
////        ObservableList<User> users = FXCollections.observableArrayList();
////        
////        users.add(new User("Nafis", "no", LocalDate.of(2002, Month.APRIL, 3)));
////        users.add(new User("Anika", "234", LocalDate.of(2005, Month.JUNE, 15)));
////        users.add(new User("Arif", "433", LocalDate.of(2012, Month.APRIL, 30)));
////        return users;
////    }
//    }
//    @FXML
//    private void namecolumnonedit(CellEditEvent event) {
//         emergency userSelected = userTable.getSelectionModel().getSelectedItem();
//        userSelected.setUsername(event.getNewValue().toString());
//    }
//
//    }
//    
//
//    @FXML
//   private void numbercolumnonedit(CellEditEvent event) {
//     emergency  userSelected = userTable.getSelectionModel().getSelectedItem();
//        userSelected.setUsername(event.getNewValue().toString());
//    }
//
//    }
//
//    @FXML
//     void joinbuttononclick(ActionEvent event) {
//     emergency newUser = new User(nametextfield.getText(), numbertextfield.getText()) {};
//        tableview.getItems().add(newUser);
//    } 
//    }
//    
//    
//    
//
//    @FXML
//    private void backbuttononclick(ActionEvent event) {
//    FXMLLoader loader = new FXMLLoader(getClass().getResource("eventOrganizerDashboard.fxml"));
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
//}

//
//package Sumya.EventOrganizer;
//
//import java.io.IOException;
//import java.net.URL;
//import java.util.ArrayList;
//import java.util.ResourceBundle;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.fxml.Initializable;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.control.ComboBox;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableColumn.CellEditEvent;
//import javafx.scene.control.TableView;
//import javafx.scene.control.TextField;
//import javafx.scene.control.cell.PropertyValueFactory;
//import javafx.stage.Stage;
//
//public class EmergencyeventController implements Initializable {
//
//    @FXML
//    private TextField nametextfield;
//    @FXML
//    private TextField numbertextfield;
//    @FXML
//    private TableColumn<emergency, String> comboconcolumn;
//    @FXML
//    private TableView<emergency> tableview;
//    @FXML
//    private TableColumn<emergency, String> namecolumn;
//    @FXML
//    private TableColumn<emergency, String> numbercolumn;
//    @FXML
//    private ComboBox<String> combobox;
//
//    ArrayList<emergency> volunteerList;
//
//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//        combobox.getItems().addAll("Yes", "No");
//
//        volunteerList = new ArrayList<>();
//
//        namecolumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
//        numbercolumn.setCellValueFactory(new PropertyValueFactory<>("Number"));
//        comboconcolumn.setCellValueFactory(new PropertyValueFactory<>("previousExperience"));
//    }
//
//    @FXML
//    private void namecolumnonedit(CellEditEvent event) {
//        emergency userSelected = tableview.getSelectionModel().getSelectedItem();
//        userSelected.setName(event.getNewValue().toString());
//    }
//
//    @FXML
//    private void numbercolumnonedit(CellEditEvent event) {
//        emergency userSelected = tableview.getSelectionModel().getSelectedItem();
//        userSelected.setNumber(event.getNewValue().toString());
//    }
//
//    @FXML
//    private void joinbuttononclick(ActionEvent event) {
//        emergency newUser = new emergency(nametextfield.getText(), numbertextfield.getText());
//        tableview.getItems().add(newUser);
//    }
//
//    @FXML
//    private void backbuttononclick(ActionEvent event) {
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("eventOrganizerDashboard.fxml"));
//        try {
//            Parent parent = loader.load();
//            Stage currentStage = (Stage) nametextfield.getScene().getWindow();
//            Scene nextScene = new Scene(parent);
//            currentStage.setScene(nextScene);
//            currentStage.show();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}

package Sumya.EventOrganizer;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class EmergencyeventController implements Initializable {

    @FXML
    private TextField nametextfield;
    @FXML
    private TextField numbertextfield;
    @FXML
    private TableColumn<emergency, String> comboconcolumn;
    @FXML
    private TableView<emergency> tableview;
    @FXML
    private TableColumn<emergency, String> namecolumn;
    @FXML
    private TableColumn<emergency, String> numbercolumn;
    @FXML
    private ComboBox<String> combobox;

    ArrayList<emergency> volunteerList;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        combobox.getItems().addAll("Yes", "No");

        volunteerList = new ArrayList<>();

        namecolumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
        numbercolumn.setCellValueFactory(new PropertyValueFactory<>("Number"));
        comboconcolumn.setCellValueFactory(new PropertyValueFactory<>("previousExperience"));
    }

    @FXML
    private void namecolumnonedit(CellEditEvent event) {
        emergency userSelected = tableview.getSelectionModel().getSelectedItem();
        userSelected.setName(event.getNewValue().toString());
    }

    @FXML
    private void numbercolumnonedit(CellEditEvent event) {
        emergency userSelected = tableview.getSelectionModel().getSelectedItem();
        //userSelected.setNumber(event.getNewValue().toString());
    }

    @FXML
    private void joinbuttononclick(ActionEvent event) {
//        String previousExperience = combobox.getValue();
//        emergency newUser = new emergency(nametextfield.getText(), numbertextfield.getText()) ;
//        tableview.getItems().add(newUser);
//    }
         volunteerList.add(new emergency(
                       Integer.parseInt(numbertextfield.getText()), 
                       nametextfield.getText(),
                       
                       combobox.getValue()
             
               )
               ); 
       nametextfield.clear();
       nametextfield.clear();
      
    }


    @FXML
    private void backbuttononclick(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("eventOrganizerDashboard.fxml"));
        try {
            Parent parent = loader.load();
            Stage currentStage = (Stage) nametextfield.getScene().getWindow();
            Scene nextScene = new Scene(parent);
            currentStage.setScene(nextScene);
            currentStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
