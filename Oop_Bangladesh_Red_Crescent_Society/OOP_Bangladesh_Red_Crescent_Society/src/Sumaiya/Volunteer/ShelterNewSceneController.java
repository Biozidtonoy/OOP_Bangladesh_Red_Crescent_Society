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
public class ShelterNewSceneController implements Initializable {

    @FXML
    private Label typeOfShelterLabel;
    @FXML
    private Label locationLabel;
    @FXML
    private Label volunteerAmountLabel;
    @FXML
    private Label leaderNameLabel;
    @FXML
    private Label volunteerIdLabel;
    @FXML
    private Label contactNumberLabel;
    private ObservableList<Shelter> shelterList= FXCollections.observableArrayList();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void goBackButtonOnClick(ActionEvent event) throws IOException {
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("shelterScene.fxml"));
        
        
        Parent parent = loader.load();
        ShelterSceneController add= loader.getController();
        add.setShelter(shelterList);
        Scene newScene = new Scene(parent);

        currentStage.setScene(newScene);
        currentStage.show();
    }

    @FXML
    private void returnHomeButtonOnClick(ActionEvent event) throws IOException {
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("volunteerDashboard.fxml"));
        Parent parent = loader.load();
        Scene newScene = new Scene(parent);

        currentStage.setScene(newScene);
        currentStage.show();
    }

    void initData(Shelter selectedItem, ObservableList<Shelter> items) {
        typeOfShelterLabel.setText(selectedItem.getTypeOfShelter());
        locationLabel.setText(selectedItem.getLocation());
        volunteerAmountLabel.setText(Integer.toString(selectedItem.getVolunteerAmount()));
        leaderNameLabel.setText(selectedItem.getLocation());
        volunteerIdLabel.setText(Integer.toString(selectedItem.getId()));
        contactNumberLabel.setText(Integer.toString(selectedItem.getContactNumber()));
        this.shelterList= items;
    }
    
}
