/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Sumaiya.Trainer;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Muntasir
 */
public class PieChartController implements Initializable {

    @FXML
    private PieChart pieChart;
    @FXML
    private TextField pollutionTextField;
    @FXML
    private TextField acidTextField;
    @FXML
    private TextField alkalineTextField;
    Alert invalid = new Alert(Alert.AlertType.WARNING, "Polluted Water");
    Alert unsuccesful = new Alert(Alert.AlertType.WARNING, "Try Again");
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    

    @FXML
    private void addButtonOnClick(ActionEvent event) {
       try {
        int pollution = Integer.parseInt(pollutionTextField.getText());
        int alkaline = Integer.parseInt(alkalineTextField.getText());
        int acid = Integer.parseInt(acidTextField.getText());

        pieChart.getData().clear();

        pieChart.getData().add(new PieChart.Data("Pollution", pollution));
        pieChart.getData().add(new PieChart.Data("Alkaline", alkaline));
        pieChart.getData().add(new PieChart.Data("Acid", acid));
        
        pollutionTextField.clear();
        alkalineTextField.clear();
        acidTextField.clear();
        if (pollution > 10 && alkaline > 14 && acid < 7) {
            invalid.show();
        }
    } catch (NumberFormatException e) {
        unsuccesful.show();

    }
    }

    @FXML
    private void goBackButtonOnClick(ActionEvent event) throws IOException {
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("waterCourse.fxml"));
        Parent parent = loader.load();
        Scene newScene = new Scene(parent);

        currentStage.setScene(newScene);
        currentStage.show();
    }
        
    
    
}
