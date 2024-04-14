/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Tonoy.Donor;

import helperClass.JobCircular;
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
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author tonoy
 */
public class viewAvailableJobController implements Initializable {

    @FXML
    private TableView<JobCircular> viewJobTV;
    @FXML
    private TableColumn<JobCircular,String> postTC;
    @FXML
    private TableColumn<JobCircular,String> timeTC;
    @FXML
    private TableColumn<JobCircular, Double> salaryTC;
    @FXML
    private TableColumn<JobCircular, LocalDate> dateTC;
    Alert select = new Alert(Alert.AlertType.WARNING,"please select your job interest");

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        salaryTC.setCellValueFactory(new PropertyValueFactory<JobCircular,Double>("salary"));
        postTC.setCellValueFactory(new PropertyValueFactory<JobCircular,String>("post"));
        timeTC.setCellValueFactory(new PropertyValueFactory<JobCircular,String>("time"));
        dateTC.setCellValueFactory(new PropertyValueFactory<JobCircular,LocalDate>("deadline"));
    }    

    @FXML
    private void backBT(ActionEvent event) throws IOException {
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("donorDashboard.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow(); 
        window.setScene(scene1);
        window.show();
    }

    @FXML
    private void nextBT(ActionEvent event) throws IOException {
        if (viewJobTV.getSelectionModel().isEmpty()) {
            select.showAndWait();
        } else {
            Parent mainSceneParent = FXMLLoader.load(getClass().getResource("applayForJob1.fxml"));
            Scene scene1 = new Scene(mainSceneParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(scene1);
            window.show();
//            FXMLLoader loader = new FXMLLoader();
//            loader.setLocation(getClass().getResource("applayForJob1.fxml"));
//            Parent mainSceneParent = loader.load();
//
//            Scene userViewScene = new Scene(mainSceneParent);

//             d = loader.getController();
////            controller.setDonor(this.donor);
//            
//            d.selectionDetails(viewJobTV.getSelectionModel().getSelectedItem());
//            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
//            window.setScene(userViewScene);
//            window.show();

        }
        
    }

    @FXML
    private void viewJobDetailsBT(ActionEvent event) {
        ObservableList<JobCircular> JobCircularList = JobCircular.readJobCircularList1();
        System.out.println(JobCircularList);
        
        // Add feedback to the TableView
        viewJobTV.setItems(JobCircularList);
    }
    
}
