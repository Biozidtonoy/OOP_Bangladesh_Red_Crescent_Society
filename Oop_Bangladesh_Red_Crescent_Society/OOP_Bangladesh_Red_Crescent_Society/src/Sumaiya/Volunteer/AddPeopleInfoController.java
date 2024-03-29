/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Sumaiya.Volunteer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
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
import javafx.scene.control.TableColumn.CellEditEvent;
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
public class AddPeopleInfoController implements Initializable {

    @FXML
    private TextField firstNameTextField;
    @FXML
    private TextField lastNameTextField;
    @FXML
    private TextField contactInformationTextField;
    @FXML
    private DatePicker dateOfRegistration;
    @FXML
    private TableView<People> tableView;
    @FXML
    private TableColumn<People, String> firstNameTableColumn;
    @FXML
    private TableColumn<People, String> lastNameTableColumn;
    @FXML
    private TableColumn<People, Integer> contactInformationTableColumn;
    @FXML
    private TableColumn<People, LocalDate> registerDateTableColumn;
    ArrayList<People> infoList= new ArrayList<>();
    Alert successful = new Alert(Alert.AlertType.INFORMATION, "Successfully registered");
    Alert unfilled = new Alert(Alert.AlertType.WARNING, "Error, try again!");
    Alert invalid = new Alert(Alert.AlertType.WARNING, "Invalid input!");
    Alert alert = new Alert(Alert.AlertType.ERROR, "Please enter a valid phone number");
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        firstNameTableColumn.setCellValueFactory(new PropertyValueFactory<People, String>("firstName"));
        lastNameTableColumn.setCellValueFactory(new PropertyValueFactory<People, String>("lastName"));
        contactInformationTableColumn.setCellValueFactory(new PropertyValueFactory<People, Integer>("contactInfornamtion"));
        registerDateTableColumn.setCellValueFactory(new PropertyValueFactory<People, LocalDate>("registrationDate"));
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        //tableView.setItems(getPeople());
    }    

    public void setPeople(ObservableList<People> people){
        tableView.setItems(people);
    }
//        ObservableList<People> people = FXCollections.observableArrayList();
//        
//        people.add(new People("Nikita", "Mysha",1348556677, LocalDate.of(2002, Month.JULY, 15)));
//        people.add(new People("Anika", "Khan",1344556677, LocalDate.of(2005, Month.JUNE, 15)));
//        people.add(new People("Ania", "Ahmed",1244556677, LocalDate.of(2000, Month.MAY, 10)));
//        return people;
//       
//   }

    @FXML
    private void addVlueButtonOnClick(ActionEvent event) {

    try {
            String firstName = firstNameTextField.getText();
            String lastName = lastNameTextField.getText();
            String contactInformationText = contactInformationTextField.getText();
            LocalDate registrationDate = dateOfRegistration.getValue();

            if (firstName.isEmpty() || lastName.isEmpty() || contactInformationText.isEmpty() || registrationDate == null) {
                unfilled.show();
                return;
            }

            if (contactInformationText.length() != 11) {
                alert.show();
                return;
            }

            int contactInformation = Integer.parseInt(contactInformationText);

            try (FileOutputStream fos = new FileOutputStream("people.bin", true);
               DataOutputStream dos = new DataOutputStream(fos)) {
                dos.writeUTF(firstName);
                dos.writeUTF(lastName);
                dos.writeInt(contactInformation);
            }

            People info = new People(firstName, lastName, contactInformation, registrationDate);
            tableView.getItems().add(info);

            successful.show();
        } catch (NumberFormatException e) {
            invalid.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    
}
    
    @FXML
    private void firstNameTextMouseClickEvent(MouseEvent event) {
        firstNameTextField.setText(null);
    }

    @FXML
    private void lastNameTextMouseClickEvent(MouseEvent event) {
        lastNameTextField.setText(null);
    }

    @FXML
    private void registrationDateMouseClickEvent(MouseEvent event) {
         dateOfRegistration.setValue(LocalDate.now());
    }

    @FXML
    private void firstNameColumnLiveEdit(CellEditEvent event) {
        People userSelected = tableView.getSelectionModel().getSelectedItem();
        userSelected.setFirstName(event.getNewValue().toString());
    }

    @FXML
    private void lastNameColumnLiveEdit(CellEditEvent event) {
        People userSelected = tableView.getSelectionModel().getSelectedItem();
        userSelected.setLastName(event.getNewValue().toString());
    }

    @FXML
    private void newSceneButtonOnClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("showPeopleInfo.fxml"));
        Parent userViewParent = loader.load();

        Scene userViewScene = new Scene(userViewParent);

        ShowPeopleInfoController controller = loader.getController();
        controller.initData(tableView.getSelectionModel().getSelectedItem(),tableView.getItems());
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(userViewScene);
        window.show();
    }
    }
