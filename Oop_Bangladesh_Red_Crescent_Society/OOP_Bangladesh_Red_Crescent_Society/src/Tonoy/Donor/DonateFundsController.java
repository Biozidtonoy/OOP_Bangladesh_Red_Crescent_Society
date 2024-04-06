/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Tonoy.Donor;

import Users.Donor;
import helperClass.UrgentDonation;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author tonoy
 */
public class DonateFundsController implements Initializable {
    private Donor donor;

    public Donor getDonor() {
        return donor;
    }

    public void setDonor(Donor donor) {
        this.donor = donor;
    }
    

    @FXML
    private TableView<UrgentDonation> urgentDonationTableView;
    @FXML
    private TableColumn<UrgentDonation,String> whereTodonateTC;
    Alert select = new Alert(Alert.AlertType.WARNING,"please select where you want to donate");

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        whereTodonateTC.setCellValueFactory(new PropertyValueFactory<UrgentDonation,String>("whereToDonate"));
        urgentDonationTableView.setItems(this.urgentDonationDetails());
    } 
    public ObservableList<UrgentDonation> urgentDonationDetails(){
        ObservableList<UrgentDonation> urgentDonation = FXCollections.observableArrayList();
        urgentDonation.add(new UrgentDonation("Immediate humanitarian aid needed for gaza residents"));
        urgentDonation.add(new UrgentDonation("Health infrastructure support needed in Rangpur"));
        urgentDonation.add(new UrgentDonation("Education and empowerment programs poor people"));
        urgentDonation.add(new UrgentDonation("Women and children's welfare initiatives for whole bangladesh"));
        return urgentDonation;
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
    private void donateNowBT(ActionEvent event) throws IOException {
        if (urgentDonationTableView.getSelectionModel().isEmpty()) {
            select.showAndWait();
        } else {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("donateNow.fxml"));
            Parent mainSceneParent = loader.load();

            Scene userViewScene = new Scene(mainSceneParent);

            DonateNowController controller = loader.getController();
            controller.setDonor(donor);
            
            controller.urgentDonatationData(urgentDonationTableView.getSelectionModel().getSelectedItem());
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(userViewScene);
            window.show();
        }
        
    }

    
    
    
}
