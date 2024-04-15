/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Sazzad.Treasurer;

import helperClass.Donor;
import helperClass.Expenses;
import helperClass.Revenue;
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
import javafx.scene.control.Label;
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
public class ViewRevenueSceneController implements Initializable {

    @FXML
    private TableView<Revenue> earnListTableView;
    @FXML
    private TableColumn<Revenue, String> idTableColumn;
    @FXML
    private TableColumn<Revenue, String> nameTableColumn;
    @FXML
    private TableColumn<Revenue, String> amountTableColumn;
    @FXML
    private TableColumn<Revenue, String> dateTableColumn;
    @FXML
    private TextArea viewDetailsTextArea;
    
    private ArrayList<Revenue> RevenueArr;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        RevenueArr = new ArrayList<Revenue>();
        
        idTableColumn.setCellValueFactory(new PropertyValueFactory<Revenue, String>("id"));
        nameTableColumn.setCellValueFactory(new PropertyValueFactory<Revenue, String>("name"));
        amountTableColumn.setCellValueFactory(new PropertyValueFactory<Revenue, String>("amount"));
        dateTableColumn.setCellValueFactory(new PropertyValueFactory<Revenue, String>("date"));
        
        earnListTableView.setItems(this.getRevenue());
        
    } 
    
    public ObservableList<Revenue> getRevenue(){
        ObservableList<Revenue> Revenues = FXCollections.observableArrayList();
        
        Revenues.add(new Revenue(101, "Nafis", 5000.0, LocalDate.of(2024, Month.MARCH, 7)));
        Revenues.add(new Revenue(102, "Shihab", 2000.0, LocalDate.of(2023, Month.MARCH, 8)));
        Revenues.add(new Revenue(103, "Siyam", 200.0, LocalDate.of(2023, Month.MARCH, 2)));
        Revenues.add(new Revenue(104, "Sabbir", 10000.0, LocalDate.of(2022, Month.MARCH, 5)));
        Revenues.add(new Revenue(105, "Tuba", 500.0, LocalDate.of(2024, Month.MARCH, 17)));
        return Revenues;
        
    }  
    
   

    
    
    
    @FXML
    private void viewDetailsActionButtonOnClick(ActionEvent event) {
         Revenue selectedDonor = earnListTableView.getSelectionModel().getSelectedItem();
    
    if (selectedDonor != null) {
        String details = "ID: " + selectedDonor.getId() + "\n"
                       + "Name: " + selectedDonor.getName() + "\n"
                       + "Date: " + selectedDonor.getDate() + "\n";
        
        viewDetailsTextArea.setText(details);
    } else {
        viewDetailsTextArea.setText("Please select a donor to view details.");
    }
    
    }


    @FXML
    private void backActionButtonOnClick(ActionEvent event) throws IOException {
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("treasurerDashboard.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow(); 
        window.setScene(scene1);
        window.show();
        
    }
    
}
