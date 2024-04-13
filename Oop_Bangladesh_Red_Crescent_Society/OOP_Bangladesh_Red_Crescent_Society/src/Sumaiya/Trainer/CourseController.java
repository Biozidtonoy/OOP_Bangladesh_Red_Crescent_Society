/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Sumaiya.Trainer;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.colors.Color;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import static com.itextpdf.kernel.pdf.PdfName.Color;
import static com.itextpdf.kernel.pdf.PdfName.a;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.IBlockElement;
import com.itextpdf.layout.element.IElement;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.List;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Text;
import java.io.File;
import java.io.FileNotFoundException;
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
import javafx.scene.control.Cell;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Muntasir
 */
public class CourseController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
//List<String[]> references;

    @FXML
    private void bookButtonOnClick(ActionEvent event) throws IOException {
//         try {
//    FileChooser fc = new FileChooser();
//    fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF files", "*.pdf"));
//    fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image files", "*.jpg", "*.bmp", "*.png"));
//    File f = fc.showSaveDialog(null);
//    
//    if (f != null) {
//        PdfWriter pw = new PdfWriter(new FileOutputStream(f));
//        PdfDocument pdf = new PdfDocument(pw);
//        pdf.addNewPage();
//        Document doc = new Document(pdf);
//        doc.setLeftMargin(70);
//        doc.setRightMargin(70);
//
//        //----------------------------------------------------
//        // Adding paragraph to the PDF
//        String newline = "\n";
//        Paragraph lineSpace = new Paragraph(newline);
//        lineSpace.setHeight(10);
//
//        String paraText1
//                = "Md. Aquib Azmain\n"
//                + "Adjunct Lecturer\n"
//                + "IUB, Dhaka\n";
//        Paragraph para1 = new Paragraph(paraText1);
//
//        Text titleText = new Text("This is the TITLE of the pdf");
//        titleText.setFontSize(18f);
//                Paragraph pageTitle = new Paragraph(titleText);
//                pageTitle.setBold();    // OR titleText.setBold();
//
//                PdfFont font2 = PdfFontFactory.createFont(FontConstants.TIMES_ROMAN);
//                PdfFont fontBold = PdfFontFactory.createFont(FontConstants.TIMES_BOLD);
//                Text title = new Text("System analysis and design").setFont(fontBold);
//                Text author = new Text("Ross").setFont(font2);
//                Paragraph bookInfo = new Paragraph().add(title).add("5th edition by ").add(author);
//
//                doc.add(pageTitle);
//                doc.add(lineSpace);
//                doc.add(para1);
//                doc.add(lineSpace);
//                doc.add(bookInfo);
//                doc.add(lineSpace);

                // Adding list to the PDF
//                List contentList = new List();
//                contentList.add("First Aid");
//                contentList.add("CPR");
//                contentList.add("Burn");
//                contentList.add("Fractured");

//                for (IElement element : contentList) {
//                    doc.add((IBlockElement) element);
//                }
//
//                doc.add(lineSpace);
//                doc.close();
//            } else {
//                Alert a = new Alert(Alert.AlertType.INFORMATION);
//                a.setContentText("Saving as PDF: cancelled!");
//                a.showAndWait();
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//            Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setContentText("Error: File not found");
//            alert.showAndWait();
//        } catch (IOException e) {
//            e.printStackTrace();
//            Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setContentText("Error: IO exception");
//            alert.showAndWait();
//        } catch (Exception e) {
//            e.printStackTrace();
//            Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setContentText("Error: " + e.getMessage());
//            alert.showAndWait();
//        }

    }

    @FXML
    private void outLineButtonOnClick(ActionEvent event) throws IOException {
//        try {
//            FileChooser fc = new FileChooser();
//            fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF files", "*.pdf"));
//            File f = fc.showSaveDialog(null);
//            if (f != null) {
//                PdfWriter pw = new PdfWriter(new FileOutputStream(f));
//                PdfDocument pdf = new PdfDocument(pw);
//                Document document = new Document(pdf);
//
//                PdfFont font = PdfFontFactory.createFont();
//
//                Paragraph title1 = new Paragraph("Blood Center Details ")
//                        .setFont(font)
//                        .setFontSize(20)
//                        .setFontColor(ColorConstants.RED)
//                        .setBold();
//                document.add(title1);
//
//                Paragraph title = new Paragraph("Donor Card Information")
//                        .setFont(font)
//                        .setFontSize(20)
//                        .setFontColor(ColorConstants.RED)
//                        .setBold();
//                document.add(title);
//
//                document.close();
//
//                Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
//                successAlert.setTitle("Success");
//                successAlert.setHeaderText(null);
//                successAlert.setContentText("Donor card information saved as PDF: " + f.getAbsolutePath());
//                successAlert.showAndWait();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
//            errorAlert.setTitle("Error");
//            errorAlert.setHeaderText(null);
//            errorAlert.setContentText("Error occurred while saving the PDF.");
//            errorAlert.showAndWait();
//        }
    }

                                
    
    @FXML
    private void yesButtonOnClick(ActionEvent event) throws IOException {
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("test.fxml"));
        Parent parent = loader.load();
        Scene newScene = new Scene(parent);

        currentStage.setScene(newScene);
        currentStage.show();
        
    }

    @FXML
    private void noButtonOnClick(ActionEvent event) throws IOException {
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("trainer.fxml"));
        Parent parent = loader.load();
        Scene newScene = new Scene(parent);

        currentStage.setScene(newScene);
        currentStage.show();
    }
    
}
