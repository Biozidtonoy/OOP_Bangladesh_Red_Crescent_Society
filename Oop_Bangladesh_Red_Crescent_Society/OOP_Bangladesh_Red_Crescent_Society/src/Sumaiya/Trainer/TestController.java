/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Sumaiya.Trainer;

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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Muntasir
 */
public class TestController implements Initializable {

    Alert successful = new Alert(Alert.AlertType.INFORMATION, "Successfully Passed");
    Alert unfilled = new Alert(Alert.AlertType.WARNING, "Error, try again!");
    Alert unsuccessful = new Alert(Alert.AlertType.WARNING, "Try Again!");
    @FXML
    private TextField thirdNoanswerTextField;
    @FXML
    private TextField fourthNoanswerTextField;
    @FXML
    private TextField fiveNoanswerTextField;
    @FXML
    private TextField oneNoAnswerTextField;
    @FXML
    private TextField secondNoAnswerTextField;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void submitButtonOnClick(ActionEvent event) {
        try {
            String one = oneNoAnswerTextField.getText();
            String two = secondNoAnswerTextField.getText();
            String third = thirdNoanswerTextField.getText();
            String four = fourthNoanswerTextField.getText();
            String five = fiveNoanswerTextField.getText();
            
            if (one.isEmpty() || two.isEmpty() || third.isEmpty() ||  four.isEmpty() || five.isEmpty()) {
                unfilled.show();
                return;
            }    
            boolean allCorrect = one.equalsIgnoreCase("CPR")
                    && two.equalsIgnoreCase("Burn")
                    && third.equalsIgnoreCase("Cool")
                    && four.equalsIgnoreCase("Heat")
                    && five.equalsIgnoreCase("Burn");

            if (allCorrect) {
                successful.show();
            } else {
                unsuccessful.show();
            }
        } catch (Exception e) {
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