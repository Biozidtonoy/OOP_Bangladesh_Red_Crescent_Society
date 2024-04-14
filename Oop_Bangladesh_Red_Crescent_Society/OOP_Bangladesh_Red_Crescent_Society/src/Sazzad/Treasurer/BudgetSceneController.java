///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
// */
//package Sazzad.Treasurer;
//
//import helperClass.Budget;
//import java.io.DataOutputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.net.URL;
//import java.util.ResourceBundle;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.fxml.Initializable;
//import javafx.scene.Node;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.control.ComboBox;
//import javafx.scene.control.Label;
//import javafx.scene.control.RadioButton;
//import javafx.scene.control.TextField;
//import javafx.stage.Stage;
//
///**
// * FXML Controller class
// *
// * @author HP
// */
//public class BudgetSceneController implements Initializable {
//
//    @FXML
//    private TextField revenueAmountTextField;
//    @FXML
//    private TextField expensesAmountTextField;
//    @FXML
//    private TextField remainingAmountTextField;
//    @FXML
//    private ComboBox<Budget> budgetComboBox;
//
//    /**
//     * Initializes the controller class.
//     */
////    @Override
////    public void initialize(URL url, ResourceBundle rb) {
////        // TODO
////        budgetComboBox.getItems().addAll("")
////        
////    }    
//
//
//
////    @FXML
////    private void backButtonOnClick(ActionEvent event) throws IOException {
////        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("treasurerDashboard.fxml"));
////        Scene scene1 = new Scene(mainSceneParent);
////        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow(); 
////        window.setScene(scene1);
////        window.show();
////    }
//
//    @FXML
//    private void addbudgetActionButtonOnClick(ActionEvent event) {
////         try{
////             Budget budget = new Budget(Double.parseDouble(revenueAmountTextField.getText()),Double.parseDouble(expensesAmountTextField.getText()),
////                     Double.parseDouble(remainingAmountTextField.getText()),budgetComboBox.getValue());
////             FileOutputStream fos = new FileOutputStream("budget.bin", true);
////             DataOutputStream dos = new DataOutputStream(fos);
////             
////             dos.writeDouble(budget.getRevenueAmount());
////             dos.writeDouble(budget.getExpensesAmount());
////             dos.writeDouble(budget.getRemainingAmount());
////             dos.writeUTF(budget.getBudget());
////             
////         }catch (Exception e){
////         }
////    }
////
////    @FXML
////    private void viewBudgetActionButtonOnClick(ActionEvent event) {
////        
////    }
////    
////}
