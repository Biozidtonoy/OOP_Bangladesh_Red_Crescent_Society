/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Tonoy.Director;

import helperClass.Report;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author tonoy
 */
public class ViewReportController implements Initializable {

    @FXML
    private TableView<Report> reportTV;
    @FXML
    private TableColumn<Report , String> userTypeTC;
    @FXML
    private TableColumn<Report , String> nameTC;
    @FXML
    private TableColumn<Report , String> reportContentTC;
    Alert select = new Alert(Alert.AlertType.WARNING,"please select the report ");


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nameTC.setCellValueFactory(new PropertyValueFactory<Report,String>("name"));
        userTypeTC.setCellValueFactory(new PropertyValueFactory<Report,String>("usertype"));
        reportContentTC.setCellValueFactory(new PropertyValueFactory<Report,String>("reportContent"));
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
        if (reportTV.getSelectionModel().isEmpty()) {
            select.showAndWait();
        } else {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("reportDetails.fxml"));
            Parent mainSceneParent = loader.load();

            Scene userViewScene = new Scene(mainSceneParent);

            ReportDetailsController d = loader.getController();          
            d.selectionDetails(reportTV.getSelectionModel().getSelectedItem());
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(userViewScene);
            window.show();
        }
    }

    @FXML
    private void viewLatestReportsBT(ActionEvent event) {
        ObservableList<Report> ReportList = Report.readReportList1();
        System.out.println(ReportList);
        reportTV.setItems(ReportList);
    }
    
}
