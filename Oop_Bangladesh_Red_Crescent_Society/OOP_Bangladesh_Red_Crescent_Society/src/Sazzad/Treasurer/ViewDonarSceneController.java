/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Sazzad.Treasurer;

import Users.Treasurer;
import helperClass.Donor;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class ViewDonarSceneController implements Initializable {

    @FXML
    private TableView<Donor> donorListTableView;
    @FXML
    private TableColumn<Donor, String> idTableColumn;
    @FXML
    private TableColumn<Donor, String> nameTableColumn;
    @FXML
    private TableColumn<Donor, String> donationTableColumn;
    @FXML
    private TableColumn<Donor, String> accountTableColumn;
    @FXML
    private TableColumn<Donor, String> dateTableColumn;
    
     private ArrayList<Donor> DonorArr;
    @FXML
    private TextArea viewDetailsTextArea;
    @FXML
    private TextField searchTextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        DonorArr = new ArrayList<Donor>();
        
         idTableColumn.setCellValueFactory(new PropertyValueFactory<Donor, String>("id"));
         nameTableColumn.setCellValueFactory(new PropertyValueFactory<Donor, String>("name"));
         donationTableColumn.setCellValueFactory(new PropertyValueFactory<Donor, String>("donation"));
         accountTableColumn.setCellValueFactory(new PropertyValueFactory<Donor, String>("accountno")); 
         dateTableColumn.setCellValueFactory(new PropertyValueFactory<Donor, String>("date"));
         
         donorListTableView.setItems(this.getDonor());
             
    } 
    
    public ObservableList<Donor> getDonor(){
        ObservableList<Donor> donors = FXCollections.observableArrayList();
        
        donors.add(new Donor(101, "Nafis", 5000.0, 879274993.0, LocalDate.of(2024, Month.MARCH, 7)));
        donors.add(new Donor(102, "Shihab", 2000.0, 78957935.0, LocalDate.of(2023, Month.FEBRUARY, 8)));
        donors.add(new Donor(103, "Siyam", 200.0, 231412442.0, LocalDate.of(2023, Month.APRIL, 2)));
        donors.add(new Donor(104, "Sabbir", 10000.0, 45345355.0, LocalDate.of(2022, Month.DECEMBER, 5)));
        donors.add(new Donor(105, "Tuba", 500.0, 85435366.0, LocalDate.of(2024, Month.JANUARY, 17)));
        return donors;
    }   

    @FXML
    private void searchActionButtonOnClick(ActionEvent event) {
        
    }

    @FXML
    private void backBouttonOnClick(ActionEvent event) throws IOException {
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("treasurerDashboard.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow(); 
        window.setScene(scene1);
        window.show();
    }

    @FXML
    private void viewDetailsActionButtonOnClick(ActionEvent event) {
         Donor selectedDonor = donorListTableView.getSelectionModel().getSelectedItem();
    
    if (selectedDonor != null) {
        String details = "Donor ID: " + selectedDonor.getId() + "\n"
                       + "Name: " + selectedDonor.getName() + "\n"
                       + "Donation: " + selectedDonor.getDonation() + "\n"
                       + "Account No: " + selectedDonor.getAccountNo() + "\n"
                       + "Date: " + selectedDonor.getDate() + "\n";
        
        viewDetailsTextArea.setText(details);
    } else {
        viewDetailsTextArea.setText("Please select a donor to view details.");
    }
    }
    
}
