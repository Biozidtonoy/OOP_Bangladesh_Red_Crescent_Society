/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Tonoy.Donor;

import helperClass.feedback;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author tonoy
 */
public class FeedbackController implements Initializable {

    @FXML
    private TextField nameTF;
    @FXML
    private TextField occupationTF;
    @FXML
    private DatePicker dateTF;
    @FXML
    private TextArea contentTF;
    @FXML
    private TextField ageTF;
    @FXML
    private ComboBox<String> districtCB;
    public static ArrayList<feedback> feedBackList = new ArrayList<feedback>();
    Alert success = new Alert(Alert.AlertType.INFORMATION,"feedback done");
    Alert unfilled = new Alert(Alert.AlertType.WARNING,"Please Enter Everything!");
    Alert cancel = new Alert(Alert.AlertType.WARNING,"your donation has cancelled");

  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        districtCB.setItems(FXCollections.observableArrayList(
            "Bagerhat", "Bandarban", "Barguna", "Barishal", "Bhola", "Bogra",
            "Brahmanbaria", "Chandpur", "Chapai Nawabganj", "Chattogram", "Chuadanga", "Cox's Bazar",
            "Cumilla", "Dhaka", "Dinajpur", "Faridpur", "Feni", "Gaibandha",
            "Gazipur", "Gopalganj", "Habiganj", "Jamalpur", "Jashore", "Jhalokati",
            "Jhenaidah", "Joypurhat", "Khagrachari", "Khulna", "Kishoreganj", "Kurigram",
            "Kushtia", "Lakshmipur", "Lalmonirhat", "Madaripur", "Magura", "Manikganj",
            "Meherpur", "Moulvibazar", "Munshiganj", "Mymensingh", "Naogaon", "Narail",
            "Narayanganj", "Narsingdi", "Natore", "Netrokona", "Nilphamari", "Noakhali",
            "Pabna", "Panchagarh", "Patuakhali", "Pirojpur", "Rajbari", "Rajshahi",
            "Rangamati", "Rangpur", "Satkhira", "Shariatpur", "Sherpur", "Sirajganj",
            "Sunamganj", "Sylhet", "Tangail", "Thakurgaon"
        ));
        
        dateTF.setValue(LocalDate.now());
        

    }    

    @FXML
    private void doneBT(ActionEvent event) {
        try {
            Integer age = Integer.parseInt(ageTF.getText().trim());
            LocalDate date =dateTF.getValue();       
            String name = nameTF.getText().trim();
            String occupation = occupationTF.getText().trim();
            String district = districtCB.getValue();
            String content = contentTF.getText().trim();
          
           if (age < 18 || age > 65) {
            Alert ageAlert = new Alert(Alert.AlertType.ERROR, "Your age must be between 18 and 65.");
            ageAlert.show();
            return;
        }

            if (age == null||name.isEmpty()|| districtCB==null||occupation.isEmpty()
                    || content.isEmpty()||date==null) {
                unfilled.show();
                return;

            }
            feedback fb = new feedback(name, occupation, district, content,age,date);
            feedBackList.add(fb);
            fb.createfeedback(fb);
            
            success.show();
 
        } catch (Exception e) {
            unfilled.show();
            System.out.println("try block didnt execute");
        }
        
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
