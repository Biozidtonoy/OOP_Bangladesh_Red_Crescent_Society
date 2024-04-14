/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Mehedi.Manager;

import Users.User;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Elitebook 830
 */
public class TrainingController implements Initializable {

    @FXML
    private TextField workshopnameTF;
    @FXML
    private DatePicker stratingdatepicker;
    @FXML
    private DatePicker endingdatepicker;
    @FXML
    private TableView<training> tableview;
    @FXML
    private TableColumn<training, String> workshopnametableview;
    @FXML
    private TableColumn<training, LocalDate> startingdatetableview;
    @FXML
    private TableColumn<training, LocalDate> endingdatetableview;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        workshopnametableview.setCellValueFactory(new PropertyValueFactory<>("workshopName"));
        startingdatetableview.setCellValueFactory(new PropertyValueFactory<>("startingDate"));
        endingdatetableview.setCellValueFactory(new PropertyValueFactory<>("endingDate"));
        // TODO
    }    

    @FXML
    private void asignbuttononclick(ActionEvent event) {
        String workshopName = workshopnameTF.getText();
        LocalDate startingDate = stratingdatepicker.getValue();
        LocalDate endingDate = endingdatepicker.getValue();
        
        training newtraining = new training(workshopName, startingDate, endingDate);
        
        tableview.getItems().add(newtraining);
        workshopnameTF.clear();
    stratingdatepicker.setValue(null);
    endingdatepicker.setValue(null);
           
        
    }

    @FXML
    private void returnbuttonclick(ActionEvent event) throws IOException {
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("managerDashboard.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow(); 
        window.setScene(scene1);
        window.show();
    }

    @FXML
    private void adduserintablebutoonclick(ActionEvent event) {
//        User newUser = new User(workshopame, startingDate, endingDate) {};

        // Add the new user to the table view
//        tableview.getItems().add(newUser);

    }

}
