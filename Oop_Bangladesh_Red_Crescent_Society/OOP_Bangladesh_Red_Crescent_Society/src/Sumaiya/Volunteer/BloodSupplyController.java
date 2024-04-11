/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Sumaiya.Volunteer;

import Sumaiya.Trainer.HealthEducationTraining;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
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
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Muntasir
 */
public class BloodSupplyController implements Initializable {

    @FXML
    private TextField recepientNameTextField;
    @FXML
    private TextField donorNameTextField;
    @FXML
    private TextField bloodGroupTextField;
    @FXML
    private TextField bloodBagAmountTextField;
    @FXML
    private TableView<BloodSupplyInfo> tableView;
    @FXML
    private TableColumn<BloodSupplyInfo, String> recepientNameTableColumn;
    @FXML
    private TableColumn<BloodSupplyInfo, String> donorNameTableColumn;
    @FXML
    private TableColumn<BloodSupplyInfo, String> bloodGroupTableColumn;
    @FXML
    private TableColumn<BloodSupplyInfo, Integer> bloodBagAmountTableColumn;
    
    Alert successful = new Alert(Alert.AlertType.INFORMATION, "Successfully registered");
    Alert unfilled = new Alert(Alert.AlertType.WARNING, "Error, try again!");
    Alert invalid = new Alert(Alert.AlertType.WARNING, "Invalid input!");
    Alert alert = new Alert(Alert.AlertType.ERROR, "Please enter a valid phone number");

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        recepientNameTableColumn.setCellValueFactory(new PropertyValueFactory<BloodSupplyInfo, String>("recipientName"));
        donorNameTableColumn.setCellValueFactory(new PropertyValueFactory<BloodSupplyInfo, String>("donorName"));
        bloodGroupTableColumn.setCellValueFactory(new PropertyValueFactory<BloodSupplyInfo, String>("bloodGroup"));
        bloodBagAmountTableColumn.setCellValueFactory(new PropertyValueFactory<BloodSupplyInfo, Integer>("bagAmount"));
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }    

    @FXML
    private void recepientNameTextFieldMouseClick(MouseEvent event) {
        recepientNameTextField.setText(null);
    }

    @FXML
    private void donorNameTextFieldMouseClick(MouseEvent event) {
        donorNameTextField.setText(null);
    }

    @FXML
    private void bloodGroupTextFieldMouseClick(MouseEvent event) {
        bloodGroupTextField.setText(null);
    }

    @FXML
    private void bloodBagAmountTextFieldMouseClick(MouseEvent event) {
         bloodBagAmountTextField.setText(null);
    }

    @FXML
    private void addDdetailsButtonOnClick(ActionEvent event) {
        try {
            String recipientName = recepientNameTextField.getText();
            String donorName = donorNameTextField.getText();
            String bloodGroup = bloodGroupTextField.getText();
            int bagAmount = Integer.parseInt(bloodBagAmountTextField.getText());

            if (recipientName.isEmpty() || donorName.isEmpty() || bloodGroup.isEmpty() || bagAmount <= 0) {
                unfilled.show();
                return;
            }
                
                if (bloodGroup != null && !bloodGroup.isEmpty()) {
                   
                }
            
            BloodSupplyInfo info = new BloodSupplyInfo(recipientName, donorName, bloodGroup, bagAmount);
            info.creatBloodInfo(info);
            tableView.getItems().addAll(info);

            successful.show();
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
        ObservableList<BloodSupplyInfo> records = FXCollections.observableList(BloodSupplyInfo.bloodinfo());
        tableView.setItems(records);
    }
    
}
