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
public class BdrcActivitiesController implements Initializable {

    @FXML
    private TextArea textAreaTF;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       textAreaTF.setText("\"Welcome to the Bangladesh Red Crescent Society (BDRCS) donation activities section.\n"
               + " Your interest in supporting our humanitarian efforts is greatly appreciated. \n"
               + "Here's a detailed overview of how your donations make a significant impact:\n" +
"1.	Emergency Response: Your donations ensure swift and effective responses to emergencies \n"
               + "such as natural disasters, conflicts, and health crises. They enable us \n"
               + "to provide immediate relief and assistance to affected communities.\n" +
"2.	Healthcare Services: Your contributions support the operation of healthcare facilities, \n"
               + "including hospitals, clinics, and mobile medical units. They help us procure essential \n"
               + "medical supplies, equipment, and medication to provide quality healthcare to those in need.\n" +
"3.	Disaster Preparedness: Your donations fund disaster preparedness programs \n"
               + "aimed at educating communities and enhancing their resilience. They enable\n"
               + " us to conduct training sessions, drills, and awareness campaigns to mitigate the impact of disasters.\n" +
"4.	Community Development: Your support empowers marginalized communities through \n"
               + "various development projects. Your donations fund initiatives such as \n"
               + "livelihood programs, vocational training, and infrastructure development, \n"
               + "fostering sustainable development and improving living standards.\n" +
"5.	Humanitarian Aid: Your contributions enable us to provide humanitarian aid to refugees, \n"
               + "internally displaced persons (IDPs), and other vulnerable groups. They help \n"
               + "us procure and distribute essential items such as food, shelter materials, \n"
               + "and hygiene kits to those in need.\n" +
"6.	Blood Donation Campaigns: Your donations save lives by supporting our blood donation drives.\n"
               + " They help us maintain an adequate supply of blood for medical emergencies and life-saving procedures.\n" +
"7.	Education and Awareness: Your support enables us to conduct educational \n"
               + "campaigns on health, hygiene, disaster preparedness, and humanitarian principles. Your donations fund the production of educational materials and the organization of awareness-raising events.\n" +
"8.	Capacity Building: Your contributions facilitate the training of staff and volunteers,\n"
               + " enhancing their skills in emergency response, healthcare, and community development. \n"
               + "They enable us to organize training workshops and provide educational \n"
               + "resources to strengthen our workforce.\n" +
"9.	Technology and Innovation: Your donations support the adoption of technology and innovation\n"
               + " to improve the efficiency and effectiveness of our operations. They help us develop \n"
               + "innovative solutions to humanitarian challenges and enhance our ability to serve communities in need.\n" +
"10.	Partnerships and Collaborations: Your support enables us to collaborate\n"
               + " with local and international partners to maximize our impact. Your donations contribute to joint initiatives and support collaborative efforts to address humanitarian needs effectively.\n" +
"Thank you for considering donating to the Bangladesh Red Crescent Society. \n"
               + "Your generosity makes a meaningful difference in the lives of vulnerable\n"
               + " communities across Bangladesh. Together, we can create a brighter and more \n"
               + "resilient future for all.\"");
       
 
       
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
