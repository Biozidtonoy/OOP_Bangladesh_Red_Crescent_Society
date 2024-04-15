/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Tonoy.Donor;

import helperClass.Community;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.ResourceBundle;
import java.util.UUID;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author tonoy
 */
public class CommunityController implements Initializable {

    @FXML
    private TableView<Community> communityTV;
    @FXML
    private TableColumn<Community,String> districtTC;
    @FXML
    private TableColumn<Community,String> bloodCenterTC;
    @FXML
    private TableColumn<Community,String> timeTC;
    @FXML
    private TableColumn<Community,LocalDate> dateTC;

    Alert select = new Alert(Alert.AlertType.WARNING,"please select donation center");
    @FXML
    private Label alertGetmeetLinklabel;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        districtTC.setCellValueFactory(new PropertyValueFactory<Community, String>("district"));
        bloodCenterTC.setCellValueFactory(new PropertyValueFactory<Community, String>("bloodCenter"));
        timeTC.setCellValueFactory(new PropertyValueFactory<Community, String>("time"));
        dateTC.setCellValueFactory(new PropertyValueFactory<Community, LocalDate>("date"));
        
        
      communityTV.setItems(this.communityDetails());
      
      communityTV.setOnMouseClicked(e -> {
        if (!communityTV.getSelectionModel().isEmpty()) {
            alertGetmeetLinklabel.setText("*Please click attend and get the meet link to participated");
        } else {
            alertGetmeetLinklabel.setText("");
        }
    });
      
   
    } 
     public ObservableList<Community> communityDetails() {
        ObservableList<Community> communitydt = FXCollections.observableArrayList();
        communitydt.add(new Community("Dhaka","Red Crescent Blood Center","03:00AM",LocalDate.of(2024, Month.APRIL, 24)  ));
        communitydt.add(new Community("Chittagong","Fatema Begum Red Crescent Blood Center","12:00AM",LocalDate.of(2024, Month.APRIL, 4)  )); 
        return communitydt;
    }

    

    @FXML
    private void attendBT(ActionEvent event) throws IOException {
        if (communityTV.getSelectionModel().isEmpty()) {
            select.showAndWait();
        } else {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("attend.fxml"));
            Parent mainSceneParent = loader.load();

            Scene userViewScene = new Scene(mainSceneParent);

            AttendController d = loader.getController();
            
            String meetingLink = generateRandomMeetingLink();
             d.meetlinkTA.setText(meetingLink);
//            controller.setDonor(this.donor);
            
            d.selectionDetails(communityTV.getSelectionModel().getSelectedItem());
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(userViewScene);
            window.show();
        }
         
  
    }
    
    private String generateRandomMeetingLink() {
        // Generate a random UUID (Universally Unique Identifier)
        UUID uuid = UUID.randomUUID();
        // Convert UUID to a string and return it as the meeting link
        return "https://example.com/meeting/" + uuid.toString();
    }
    
    @FXML
    private void backBT(ActionEvent event) throws IOException {
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("donorDashboard.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow(); 
        window.setScene(scene1);
        window.show();
    }
    
}
