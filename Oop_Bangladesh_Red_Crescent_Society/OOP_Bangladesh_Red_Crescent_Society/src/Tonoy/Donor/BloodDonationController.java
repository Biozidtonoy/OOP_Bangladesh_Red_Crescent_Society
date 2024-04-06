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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author tonoy
 */
public class BloodDonationController implements Initializable {

    @FXML
    private Label bloodDonationLabelTF;
    @FXML
    private TableView<?> bloodCenterTV;
    @FXML
    private TableColumn<?, ?> districtTC;
    @FXML
    private TableColumn<?, ?> bloodCenterTC;
    @FXML
    private TableColumn<?, ?> inChargeTC;
    @FXML
    private TableColumn<?, ?> locationTC;
    @FXML
    private TableColumn<?, ?> hotlineTC;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        bloodDonationLabelTF.setText("Your donation can save the lives of make a difference or simply make you feel great about your contribution to humanity. \n"
                + "Whatever your reason, whatever your motivation we welcome you to learn more about eligibility and benefits of donating   \n"
                + "blood with a trusted organization like us.");
        
    }    

    @FXML
    private void backBT(ActionEvent event) throws IOException {
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("donorDashboard.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow(); 
        window.setScene(scene1);
        window.show();
    }

   

    @FXML
    private void nextBT(ActionEvent event) throws IOException {
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("donorCard.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow(); 
        window.setScene(scene1);
        window.show();
    }
    
}
