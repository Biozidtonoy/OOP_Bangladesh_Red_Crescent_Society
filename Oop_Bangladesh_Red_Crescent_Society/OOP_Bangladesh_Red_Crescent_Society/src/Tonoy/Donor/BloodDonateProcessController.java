/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Tonoy.Donor;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author tonoy
 */
public class BloodDonateProcessController implements Initializable {

    @FXML
    private TextArea textAreaTF;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      textAreaTF.setText("1.	Select Blood Center: To begin the blood donation process, you can choose a nearby \n"
              + "Bangladesh Red Crescent Society blood center where you'll be donating. \n"
              + "These centers are strategically located to ensure convenient access for donors across the country.\n" +
"2.	Receive Donor Card: As a token of appreciation for your donation, you'll receive a donor card \n"
              + " from the Bangladesh Red Crescent Society. This card serves as a record \n"
              + "of your donation and may entitle you to certain benefits or privileges in the future.\n" +
"3.	Make an Appointment: Once you've selected a blood center, you can either walk in during operating\n"
              + " hours or make an appointment for your donation. Making an appointment ensures that \n"
              + "the blood center staff can accommodate your donation without long waiting times.\n" +
"4.	Medical Examination: A qualified healthcare professional will conduct a brief medical \n"
              + "examination to assess your overall health and suitability for blood donation. \n"
              + "This may involve checking your pulse, temperature, and conducting a physical examination.\n" +
"5.	Post-Donation Refreshments: After donating blood, you'll be offered refreshments to \n"
              + "replenish fluids and restore energy levels. It's essential to rest for a \n"
              + "short while and hydrate adequately before resuming normal activities.\n" +
"6.	Follow-up Communication: The blood center may follow up with you after your donation\n"
              + " to ensure you're feeling well and to provide any additional information or support you may need.\n" +
"\n" +
"By following these steps, you can make a meaningful contribution to saving lives and supporting \n"
              + "healthcare initiatives through blood donation with the Bangladesh Red Crescent Society. \n"
              + "Your generosity helps ensure a stable supply of blood for patients in need across the country.\n"
              + " Thank you for considering blood donation as a way to make a difference in your community.\n" +
"");
      
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
