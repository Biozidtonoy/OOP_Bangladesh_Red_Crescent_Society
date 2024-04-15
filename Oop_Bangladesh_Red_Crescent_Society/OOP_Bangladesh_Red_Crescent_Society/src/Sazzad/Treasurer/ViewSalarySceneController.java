/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Sazzad.Treasurer;

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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class ViewSalarySceneController implements Initializable {

    @FXML
    private Label idLabel;
    @FXML
    private Label nameLabel;
    @FXML
    private Label hourlyRateLabel;
    @FXML
    private Label workHourLabel;
    @FXML
    private Label salaryLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    void initData(Salary selectedItem) {
        idLabel.setText(Integer.toString(selectedItem.getId()));
        nameLabel.setText(selectedItem.getName());
        hourlyRateLabel.setText(Double.toString(selectedItem.getHourlyRate()));
        workHourLabel.setText(Double.toString(selectedItem.getWorkHour()));
        salaryLabel.setText(Integer.toString(selectedItem.geSalary()));
    }

    @FXML
    private void backActionButtonOnClick(ActionEvent event) throws IOException {
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("prepareSalaryScene.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow(); 
        window.setScene(scene1);
        window.show();
    }
    
}
