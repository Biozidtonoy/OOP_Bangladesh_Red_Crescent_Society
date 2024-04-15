/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Sazzad.Member;

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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class VolunteerSceneController implements Initializable {

    @FXML
    private TextField nameTextField;
    @FXML
    private TextField phoneNumberTextField;
    @FXML
    private TextField emailTextField;
    @FXML
    private TextField districtTextField;
    @FXML
    private PasswordField passwordTextField;
    @FXML
    private PasswordField confirmTextField;
    @FXML
    private RadioButton maleRadioButton;
    @FXML
    private RadioButton femaleRadioButton;
    @FXML
    private RadioButton othersRadioButton;
    @FXML
    private ComboBox<String> bloodGroupComboBox;
    @FXML
    private TextArea aboutTextArea;

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
        
        bloodGroupComboBox.getItems().addAll("AB+","AB-","A+","A-","B+","B-","O+","O-");
        
        
    }    

    @FXML
    private void nameMouseClickOnEvent(MouseEvent event) {
        nameTextField.setText(null);
    }

    @FXML
    private void phoneNumberMouseClickOnEvent(MouseEvent event) {
        phoneNumberTextField.setText(null);
    }

    @FXML
    private void emailMouseClickOnEvent(MouseEvent event) {
        emailTextField.setText(null);
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
    private void confirmMouseClickOnEvent(MouseEvent event) {
        confirmTextField.setText(null);
    }

    @FXML
    private void aboutMouseClickOnEvent(MouseEvent event) {
        aboutTextArea.setText(null);
    }

    @FXML
    private void saveActionButtonOnClick(ActionEvent event) {
        try{
            training Training = new training(Integer.parseInt(phoneNumberTextField.getText()),nameTextField.getText(),emailTextField.getText(),
                    districtTextField.getText(),passwordTextField.getText(),confirmTextField.getText(),bloodGroupComboBox.getValue(),aboutTextArea.getText());
             FileOutputStream fos = new FileOutputStream("budget.bin", true);
             DataOutputStream dos = new DataOutputStream(fos);
             
             dos.writeInt(Training.getPhoneNumber());
             dos.writeUTF(Training.getName());
             dos.writeUTF(Training.getEamil());
             dos.writeUTF(Training.getDistrict());
             dos.writeUTF(Training.getPassword());
             dos.writeUTF(Training.getConfirm());
             dos.writeUTF(Training.getBloodGroup());
             dos.writeUTF(Training.getAbout());
             
             
         }catch (Exception e){
         }
    }

    @FXML
    private void backActionButtonOnClick(ActionEvent event) throws IOException {
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("memberDashboard.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow(); 
        window.setScene(scene1);
        window.show();
    }
    
}
