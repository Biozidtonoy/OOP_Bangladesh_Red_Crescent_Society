/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Sumaiya.Volunteer;

import Sumaiya.Trainer.FeedBackVolunteer;
import java.io.IOException;
import java.net.URL;
import java.util.Observable;
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
 * @author Muntasir
 */
public class ViewTrainerFeedbackController implements Initializable {

    @FXML
    private TableView<FeedBackVolunteer> tableView;
    @FXML
    private TableColumn<FeedBackVolunteer, String> nameTableColumn;
    @FXML
    private TableColumn<FeedBackVolunteer, String> emailTableColumn;
    @FXML
    private TableColumn<FeedBackVolunteer, String> feedbackTableColumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    nameTableColumn.setCellValueFactory(new PropertyValueFactory<>("volunteerName"));
    emailTableColumn.setCellValueFactory(new PropertyValueFactory<>("emailAddress"));
    feedbackTableColumn.setCellValueFactory(new PropertyValueFactory<>("feedback"));
    }    

    @FXML
    private void viewButtonOnClick(ActionEvent event) {
        ObservableList<FeedBackVolunteer> feedbackList= FeedBackVolunteer.readfeedbackList1();
        tableView.setItems(feedbackList);
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
    
}
