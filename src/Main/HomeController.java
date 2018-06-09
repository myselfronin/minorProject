/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Connectivity.DbConnection;
import manager.ManagerScreenController;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Rabinson
 */
public class HomeController implements Initializable {
    
    // JFXBUTTONS
    @FXML
    private JFXButton exitBtn;
    @FXML
    private JFXButton loginBtn;
    @FXML
    private JFXButton managerBtn;
    @FXML
    private JFXButton cashierBtn;
    @FXML
    private JFXButton deoBtn;
    
    //PANE
    @FXML
    private Pane loginBtnPane;
    @FXML
    private Pane managerLoginPane;
    @FXML
    private Pane cashierLoginPane;
    @FXML
    private Pane deoLoginPane;
    
    //LABELS
    @FXML
    private Label managerStatus;
    @FXML
    private Label cashierStatus;
    @FXML
    private Label deoStatus;
    
    //TEXTFIELDS
    @FXML
    private JFXTextField managerUsernameTextField;
    @FXML
    private JFXTextField cashierUsernameTextField;
    @FXML
    private JFXTextField deoUsernameTextField;
    
    //PASSWORDFIELDS
    @FXML
    private JFXPasswordField managerPasswordField;
    @FXML
    private JFXPasswordField cashierPasswordField;
    @FXML
    private JFXPasswordField deoPasswordField;
    
    //FOR JDBC 
    private Connection Con;
    private PreparedStatement PreStmt;
    private ResultSet Rs;
  
    //LOGIN MANAGER 
    @FXML
    public void managerNxtButtonPushed() throws ClassNotFoundException, IOException {
        try{
            DbConnection connect = new DbConnection();
            Con = connect.DbConnect();
            
        String sql = "SELECT * FROM manager_info where Username = ? AND Password = ?;";
                
        PreStmt=Con.prepareStatement(sql);
       String user = managerUsernameTextField.getText();
       String pass = managerPasswordField.getText();
        PreStmt.setString(1,user);
        PreStmt.setString(2,pass);
       
       ResultSet rs = PreStmt.executeQuery();
       if(rs.next()){
            loginExitBtnPushed();
            managerUsernameTextField.setText("");
            managerPasswordField.setText("");
            loginBtnPane.setVisible(false);
            //loginBtn.setDisable(true);
            Parent root = FXMLLoader.load(getClass().getResource("/manager/managerScreen.fxml"));
            
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            //stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();
            
       }
       else{
           managerUsernameTextField.setText("");
           managerPasswordField.setText("");
           managerStatus.setVisible(true);
       }       
       
        }catch(SQLException ex)
        {
            System.out.println(ex);
        }
        
                   }
    //LOGIN CASHIER
    @FXML
    public void cashierNxtButtonPushed() throws ClassNotFoundException, IOException, SQLException, NoSuchAlgorithmException {
        try{
            DbConnection connect = new DbConnection();
            Con = connect.DbConnect();
            
        String sql = "SELECT * FROM cashier_login where Username = ? AND Password = ?;";
                
        PreStmt=Con.prepareStatement(sql);
       String user = cashierUsernameTextField.getText();
       Hashing HashBack = new Hashing();
       String pass = HashBack.Hashing(cashierPasswordField.getText());
        PreStmt.setString(1,user);
        PreStmt.setString(2,pass);
       
       ResultSet rs = PreStmt.executeQuery();
       if(rs.next()){
           loginExitBtnPushed();
          
            cashierUsernameTextField.setText("");
            cashierPasswordField.setText("");
            loginBtnPane.setVisible(false);
             Parent root = FXMLLoader.load(getClass().getResource("/Cashier/CashierWindow.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            
            stage.show();
       }
       else{
           cashierStatus.setVisible(true);
       }       
       
        }catch(SQLException ex)
        {
            System.out.println(ex);
        }
        finally{
            PreStmt.close();
        }
        
                   }
    
    @FXML
    public void deoNxtButtonPushed() throws ClassNotFoundException, IOException, SQLException, NoSuchAlgorithmException {
         
         try{
            DbConnection connect = new DbConnection();
            Con = connect.DbConnect();
            
        String sql = "SELECT * FROM deo_login where Username = ? AND Password = ?;";
                
        PreStmt=Con.prepareStatement(sql);
       String user = deoUsernameTextField.getText();
       Hashing HashBack = new Hashing();
       String pass = HashBack.Hashing(deoPasswordField.getText());
        PreStmt.setString(1,user);
        PreStmt.setString(2,pass);
       
       ResultSet rs = PreStmt.executeQuery();
       if(rs.next()){
           loginExitBtnPushed();
            deoUsernameTextField.setText("");
            deoPasswordField.setText("");
            loginBtnPane.setVisible(false);
             Parent root = FXMLLoader.load(getClass().getResource("/DEO/DeoWindow.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            //stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();
       }
       else{
           deoStatus.setVisible(true);
       }       
       
        }catch(SQLException ex)
        {
            System.out.println(ex);
        }
        finally{
            PreStmt.close();
        }
        
                   }
    
    @FXML
    public void exitBtnPushed(){
        System.exit(0);
    }
    
    @FXML
    private AnchorPane mainPane;
    
    @FXML
    public void loginExitBtnPushed(){
        mainPane.toFront();
        loginBtnPane.setVisible(false);
    }
    
    @FXML
    public void loginBtnPushed(){
        
        loginBtnPane.toFront();
       
    }
      public void loginBtnPushed2(){
        
        loginBtnPane.toBack();
       
    }
   @FXML
    public void managerLoginBtnHandler(){
        
            managerLoginPane.toFront();
       
        }
    
    @FXML
    public void cashierLoginBtnHandler(){
         cashierLoginPane.toFront();
    }
    
    @FXML
    public void deoLoginBtbHandler(){
        
            deoLoginPane.toFront();
    }
   
    public void initialize(URL url, ResourceBundle rb) {
        
       
        managerStatus.setVisible(false);
        cashierStatus.setVisible(false);
        deoStatus.setVisible(false);
        
        
                
        
    }    
    
}
