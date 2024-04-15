//import Sumya.MediaAndPublication.Media;
//import javafx.scene.control.cell.PropertyValueFactory;
//import javafx.scene.control.cell.TextFieldTableCell;
//import javafx.scene.control.SelectionMode;
//
//import java.io.IOException;
//import java.net.URL;
//import java.time.LocalDate;
//import java.time.Month;
//import java.util.ArrayList;
//import java.util.ResourceBundle;
//
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.fxml.Initializable;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.control.DatePicker;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableView;
//import javafx.scene.control.TextField;
//import javafx.scene.input.MouseEvent;
//import javafx.stage.Stage;
//
//public class NewsController implements Initializable {
//
//    @FXML
//    private DatePicker birthdaypicker;
//    @FXML
//    private TextField newstextfield;
//    @FXML
//    private TableView<Media> newstable;
//    @FXML
//    private TableColumn<Media, LocalDate> datecolumn;
//    @FXML
//    private TableColumn<Media, String> newscolumn;
//
//    private ArrayList<Media> userArr;
//
//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//        userArr = new ArrayList<>();
//
//        newscolumn.setCellValueFactory(new PropertyValueFactory<>("news"));
//        datecolumn.setCellValueFactory(new PropertyValueFactory<>("date"));
//
//        newstable.setItems(this.getUser());
//        newstable.setEditable(true);
//        newscolumn.setCellFactory(TextFieldTableCell.forTableColumn());
//
//        newstable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
//    }
//
//    public ObservableList<Media> getUser() {
//        ObservableList<Media> users = FXCollections.observableArrayList();
//
//        users.add(new Media("BDRCS Chottogram District’s Ramadan Activities", "", "", LocalDate.of(2024, Month.APRIL, 3)));
//        users.add(new Media("Workshop on Shock Responsive Social Protection in AA", "", "", LocalDate.of(2023, Month.APRIL, 15)));
//
//        return users;
//    }
//
//    @FXML
//    private void birthdayonmouseclicked(MouseEvent event) {
//        birthdaypicker.setValue(LocalDate.now());
//    }
//
//    @FXML
//    private void newscolumnonedit(TableColumn.CellEditEvent<Media, String> event) {
//        Media userSelected = newstable.getSelectionModel().getSelectedItem();
//        userSelected.setNews(event.getNewValue());
//    }
//
//    @FXML
//    private void addnewsonclick(ActionEvent event) {
//        Media newUser = new Media(newstextfield.getText(), birthdaypicker.getValue());
//        newstable.getItems().add(newUser);
//    }
//
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
////}
//import Sumya.MediaAndPublication.Media;
//import Sumya.MediaAndPublication.News;
//import javafx.scene.control.cell.PropertyValueFactory;
//import javafx.scene.control.cell.TextFieldTableCell;
//import javafx.scene.control.SelectionMode;
//
//import java.io.IOException;
//import java.net.URL;
//import java.time.LocalDate;
//import java.time.Month;
//import java.util.ArrayList;
//import java.util.ResourceBundle;
//
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.fxml.Initializable;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.control.DatePicker;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableView;
//import javafx.scene.control.TextField;
//import javafx.scene.input.MouseEvent;
//import javafx.stage.Stage;
//
//public class NewsController implements Initializable {
//
//    @FXML
//    private DatePicker birthdaypicker;
//    @FXML
//    private TextField newstextfield;
//    @FXML
//    private TableView<Media> newstable;
//    @FXML
//    private TableColumn<Media, LocalDate> datecolumn;
//    @FXML
//    private TableColumn<Media, String> newscolumn;
//
//    private ArrayList<News> userArr;
//
//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//        userArr = new ArrayList<>();
//
//        newscolumn.setCellValueFactory(new PropertyValueFactory<>("news"));
//        datecolumn.setCellValueFactory(new PropertyValueFactory<>("date"));
//
//        newstable.setItems(getUser());
//        newstable.setEditable(true);
//        newscolumn.setCellFactory(TextFieldTableCell.forTableColumn());
//
//        newstable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
//    }
//
//    private ObservableList<News> getUser() {
//        ObservableList<News> users = FXCollections.observableArrayList();
//
//        users.add(new News("BDRCS Chottogram District’s Ramadan Activities",  LocalDate.of(2024, Month.APRIL, 3)));
//        users.add(new News("Workshop on Shock Responsive Social Protection in AA", LocalDate.of(2023, Month.APRIL, 15)));
//
//        return users;
//    }
//
//    @FXML
//    private void birthdayonmouseclicked(MouseEvent event) {
//        birthdaypicker.setValue(LocalDate.now());
//    }
//
//    @FXML
//    private void newscolumnonedit(TableColumn.CellEditEvent<News, String> event) {
//        Media userSelected = newstable.getSelectionModel().getSelectedItem();
//        userSelected.setNews(event.getNewValue());
//    }
//
//     
//
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
import Sumya.MediaAndPublication.Media;
import Sumya.MediaAndPublication.News;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.ResourceBundle;

public class NewsController implements Initializable {

    @FXML
    private DatePicker birthdaypicker;
    @FXML
    private TextField newstextfield;
    @FXML
    private TableView<News> newstable;
    @FXML
    private TableColumn<News, LocalDate> datecolumn;
    @FXML
    private TableColumn<News, String> newscolumn;

    private ObservableList<News> newsList;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        newsList = FXCollections.observableArrayList();
        
        // Set up columns
        newscolumn.setCellValueFactory(new PropertyValueFactory<>("news"));
        datecolumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        
        // Populate table with initial data
        newsList.addAll(
            new News("BDRCS Chottogram District’s Ramadan Activities",  LocalDate.of(2024, Month.APRIL, 3)),
            new News("Workshop on Shock Responsive Social Protection in AA", LocalDate.of(2023, Month.APRIL, 15))
        );
        newstable.setItems(newsList);
        
        // Enable cell editing
        newstable.setEditable(true);
        newscolumn.setCellFactory(TextFieldTableCell.forTableColumn());
    }

    @FXML
    private void birthdayonmouseclicked(MouseEvent event) {
        birthdaypicker.setValue(LocalDate.now());
    }

    @FXML
    private void newscolumnonedit(TableColumn.CellEditEvent<News, String> event) {
        News news = event.getRowValue();
        news.setNews(event.getNewValue());
    }

    @FXML
    private void backbuttononclick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("mediaPublicationDashboard.fxml"));
        Scene nextScene = new Scene(parent);

        Stage currentStage = (Stage) newstable.getScene().getWindow();
        currentStage.setScene(nextScene);
        currentStage.show();
    }
}
