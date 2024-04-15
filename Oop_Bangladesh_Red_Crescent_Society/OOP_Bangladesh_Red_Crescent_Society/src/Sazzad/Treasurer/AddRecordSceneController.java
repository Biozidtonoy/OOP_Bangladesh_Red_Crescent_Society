/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Sazzad.Treasurer;

import helperClass.Record;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import static java.time.Month.DECEMBER;
import static java.time.Month.MARCH;
import java.util.ArrayList;
import static java.util.Calendar.APRIL;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class AddRecordSceneController implements Initializable {

  
    @FXML
    private TableView<Record> addRecordTableView;
    @FXML
    private TableColumn<Record, String> nameTableColumn;
    @FXML
    private TableColumn<Record, String> recordTypeTableColumn;
    @FXML
    private TableColumn<Record, String> statusTableColumn;
    @FXML
    private TableColumn<Record,String> dateTableColumn;
    @FXML
    private DatePicker datePicker;
    
    private ArrayList<Record> RecordArr;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        RecordArr = new ArrayList<Record>();
        
        nameTableColumn.setCellValueFactory(new PropertyValueFactory<Record, String>("name"));
        recordTypeTableColumn.setCellValueFactory(new PropertyValueFactory<Record, String>("recordType"));
        statusTableColumn.setCellValueFactory(new PropertyValueFactory<Record, String>("status"));
        dateTableColumn.setCellValueFactory(new PropertyValueFactory<Record, String>("dateCreated"));
        
        
        addRecordTableView.setItems(this.getRecord());
        
        
    } 
    
      public ObservableList<Record> getRecord(){
        ObservableList<Record> Records = FXCollections.observableArrayList();
        
        Records.add(new Record("Blood Donation Record","Health","Active",LocalDate.of(2024,MARCH, 8)));
        Records.add(new Record("Volunteer Training Attandance Record","Emergency Response","Ongoing",LocalDate.of(2024,APRIL, 9)));
        Records.add(new Record("FirstAid Training Cretificate Record","Education","Renewed Anually",LocalDate.of(2024,DECEMBER, 16)));
        Records.add(new Record("Event participation Record","Public Relations","Archived",LocalDate.of(2024,MARCH, 1)));
        Records.add(new Record("Fund Rising Campagin Record","Finance","Closed",LocalDate.of(2024,MARCH, 10)));
        
   
        return Records;
        
    }  


    @FXML
    private void viewRecordActionButtonOnClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("viewRecordScene.fxml"));
        Parent recordViewParent = loader.load();
        
        Scene recordViewScene = new Scene(recordViewParent);
        
        ViewRecordSceneController controller = loader.getController();
        controller.initData(addRecordTableView.getSelectionModel().getSelectedItem());
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(recordViewScene);
        window.show();
         
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
