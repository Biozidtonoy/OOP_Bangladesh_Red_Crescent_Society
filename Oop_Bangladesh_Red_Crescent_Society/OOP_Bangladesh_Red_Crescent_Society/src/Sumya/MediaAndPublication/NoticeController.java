/////*
//// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
//// * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
//// */
////package Sumya.MediaAndPublication;
////
////import java.net.URL;
////import java.util.ArrayList;
////import java.util.ResourceBundle;
////import javafx.event.ActionEvent;
////import javafx.fxml.FXML;
////import javafx.fxml.Initializable;
////import javafx.scene.control.DatePicker;
////import javafx.scene.control.TableColumn;
////import javafx.scene.control.TableView;
////import javafx.scene.control.TextField;
////
/////**
//// * FXML Controller class
//// *
//// * @author sumya
//// */
////public class NoticeController implements Initializable {
////
////    @FXML
////    private TableView<Media> noticetable;
////    @FXML
////    private TableColumn<Media, String> datecolumn;
////    @FXML
////    private TableColumn<Media, String> noticecoumn;
////    @FXML
////    private TextField noticetextfield;
////    @FXML
////    private DatePicker datepicker;
////    private ArrayList<Media> userArr;
////
////    /**
////     * Initializes the controller class.
////     */
////    @Override
////    public void initialize(URL url, ResourceBundle rb) {
////        // TODO // TODO
////        userArr = new ArrayList<Media>();
////        
////        noticeCoumn.setCellValueFactory(new PropertyValueFactory<Media, String>("Notice"));
////       
////        dateColumn.setCellValueFactory(new PropertyValueFactory<Media, LocalDate>("Date"));
////        
////        userTable.setItems(this.getUser());
////        userTable.setEditable(true);
////        noticeColumn.setCellFactory(TextFieldTableCell.forTableColumn());
////        
////        noticeTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
////        
////    }    
////
////    
////
////    @FXML
////    private void noticecolumnonedit(TableColumn.CellEditEvent)<S, T> event) {
////    rivate void noticecolumnonedit(TableColumn.CellEditEvent event) {
////        Media userSelected = noticeTable.getSelectionModel().getSelectedItem();
////        userSelected.setNotice(event.getNewValue().toString());
////    }
////
////    }
////
////    @FXML
////    private void addnoticebuttononclick(ActionEvent event) {
////        Media newUser = new Media(noticetextfield.getText(),datepicker.getValue());
////        noticeTable.getItems().add(newUser);
////    
////    }
////    
////
////    @FXML
////    private void backbuttononclick(ActionEvent event) {
////        FXMLLoader loader = new FXMLLoader(getClass().getResource("mediaPublicationDashboard.fxml"));
////        Parent parent = loader.load();
////
////
////        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
////
////
////        Scene nextScene = new Scene(parent);
////
////        currentStage.setScene(nextScene);
////        currentStage.show()
////  
////    }
////    
////    
////    
////}
//import Sumya.MediaAndPublication.Media;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.fxml.Initializable;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.control.DatePicker;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableView;
//import javafx.scene.control.TextField;
//import javafx.scene.control.cell.PropertyValueFactory;
//import javafx.scene.control.cell.TextFieldTableCell;
//import javafx.event.ActionEvent;
//import javafx.stage.Stage;
//
//import java.io.IOException;
//import java.net.URL;
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.ResourceBundle;
//
//public class NoticeController implements Initializable {
//
//    @FXML
//    private TableView<Media> noticetable;
//
//    @FXML
//    private TableColumn<Media, String> datecolumn;
//
//    @FXML
//    private TableColumn<Media, String> noticecolumn;
//
//    @FXML
//    private TextField noticetextfield;
//
//    @FXML
//    private DatePicker datepicker;
//
//    private ArrayList<Media> userArr;
//
//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//        userArr = new ArrayList<>();
//
//        noticecolumn.setCellValueFactory(new PropertyValueFactory<>("notice"));
//        datecolumn.setCellValueFactory(new PropertyValueFactory<>("date"));
//
//        noticetable.setItems(this.getUser());
//        noticetable.setEditable(true);
//        noticecolumn.setCellFactory(TextFieldTableCell.forTableColumn());
//
//        noticetable.getSelectionModel().setSelectionMode(javafx.scene.control.SelectionMode.MULTIPLE);
//    }
//
////    public ObservableList<Media> getUser() {
////        ObservableList<Media> users = FXCollections.observableArrayList();
////
////        users.add(new Media("Example Notice", LocalDate.now()));
////
////        return users;
////    }
//
//    @FXML
//    private void noticecolumnonedit(TableColumn.CellEditEvent<Media, String> event) {
//        Media noticeSelected = noticetable.getSelectionModel().getSelectedItem();
//        noticeSelected.setNotice(event.getNewValue());
//    }
//
//    @FXML
////    private void addnoticebuttononclick(ActionEvent event) {
////        Media newNotice = new Media(noticetextfield.getText(), datepicker.getValue());
////        noticetable.getItems().add(newNotice);
////    }
//    
////  private void addnoticebuttononclick(ActionEvent event) {
////    String noticeText = noticetextfield.getText();
////    LocalDate noticeDate = datepicker.getValue();
////    Media newNotice = new Media(noticeText, noticeDate);
////    noticetable.getItems().add(newNotice);
////}

    
// private void addnoticebuttononclick(ActionEvent event) {
//    String noticeText = noticetextfield.getText();
//    LocalDate noticeDate = datepicker.getValue();
//    Media newNotice = new Media(noticeText, noticeDate);
//    noticetable.getItems().add(newNotice);
//}
 import Sumya.MediaAndPublication.Media;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.control.SelectionMode;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class NoticeController implements Initializable {

    @FXML
    private TableView<Media> noticetable;
    @FXML
    private TableColumn<Media, String> datecolumn;
    @FXML
    private TableColumn<Media, String> noticecolumn;
    @FXML
    private TextField noticetextfield;
    @FXML
    private DatePicker datepicker;

    private ArrayList<Media> noticeList;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        noticeList = new ArrayList<>();

        datecolumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        noticecolumn.setCellValueFactory(new PropertyValueFactory<>("notice"));

        noticetable.setItems(getNoticeData());
        noticetable.setEditable(true);
        noticecolumn.setCellFactory(TextFieldTableCell.forTableColumn());

        noticetable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

    public ObservableList<Media> getNoticeData() {
        ObservableList<Media> noticeData = FXCollections.observableArrayList();
        // Add initial data to the noticeData list
        // Example:
        // noticeData.add(new Media("Initial Notice", LocalDate.now()));
        return noticeData;
    }

    @FXML
    private void noticecolumnonedit(TableColumn.CellEditEvent<Media, String> event) {
        Media selectedNotice = noticetable.getSelectionModel().getSelectedItem();
        selectedNotice.setNotice(event.getNewValue());
    }

    @FXML
    private void addnoticebuttononclick(ActionEvent event) {
        String noticeText = noticetextfield.getText();
        LocalDate noticeDate = datepicker.getValue();
        Media newNotice = new Media(noticeText, "", "", noticeDate);
        noticetable.getItems().add(newNotice);
    }

    @FXML
    private void backbuttononclick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("mediaPublicationDashboard.fxml"));
        Parent parent = loader.load();

        Stage currentStage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();

        Scene nextScene = new Scene(parent);

        currentStage.setScene(nextScene);
        currentStage.show();
    }
}




//    @FXML
//    private void backbuttononclick(ActionEvent event) throws IOException {
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("mediaPublicationDashboard.fxml"));
//        Parent parent = loader.load();
//
//        Stage currentStage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
//
//        Scene nextScene = new Scene(parent);
//
//        currentStage.setScene(nextScene);
//        currentStage.show();
//    }
//}
