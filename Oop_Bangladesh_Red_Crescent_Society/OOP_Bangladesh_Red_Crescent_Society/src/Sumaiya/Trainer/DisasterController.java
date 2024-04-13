/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Sumaiya.Trainer;

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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Muntasir
 */
public class DisasterController implements Initializable {

    @FXML
    private ComboBox<String> aidKitComboBox;
    @FXML
    private ComboBox<String> communicaionEquipmentComboBox;
    @FXML
    private ComboBox<String> rescueEquipmentComboBox;
    @FXML
    private ComboBox<String> shelterComboBox;
    @FXML
    private TableView<DisasterRecoveryTools> tableView;
    @FXML
    private TableColumn<DisasterRecoveryTools, String> aidKitTableColumn;
    @FXML
    private TableColumn<DisasterRecoveryTools, String> communicationEquipmentTableColumn;
    @FXML
    private TableColumn<DisasterRecoveryTools, String> rescueEquipmentTableColumn;
    @FXML
    private TableColumn<DisasterRecoveryTools, String> shelterTableColumn;
    
    Alert successful = new Alert(Alert.AlertType.INFORMATION, "Successfully registered");
    Alert unfilled = new Alert(Alert.AlertType.WARNING, "Error, try again!");
    Alert invalid = new Alert(Alert.AlertType.WARNING, "Invalid input!");
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    aidKitTableColumn.setCellValueFactory(new PropertyValueFactory<DisasterRecoveryTools, String>("firstAidKit"));
    communicationEquipmentTableColumn.setCellValueFactory(new PropertyValueFactory<DisasterRecoveryTools, String>("communicationEquipment"));
    rescueEquipmentTableColumn.setCellValueFactory(new PropertyValueFactory<DisasterRecoveryTools, String>("rescueEquipment"));
    shelterTableColumn.setCellValueFactory(new PropertyValueFactory<DisasterRecoveryTools, String>("shelterMaterials"));
    
    aidKitComboBox.getItems().addAll("Bandages","Adhesive tape","Gauze pads","Antiseptic wipes","Scissors");
    communicaionEquipmentComboBox.getItems().addAll("Satellite phones","Cellular phones","Walkie-talkies","Megaphones","Ham radios");
    rescueEquipmentComboBox.getItems().addAll("Rope","Ladders","Stretchers","Whistles","Flashlights");
    shelterComboBox.getItems().addAll("Bamboo","Reed","Thatch","Rattan","Cordwood");
    }    

    @FXML
    private void addButtonOnClick(ActionEvent event) {
          try {
        String firstAidKit = aidKitComboBox.getValue();
        String communicationEquipment = communicaionEquipmentComboBox.getValue();
        String rescueEquipment = rescueEquipmentComboBox.getValue();
        String shelterMaterials = shelterComboBox.getValue();

        if (firstAidKit == null || communicationEquipment == null || rescueEquipment == null || shelterMaterials == null) {
            unfilled.show();
            return;
        }

        DisasterRecoveryTools info = new DisasterRecoveryTools(firstAidKit, communicationEquipment, rescueEquipment, shelterMaterials);
        info.creatTools(info);
        tableView.getItems().add(info);
        aidKitComboBox.getSelectionModel().clearSelection();
        communicaionEquipmentComboBox.getSelectionModel().clearSelection();
        rescueEquipmentComboBox.getSelectionModel().clearSelection();
        shelterComboBox.getSelectionModel().clearSelection();
        successful.show();
    } catch (Exception e) {
        invalid.show();
    }


    }

    @FXML
    private void viewButtonOnClick(ActionEvent event) {
        ObservableList<DisasterRecoveryTools> record = FXCollections.observableList(DisasterRecoveryTools.tools());
         tableView.setItems(record);
    }

    @FXML
    private void goBackButtonOnClick(ActionEvent event) throws IOException {
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("resource.fxml"));
        Parent parent = loader.load();
        Scene newScene = new Scene(parent);

        currentStage.setScene(newScene);
        currentStage.show();
    }
    
}
