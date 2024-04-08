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
public class MedicalController implements Initializable {

    @FXML
    private ComboBox<String> toolNameComboBox;
    @FXML
    private ComboBox<String> categoryComboBox;
    @FXML
    private ComboBox<Integer> modelNumberComboBox;
    @FXML
    private ComboBox<String> condtionComboBox;
    @FXML
    private TableView<MedicalTools> tableView;
    @FXML
    private TableColumn<MedicalTools, String> toolNameTableColumn;
    @FXML
    private TableColumn<MedicalTools, String> conditionTableColumn;
    @FXML
    private TableColumn<MedicalTools, String> categoryTableColumn;
    @FXML
    private TableColumn<MedicalTools, Integer> modelNumberTableColumn;
    
    Alert successful = new Alert(Alert.AlertType.INFORMATION, "Successfully registered");
    Alert unfilled = new Alert(Alert.AlertType.WARNING, "Error, try again!");
    Alert invalid = new Alert(Alert.AlertType.WARNING, "Invalid input!");
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    toolNameTableColumn.setCellValueFactory(new PropertyValueFactory<MedicalTools, String>("toolName"));
    conditionTableColumn.setCellValueFactory(new PropertyValueFactory<MedicalTools, String>("condition"));
    categoryTableColumn.setCellValueFactory(new PropertyValueFactory<MedicalTools, String>("category"));
    modelNumberTableColumn.setCellValueFactory(new PropertyValueFactory<MedicalTools, Integer>("modelNumber"));
    
    toolNameComboBox.getItems().addAll("Stethoscope","Otoscope","Scalpel","Thermometer","Syringe");
    categoryComboBox.getItems().addAll("Diagnostic tools","Surgical tools","Treatment tools","Supportive tools","Protective tools");
    modelNumberComboBox.getItems().addAll(01, 04,00,87,45);
    condtionComboBox.getItems().addAll("New","Used","Open-box","Refurbished","Pre-owned");
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

    @FXML
    private void addButtonOnClick(ActionEvent event) {
          try {
        String toolName = toolNameComboBox.getValue();
        String condition = condtionComboBox.getValue();
        String category = categoryComboBox.getValue();
        int modelNumber = modelNumberComboBox.getValue();

        if (toolName == null || condition == null || category == null || modelNumber<=0) {
            unfilled.show();
            return;
        }

        MedicalTools info = new MedicalTools(toolName, condition, category, modelNumber);
        info.creatMdedical(info);
        tableView.getItems().add(info);
        
        toolNameComboBox.getSelectionModel().clearSelection();
        categoryComboBox.getSelectionModel().clearSelection();
        modelNumberComboBox.getSelectionModel().clearSelection();
        condtionComboBox.getSelectionModel().clearSelection();
        successful.show();
    } catch (Exception e) {
        invalid.show();
    }

    }

    @FXML
    private void viewButtonOnClick(ActionEvent event) {
        ObservableList<MedicalTools> record = FXCollections.observableList(MedicalTools.medical());
         tableView.setItems(record);
    }
    
}
