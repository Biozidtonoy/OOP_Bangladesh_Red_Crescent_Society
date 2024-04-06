/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Tonoy.Donor;

import helperClass.bloodCenter;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
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
public class BloodDonationController implements Initializable {

    @FXML
    private Label bloodDonationLabelTF;
    @FXML
    private TableView<bloodCenter> bloodCenterTV;
    @FXML
    private TableColumn<bloodCenter, String> districtTC;
    @FXML
    private TableColumn<bloodCenter, String> bloodCenterTC;
    @FXML
    private TableColumn<bloodCenter, String> inChargeTC;
    @FXML
    private TableColumn<bloodCenter, String> locationTC;
    @FXML
    private TableColumn<bloodCenter, Integer> hotlineTC;
    Alert select = new Alert(Alert.AlertType.WARNING,"please select donation center");
    @FXML
    private Label AlerttoGetDonorCardLabelTF;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        bloodDonationLabelTF.setText("Your donation can save the lives of make a difference or simply make you feel great about your contribution to humanity. \n"
                + "Whatever your reason, whatever your motivation we welcome you to learn more about eligibility and benefits of donating   \n"
                + "blood with a trusted organization like us.");
        
        districtTC.setCellValueFactory(new PropertyValueFactory<bloodCenter, String>("district"));
        bloodCenterTC.setCellValueFactory(new PropertyValueFactory<bloodCenter, String>("bloodCenterName"));
        inChargeTC.setCellValueFactory(new PropertyValueFactory<bloodCenter, String>("volunteerName"));
        locationTC.setCellValueFactory(new PropertyValueFactory<bloodCenter, String>("location"));
        hotlineTC.setCellValueFactory(new PropertyValueFactory<bloodCenter, Integer>("number"));

        bloodCenterTV.setItems(this.bloodCenterDetails());
        
        bloodCenterTV.setOnMouseClicked(e -> {
        if (!bloodCenterTV.getSelectionModel().isEmpty()) {
            AlerttoGetDonorCardLabelTF.setText("Please click next for donor card");
        } else {
            AlerttoGetDonorCardLabelTF.setText("");
        }
    });
        
        
        
    }  
    public ObservableList<bloodCenter> bloodCenterDetails() {
        ObservableList<bloodCenter> bloodCenterDt = FXCollections.observableArrayList();
        bloodCenterDt.add(new bloodCenter("Red Crescent Blood Center", "Dhaka", "7/5, Aurongzeb Road, \n"
                + "Mohammadpur, Dhaka.", "sumu", "0179662253"));
        bloodCenterDt.add(new bloodCenter("Holy Family Red Crescent Blood Center", "Dhaka", "1st Floor, Out Door\n"
                + "1 Eskaton Garden Road, Dhaka", "Dr. Zahidur Rahman", "0179662848"));
        bloodCenterDt.add(new bloodCenter("Fatema Begum Red Crescent Blood Center", "Chattogram", "395 Anderkilla, Chattogram,", " Minhaz Uddin Taher", "01796622847"));
        bloodCenterDt.add(new bloodCenter("Ahad Red Crescent Blood Center", "Jashore", "Munshi Mehabullah Road, Jashore", " Md. Kamrul hasan", "01796738293"));
        bloodCenterDt.add(new bloodCenter("Mujib Jahan Red Crescent Blood Center ", "Sylhet", "Chowhatta, Sylhet", "Md. Abu Saleh Khan", "01796622288"));
        bloodCenterDt.add(new bloodCenter("Rajshahi Red Crescent Blood Center", "Rajshahi", "Rajshahi District Road, Rajshahi", "Md. Mobarak Ali", "01784948323"));
        bloodCenterDt.add(new bloodCenter("Begum Tayeeba Mojumder Red Crescent\n" + "Blood Center", "Dinajpur", "1 New Town, Dinajpur", "Fazlul Karim,", "01784948323"));
        bloodCenterDt.add(new bloodCenter("Natore Red Crescent Blood Center", "Natore", "Hospital Road, Natore", "Mrs. Shammi Akter", "01784948323"));
        bloodCenterDt.add(new bloodCenter("Achia Khatun Memorial Red Crescent Blood Center", "Magura", "Bonna, Medical Technologist \n" + "Jhenidah Road, Stadium Para, Magura", "Md. Sohrab Hossain", "01784948323"));
        return bloodCenterDt;
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
       if (bloodCenterTV.getSelectionModel().isEmpty()) {
            select.showAndWait();
        } else {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("donorCard.fxml"));
            Parent mainSceneParent = loader.load();

            Scene userViewScene = new Scene(mainSceneParent);

            DonorCardController d = loader.getController();
//            controller.setDonor(this.donor);
            Random random = new Random();
           int donorCardNo = random.nextInt(900000) + 100000; // Generates a number between 100000 and 999999

           // Set the generated number to the label
           d.donorCardNoLabelTF.setText(String.valueOf(donorCardNo));
            d.selectionDetails(bloodCenterTV.getSelectionModel().getSelectedItem());
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(userViewScene);
            window.show();
        }
        
    }
    
    
}
