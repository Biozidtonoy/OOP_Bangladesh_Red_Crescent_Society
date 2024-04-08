/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Sumaiya.Trainer;

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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Muntasir
 */
public class TrainingProgramSceneController implements Initializable {

    @FXML
    private TextField trainerNameTextField;
    @FXML
    private TextField programNameTextField;
    @FXML
    private RadioButton onlineRadioButtonOnClick;
    @FXML
    private ToggleGroup tg_group;
    @FXML
    private TextField classDurationTextField;
    @FXML
    private TableColumn<TrainingProgram, String> trainerTableColumn;
    @FXML
    private TableColumn<TrainingProgram, String> programNameTableColumn;
    @FXML
    private TableColumn<TrainingProgram, String> classTypeTableColumn;
    @FXML
    private TableColumn<TrainingProgram, Integer> classDurationTableColumn;
    @FXML
    private TableView<TrainingProgram> tableView;
    Alert successful = new Alert(Alert.AlertType.INFORMATION, "Successfully registered");
    Alert unfilled = new Alert(Alert.AlertType.WARNING, "Error, try again!");
    Alert invalid = new Alert(Alert.AlertType.WARNING, "Invalid input!");
    @FXML
    private RadioButton offlineRadionButtonOnClick;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
        trainerTableColumn.setCellValueFactory(new PropertyValueFactory<TrainingProgram, String>("programName"));
        programNameTableColumn.setCellValueFactory(new PropertyValueFactory<TrainingProgram, String>("TrainerName"));
        classTypeTableColumn.setCellValueFactory(new PropertyValueFactory<TrainingProgram, String>("classType"));
        classDurationTableColumn.setCellValueFactory(new PropertyValueFactory<TrainingProgram, Integer>("duration"));
    }    

    @FXML
    private void addButtonOnClick(ActionEvent event) {
        try {
            String programName = programNameTextField.getText();
            String trainerName = trainerNameTextField.getText();
            int duration = Integer.parseInt(classDurationTextField.getText());
            String classType = "";

            if (onlineRadioButtonOnClick.isSelected()) {
                classType = "Online";
            } else if (offlineRadionButtonOnClick.isSelected()) {
                classType = "Offline";
            }

            if (programName.isEmpty() || trainerName.isEmpty() || classType.isEmpty() || duration <= 0) {
                unfilled.show();
                return;
            }

            TrainingProgram info = new TrainingProgram(programName, trainerName, classType, duration);
            info.creatProgram(info);
            tableView.getItems().add(info);
            successful.show();
            onlineRadioButtonOnClick.setSelected(false);
            offlineRadionButtonOnClick.setSelected(false);
        } catch (NumberFormatException e) {
            invalid.show();
        }

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
    private void viewButtonOnClick(ActionEvent event) {
         ObservableList<TrainingProgram> records = FXCollections.observableList(TrainingProgram.program());
         tableView.setItems(records);
    }
    
}
