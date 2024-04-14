/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Mehedi.Manager;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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
public class Manage_volunteersController implements Initializable {

    @FXML
    private TextField nameTF;
    @FXML
    private TextField volunteerTF;
    @FXML
    private TextField emailTF;
    @FXML
    private TableView<Volunteer> tableview;
    @FXML
    private TableColumn<Volunteer, String> nametableview;
    @FXML
    private TableColumn<Volunteer, Integer> volunteeridtableview;
    @FXML
    private TableColumn<Volunteer, String> emailtableview;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tableview.getItems().clear();
         nametableview.setCellValueFactory(new PropertyValueFactory<>("name"));
        volunteeridtableview.setCellValueFactory(new PropertyValueFactory<>("volunteerId"));
        emailtableview.setCellValueFactory(new PropertyValueFactory<>("email"));

       
    }    

    @FXML
    private void addvolunteerbuttonclick(ActionEvent event) {
        String name = nameTF.getText();
        int volunteerID = Integer.parseInt(volunteerTF.getText());
      String email = emailTF.getText();
      
      
      //aleart making
      if (!email.contains("@")) {
        
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText("incomplite Email");
        alert.showAndWait();
        return;
      } 

        // Create a new Volunteer object
        Volunteer newVolunteer = new Volunteer(name, volunteerID, email);

        // Add the new volunteer to the table
        tableview.getItems().add(newVolunteer);

        // Clear input fields
        nameTF.clear();
        volunteerTF.clear();
        emailTF.clear();
    }


    

    @FXML
    private void returntohomebuttonclick(ActionEvent event) throws IOException {
         Parent mainSceneParent = FXMLLoader.load(getClass().getResource("managerDashboard.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow(); 
        window.setScene(scene1);
        window.show();
    }
    
}

