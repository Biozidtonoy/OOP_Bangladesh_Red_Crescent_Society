/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Tonoy.Director;

import Users.User;
import helperClass.bloodCenter;
import helperClass.loginData;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
public class EmergencyController implements Initializable {

    @FXML
    private ComboBox<String> bloodCenterCB;
    @FXML
    private ComboBox<String> districtCB;
    @FXML
    private ComboBox<String> inChargeCB;
    @FXML
    private TextField locationTF;
    @FXML
    private TextField hotLineTF;
    Alert success = new Alert(Alert.AlertType.INFORMATION,"urgent need blood donation done");
    Alert unfilled = new Alert(Alert.AlertType.WARNING,"Please Enter Everything!");
    
    ArrayList<loginData > registerInfoList = User.readregisterInfoList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        bloodCenterCB.setItems(FXCollections.observableArrayList("Fatema Begum Red Crescent Blood Center","Mujib Jahan Red Crescent Blood Center","Red Crescent Blood Center","Holy Family Red Crescent Blood Center"
        ,"Ahad Red Crescent Blood Center","Rajshahi Red Crescent Blood Center","Begum Tayeeba Mojumder Red Crescent","Natore Red Crescent Blood Center"
        ,"Achia Khatun Memorial Red Crescent Blood Center"));
        districtCB.setItems(FXCollections.observableArrayList("Dhaka","Chittagong","Rajshahi","Jossore","Natore","Sylhet","Magura"));
        for (loginData  t : registerInfoList) {
            inChargeCB.getItems().add(t.getUsername());
        }
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
    private void updateBT(ActionEvent event) {
        try {
           
            String district = districtCB.getValue();
            String bloodCenter = bloodCenterCB.getValue();
            String inCharge = inChargeCB.getValue();
            String location = locationTF.getText().trim();
            String hotline = hotLineTF.getText().trim();
            
          
          

            if (district == null||location.isEmpty()|| bloodCenterCB==null||hotline.isEmpty()
                    || inChargeCB == null) {
                unfilled.show();
                return;

            }
            bloodCenter fb = new bloodCenter(bloodCenter,district,location,inCharge,hotline);
//            feedBackList.add(fb);
            fb.createbloodCenter(fb);
            
            
            
            
            success.show();
 
        } catch (Exception e) {
            unfilled.show();
            System.out.println("try block didnt execute");
        }
        
    }
    
}
