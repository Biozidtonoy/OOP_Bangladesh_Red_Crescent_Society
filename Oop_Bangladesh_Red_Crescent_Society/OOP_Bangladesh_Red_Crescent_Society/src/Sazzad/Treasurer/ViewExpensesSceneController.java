/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Sazzad.Treasurer;

import Users.Treasurer;
import helperClass.Expenses;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class ViewExpensesSceneController implements Initializable {

    @FXML
    private TableView<Expenses> expensesRecordTableView;
    @FXML
    private TableColumn<Expenses, String> idTableColumn;
    @FXML
    private TableColumn<Expenses, String> amountTableColumn;
    @FXML
    private TableColumn<Expenses, String> spentOnTableColumn;
    @FXML
    private TableColumn<Expenses, String> spentDateTableColumn;
    @FXML
    private Label detailsTextFiled;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        idTableColumn.setCellValueFactory(new PropertyValueFactory<Expenses, String>("id"));
        amountTableColumn.setCellValueFactory(new PropertyValueFactory<Expenses, String>("amount"));
        spentOnTableColumn.setCellValueFactory(new PropertyValueFactory<Expenses, String>("spentOn"));
        spentDateTableColumn.setCellValueFactory(new PropertyValueFactory<Expenses, String>("date"));
        
        
    }    

    @FXML
    private void backActionButtonOnClick(ActionEvent event) throws IOException {
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("addExpensesScene.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow(); 
        window.setScene(scene1);
        window.show();
    }

    @FXML
    private void viewDetailsActionButtonOnClick(ActionEvent event) {
        Expenses selectedRecord = expensesRecordTableView.getSelectionModel().getSelectedItem();
    
    if (selectedRecord != null) {
       
        detailsTextFiled.setText(selectedRecord.getDetails());
    }
    }
    
}
