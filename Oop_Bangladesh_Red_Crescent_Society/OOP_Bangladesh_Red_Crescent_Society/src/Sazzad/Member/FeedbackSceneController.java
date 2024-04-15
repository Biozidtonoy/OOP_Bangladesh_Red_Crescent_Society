/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Sazzad.Member;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class FeedbackSceneController implements Initializable {

    @FXML
    private TextField nameTF;
    @FXML
    private TextField ageTF;
    @FXML
    private TextField occupationTF;
    @FXML
    private ComboBox<String> districtCB;
    @FXML
    private DatePicker dateTF;
    @FXML
    private TextArea contentTF;
    
    Alert success = new Alert(Alert.AlertType.INFORMATION,"feedback done");
    Alert unfilled = new Alert(Alert.AlertType.WARNING,"Please Enter Everything!");
    Alert cancel = new Alert(Alert.AlertType.WARNING,"your donation has cancelled");

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
    private void doneBTActionEvent(ActionEvent event) {
        

    }

    @FXML
    private void backBTActionEvent(ActionEvent event) {
    }
    
}
