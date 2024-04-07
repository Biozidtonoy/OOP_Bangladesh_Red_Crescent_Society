/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Tonoy.Donor;

import helperClass.DonorCard;
import helperClass.bloodCenter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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
     Label donorCardNoLabelTF;
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
    private ComboBox<String> bloodGroupTF;
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
    
    Alert success = new Alert(Alert.AlertType.INFORMATION,"please download the donor card");
    Alert unfilled = new Alert(Alert.AlertType.WARNING,"Please Enter Everything!");
    Alert cancel = new Alert(Alert.AlertType.WARNING,"your donation has cancelled");
    public static ArrayList<DonorCard> donorCardList = new ArrayList<DonorCard>();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        bloodGroupTF.getItems().addAll("AB+","AB-","A+","A-","B+","B-","O+","O-");
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
        
        try {
            Integer age = Integer.parseInt(ageTF.getText().trim());
            Integer number = Integer.parseInt(numberTF.getText().trim());
            Integer weight = Integer.parseInt(weightTF.getText().trim());
            String name = nameTF.getText().trim();
            String email = emailTF.getText().trim();
            String district = districtTF.getText().trim();
            String adress = adressTF.getText().trim();
            String bloodGroup = bloodGroupTF.getValue();
            if (!email.contains("@")) {
                Alert validEmail = new Alert(Alert.AlertType.ERROR, "please use valid email ");
                validEmail.show();
                return;
            }
            
           if (age < 18 || age > 65) {
            Alert ageAlert = new Alert(Alert.AlertType.ERROR, "Your age must be between 18 and 65.");
            ageAlert.show();
            return;
        }

            if (age == null|| number == null || name.isEmpty() || email.isEmpty()|| district.isEmpty()||adress.isEmpty()
                    || weight == null || bloodGroupTF == null) {
                unfilled.show();
                return;

            }
            DonorCard dc1 = new DonorCard(name, email, district, adress,bloodGroup, weight, age,number);
            donorCardList.add(dc1);
            dc1.getDonorCard(dc1);
            
            success.show();

           
        } catch (Exception e) {
            System.out.println("try block didnt execute");
        }
        
        
        
    }

    @FXML
    private void cancelBT(ActionEvent event) {
    }

    void selectionDetails(bloodCenter selectedItem) {
        districtLabel.setText(selectedItem.getDistrict());
        bloodCenterLabel.setText(selectedItem.getBloodCenterName());
        locationLabel.setText(selectedItem.getLocation());
        inChargeLAbel.setText(selectedItem.getVolunteerName());
        hotLineLabel.setText(selectedItem.getNumber());
    }
    
}
