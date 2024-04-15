/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Sazzad.Member;

import helperClass.BloodDonate;
import helperClass.training;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class DonateBloodSceneController implements Initializable {

    @FXML
    private TextField nameTextField;
    @FXML
    private TextField donorIdTextField;
    @FXML
    private TextField phoneNumberTextField;
    @FXML
    private TextField eamilTextField;
    @FXML
    private TextField districtTextField;
    @FXML
    private ComboBox<String> bloodGroupComboBox;
    @FXML
    private RadioButton maleRadioButton;
    @FXML
    private RadioButton femaleRadioButton;
    @FXML
    private RadioButton othersRadioButton;
    @FXML
    private RadioButton yesRadioButton;
    @FXML
    private RadioButton noRadioButton;
    @FXML
    private PasswordField passwordTextField;

    ToggleGroup tg;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        maleRadioButton.setToggleGroup(tg);
        femaleRadioButton.setToggleGroup(tg);
        othersRadioButton.setToggleGroup(tg);
        
        yesRadioButton.setToggleGroup(tg);
        noRadioButton.setToggleGroup(tg);
        
        
        bloodGroupComboBox.getItems().addAll("AB+","AB-","A+","A-","B+","B-","O+","O-");
        
    }    
    

    @FXML
    private void nameMouseClickOnEvent(MouseEvent event) {
        nameTextField.setText(null);
    }

    @FXML
    private void idMouseClickOnEvent(MouseEvent event) {
        donorIdTextField.setText(null);
    }

    @FXML
    private void phoneNumberMouseClickOnEvent(MouseEvent event) {
        phoneNumberTextField.setText(null);
    }

    @FXML
    private void emailMouseClickOnEvent(MouseEvent event) {
        eamilTextField.setText(null);
    }

    @FXML
    private void districtMouseClickOnEvent(MouseEvent event) {
        districtTextField.setText(null);
    }
    
    @FXML
    private void passwordMouseClickOnEvent(MouseEvent event) {
        passwordTextField.setText(null);
    }

    @FXML
    private void saveActionButtonOnClick(ActionEvent event) {
        try{
            BloodDonate bloodDonate = new BloodDonate(Integer.parseInt(donorIdTextField.getText()),Integer.parseInt(phoneNumberTextField.getText()),nameTextField.getText(),
            passwordTextField.getText(),eamilTextField.getText(),districtTextField.getText(),bloodGroupComboBox.getValue());
             FileOutputStream fos = new FileOutputStream("BloodDonate.bin", true);
             DataOutputStream dos = new DataOutputStream(fos);
             
             
             dos.writeInt(bloodDonate.getId());
             dos.writeInt(bloodDonate.getPhoneNumber());
             dos.writeUTF(bloodDonate.getName());
             dos.writeUTF(bloodDonate.getPassword());
             dos.writeUTF(bloodDonate.getEamil());
             dos.writeUTF(bloodDonate.getDistrict());
             dos.writeUTF(bloodDonate.getBloodGroup());
              
             
         }catch (Exception e){
         }
    }

    @FXML
    private void backActionButtonOnClick(ActionEvent event) throws IOException {
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("bloodScene.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow(); 
        window.setScene(scene1);
        window.show();
    }

    
}
