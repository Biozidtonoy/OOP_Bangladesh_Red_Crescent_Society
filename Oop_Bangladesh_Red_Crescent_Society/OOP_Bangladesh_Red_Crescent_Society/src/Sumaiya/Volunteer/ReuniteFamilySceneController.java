/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Sumaiya.Volunteer;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Muntasir
 */
public class ReuniteFamilySceneController implements Initializable {

    @FXML
    private TextField parentNameTextField;
    @FXML
    private TextField location1TextField;
    @FXML
    private DatePicker dateTextField;
    @FXML
    private TextArea parentDescriptionTextArea;
    @FXML
    private TableView<ReuniteFamily> tableView;
    @FXML
    private TableColumn<ReuniteFamily, String> parentNameTableColumn;
    @FXML
    private TableColumn<ReuniteFamily, String> locationTableColumn;
    @FXML
    private TableColumn<ReuniteFamily, String> parentDescriptionTableColumn;
    @FXML
    private TableColumn<ReuniteFamily, LocalDate> dateTableColumn;
    
    Alert successful = new Alert(Alert.AlertType.INFORMATION, "Successfully registered");
    Alert unfilled = new Alert(Alert.AlertType.WARNING, "Error, try again!");
    Alert invalid = new Alert(Alert.AlertType.WARNING, "Invalid input!");
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    parentNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("parentName"));
    locationTableColumn.setCellValueFactory(new PropertyValueFactory<>("location"));
    parentDescriptionTableColumn.setCellValueFactory(new PropertyValueFactory<>("parentDescription"));
    dateTableColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
    tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
      
    }    

    @FXML
    private void goBackButtonOnClick(ActionEvent event) throws IOException {
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("reuniteScene.fxml"));
        Parent parent = loader.load();
        Scene newScene = new Scene(parent);

        currentStage.setScene(newScene);
        currentStage.show();
    }

    @FXML
    private void addButtonOnClick(ActionEvent event) {
        try {
        String parentName = parentNameTextField.getText();
        String location = location1TextField.getText();
        String parentDescription= parentDescriptionTextArea.getText();
        LocalDate date= dateTextField.getValue();
        
            if (parentName.isEmpty() || location.isEmpty() || parentDescription.isEmpty() || date == null) {
                unfilled.show();
                return;
            }
            ReuniteFamily newReunite = new ReuniteFamily(location, parentName, parentDescription, date);
             newReunite.creatReunite(newReunite);
            tableView.getItems().add(newReunite);
            successful.show();
        } catch (NumberFormatException e) {
            invalid.show();
        }
    }

    @FXML
    private void viewDetailsButtonOnClick(ActionEvent event) {
         ObservableList<ReuniteFamily> records = FXCollections.observableList(ReuniteFamily.reunite());
         tableView.setItems(records);
    }
    
}
