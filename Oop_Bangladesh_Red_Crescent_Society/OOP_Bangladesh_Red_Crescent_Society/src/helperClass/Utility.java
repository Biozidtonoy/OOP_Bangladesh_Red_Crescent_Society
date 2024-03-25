/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helperClass;

import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author tonoy
 */
public class Utility {
    //    Utility.sceneSwitch (getClass(),event,"myXML.fxml");
    public static void sceneSwitch(Class aClass, Event aEvent,String sceneFileStr) throws Exception{
        Parent root = FXMLLoader.load (aClass.getResource(sceneFileStr));
        Scene Scene = new Scene(root);
        Stage stage = (Stage) ((Node) aEvent.getSource()).getScene().getWindow();
        stage.setScene(Scene);
        stage.show();
    }
}
