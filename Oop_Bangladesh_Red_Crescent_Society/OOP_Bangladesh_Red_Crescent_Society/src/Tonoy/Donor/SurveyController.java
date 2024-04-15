/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Tonoy.Donor;

import helperClass.Survey;
import helperClass.feedback;
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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author tonoy
 */
public class SurveyController implements Initializable {

    @FXML
    private TextField emailTF;
    @FXML
    private TextField q1TF;
    @FXML
    private TextField occupationTF;
    @FXML
    private ComboBox<String> genderCB;
    @FXML
    private ComboBox<String> ageCB;
    @FXML
    private TextField q2TF;
    @FXML
    private TextField q4TF;
    @FXML
    private TextField q5TF;
    @FXML
    private TextField q6TF;
    @FXML
    private TextField q7TF;
    @FXML
    private TextField q8TF;
    @FXML
    private TextField q9TF;
    @FXML
    private TextField q3TF;
    @FXML
    private ComboBox<String> selectYesorNoCb;
   

     public static ArrayList<Survey> surveyList = new ArrayList<Survey>();
    Alert success = new Alert(Alert.AlertType.INFORMATION,"Survey done");
    Alert unfilled = new Alert(Alert.AlertType.WARNING,"Please Enter Everything!");
    Alert cancel = new Alert(Alert.AlertType.WARNING,"your donation has cancelled");
    @FXML
    
    public void initialize(URL url, ResourceBundle rb) {
        ageCB.setItems(FXCollections.observableArrayList("age >= 18 && age <= 25","age > 25 && age <= 30"," age > 30 && age <= 35","age>35"));
        genderCB.setItems(FXCollections.observableArrayList("Male","female","other"));
        selectYesorNoCb.setItems(FXCollections.observableArrayList("Yes","No"));
        
    }    

    @FXML
    private void submitBT(ActionEvent event) {
     try {
                 
            String email = emailTF.getText().trim();
            String age = ageCB.getValue();
            String gender = genderCB.getValue();
            String occupation = occupationTF.getText().trim();
            String q1 = q1TF.getText().trim();
            String q2 = q2TF.getText().trim();
            String q3 = q3TF.getText().trim();
            String q4 = q4TF.getText().trim();
            String q5 = q5TF.getText().trim();
            String q6 = q6TF.getText().trim();
            String q7 = q7TF.getText().trim();
            String q8 = q8TF.getText().trim();
            String q9 = q9TF.getText().trim();
            String q10 =selectYesorNoCb.getValue();;
            
            
          
           

            if (email.isEmpty()||ageCB==null||genderCB==null||occupation.isEmpty()||q1.isEmpty()||
                    q2.isEmpty()||q3.isEmpty()||q4.isEmpty()||q5.isEmpty()||q6.isEmpty()||
                    q7.isEmpty()||q8.isEmpty()||q9.isEmpty()||q10.isEmpty()||selectYesorNoCb==null) {
                unfilled.show();
                return;

            }
            Survey s1 = new Survey(email,age,gender,occupation,q1,q2,q3,q4,q5,q6,q7,q8,q9,q10);
            surveyList.add(s1);
            s1.getSurvey(s1);
            
            
            
            success.show();
 
        } catch (Exception e) {
            unfilled.show();
            System.out.println("try block didnt execute");
        }
        
    }

    @FXML
    private void cancelBT(ActionEvent event) {
    }

    @FXML
    private void backBT(ActionEvent event) throws IOException {
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("donorDashboard.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow(); 
        window.setScene(scene1);
        window.show();
    }
    
}
