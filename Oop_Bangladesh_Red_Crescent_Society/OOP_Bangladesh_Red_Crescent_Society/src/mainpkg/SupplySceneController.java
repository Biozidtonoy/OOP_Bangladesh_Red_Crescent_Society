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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Muntasir
 */
public class SupplySceneController implements Initializable {

    @FXML
    private TextField amountTextField;
    @FXML
    private RadioButton maleRadioButton;
    @FXML
    private ToggleGroup tg_gender;
    @FXML
    private RadioButton femaleRadioButton;
    @FXML
    private RadioButton childRadioButton;
    @FXML
    private RadioButton oldRadioButton;
    @FXML
    private TableView<?> tableView;
    @FXML
    private TableColumn<?, ?> nameOfSupplyTableColumn;
    @FXML
    private TableColumn<?, ?> amountTableView;
    @FXML
    private TableColumn<?, ?> genderTableView;
    @FXML
    private TextField nameOfSupplyTextField1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void nameOfSupplyTextFieldMousrClick(MouseEvent event) {
    }

    @FXML
    private void amountTextFieldMouseClick(MouseEvent event) {
    }

    @FXML
    private void addButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void returnHomeButtonOnClick(ActionEvent event) {
    }
    
}
