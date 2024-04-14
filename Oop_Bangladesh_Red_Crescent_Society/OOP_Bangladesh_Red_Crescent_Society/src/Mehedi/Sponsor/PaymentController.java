/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Mehedi.Sponsor;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
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
import javafx.scene.control.DatePicker;
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
    private ComboBox<String> paymentviafield;
    @FXML
    private DatePicker paymentDate;
    Alert success = new Alert(Alert.AlertType.INFORMATION,"feedback done");
    Alert unfilled = new Alert(Alert.AlertType.WARNING,"Please Enter Everything!");

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         
        
        paymentviafield.getItems().addAll("bkash", "nogod", "atm card");
    
        
    }    

    @FXML
    private void confirmpaymentButtonaction(ActionEvent event) {
         try {
            LocalDate date =paymentDate.getValue();       
            String name = sponsorNameField.getText().trim();
            String id = sponsorIdField.getText().trim();
            String paymentMethod = paymentviafield.getValue();
            String amount = amountField.getText().trim();
          
           

            if (paymentviafield == null||name.isEmpty()|| id.isEmpty()
                    || amount.isEmpty()||date==null) {
                unfilled.show();
                return;

            }
            Payment fb = new Payment(id,name,amount,paymentMethod,date);
            fb.createPayment(fb);
            
            
            
            success.show();
 
        } catch (Exception e) {
            unfilled.show();
            System.out.println("try block didnt execute");
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
