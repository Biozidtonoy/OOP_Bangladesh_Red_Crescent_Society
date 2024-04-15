/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Sazzad.Member;

import helperClass.Event;
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
public class EventRegistrationController implements Initializable {

    @FXML
    private TextField nameTextField;
    @FXML
    private TextField idTextField;
    @FXML
    private TextField emailTextField;
    @FXML
    private PasswordField passwordTextField;
    @FXML
    private RadioButton maleRadioButton;
    @FXML
    private RadioButton femaleRadioButton;
    @FXML
    private RadioButton othersRadioButton;
    
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
    }    

    @FXML
    private void nameMouseClickOnEvent(MouseEvent event) {
        nameTextField.setText(null);
    }

    @FXML
    private void idMouseClickOnEvent(MouseEvent event) {
        idTextField.setText(null);
    }

    @FXML
    private void emailMouseClickOnEvent(MouseEvent event) {
        emailTextField.setText(null);
    }

    @FXML
    private void passwordMouseClickOnEvent(MouseEvent event) {
        passwordTextField.setText(null);
    }

    @FXML
    private void registerActionButtonOnClick(ActionEvent event) {
         try{
            Event events = new Event(Integer.parseInt(idTextField.getText()),nameTextField.getText(),emailTextField.getText(),passwordTextField.getText());
             FileOutputStream fos = new FileOutputStream("event.bin", true);
             DataOutputStream dos = new DataOutputStream(fos);
             
             dos.writeInt(events.getId());
             dos.writeUTF(events.getName());
             dos.writeUTF(events.getEmail());
             dos.writeUTF(events.getPassword());  
             
         }catch (Exception e){
         }
    }

    @FXML
    private void backActionButtonOnClick(ActionEvent event) throws IOException {
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("eventScene.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow(); 
        window.setScene(scene1);
        window.show();
    }
    
}
