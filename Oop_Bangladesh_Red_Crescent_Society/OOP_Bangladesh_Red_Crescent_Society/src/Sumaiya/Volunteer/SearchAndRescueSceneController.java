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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Muntasir
 */
public class SearchAndRescueSceneController implements Initializable {

    @FXML
    private TableView<SearchAndRescue> tableView;
    @FXML
    private TableColumn<SearchAndRescue, String> nameTableColumn;
    @FXML
    private TableColumn<SearchAndRescue, String> locationTableColumn;
    @FXML
    private TableColumn<SearchAndRescue, String> ageTableColumn;
    @FXML
    private TableColumn<SearchAndRescue, LocalDate> rescuedDateTableColumn;
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField ageTextField;
    @FXML
    private TextField locationTextField;
    @FXML
    private DatePicker rescuedDateTextField;
    Alert successful = new Alert(Alert.AlertType.INFORMATION, "Successfully registered");
    Alert unfilled = new Alert(Alert.AlertType.WARNING, "Error, try again!");
    Alert invalid = new Alert(Alert.AlertType.WARNING, "Invalid input!");
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    nameTableColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
    locationTableColumn.setCellValueFactory(new PropertyValueFactory<>("location"));
    ageTableColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
    rescuedDateTableColumn.setCellValueFactory(new PropertyValueFactory<>("rescuedDate"));
    tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }    

    @FXML
    private void detailsButtonOnClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("searchAndRescueNew.fxml"));
        Parent userViewParent = loader.load();

        Scene userViewScene = new Scene(userViewParent);

        SearchAndRescueNewController controller = loader.getController();
       
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(userViewScene);
        window.show();
    }

    @FXML
    private void addButtonOnClick(ActionEvent event) {
        try {
        String name = nameTextField.getText();
        String location = locationTextField.getText();
        int age = Integer.parseInt(ageTextField.getText());
        LocalDate date = rescuedDateTextField.getValue();
        
            if (name.isEmpty() || location.isEmpty() || age <= 0 || date == null) {
                unfilled.show();
                return;
            }
            SearchAndRescue newRescue = new SearchAndRescue(name, location, age, date);
            newRescue.creatSearch(newRescue);
            tableView.getItems().add(newRescue);
            successful.show();
            rescuedDateTextField.setValue(null);
        } catch (NumberFormatException e) {
            invalid.show();
        }
    }

    @FXML
    private void viewDetailsButtonOnClick(ActionEvent event) {
         ObservableList<SearchAndRescue> records = FXCollections.observableList(SearchAndRescue.searchRecord());
         tableView.setItems(records);
    }

    @FXML
    private void nameMouseButtonOnClick(MouseEvent event) {
        nameTextField.setText(null);
    }

    @FXML
    private void ageMouseButtonOnClick(MouseEvent event) {
        ageTextField.setText(null);
    }

    @FXML
    private void locationMouseButtonOnClick(MouseEvent event) {
         locationTextField.setText(null);
    }
    
}
