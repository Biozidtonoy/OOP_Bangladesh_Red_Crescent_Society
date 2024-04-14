/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Tonoy.Director;

import Mehedi.Sponsor.Payment;
import Users.director;
import helperClass.feedback;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author tonoy
 */
public class SponsorAmountDetailsController implements Initializable {

    @FXML
    private TableView<Payment > sponsorPaymentDetailsTV;
    @FXML
    private TableColumn<Payment , String> idTC;
    @FXML
    private TableColumn<Payment , String> nameTC;
    @FXML
    private TableColumn<Payment ,LocalDate> dobTC;
    @FXML
    private TableColumn<Payment , String> payMethodTC;
    @FXML
    private TableColumn<Payment , String> ammountTC;
    Alert select = new Alert(Alert.AlertType.WARNING,"please select the ammount you want to approved");
    private director p = new director();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       nameTC.setCellValueFactory(new PropertyValueFactory<Payment,String>("sponsorName"));
       idTC.setCellValueFactory(new PropertyValueFactory<Payment,String>("sponsorID"));
       payMethodTC.setCellValueFactory(new PropertyValueFactory<Payment,String>("paymentmethod"));
       ammountTC.setCellValueFactory(new PropertyValueFactory<Payment,String>("amount"));
       dobTC.setCellValueFactory(new PropertyValueFactory<Payment,LocalDate>("paymentDate"));
    }   
    

    @FXML
    private void backBT(ActionEvent event) throws IOException {
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("directorDashboard.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow(); 
        window.setScene(scene1);
        window.show();
    }

    @FXML
    private void approvedBT(ActionEvent event) {
        
        if (sponsorPaymentDetailsTV.getSelectionModel().isEmpty()) {
            select.showAndWait();
        } else {
            Payment selectedPayment = sponsorPaymentDetailsTV.getSelectionModel().getSelectedItem();
            String sponsorID = selectedPayment.getSponsorID();
            String sponsorName = selectedPayment.getSponsorName();
            String amount = selectedPayment.getAmount();
            String paymentmethod = selectedPayment.getPaymentmethod();
            LocalDate paymentDate = selectedPayment.getPaymentDate();
            p.approvedPayment(sponsorID, sponsorName, amount, paymentmethod, paymentDate);
            Alert success = new Alert(Alert.AlertType.INFORMATION,"payment approved");
            success.show();
        }
        
    }

    @FXML
    private void viewPaymentDetailsBT(ActionEvent event) {
         ObservableList<Payment > PaymentList = Payment.readPaymentList1();
        System.out.println(PaymentList);
        sponsorPaymentDetailsTV.setItems(PaymentList);
    }
    
}
