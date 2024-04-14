/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Tonoy.Donor;

import helperClass.Report;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author tonoy
 */
public class ReportSubmisionController implements Initializable {

    @FXML
    private ComboBox<String> usertypeCB;
    @FXML
    private TextField nameTF;
    @FXML
    private TextField reportAboutTF;
    Alert success = new Alert(Alert.AlertType.INFORMATION,"report submission  done");
    Alert unfilled = new Alert(Alert.AlertType.WARNING,"Please Enter Everything!");

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        usertypeCB.setItems(FXCollections.observableArrayList("Treasurer","sponsor","donor","trainer","Volunteer","event organizer","media and publicaton"));
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
    private void submitBT(ActionEvent event) {
        try {     
            String name = nameTF.getText().trim();
            String reportCNT = reportAboutTF.getText().trim();
            String userType = usertypeCB.getValue();
            
            if (name.isEmpty()|| usertypeCB==null||reportCNT.isEmpty()) {
                unfilled.show();
                return;

            }
            Report fb = new Report(userType,name, reportCNT);
            fb.createReport(fb);
            
            
            
            success.show();
 
        } catch (Exception e) {
            unfilled.show();
            System.out.println("try block didnt execute");
        }
        
    
    }
    
}
