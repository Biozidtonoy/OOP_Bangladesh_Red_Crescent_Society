/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Tonoy.Donor;

import Users.Donor;
import helperClass.Utility;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author tonoy
 */
public class DonorDashboardController implements Initializable {
    
    private Donor donor;

    public Donor getDonor() {
        return donor;
    }

    public void setDonor(Donor donor) {
        this.donor = donor;
    }
    

    @FXML
    private MenuBar menubarDonor;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void logoutMitem(ActionEvent event) throws IOException {
        Parent sceneParent = FXMLLoader.load(getClass().getResource("/mainpkg/startScene.fxml"));
        Scene scene = new Scene(sceneParent);
        Stage window = (Stage) menubarDonor.getScene().getWindow(); 
        window.setScene(scene);
        window.show();
    }

    @FXML
    private void donanteFundsBT(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("donateFunds.fxml"));
            Parent mainSceneParent = loader.load();

            Scene userViewScene = new Scene(mainSceneParent);

            DonateFundsController controller = loader.getController();
            controller.setDonor(this.donor);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(userViewScene);
            window.show();
    }
    

    @FXML
    private void bloodDonationBT(ActionEvent event) throws IOException {
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("bloodDonation.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow(); 
        window.setScene(scene1);
        window.show();
    }

    @FXML
    private void feedbackBT(ActionEvent event) throws IOException {
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("feedback.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow(); 
        window.setScene(scene1);
        window.show();
    }

    @FXML
    private void comunityBT(ActionEvent event) throws IOException {
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("community.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow(); 
        window.setScene(scene1);
        window.show();
    }

    @FXML
    private void surveyBT(ActionEvent event) throws IOException {
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("survey.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow(); 
        window.setScene(scene1);
        window.show();
    }

    @FXML
    private void learnAboutBDRCActivitiesBT(ActionEvent event) throws IOException {
        Parent sceneParent = FXMLLoader.load(getClass().getResource("bdrcActivities.fxml"));
        Scene scene = new Scene(sceneParent);
        Stage window = (Stage) menubarDonor.getScene().getWindow(); 
        window.setScene(scene);
        window.show();
    }

    @FXML
    private void bloodDonationProcessBT(ActionEvent event) throws IOException {
        Parent sceneParent = FXMLLoader.load(getClass().getResource("bloodDonateProcess.fxml"));
        Scene scene = new Scene(sceneParent);
        Stage window = (Stage) menubarDonor.getScene().getWindow(); 
        window.setScene(scene);
        window.show();
    }

    @FXML
    private void viewAvailabeJobMItem(ActionEvent event) throws IOException {
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("viewAvailableJob.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage) menubarDonor.getScene().getWindow(); 
        window.setScene(scene1);
        window.show();
    }

    @FXML
    private void reportSubmissionBT(ActionEvent event) throws IOException {
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("reportSubmision.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow(); 
        window.setScene(scene1);
        window.show();
    }
    
}
