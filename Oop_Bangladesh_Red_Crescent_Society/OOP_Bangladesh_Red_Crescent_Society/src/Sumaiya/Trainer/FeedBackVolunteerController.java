/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Sumaiya.Trainer;

import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Muntasir
 */
public class FeedBackVolunteerController implements Initializable {
    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField emailTextField;
    @FXML
    private TextArea feedbackTextArea;
    Alert successful = new Alert(Alert.AlertType.INFORMATION, "feedback done");
    Alert unfilled = new Alert(Alert.AlertType.WARNING, "Error, try again!");
    Alert invalid = new Alert(Alert.AlertType.WARNING, "Try Again");
    public static ArrayList<FeedBackVolunteer> feedbackList= new ArrayList<FeedBackVolunteer>();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void feedbackButtonOnClick(ActionEvent event) {
        try {
            String volunteerName= nameTextField.getText();
            String feedback= feedbackTextArea.getText();
            String emailAddress= emailTextField.getText();
            if (volunteerName.isEmpty() || feedback.isEmpty() || emailAddress.isEmpty()) {
                unfilled.show();
                return;
            }
            FeedBackVolunteer info = new FeedBackVolunteer(volunteerName, feedback, emailAddress);
            info.creatFeedBack(info);
            feedbackList.add(info);
            nameTextField.clear();
            feedbackTextArea.clear();
            emailTextField.clear();

            successful.show();
            
        } catch (Exception e) {
            invalid.show();
        }
    }

    @FXML
    private void returnHomeButtonOnClick(ActionEvent event) throws IOException {
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("trainer.fxml"));
        Parent parent = loader.load();
        Scene newScene = new Scene(parent);

        currentStage.setScene(newScene);
        currentStage.show();
    }
    
}
