/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Muntasir
 */
public class DonorEligibilityController implements Initializable {

    @FXML
    private TextField ageTextField;
    @FXML
    private TextField bloodPressureTextField;
    @FXML
    private TextField weightTextField;
    @FXML
    private TextArea medicalHistoryTextArea;
    @FXML
    private TextField nameTextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void addButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void newSceneButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void nameMouseOnClick(MouseEvent event) {
    }

    @FXML
    private void ageMouseOnClick(MouseEvent event) {
    }

    @FXML
    private void bloodPressureMouseOnClick(MouseEvent event) {
    }

    @FXML
    private void weightMouseOnClick(MouseEvent event) {
    }

    @FXML
    private void medicalHistoryMouseOnClick(MouseEvent event) {
    }
    
}
