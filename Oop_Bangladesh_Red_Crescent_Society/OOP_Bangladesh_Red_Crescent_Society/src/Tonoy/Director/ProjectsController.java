/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Tonoy.Director;

import helperClass.projects;
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
public class ProjectsController implements Initializable {

    @FXML
    private TableView<projects> projectsTV;
    @FXML
    private TableColumn<projects, String> projectsNameTC;
    Alert select = new Alert(Alert.AlertType.WARNING,"please select donation center");

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          projectsNameTC.setCellValueFactory(new PropertyValueFactory<projects,String>("projectName"));
          projectsTV.setItems(this.projectNameList());
          
    } 
    public ObservableList<projects> projectNameList() {
        ObservableList<projects> projectNames = FXCollections.observableArrayList();
        projectNames.add(new projects("disaster response capacity building"));
        projectNames.add(new projects("disaster preparedness expansion"));
        projectNames.add(new projects("healthcare activities"));
        
        return projectNames;
    
    }

    @FXML
    private void backBT(ActionEvent event) throws IOException {
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("directorDashboard.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow(); 
        window.setScene(scene1);
        window.show();
    }

    @FXML
    private void nextBT(ActionEvent event) throws IOException {
         if (projectsTV.getSelectionModel().isEmpty()) {
            select.showAndWait();
        } else {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("projectsDetails.fxml"));
            Parent mainSceneParent = loader.load();

            Scene userViewScene = new Scene(mainSceneParent);

            ProjectsDetailsController d = loader.getController();
            
             projects selectedProject = projectsTV.getSelectionModel().getSelectedItem();
             d.selectionDetails(selectedProject);

            
             String details = ProjectDetails(selectedProject.getProjectName());
             d.setProjectDetails(details);

//            d.selectionDetails(projectsTV.getSelectionModel().getSelectedItem());
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(userViewScene);
            window.show();
        }
        
    }

    
    
    private String ProjectDetails(String projectName) {
        
        if (projectName.equals("disaster response capacity building")) {
            return " This is a sample project details for disaster response capacity building.\n"
                    + "Capacity building is an ongoing process that equips officials, \n"
                    + "stakeholders and the community to perform their functions in a better manner during a crisis/disaster.";
        } else if (projectName.equals("disaster preparedness expansion")) {
            return " This is a sample project details for disaster preparedness expansion.\n"
                    + "Preparing for disasters saves countless lives, speeds up people's recovery and saves money. \n"
                    + "The IFRC supports National Societies to continually improve their local preparedness and \n"
                    + "response capacity—ultimately preventing and reducing the impacts of disasters on communities.";
        } else if (projectName.equals("healthcare activities")) {
            return "This is a sample project details for healthcare activities.";
        } else {
            return "No details available for the selected project.";
        }
    }

    
}
