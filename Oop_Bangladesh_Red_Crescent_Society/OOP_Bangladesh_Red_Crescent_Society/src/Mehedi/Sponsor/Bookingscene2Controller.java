/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Mehedi.Sponsor;

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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Elitebook 830
 */
public class Bookingscene2Controller implements Initializable {

    @FXML
    private TextField nameTFarea;
    @FXML
    private TextField emailTFarea;
    @FXML
    private TextField phoneTFarea;
    @FXML
    private TextField eventnameTFarea;
    @FXML
    private DatePicker eventdateTFarea;
    Alert success = new Alert(Alert.AlertType.INFORMATION,"booking done");
    Alert unfilled = new Alert(Alert.AlertType.WARNING,"Please Enter Everything!");

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void returnBThandler(ActionEvent event) throws IOException {
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("sponsorDashboard.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow(); 
        window.setScene(scene1);
        window.show();
    }

    @FXML
    private void addbookBThandle(ActionEvent event) {
        
        try {
            String name = nameTFarea.getText().trim();
            LocalDate date =eventdateTFarea.getValue();       
            String email = emailTFarea.getText().trim();
            String eventName = eventnameTFarea.getText().trim();
            String number = phoneTFarea.getText();
           
          
           

            if (name.isEmpty()||email.isEmpty()|| eventName.isEmpty()||number.isEmpty()
                    ||date==null) {
                unfilled.show();
                return;

            }
            booking fb = new booking(name,eventName, email,number,date);

            fb.createbooking(fb);
            
            
            
            success.show();
 
        } catch (Exception e) {
            unfilled.show();
            System.out.println("try block didnt execute");
        }
        

        
    }
    
}
