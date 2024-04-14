/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Sazzad.Treasurer;

import Users.Treasurer;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class AddExpensesSceneController implements Initializable {

    @FXML
    private TextField idTextField;
    @FXML
    private TextField amountTextField;
    @FXML
    private ComboBox<String> spendReasonComboBox;
    @FXML
    private DatePicker datePicker;
    @FXML
    private TextField detailsTextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         ObservableList<String> items = FXCollections.observableArrayList(
                "Program Expenses","Financial Expenses","Asset Investments","Training and Capacity Building Expenses"
        );

        spendReasonComboBox.setItems(items);
    }    

    @FXML
    private void addActionButtonOnClick(ActionEvent event) throws IOException {
        int id = Integer.parseInt(idTextField.getText());
      String amountText = amountTextField.getText();
      String itemSpentOn = spendReasonComboBox.getValue();
      LocalDate dateSpent = datePicker.getValue();
      String details = detailsTextField.getText();
        
    }
    
    
    @FXML
    private void viewExpensesActionButtonOnClick(ActionEvent event) throws IOException {
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("viewExpensesScene.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow(); 
        window.setScene(scene1);
        window.show();
        

    }

    @FXML
    private void backActionButtonOnClick(ActionEvent event) throws IOException {
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("treasurerDashboard.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow(); 
        window.setScene(scene1);
        window.show();
    }

    
}
