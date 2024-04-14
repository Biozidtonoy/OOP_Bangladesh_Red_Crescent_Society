/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Sazzad.Treasurer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class PrepareSalaryController implements Initializable {

    @FXML
    private TextField idTextField;
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField hourTextField;
    @FXML
    private TextField hourlyRateTextField;
    @FXML
    private TableView<Salary> salaryTableView;
    @FXML
    private TableColumn<Salary, String> idTableColumn;
    @FXML
    private TableColumn<Salary, String> nameTableColumn;
    @FXML
    private TableColumn<Salary, String> hourlyRateTableColumn;
    @FXML
    private TableColumn<Salary, String> workHourTableColumn;
    @FXML
    private TextArea fileContentTextArea;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ArrayList<Object> salaryArr = new ArrayList<>();

        idTableColumn.setCellValueFactory(new PropertyValueFactory<Salary, String>("id"));
        nameTableColumn.setCellValueFactory(new PropertyValueFactory<Salary, String>("name"));
        hourlyRateTableColumn.setCellValueFactory(new PropertyValueFactory<Salary, String>("hourlyRate"));
        workHourTableColumn.setCellValueFactory(new PropertyValueFactory<Salary, String>("workHour"));
        

    }
    
     

    @FXML
    private void viewSalaryButtonOnClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("viewSalaryScene.fxml"));
        Parent salaryViewParent = loader.load();
        
        Scene salaryViewScene = new Scene(salaryViewParent);
        
        ViewSalarySceneController controller = loader.getController();
        controller.initData(salaryTableView.getSelectionModel().getSelectedItem());
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(salaryViewScene);
        window.show();
    }

    @FXML
    private void backButtonOnClick(ActionEvent event) throws IOException {
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("treasurerDashboard.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow(); 
        window.setScene(scene1);
        window.show();
    }

    @FXML
    private void addSalaryToListButton(ActionEvent event) {
        Salary salary = new Salary(nameTextField.getText(),Integer.parseInt(idTextField.getText()),Double.parseDouble(hourlyRateTextField.getText()),Double.parseDouble(hourTextField.getText()));
        salaryTableView.getItems().add(salary);
    }
    

    @FXML
    private void readSalaryButtonOnClick(ActionEvent event) {
        try{
            File f = new File("salary.bin");
            FileInputStream fis = new FileInputStream(f);
            DataInputStream dis = new DataInputStream(fis);
            
            
            fileContentTextArea.clear();
            
            while(true){
                fileContentTextArea.appendText("name:"+dis.readUTF()+"id:"+dis.readInt()+"hourlyRate"+dis.readDouble()+"workhour"+dis.readDouble()+"\n");     
            }   
        }catch (Exception e){
        }
    }

    @FXML
    private void addSalaryToFileButtonOnClick(ActionEvent event) {
        try {
            Salary salary = new Salary(nameTextField.getText(),Integer.parseInt(idTextField.getText()),Double.parseDouble(hourlyRateTextField.getText()),Double.parseDouble(hourTextField.getText()));
            FileOutputStream fos = new FileOutputStream("salary.bin", true);
            DataOutputStream dos = new DataOutputStream(fos);

            dos.writeUTF(salary.getName());
            dos.writeInt(salary.getId());
            dos.writeDouble(salary.getHourlyRate());
            dos.writeDouble(salary.getWorkHour());

        } catch (Exception e) {

        }

    }

    @FXML
    private void idMouseClickEvent(MouseEvent event) {
        idTextField.setText(null);
    }

    @FXML
    private void nameMouseClickEvent(MouseEvent event) {
         nameTextField.setText(null);
    }

    @FXML
    private void workHourMouseClickEvent(MouseEvent event) {
         hourTextField.setText(null);
    }

    @FXML
    private void hourlyRateMouseClickEvent(MouseEvent event) {
     hourlyRateTextField.setText(null);
    }

}
