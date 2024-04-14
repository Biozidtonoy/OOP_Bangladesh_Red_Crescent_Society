/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Tonoy.Donor;

import helperClass.applyjob;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author tonoy
 */
public class ApplayForJob1Controller implements Initializable {

    @FXML
    private TextField nameTF;
    @FXML
    private TextArea experienceTA;
    @FXML
    private ComboBox<String> degreecomboBox;
    @FXML
    private DatePicker dobLD;
    
    Alert success = new Alert(Alert.AlertType.INFORMATION,"job application done done");
    Alert unfilled = new Alert(Alert.AlertType.WARNING,"Please Enter Everything!");
    Alert cancel = new Alert(Alert.AlertType.WARNING,"your donation has cancelled");
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        degreecomboBox.setItems(FXCollections.observableArrayList("Secondary School Certificate (SSC)"," Higher Secondary Certificate (HSC) "
        ,"Bachelor of Arts (BA)","Bachelor of Science (BSc)","Bachelor of Commerce (BCom)",
        "Bachelor of Business Administration (BBA)","Bachelor of Business Administration (BBA)"
        ,"Master of Arts (MA)","Master of Science (MSc)","Master of Commerce (MCom)"," Master of Business Administration (MBA)"));
    }    

    @FXML
    private void backBT(ActionEvent event) throws IOException {
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("viewAvailableJob.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow(); 
        window.setScene(scene1);
        window.show();
    }

    @FXML
    private void submitBT(ActionEvent event) {
        try {
            
            LocalDate date =dobLD.getValue();       
            String name = nameTF.getText().trim();
            String experience = experienceTA.getText().trim();
            String degree = degreecomboBox.getValue();
            
          
       

            if (degree == null||name.isEmpty()|| experience.isEmpty()
                    || date==null) {
                unfilled.show();
                return;

            }
            applyjob fb = new applyjob(name, degree, experience,date);
            fb.createapplyjob(fb);

            success.show();
 
        } catch (Exception e) {
            unfilled.show();
            System.out.println("try block didnt execute");
        }
    }

    @FXML
    private void cancelBT(ActionEvent event) {
        nameTF.clear();
        degreecomboBox.setValue(null);
        experienceTA.clear();
        dobLD.setValue(null);
        
        cancel.show();
        
    }

    
}
