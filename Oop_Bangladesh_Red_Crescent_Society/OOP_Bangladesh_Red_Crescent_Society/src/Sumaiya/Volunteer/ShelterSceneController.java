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
import javafx.scene.control.ComboBox;
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
public class ShelterSceneController implements Initializable {

    @FXML
    private TextField typeOfShelterTextFiled;
    @FXML
    private TextField locationTextFiled;
    @FXML
    private ComboBox<Integer> volunteerAmountComboBox;
    @FXML
    private TextField leaderNameTextFiled;
    @FXML
    private TextField volunteerIdTextFiled;
    @FXML
    private TextField contactNumberTextFiled;
    @FXML
    private TableView<Shelter> tableView;
    @FXML
    private TableColumn<Shelter, String> typeOfShelterTableColumn;
    @FXML
    private TableColumn<Shelter, String> locationTableColumn;
    @FXML
    private TableColumn<Shelter, Integer> volunteerAmountTableColumn;
    @FXML
    private TableColumn<Shelter, String> leaderNameTableColumn;
    @FXML
    private TableColumn<Shelter, Integer> volunteerIdTableColumn;
    @FXML
    private TableColumn<Shelter, Integer> contactNumberTableColumn;
    Alert successful = new Alert(Alert.AlertType.INFORMATION, "Successfully registered");
    Alert unfilled = new Alert(Alert.AlertType.WARNING, "Error, try again!");
    Alert invalid = new Alert(Alert.AlertType.WARNING, "Invalid input!");
    Alert alert = new Alert(Alert.AlertType.ERROR, "Please enter a valid phone number");
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         volunteerAmountComboBox.getItems().addAll(10,15,20,25,30,35,40,50,60);
        typeOfShelterTableColumn.setCellValueFactory(new PropertyValueFactory<>("typeOfShelter"));
        locationTableColumn.setCellValueFactory(new PropertyValueFactory<>("location"));
        volunteerAmountTableColumn.setCellValueFactory(new PropertyValueFactory<>("volunteerAmount"));
        leaderNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("leaderName"));
        volunteerIdTableColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        contactNumberTableColumn.setCellValueFactory(new PropertyValueFactory<>("contactNumber"));
  
    }    
    
    
    public void setShelter(ObservableList<Shelter> shelter){
        tableView.setItems(shelter);
    } 

    @FXML
    private void typeOfShelterTextFiledMouseClick(MouseEvent event) {
         typeOfShelterTextFiled.setText(null);
    }

    @FXML
    private void locationTextFiledMouseClick(MouseEvent event) {
         locationTextFiled.setText(null);
    }

    @FXML
    private void volunteerNameTextFiledMouseClick(MouseEvent event) {
        leaderNameTextFiled.setText(null);
    }

    @FXML
    private void volunteerIdTextFiledMouseClick(MouseEvent event) {
        volunteerIdTextFiled.setText(null);
    }

    @FXML
    private void contactNumberTextFiledMouseClick(MouseEvent event) {
        contactNumberTextFiled.setText(null);
    }

    @FXML
    private void addDetailsButtonOnClick(ActionEvent event) {
        try {
            String typeOfShelter = typeOfShelterTextFiled.getText();
            String location = locationTextFiled.getText();
            int volunteerAmount = volunteerAmountComboBox.getValue();
            String leaderName = leaderNameTextFiled.getText();
            int id = Integer.parseInt(volunteerIdTextFiled.getText());
            int contactNumber = Integer.parseInt(contactNumberTextFiled.getText());

            if (typeOfShelter.isEmpty() || location.isEmpty() || volunteerAmount == 0
                    || leaderName.isEmpty() || id == 0 || contactNumber == 0) {
                unfilled.show();
                return;
            }

            if (volunteerIdTextFiled.getText().length() != 4) {
                invalid.show();
                return;
            }

            if (contactNumberTextFiled.getText().length() != 11) {
                alert.show();
                return;
            }

            Shelter info = new Shelter(typeOfShelter, location, leaderName, volunteerAmount, id, contactNumber);
            info.creatShelter(info);
            tableView.getItems().add(info);

            successful.show();
        } catch (NumberFormatException e) {
            invalid.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void detailsSceneButtonOnClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("shelterNewScene.fxml"));
        Parent userViewParent = loader.load();

        Scene userViewScene = new Scene(userViewParent);

        ShelterNewSceneController controller = loader.getController();
        controller.initData(tableView.getSelectionModel().getSelectedItem(),tableView.getItems());
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(userViewScene);
        window.show();
    }

    @FXML
    private void viewDetailsButtonOnClick(ActionEvent event) {
        ObservableList<Shelter> records = FXCollections.observableList(Shelter.shelter());
        tableView.setItems(records);
    }
    
}
