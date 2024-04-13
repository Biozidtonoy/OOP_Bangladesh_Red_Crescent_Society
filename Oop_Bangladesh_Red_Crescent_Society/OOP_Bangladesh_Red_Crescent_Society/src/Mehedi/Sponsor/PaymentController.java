/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Mehedi.Sponsor;

import java.io.File;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Elitebook 830
 */
public class PaymentController implements Initializable {

    @FXML
    private TextField sponsorIdField;
    @FXML
    private TextField sponsorNameField;
    @FXML
    private TextField amountField;
    @FXML
    private VBox root;
    @FXML
    private TextField paymentDateField;
    @FXML
    private ComboBox<String> paymentviafield;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         
        // Fill ComboBox
        paymentviafield.getItems().addAll("bkash", "nogod", "atm card");
    
        
    }    

    @FXML
    private void confirmpaymentButtonaction(ActionEvent event) {
         try {
            // payment = new File("payment.bin");
            // Check if any field is empty
            if (sponsorIdField.getText().isEmpty() || sponsorNameField.getText().isEmpty() || amountField.getText().isEmpty() || paymentDateField.getText().isEmpty() || paymentviafield.getValue() == null) {
                throw new Exception("Please fill in all the fields.");
            }
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Confirmation");
            alert.setHeaderText(null);
            alert.setContentText("Payment confirmed");
            alert.showAndWait();
        } catch (Exception e) {
            // Show alert for missing fields
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
            sponsorIdField.clear();
            sponsorNameField.clear();
            amountField.clear();
            paymentDateField.clear();
            paymentviafield.getSelectionModel().clearSelection();
        }
    }


    

   @FXML
    private void cancelbuttonaction(ActionEvent event) {
         Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to cancel?");
        alert.showAndWait();
        sponsorIdField.clear();
            sponsorNameField.clear();
            amountField.clear();
            paymentDateField.clear();
            paymentviafield.getSelectionModel().clearSelection();

    }

    @FXML
    private void returndashboardaction(ActionEvent event) throws IOException {
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("sponsorDashboard.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow(); 
        window.setScene(scene1);
        window.show();
    }
    
}
