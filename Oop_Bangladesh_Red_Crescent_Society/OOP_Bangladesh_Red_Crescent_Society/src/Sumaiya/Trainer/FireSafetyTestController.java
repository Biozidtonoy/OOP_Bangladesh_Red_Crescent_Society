/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Sumaiya.Trainer;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Muntasir
 */
public class FireSafetyTestController implements Initializable {

    @FXML
    private TextField oneNoAnswerTextField;
    @FXML
    private TextField secondNoAnswerTextField;
    @FXML
    private TextField thirdNoanswerTextField;
    @FXML
    private TextField fourthNoanswerTextField;
    @FXML
    private TextField fiveNoanswerTextField;
    Alert successful = new Alert(Alert.AlertType.INFORMATION, "Congrats,you have passed the test!!");
    Alert unfilled = new Alert(Alert.AlertType.WARNING, "Error, try again!");
    Alert unsuccessful = new Alert(Alert.AlertType.WARNING, "Sorry, give another exam!");
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
            boolean allCorrect = one.equalsIgnoreCase("Ignition")
                    && two.equalsIgnoreCase("Suppression")
                    && third.equalsIgnoreCase("Evacuation")
                    && four.equalsIgnoreCase("Early detection")
                    && five.equalsIgnoreCase("Roll");
            oneNoAnswerTextField.clear();
            secondNoAnswerTextField.clear();
            thirdNoanswerTextField.clear();
            fourthNoanswerTextField.clear();
            fiveNoanswerTextField.clear();
            if (allCorrect) {
               successful.show();
            } else {
               unsuccessful.show();
            }
        } catch (Exception e) {
        }
    }
}
