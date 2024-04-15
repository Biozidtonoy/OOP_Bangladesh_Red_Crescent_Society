/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Tonoy.Director;

import Users.User;
import helperClass.Trainig;
import helperClass.loginData;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author tonoy
 */
public class TrainingController implements Initializable {

    @FXML
    private ComboBox<String> trainerCB;
    @FXML
    private DatePicker dateTF;
    @FXML
    private TextField locationTF;
    @FXML
    private TextField timeTF;
    Alert success = new Alert(Alert.AlertType.INFORMATION,"organize training successfuly ");
    Alert unfilled = new Alert(Alert.AlertType.WARNING,"Please Enter Everything!");
    ArrayList<loginData > registerInfoList = User.readregisterInfoList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        for (loginData  t : registerInfoList) {
            trainerCB.getItems().add(t.getUsername());
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
    private void confirmBT(ActionEvent event) {
        String trainer = trainerCB.getValue();
        String time = timeTF.getText();
        String location = locationTF.getText();
        LocalDate date = dateTF.getValue();
        Trainig t1 ;

        
        if (trainerCB ==null||time.isEmpty()||location.isEmpty() ||date ==null){
            unfilled.show();
            return;
        }
        t1= new Trainig(trainer,location,time,date);
        t1.createTrainig(t1);
        
        success.show();
        
    }
    
}
