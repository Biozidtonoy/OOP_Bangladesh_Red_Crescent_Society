/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package startPage;


import helperClass.Utility;
import helperClass.loginData;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author tonoy
 */
public class RegisterSceneController implements Initializable {

  
    @FXML
    private TextField usernameTextF;
    @FXML
    private PasswordField passwordTF;
    @FXML
    private TextField emailTF;
    @FXML
    private DatePicker birthdayTF;
    @FXML
    private RadioButton maleRadio;
    @FXML
    private RadioButton femaleRadio;
    @FXML
    private RadioButton otherRadio;
    
    ToggleGroup tg =new ToggleGroup();
    Alert failure = new Alert(Alert.AlertType.WARNING, "Error, sign up failed!");
    Alert unfilled = new Alert(Alert.AlertType.WARNING,"Please Enter Everything!");
    Alert success = new Alert(Alert.AlertType.INFORMATION,"Congratulation your account has been created ");
//    Alert invalid = new Alert(Alert.AlertType.WARNING,"");
    @FXML
    private ComboBox<String> userTypeCB;
    
    
    /**
     *
     */
//    public static ArrayList<loginData> userDetails = new ArrayList<>();
//    public static ArrayList<String> username = new ArrayList<>();
//    public static ArrayList<String> userpass = new ArrayList<>();
   
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        maleRadio.setToggleGroup(tg);
        femaleRadio.setToggleGroup(tg);
        otherRadio.setToggleGroup(tg);
        userTypeCB.getItems().addAll("Director","Donor","Manager","Sponsor","Member","Treasure","Trainer","Volunteer","Media and publication","Event Organizer");
        
        
    }    

    @FXML
    private void signupButton(ActionEvent event) {
        String usertype = userTypeCB.getSelectionModel().getSelectedItem();
        String userName = usernameTextF.getText();
        String email = emailTF.getText();
        String userPass = passwordTF.getText();
        LocalDate birthday = birthdayTF.getValue();
        String gender = "";

        if(maleRadio.isSelected())
            gender = "male";
        else if( femaleRadio.isSelected())
            gender = "female";
        else if (otherRadio.isSelected())
            gender = " other";
        

        loginData L1;
        if (userTypeCB==null||userName.isEmpty()||email.isEmpty()||userPass.isEmpty()||birthday==null){
            unfilled.show();
            return;
        }
//        if (!email.contains("@")){
//            Alert mailError = new Alert(Alert.AlertType.WARNING, "email must have this character" + "@");
//            mailError.show();
//           
//        }
        L1= new loginData(usertype,userName,email,userPass,gender,birthday);
        if(L1.register(L1)){
            success.show();
           
        }else{
            failure.show();
        }
        userTypeCB.setValue(null);
        usernameTextF.clear();
        emailTF.clear();
        passwordTF.clear();
//        tg.selectToggle(null);
//        birthdayTF.setValue(null);
    
    }
    @FXML
    private void backButton(ActionEvent event) throws Exception {
        Utility.sceneSwitch (getClass(),event,"/startPage/loginScene.fxml");
    }

}
