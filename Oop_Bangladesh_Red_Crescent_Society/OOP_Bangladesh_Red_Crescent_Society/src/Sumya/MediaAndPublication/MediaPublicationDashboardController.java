/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Sumya.MediaAndPublication;

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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author sumya
 */
public class MediaPublicationDashboardController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void NewsbuttonOnclick(ActionEvent event) throws IOException {
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("News.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow(); 
        window.setScene(scene1);
        window.show();
    }

    @FXML
    private void NoticebuttonOnclick(ActionEvent event) throws IOException { 
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Notice.fxml"));
        Parent parent = loader.load();

        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene nextScene = new Scene(parent);

        currentStage.setScene(nextScene);
        currentStage.show();
        
        
    }
    

        

    @FXML
    void ReportbuttonOnclick(ActionEvent event) throws IOException {
         Parent mainSceneParent = FXMLLoader.load(getClass().getResource("Report.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow(); 
        window.setScene(scene1);
        window.show();

    }

    @FXML
    void historybuttononclick(ActionEvent event) throws IOException {
     FXMLLoader loader = new FXMLLoader(getClass().getResource("History.fxml"));
        Parent parent = loader.load();


        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();


        Scene nextScene = new Scene(parent);

        currentStage.setScene(nextScene);
        currentStage.show();
    }

    @FXML
    void logoutbuttonclick(ActionEvent event) throws IOException {
     FXMLLoader loader = new FXMLLoader(getClass().getResource("/mainpkg/startScene.fxml"));
        Parent parent = loader.load();


        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();


        Scene nextScene = new Scene(parent);

        currentStage.setScene(nextScene);
        currentStage.show();
    }

    @FXML
    void missionandvisionbuttononclick(ActionEvent event) throws IOException {  
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MissionAndVision.fxml"));
        Parent parent = loader.load();


        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();


        Scene nextScene = new Scene(parent);

        currentStage.setScene(nextScene);
        currentStage.show();

    }

    @FXML
    void policybuttononclick(ActionEvent event) throws IOException {
     FXMLLoader loader = new FXMLLoader(getClass().getResource("Policy.fxml"));
        Parent parent = loader.load();


        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Scene nextScene = new Scene(parent);

       currentStage.setScene(nextScene);
       currentStage.show();
  }
//    @FXML
//   void policybuttononclick(ActionEvent event) throws IOException {
//    Parent mainSceneParent = FXMLLoader.load(getClass().getResource("Policy.fxml"));
//        Scene scene1 = new Scene(mainSceneParent);
//        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow(); 
//        window.setScene(scene1);
//        window.show();
//   }
}
   

