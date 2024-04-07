/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Tonoy.Director;

import Tonoy.Donor.FeedbackController;
import static Tonoy.Donor.FeedbackController.feedBackList;
import helperClass.feedback;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
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
public class ViewFeedbackController implements Initializable {

    @FXML
    private TableView<feedback> viewFeedbackTableView;
    @FXML
    private TableColumn<feedback,String> nameTC;
    @FXML
    private TableColumn<feedback,Integer> ageTC;
    @FXML
    private TableColumn<feedback,String> ocupationTC;
    @FXML
    private TableColumn<feedback,String> districtTC;
    @FXML
    private TableColumn<feedback,LocalDate> dateTC;
    @FXML
    private TableColumn<feedback,String> contentTC;
//    ArrayList<feedback> feedBackList = FeedbackController.feedBackList;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        nameTC.setCellValueFactory(new PropertyValueFactory<feedback,String>("name"));
        ageTC.setCellValueFactory(new PropertyValueFactory<feedback,Integer>("age"));
        ocupationTC.setCellValueFactory(new PropertyValueFactory<feedback,String>("occupation"));
        districtTC.setCellValueFactory(new PropertyValueFactory<feedback,String>("district"));
        dateTC.setCellValueFactory(new PropertyValueFactory<feedback,LocalDate>("date"));
        contentTC.setCellValueFactory(new PropertyValueFactory<feedback,String>("content"));
    }    

    @FXML
    private void viewFeedbackBT(ActionEvent event) {
//        viewFeedbackTableView.getItems().clear();
        
        // Read feedback from the binary file
        ObservableList<feedback> feedbackList = feedback.readfeedbackList1();
        System.out.println(feedbackList);
        
        // Add feedback to the TableView
        viewFeedbackTableView.setItems(feedbackList);
        
//        for(feedback fb2 : feedBackList){
//          viewFeedbackTableView.getItems().add(fb2); 
//        }
    }

    @FXML
    private void backBT(ActionEvent event) throws IOException {
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("directorDashboard.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow(); 
        window.setScene(scene1);
        window.show();
    }
    
}
