package Sumya.MediaAndPublication;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

public class ReportController implements Initializable {
    
    private TableView<Report> reporttable;

    @FXML
    private TableColumn<Report, LocalDate> datecolumn;

    @FXML
    private TableColumn<Report, String> reportcolumn;

    @FXML
    private DatePicker datepicker;

    @FXML
    private TextField reporttextfield;

    private ArrayList<Report> userArr;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        userArr = new ArrayList<>();
        
        reportcolumn.setCellValueFactory(new PropertyValueFactory<>("Report"));
        datecolumn.setCellValueFactory(new PropertyValueFactory<>("Date"));
        
        reporttable.setItems(this.getUser());
        reporttable.setEditable(true);
        reportcolumn.setCellFactory(TextFieldTableCell.forTableColumn());
        
        reporttable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

    @FXML
    private void addreportonclick(ActionEvent event) {
        String reportText = reporttextfield.getText();
        LocalDate reportDate = datepicker.getValue();
        Report newReport = new Report(reportText, reportDate);
        reporttable.getItems().add(newReport);
    }
     
    

    private void reportcolumnonedit(TableColumn.CellEditEvent<Report, String> event) {
        Report userSelected = reporttable.getSelectionModel().getSelectedItem();
        userSelected.setReport(event.getNewValue());
    }

    @FXML
    private void backbuttononclick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("mediaPublicationDashboard.fxml"));
        Parent parent = loader.load();
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene nextScene = new Scene(parent);
        currentStage.setScene(nextScene);
        currentStage.show();
    }

    private ObservableList<Report> getUser() {
        ObservableList<Report> users = FXCollections.observableArrayList();
        
        users.add(new Report("hello", LocalDate.of(2002, Month.APRIL, 3)));
        users.add(new Report("hi", LocalDate.of(2005, Month.JUNE, 15)));
       
        return users;
    }  

}
