/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Sumaiya.Trainer;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Muntasir
 */
public class FirstAidTrainingController implements Initializable {

    @FXML
    private TextField trainerNameTextField;
    @FXML
    private ComboBox<?> courseTitleComboBox;
    @FXML
    private TextField courseDurationTextField;
    @FXML
    private TextField locationTextField;
    @FXML
    private TableView<?> tableView;
    @FXML
    private TableColumn<?, ?> trainerNameTableColumn;
    @FXML
    private TableColumn<?, ?> courseTitleTableColumn;
    @FXML
    private TableColumn<?, ?> courseDurationTableColumn;
    @FXML
    private TableColumn<?, ?> locationTableColumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void saveButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void courseButtonOnClick(ActionEvent event) {
    }
    
}
