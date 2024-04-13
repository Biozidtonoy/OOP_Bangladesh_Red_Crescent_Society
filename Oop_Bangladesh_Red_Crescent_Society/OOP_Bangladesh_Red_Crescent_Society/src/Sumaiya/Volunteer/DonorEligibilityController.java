/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Sumaiya.Volunteer;

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
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Muntasir
 */
public class DonorEligibilityController implements Initializable {

    @FXML
    private TextField nameTextField;
    @FXML
    private TextField weightTextField;
    @FXML
    private TextField bloodPressureTextField;
    @FXML
    private TextField ageTextField;
    @FXML
    private TextArea medicalHistoryTextArea;
    Alert successful = new Alert(Alert.AlertType.INFORMATION, "Successfully registered");
    Alert unfilled = new Alert(Alert.AlertType.WARNING, "Error, try again!");
    Alert invalid = new Alert(Alert.AlertType.WARNING, "Sorry,you are not eligible");
    Alert alert = new Alert(Alert.AlertType.ERROR, "You are eligible!!!");
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void nameMouseOnClick(MouseEvent event) {
         nameTextField.setText(null);
    }

    @FXML
    private void weightMouseOnClick(MouseEvent event) {
       weightTextField.setText(null);
    }

    @FXML
    private void bloodPressureMouseOnClick(MouseEvent event) {
        bloodPressureTextField.setText(null);
    }

    @FXML
    private void ageMouseOnClick(MouseEvent event) {
         ageTextField.setText(null);
    }

    @FXML
    private void medicalHistoryMouseOnClick(MouseEvent event) {
        bloodPressureTextField.setText(null);
    }

    @FXML
    private void addButtonOnClick(ActionEvent event) {
        try {
            String name= nameTextField.getText();
            String medicalHistory= medicalHistoryTextArea.getText();
            int age= Integer.parseInt(ageTextField.getText());
            int weight= Integer.parseInt(weightTextField.getText());
            int bloodPressure = Integer.parseInt(bloodPressureTextField.getText());

            if (name.isEmpty() || medicalHistory.isEmpty() || age <= 0 || weight <= 0 || bloodPressure <= 0) {
                unfilled.show();
                return;
            }

            if (bloodPressure >= 130 || bloodPressure <= 80 || age >= 60 || age <= 18 || weight>=100 || weight<=50) {
                invalid.show();
                return;
            }
            if (showConfirmationAlert("Are you sure you want to save this report?")) {
                DonorEligibility.saveDonorReportRecord(name, medicalHistory, age, weight, bloodPressure);
            }

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public boolean showConfirmationAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setContentText(message);

        return alert.showAndWait().orElse(null).equals(ButtonType.OK);
    }
    

    @FXML
    private void newSceneButtonOnClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("donorEligibilityNewScene.fxml"));
        Parent userViewParent = loader.load();

        Scene userViewScene = new Scene(userViewParent);

        DonorEligibilityNewSceneController controller = loader.getController();
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(userViewScene);
        window.show();
    }

    @FXML
    private void returnHomeButtonOnClick(ActionEvent event) throws IOException {
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("volunteerDashboard.fxml"));
        Parent parent = loader.load();
        Scene newScene = new Scene(parent);

        currentStage.setScene(newScene);
        currentStage.show();
    }
    
}
