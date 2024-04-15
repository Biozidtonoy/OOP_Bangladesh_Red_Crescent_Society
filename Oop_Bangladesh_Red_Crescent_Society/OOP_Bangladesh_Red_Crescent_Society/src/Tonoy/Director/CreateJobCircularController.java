/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Tonoy.Director;

import helperClass.JobCircular;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author tonoy
 */
public class CreateJobCircularController implements Initializable {

    @FXML
    private ComboBox<String> postCB;
    @FXML
    private TextField timeTF;
    @FXML
    private DatePicker deadlineTF;
    @FXML
    private TextField salaryTF;
    @FXML
    private TableView<JobCircular> jobCircularTV;
    @FXML
    private TableColumn<JobCircular,String> postTC;
    @FXML
    private TableColumn<JobCircular,String> timeTC;
    @FXML
    private TableColumn<JobCircular,Double> salaryTC;
    @FXML
    private TableColumn<JobCircular,LocalDate> deadLineTC;
    Alert success = new Alert(Alert.AlertType.INFORMATION,"job creation done");
    Alert unfilled = new Alert(Alert.AlertType.WARNING,"Please Enter Everything!");

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        postCB.getItems().addAll("Treasure","Manager","trainer","event organizer","Media and Publisher","Volunteer");
        salaryTC.setCellValueFactory(new PropertyValueFactory<JobCircular,Double>("salary"));
        postTC.setCellValueFactory(new PropertyValueFactory<JobCircular,String>("post"));
        timeTC.setCellValueFactory(new PropertyValueFactory<JobCircular,String>("time"));
        deadLineTC.setCellValueFactory(new PropertyValueFactory<JobCircular,LocalDate>("deadline"));
        
        jobCircularTV.setEditable(true);
        timeTC.setCellFactory(TextFieldTableCell.forTableColumn());
        postTC.setCellFactory(TextFieldTableCell.forTableColumn());
//      dateTC.setCellFactory(TextFieldTableCell.forTableColumn());
        jobCircularTV.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        
        jobCircularTV.setItems(this.JobCircularDetails());
        
        
        
    }    
    public ObservableList<JobCircular> JobCircularDetails(){
        ObservableList<JobCircular> JobCirculardetails = FXCollections.observableArrayList();
        JobCirculardetails.add(new JobCircular("Trainer","0300",LocalDate.of(2024, Month.APRIL, 20),10000.00));
        JobCirculardetails.add(new JobCircular("Event Organizer","0300",LocalDate.of(2024, Month.APRIL, 20),30000.00));
        return JobCirculardetails;
    }
    
    

    @FXML
    private void backBT(ActionEvent event) throws IOException {
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("jobCircular.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow(); 
        window.setScene(scene1);
        window.show();
    }

    @FXML
    private void doneBT(ActionEvent event) {
        try {
            Double salary = Double.parseDouble(salaryTF.getText().trim());
            LocalDate date =deadlineTF.getValue();       
            String time = timeTF.getText().trim();
            String post = postCB.getValue();
            
          
           

            if (post == null||time.isEmpty()|| salary==null||
                    date==null) {
                unfilled.show();
                return;

            }
            JobCircular fb = new JobCircular(post,time,date,salary);
//            feedBackList.add(fb);
            fb.createJobCircular(fb);
            jobCircularTV.getItems().add(fb);
            
            
            success.show();
 
        } catch (Exception e) {
            unfilled.show();
            System.out.println("try block didnt execute");
        }
        
        
        
        
    }

    @FXML
    private void deleteBT(ActionEvent event) {
        ObservableList<JobCircular> selectedJobCircular, allUsers;
        allUsers = jobCircularTV.getItems();
        selectedJobCircular= jobCircularTV.getSelectionModel().getSelectedItems();
        
        for(JobCircular s: selectedJobCircular){
            allUsers.remove(s);
        }
    }

    @FXML
    private void viewJobDetails(ActionEvent event) {
        ObservableList<JobCircular> JobCircularList = JobCircular.readJobCircularList1();
        System.out.println(JobCircularList);
        
        // Add feedback to the TableView
        jobCircularTV.setItems(JobCircularList);
    }
    
}
