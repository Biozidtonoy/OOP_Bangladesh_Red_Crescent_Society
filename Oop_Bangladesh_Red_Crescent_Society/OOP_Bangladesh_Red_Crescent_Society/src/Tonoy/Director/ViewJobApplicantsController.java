/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Tonoy.Director;

import helperClass.JobCircular;
import helperClass.applyjob;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author tonoy
 */
public class ViewJobApplicantsController implements Initializable {

    @FXML
    private TableView<applyjob> viewApplicantTV;
    @FXML
    private TableColumn<applyjob, String> nameTC;
    @FXML
    private TableColumn<applyjob, LocalDate> dobTC;
    @FXML
    private TableColumn<applyjob, String> degreeTC;
    @FXML
    private TableColumn<applyjob, String> experienceTC;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nameTC.setCellValueFactory(new PropertyValueFactory<applyjob,String>("name"));
        dobTC.setCellValueFactory(new PropertyValueFactory<applyjob,LocalDate>("dob"));
        degreeTC.setCellValueFactory(new PropertyValueFactory<applyjob,String>("degree"));
        experienceTC.setCellValueFactory(new PropertyValueFactory<applyjob,String>("experience"));
    }    

    @FXML
    private void backBT(ActionEvent event) throws IOException {
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("directorDashboard.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow(); 
        window.setScene(scene1);
        window.show();
    }

    @FXML
    private void viewApplicantsBT(ActionEvent event) {
         ObservableList<applyjob> applyjobList = applyjob.readapplyjobList1();
        System.out.println(applyjobList);
        
        // Add feedback to the TableView
        viewApplicantTV.setItems(applyjobList);
        
    }
    
}
