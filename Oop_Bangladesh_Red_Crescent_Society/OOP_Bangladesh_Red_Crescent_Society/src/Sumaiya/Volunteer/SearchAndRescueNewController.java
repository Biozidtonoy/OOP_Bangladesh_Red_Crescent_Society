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
import javafx.collections.transformation.FilteredList;
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
public class SearchAndRescueNewController implements Initializable {

    @FXML
    private TextField searchNameTextField;
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
    Alert unfilled = new Alert(Alert.AlertType.WARNING, "Error, try again!");
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
    private void returnHomeButtonOnClick(ActionEvent event) throws IOException {
         Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("volunteerDashboard.fxml"));
        Parent parent = loader.load();
        Scene newScene = new Scene(parent);

        currentStage.setScene(newScene);
        currentStage.show();
    }

    @FXML
    private void searchMouseButtonOnClick(MouseEvent event) {
                searchNameTextField.setText(null);
    }

    @FXML
    private void searchButtonOnClick(ActionEvent event) {
        String searchText = searchNameTextField.getText().toLowerCase();
        FilteredList<SearchAndRescue> filteredList = new FilteredList<>(tableView.getItems());
        filteredList.setPredicate(searchAndRescue -> {
            if (searchText == null || searchText.isEmpty()) {
                unfilled.show();
                return true;
            }
            String lowerCaseSearchText = searchText.toLowerCase();
            return searchAndRescue.getName().toLowerCase().contains(lowerCaseSearchText)
                    || searchAndRescue.getLocation().toLowerCase().contains(lowerCaseSearchText)
                    || String.valueOf(searchAndRescue.getAge()).contains(lowerCaseSearchText)
                    || searchAndRescue.getRescuedDate().toString().contains(lowerCaseSearchText);
        });
        tableView.setItems(filteredList);
    }

    @FXML
    private void goBackButtonOnClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("searchAndRescueScene.fxml"));
        Parent userViewParent = loader.load();

        Scene userViewScene = new Scene(userViewParent);

        SearchAndRescueSceneController controller = loader.getController();
        //controller.loadTable();
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(userViewScene);
        window.show();
    }

    @FXML
    private void viewDetailsButtonOnClick(ActionEvent event) {
        ObservableList<SearchAndRescue> records = FXCollections.observableList(SearchAndRescue.searchRecord());
         tableView.setItems(records);
    }
    
}
