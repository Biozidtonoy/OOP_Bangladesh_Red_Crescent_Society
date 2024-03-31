/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Tonoy.Donor;

import helperClass.DonationFunds;
import helperClass.UrgentDonation;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Locale;
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
public class DonateNowController implements Initializable {

    @FXML
    private Label donateNowLabel;
    @FXML
    private TextField amountTF;
    @FXML
    private TextField donorNameTF;
    @FXML
    private TextField phoneTF;
    @FXML
    private TextField emailTF;
    @FXML
    private ComboBox<String> countryCB;
    @FXML
    private ComboBox<String> paymentMethodCB;
    
    Alert success = new Alert(Alert.AlertType.INFORMATION,"donation successfuly ");
    Alert unfilled = new Alert(Alert.AlertType.WARNING,"Please Enter Everything!");
    Alert cancel = new Alert(Alert.AlertType.WARNING,"your donation has cancelled");
    
    private ArrayList<DonationFunds> donatefundsList;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String[] countryCodes = Locale.getISOCountries();
        for (String countryCode : countryCodes) {
        Locale locale = new Locale("", countryCode);
        String countryName = locale.getDisplayCountry();
        countryCB.getItems().add(countryName);
    }
       
//       countryCB.getItems().addAll("bangladesh","america","canada");
       paymentMethodCB.getItems().addAll("Bkash","ATM","Nogod");
    }    

    

    @FXML
    private void confirmBT(ActionEvent event) {
        
        try {
            Integer amount = Integer.parseInt(amountTF.getText());
            Integer number = Integer.parseInt(phoneTF.getText());
            String name = donorNameTF.getText();
            String email = emailTF.getText();
            String country = countryCB.getValue();
            String payment = paymentMethodCB.getValue();

            if (!email.contains("@")) {
                Alert validEmail = new Alert(Alert.AlertType.ERROR, "please use valid email ");
                validEmail.show();
                return;
            }

            if (amount == null || number == null || name.isEmpty() || email.isEmpty() || countryCB == null || paymentMethodCB == null) {
                unfilled.show();
                return;

            }
            DonationFunds df1 = new DonationFunds(name, email, country, payment, 0, 0);
            success.show();
        } catch (NumberFormatException e) {
             Alert invalidInput = new Alert(Alert.AlertType.ERROR, "Please enter valid numeric values for amount and phone.");
             invalidInput.show();
        }
        
        
        
        
        
    }

    @FXML
    private void cancelBT(ActionEvent event) {
        paymentMethodCB.setValue(null);
        countryCB.setValue(null);
        amountTF.setText(null);
        phoneTF.setText(null);
        donorNameTF.clear();
        emailTF.clear();
        cancel.show();
    }
    @FXML
    private void backBT(ActionEvent event) throws IOException {
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("donateFunds.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow(); 
        window.setScene(scene1);
        window.show();
    }


    void urgentDonatationData(UrgentDonation selectedItem) {
         donateNowLabel.setText(selectedItem.getWhereToDonate());
    }
    
}
