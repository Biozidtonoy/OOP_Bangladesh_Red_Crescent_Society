package Sumya.EventOrganizer;

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
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

public class NextEventController implements Initializable {

    @FXML
    private TextField eventName;
    @FXML
    private DatePicker datepicker;
    @FXML
    private TableView<Event> eventatbleview;
    @FXML
    private TableColumn<Event, LocalDate> datecolumn;
    @FXML
    private TableColumn<Event, String> eventcolumn;
    private ArrayList<Event> userArr;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        userArr = new ArrayList<>();

        eventcolumn.setCellValueFactory(new PropertyValueFactory<>("eventName"));

        datecolumn.setCellValueFactory(new PropertyValueFactory<>("date"));

        eventatbleview.setItems(this.getUser());
        eventatbleview.setEditable(true);
        eventcolumn.setCellFactory(TextFieldTableCell.forTableColumn());
        eventatbleview.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

    @FXML
    private void eventcolumnonedit(CellEditEvent event) {
        Event userSelected = eventatbleview.getSelectionModel().getSelectedItem();
        userSelected.setEventName(event.getNewValue().toString());
    }

    @FXML
    private void savebuttononclick(ActionEvent event) {
        Event newUser = new Event(eventName.getText(), datepicker.getValue());
        eventatbleview.getItems().add(newUser);
    }

    @FXML
    private void backbuttononclick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("eventOrganizerDashboard.fxml"));
        Parent parent = loader.load();


        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();


        Scene nextScene = new Scene(parent);

        currentStage.setScene(nextScene);
        currentStage.show();
        
        // Your back button logic
    }

    private ObservableList<Event> getUser() {
        ObservableList<Event> Events = FXCollections.observableArrayList();

        Events.add(new Event("collecting donation for Gaza", LocalDate.of(2024, Month.APRIL, 28)));
        Events.add(new Event("A food distribution program among poor people", LocalDate.of(2024, Month.JUNE, 15)));

        return Events;
    }
}
