/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Sumaiya.Volunteer;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
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
public class FirstAidSceneController implements Initializable {

    @FXML
    private TextField patientTextFiield;
    @FXML
    private CheckBox massiveCheckButtonOnClick;
    @FXML
    private CheckBox minorCheckButtonOnClick;
    @FXML
    private RadioButton maleRadioButton;
    @FXML
    private ToggleGroup tg_group;
    @FXML
    private RadioButton femaleRadioButton;
    @FXML
    private ToggleGroup tg_group1;
    @FXML
    private RadioButton oldRadioButton;
    @FXML
    private ToggleGroup tg_group2;
    @FXML
    private RadioButton childRadioButton;
    @FXML
    private ToggleGroup tg_group3;
    @FXML
    private TextField ageTextFiield;
    @FXML
    private DatePicker dateTextFiield;
    @FXML
    private TableView<FirstAid> tableView;
    @FXML
    private TableColumn<FirstAid, String> patientTableColumn;
    @FXML
    private TableColumn<FirstAid, String> injuryTableColumn;
    @FXML
    private TableColumn<FirstAid, String> genderTableColumn;
    @FXML
    private TableColumn<FirstAid, Integer> ageTableColumn;
    @FXML
    private TableColumn<FirstAid, LocalDate> dateTableColumn;
    ToggleGroup tg;
    Alert successful = new Alert(Alert.AlertType.INFORMATION, "Successfully registered");
    Alert unfilled = new Alert(Alert.AlertType.WARNING, "Error, try again!");
    Alert invalid = new Alert(Alert.AlertType.WARNING, "Invalid input!");
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        patientTableColumn.setCellValueFactory(new PropertyValueFactory<FirstAid, String>("patientName"));
        genderTableColumn.setCellValueFactory(new PropertyValueFactory<FirstAid, String>("gender"));
        injuryTableColumn.setCellValueFactory(new PropertyValueFactory<FirstAid, String>("injuryType"));
        ageTableColumn.setCellValueFactory(new PropertyValueFactory<FirstAid, Integer>("age"));
        dateTableColumn.setCellValueFactory(new PropertyValueFactory<FirstAid, LocalDate>("firtAidProvidingDate"));
        tg = new ToggleGroup(); 
        maleRadioButton.setToggleGroup(tg);
        femaleRadioButton.setToggleGroup(tg);
        oldRadioButton.setToggleGroup(tg);
        childRadioButton.setToggleGroup(tg);

       tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

    }    

    @FXML
    private void returnButtonOnClick(ActionEvent event) throws IOException {
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("volunteerDashboard.fxml"));
        Parent parent = loader.load();
        Scene newScene = new Scene(parent);

        currentStage.setScene(newScene);
        currentStage.show();
    }

    @FXML
    private void patientNameMouseOnClick(MouseEvent event) {
         patientTextFiield.setText(null);
    }

    @FXML
    private void ageMouseOnClick(MouseEvent event) {
        ageTextFiield.setText(null);
    }

    @FXML
    private void addButtonOnClick(ActionEvent event) {
        try {
            String gender = "";
            if (maleRadioButton.isSelected()) {
                gender = "Male";
            } else if (femaleRadioButton.isSelected()) {
                gender = "Female";
            }
            if (oldRadioButton.isSelected()) {
                gender = "Other";
            }
            else if(childRadioButton.isSelected()) {
                gender = "Other";
            }
            
            String injuryType = ""; 
            if (massiveCheckButtonOnClick.isSelected()) {
                injuryType = "massive";
            } else if (minorCheckButtonOnClick.isSelected()) {
                injuryType = "minor";
            }
            
            String patientName = patientTextFiield.getText();
            
            int age = Integer.parseInt(ageTextFiield.getText());
            LocalDate firtAidProvidingDate = dateTextFiield.getValue();

            if (patientName.isEmpty() ||gender.isEmpty() ||injuryType.isEmpty() || age==0 || firtAidProvidingDate == null) {
                unfilled.show();
                return;
            }
            
            FirstAid info = new FirstAid(patientName, gender, injuryType, age, firtAidProvidingDate);
            tableView.getItems().add(info);
            maleRadioButton.setSelected(false);
            femaleRadioButton.setSelected(false);
            oldRadioButton.setSelected(false);
            childRadioButton.setSelected(false);
            massiveCheckButtonOnClick.setSelected(false);
            minorCheckButtonOnClick.setSelected(false);
            dateTextFiield.setValue(null);
            successful.show();
            
        }catch (NumberFormatException e) {
            invalid.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    
        }
    }
    

