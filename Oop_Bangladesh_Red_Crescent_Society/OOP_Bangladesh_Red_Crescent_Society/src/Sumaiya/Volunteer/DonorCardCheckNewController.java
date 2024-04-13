/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Sumaiya.Volunteer;

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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Muntasir
 */
public class DonorCardCheckNewController implements Initializable {

    @FXML
    private TableView<DonorCardCheck> tableView;
    @FXML
    private TableColumn<DonorCardCheck, String> nameTableColumn;
    @FXML
    private TableColumn<DonorCardCheck, String> medicalHistoryTableColumn;
    @FXML
    private TableColumn<DonorCardCheck, Integer> ageTableColumn;
    @FXML
    private TableColumn<DonorCardCheck, Integer> weightTableColumn;
    @FXML
    private TableColumn<DonorCardCheck, Integer> bloodPressureTableColumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nameTableColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        medicalHistoryTableColumn.setCellValueFactory(new PropertyValueFactory<>("medicalHistory"));
        ageTableColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
        weightTableColumn.setCellValueFactory(new PropertyValueFactory<>("weight"));
        bloodPressureTableColumn.setCellValueFactory(new PropertyValueFactory<>("bloodPressure"));
//        ObservableList<DonorCardCheck> donorReportRecords = FXCollections.observableList(DonorCardCheck.loadDonorReportRecords());
//        tableView.setItems(donorReportRecords);  
    }    

    @FXML
    private void goBackButtonOnClick(ActionEvent event) throws IOException {
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("donorCardCheck.fxml"));
        Parent parent = loader.load();
        Scene newScene = new Scene(parent);
        //controller.initData(tableView.getSelectionModel().getSelectedItem(),tableView.getItems());
        currentStage.setScene(newScene);
        currentStage.show();
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
        ObservableList<DonorCardCheck> records = FXCollections.observableList(DonorCardCheck.cardCheck());
        tableView.setItems(records);
    }
    
}
