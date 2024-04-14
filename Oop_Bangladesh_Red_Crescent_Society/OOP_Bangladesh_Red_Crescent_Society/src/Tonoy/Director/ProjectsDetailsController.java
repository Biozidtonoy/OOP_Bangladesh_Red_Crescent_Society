/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Tonoy.Director;

import helperClass.projects;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author tonoy
 */
public class ProjectsDetailsController implements Initializable {

    @FXML
     Label projectsDetails;
    @FXML
     TextArea projectDetailsTA;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void backBT(ActionEvent event) throws IOException {
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("projects.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow(); 
        window.setScene(scene1);
        window.show();
    }

    void selectionDetails(projects selectedItem) {
        projectsDetails.setText(selectedItem.getProjectName());
        
//        String details = ""; 
//        details +=  "This is a sample project details for " + selectedItem.getProjectName() + ".";
//        projectDetailsTA.setText(details);
        
    }

    void setProjectDetails(String details) {
        projectDetailsTA.setText(details);
    }
    
    



    
    
}
