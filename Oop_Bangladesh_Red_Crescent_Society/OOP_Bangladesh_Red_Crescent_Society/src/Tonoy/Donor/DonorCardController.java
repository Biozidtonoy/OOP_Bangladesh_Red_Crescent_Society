/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Tonoy.Donor;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.color.ColorConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.List;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Text;
import helperClass.DonorCard;
import helperClass.bloodCenter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author tonoy
 */
public class DonorCardController implements Initializable {

    @FXML
     Label donorCardNoLabelTF;
    @FXML
    private TextField nameTF;
    @FXML
    private TextField numberTF;
    @FXML
    private TextField emailTF;
    @FXML
    private TextField districtTF;
    @FXML
    private TextField adressTF;
    @FXML
    private TextField weightTF;
    @FXML
    private TextField ageTF;
    @FXML
    private ComboBox<String> bloodGroupTF;
    @FXML
    private Label districtLabel;
    @FXML
    private Label bloodCenterLabel;
    @FXML
    private Label inChargeLAbel;
    @FXML
    private Label locationLabel;
    @FXML
    private Label hotLineLabel;
    
    Alert success = new Alert(Alert.AlertType.INFORMATION,"please download the donor card");
    Alert unfilled = new Alert(Alert.AlertType.WARNING,"Please Enter Everything!");
    Alert cancel = new Alert(Alert.AlertType.WARNING,"your donation has cancelled");
    public static ArrayList<DonorCard> donorCardList = new ArrayList<DonorCard>();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        bloodGroupTF.getItems().addAll("AB+","AB-","A+","A-","B+","B-","O+","O-");
    }    

    @FXML
    private void backBT(ActionEvent event) throws IOException {
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("bloodDonation.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow(); 
        window.setScene(scene1);
        window.show();
    }

    @FXML
    private void confirmBT(ActionEvent event) {
        
        try {
            Integer age = Integer.parseInt(ageTF.getText().trim());
            Integer number = Integer.parseInt(numberTF.getText().trim());
            Integer weight = Integer.parseInt(weightTF.getText().trim());
            String name = nameTF.getText().trim();
            String email = emailTF.getText().trim();
            String district = districtTF.getText().trim();
            String adress = adressTF.getText().trim();
            String bloodGroup = bloodGroupTF.getValue();
            if (!email.contains("@")) {
                Alert validEmail = new Alert(Alert.AlertType.ERROR, "please use valid email ");
                validEmail.show();
                return;
            }
            
           if (age < 18 || age > 65) {
            Alert ageAlert = new Alert(Alert.AlertType.ERROR, "Your age must be between 18 and 65.");
            ageAlert.show();
            return;
        }

            if (age == null|| number == null || name.isEmpty() || email.isEmpty()|| district.isEmpty()||adress.isEmpty()
                    || weight == null || bloodGroupTF == null) {
                unfilled.show();
                return;

            }
            DonorCard dc1 = new DonorCard(name, email, district, adress,bloodGroup, weight, age,number);
            donorCardList.add(dc1);
            dc1.getDonorCard(dc1);
            
            success.show();

           
        } catch (Exception e) {
            System.out.println("try block didnt execute");
        }
        
        
        
    }

    @FXML
    private void cancelBT(ActionEvent event) {
    }

    void selectionDetails(bloodCenter selectedItem) {
        districtLabel.setText(selectedItem.getDistrict());
        bloodCenterLabel.setText(selectedItem.getBloodCenterName());
        locationLabel.setText(selectedItem.getLocation());
        inChargeLAbel.setText(selectedItem.getVolunteerName());
        hotLineLabel.setText(selectedItem.getNumber());
    }

    @FXML
    private void downloadBT(ActionEvent event) {
             try {
            FileChooser fc = new FileChooser();
            fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF files", "*.pdf"));
            File f = fc.showSaveDialog(null);
            if (f != null) {
                PdfWriter pw = new PdfWriter(new FileOutputStream(f));
                PdfDocument pdf = new PdfDocument(pw);
                Document document = new Document(pdf);

                PdfFont font = PdfFontFactory.createFont();
                
                Paragraph title1 = new Paragraph("Blood Center Details ")
                        .setFont(font)
                        .setFontSize(20)
                        .setFontColor(ColorConstants.RED)
                        .setBold();
                document.add(title1);
                
                
                document.add(new Paragraph("bloodCenter  : " + bloodCenterLabel.getText()));
                document.add(new Paragraph("district     : " + districtLabel.getText()));
                document.add(new Paragraph("inCharge     : " + inChargeLAbel.getText()));
                document.add(new Paragraph("location     : " + locationLabel.getText()));
                document.add(new Paragraph("hotLine      : " + hotLineLabel.getText()));

                Paragraph title = new Paragraph("Donor Card Information")
                        .setFont(font)
                        .setFontSize(20)
                        .setFontColor(ColorConstants.RED)
                        .setBold();
                document.add(title);
                
                document.add(new Paragraph("Donor Card No: " + donorCardNoLabelTF.getText()));
                document.add(new Paragraph("Name: " + nameTF.getText()));
                document.add(new Paragraph("Number: " + numberTF.getText()));
                document.add(new Paragraph("Email: " + emailTF.getText()));
                document.add(new Paragraph("District: " + districtTF.getText()));
                document.add(new Paragraph("Address: " + adressTF.getText()));
                document.add(new Paragraph("Weight: " + weightTF.getText()));
                document.add(new Paragraph("Age: " + ageTF.getText()));
                document.add(new Paragraph("Blood Group: " + bloodGroupTF.getValue()));

                document.close();

                Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
                successAlert.setTitle("Success");
                successAlert.setHeaderText(null);
                successAlert.setContentText("Donor card information saved as PDF: " + f.getAbsolutePath());
                successAlert.showAndWait();
            }
        } catch (IOException e) {
            e.printStackTrace();
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Error");
            errorAlert.setHeaderText(null);
            errorAlert.setContentText("Error occurred while saving the PDF.");
            errorAlert.showAndWait();
        }
    }
        
       
}
