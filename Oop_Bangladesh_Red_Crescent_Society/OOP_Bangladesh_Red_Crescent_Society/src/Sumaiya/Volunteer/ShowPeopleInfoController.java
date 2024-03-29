/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Sumaiya.Volunteer;

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
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Muntasir
 */
public class ShowPeopleInfoController implements Initializable {

    @FXML
    private Label firstNameLabel;
    @FXML
    private Label lastNameLabel;
    @FXML
    private Label contactInformationLabel;
    @FXML
    private Label registrationDateLabel;
    @FXML
    private Label ageLabel;
   private ObservableList<People> peopleList= FXCollections.observableArrayList();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void goBackButtonOnClick(ActionEvent event) throws IOException {
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("addPeopleInfo.fxml"));
        
        
        Parent parent = loader.load();
        AddPeopleInfoController add= loader.getController();
        add.setPeople(peopleList);
        Scene newScene = new Scene(parent);

        currentStage.setScene(newScene);
        currentStage.show();
    }


    @FXML
    private void returnHomeButtonOnClick(ActionEvent event) throws IOException {
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("new.fxml"));
        Parent parent = loader.load();
        Scene newScene = new Scene(parent);

        currentStage.setScene(newScene);
        currentStage.show();
    }
    void initData(People selectedItem, ObservableList<People> peopleList) {
        firstNameLabel.setText(selectedItem.getFirstName());
        lastNameLabel.setText(selectedItem.getLastName());
        contactInformationLabel.setText(Integer.toString(selectedItem.getContactInfornamtion()));
        this.peopleList= peopleList;
        registrationDateLabel.setText(selectedItem.getRegistrationDate().toString());
        ageLabel.setText(Integer.toString(selectedItem.getAge())+ " years");
    }
}
    
    

