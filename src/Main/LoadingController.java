/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Rabinson
 */
public class LoadingController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        new ShowSplashScreen().start();
    }   
    
     @FXML
    private AnchorPane ap;
   
    
     class ShowSplashScreen extends Thread{
        @Override
        public void run(){
            try {
                Thread.sleep(5000);
                
                Platform.runLater(() -> {
                    Stage stage = new Stage();
                    Parent root = null;
                    try {
                        root = FXMLLoader.load(getClass().getResource("/Main/Home.fxml"));
                    } catch (IOException ex) {
                        Logger.getLogger(LoadingController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    //stage.initStyle(StageStyle.UNDECORATED);
                    stage.setMaximized(true);
                    stage.show();
                   
                    
                    ap.getScene().getWindow().hide();
                });                
            } catch (InterruptedException ex) {
                Logger.getLogger(LoadingController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
     }
     
    
}
