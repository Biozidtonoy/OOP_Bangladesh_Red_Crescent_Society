/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Sumaiya.Volunteer;

import Sumaiya.Trainer.HealthEducationTraining;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Muntasir
 */
public class SupplyNecessitiesSceneController implements Initializable {

    @FXML
    private TextField nameOfSupplyTextField;
    @FXML
    private TextField amountTextField;
    @FXML
    private RadioButton maleRadioButton;
    @FXML
    private ToggleGroup tg_gender;
    @FXML
    private RadioButton femaleRadioButton;
    @FXML
    private ToggleGroup tg_gender1;
    @FXML
    private RadioButton oldRadioButton;
    @FXML
    private ToggleGroup tg_gender2;
    @FXML
    private RadioButton childRadioButton;
    @FXML
    private ToggleGroup tg_gender3;
    @FXML
    private TableView<SupplyNcessities> tableView;
    @FXML
    private TableColumn<SupplyNcessities, String> nameOfSupplyTableColumn;
    @FXML
    private TableColumn<SupplyNcessities, Integer> amountTableView;
    @FXML
    private TableColumn<SupplyNcessities, String> genderTableView;
    Alert successful = new Alert(Alert.AlertType.INFORMATION, "Successfully registered");
    Alert unfilled = new Alert(Alert.AlertType.WARNING, "Error, try again!");
    Alert invalid = new Alert(Alert.AlertType.WARNING, "Invalid input!");
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nameOfSupplyTableColumn.setCellValueFactory(new PropertyValueFactory<SupplyNcessities, String>("nameOfSupply"));
        genderTableView.setCellValueFactory(new PropertyValueFactory<SupplyNcessities, String>("gender1"));
        amountTableView.setCellValueFactory(new PropertyValueFactory<SupplyNcessities, Integer>("amount"));
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }    

    @FXML
    private void nameOfSupplyTextFieldMousrClick(MouseEvent event) {
         nameOfSupplyTextField.setText(null);
    }

    @FXML
    private void amountTextFieldMouseClick(MouseEvent event) {
         amountTextField.setText(null);
    }

    @FXML
    private void addButtonOnClick(ActionEvent event) {
        try {
            String nameOfSupply = nameOfSupplyTextField.getText();
            int amount = Integer.parseInt(amountTextField.getText());
            String gender1 = "";
            if (maleRadioButton.isSelected()) {
                gender1 = "Male";
            } else if (femaleRadioButton.isSelected()) {
                gender1 = "Female";
            } else if (oldRadioButton.isSelected()) {
                gender1 = "Old";
            } else if (childRadioButton.isSelected()) {
                gender1 = "Child";
            }

            if (nameOfSupply.isEmpty() || amountTextField.getText().isEmpty() || gender1.isEmpty()) {
                unfilled.show();
                return;
            }

            SupplyNcessities info = new SupplyNcessities(nameOfSupply, gender1, amount);
            info.creatSupplyList(info);
            tableView.getItems().add(info);
            successful.show();
            maleRadioButton.setSelected(false);
            femaleRadioButton.setSelected(false);
            oldRadioButton.setSelected(false);
            childRadioButton.setSelected(false);
        } catch (NumberFormatException e) {
            invalid.show();
        }
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

    @FXML
    private void viewButtonOnClick(ActionEvent event) {
        ObservableList<SupplyNcessities> records = FXCollections.observableList(SupplyNcessities.supplyInfo());
        tableView.setItems(records);
        
    }
    
}
