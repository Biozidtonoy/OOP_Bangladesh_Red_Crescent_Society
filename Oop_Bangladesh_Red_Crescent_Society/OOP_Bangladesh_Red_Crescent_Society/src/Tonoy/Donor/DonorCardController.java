/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Tonoy.Donor;

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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author tonoy
 */
public class DonorCardController implements Initializable {

    @FXML
    private Label donorCardNoLabelTF;
    @FXML
    private TextField nameTF;
    @FXML
    private TextField numberTF;
    @FXML
    private TextField emailTF;
    @FXML
    private TextField districtTF;
    @FXML
    private TextField adressTF;
    @FXML
    private TextField weightTF;
    @FXML
    private TextField ageTF;
    @FXML
    private ComboBox<?> bloodGroupTF;
    @FXML
    private Label districtLabel;
    @FXML
    private Label bloodCenterLabel;
    @FXML
    private Label inChargeLAbel;
    @FXML
    private Label locationLabel;
    @FXML
    private Label hotLineLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void backBT(ActionEvent event) throws IOException {
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("bloodDonation.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow(); 
        window.setScene(scene1);
        window.show();
    }

    @FXML
    private void confirmBT(ActionEvent event) {
    }

    @FXML
    private void cancelBT(ActionEvent event) {
    }
    
}
