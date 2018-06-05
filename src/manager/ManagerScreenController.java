/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import Main.Hashing;
import Connectivity.DbConnection;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Rabinson
 */
public class ManagerScreenController implements Initializable {

    //Data Entry Operator Scene
   @FXML
    private AnchorPane deoPane;
    @FXML
    private TableView<?> deoTableView;
    @FXML
    private JFXTextField deoNameTextField;
    @FXML
    private JFXDatePicker deoDobDatePicker;
    @FXML
    private JFXTextField deoUsernameTextField;
    @FXML
    private JFXRadioButton deoMaleRadioBtn;
    @FXML
    private JFXRadioButton deoFemaleRadioBtn;
    @FXML
    private JFXPasswordField deoPasswordField;
    @FXML
    private JFXTextField deoContactNoTextField;
    @FXML
    private JFXTextField deoAddressTextField;
    @FXML
    private Label deoStatusLabel;

    //Cashier Scene
    @FXML
    private AnchorPane cashierPane;
    @FXML
    private TableView<?> cashierTableView;
    @FXML
    private JFXTextField cashierNameTextField;
    @FXML
    private JFXDatePicker cashierDobDatePicker;
    @FXML
    private JFXTextField cashierUsernameTextField;
    @FXML
    private JFXRadioButton cashierMaleRadioBtn;
    @FXML
    private JFXRadioButton cashierFemaleRadioBtn;
    @FXML
    private JFXPasswordField cashierPasswordField;
    @FXML
    private JFXTextField cashierContactNoTextField;
    @FXML
    private JFXTextField cashierAddressTextField;
    @FXML
    private Label cashierStatusLabel;

    //Employee Scene
    @FXML
    private AnchorPane employeePane;
    @FXML
    private TableView<?> employeeTableView;
    @FXML
    private JFXTextField employeeNameTextField;
    @FXML
    private JFXDatePicker employeeDobDatePicker;
    @FXML
    private JFXTextField employeeContactNoTextField;
    @FXML
    private JFXTextField employeeAddressTextField;
    @FXML
    private JFXRadioButton employeeMaleRadioBtn;
    @FXML
    private JFXRadioButton employeeFemaleRadioBtn;
    @FXML
    private Label employeeStatusLabel;
    
    //variable for database action
    
    private PreparedStatement PreStmt;
    private Connection Con;

   //Button Actions
    @FXML
    public void employeeBtnPushed()
    {
        
    }
    
    @FXML
    public void cashierSideMenuBtnPushed(){
        cashierPane.toFront();
    }
    
    @FXML
    public void deoSideMenuBtnPushed(){
        deoPane.toFront();
    }
    
    @FXML
    public void employeeSideMenuBtnPushed()
    {
        employeePane.toFront();
    }
    
    @FXML
    public void cashierRegisterBtnPushed() throws SQLException, NoSuchAlgorithmException 
    {
        try{
        String sql = "INSERT INTO cashier_login (Name, Username, Password, Address,DOB, Contact_No, Gender) VALUES(?,?,?,?,?,?,?);";
        Hashing hashpass = new Hashing();
        String hashedpass = hashpass.Hashing(cashierPasswordField.getText());
        PreStmt= Con.prepareStatement(sql);
        PreStmt.setString(1,cashierNameTextField.getText());
        PreStmt.setString(2,cashierUsernameTextField.getText());
        PreStmt.setString(3,hashedpass);
        PreStmt.setString(4,cashierAddressTextField.getText());
        PreStmt.setString(5,cashierDobDatePicker.getValue().toString());
        PreStmt.setString(6,cashierContactNoTextField.getText());
        PreStmt.setString(7,"male");
        
        int i = PreStmt.executeUpdate();
        if(i==1)
        {
            cashierStatusLabel.setText("Registration Successful");
        }
        }
        catch(SQLException ex)
        {
            System.out.println("Error: "+ ex);
        }
        finally{
            PreStmt.close();
            cashierNameTextField.setText("");
            cashierUsernameTextField.setText("");
            cashierPasswordField.setText("");
            cashierAddressTextField.setText("");
            cashierContactNoTextField.setText("");
            cashierDobDatePicker.setValue(null);
        }
        
    }
    
    @FXML
    public void deoRegisterBtnPushed() throws SQLException, NoSuchAlgorithmException
    {
        try{
        String sql = "INSERT INTO deo_login (Name, Username, Password, Address,DOB, Contact_No, Gender) VALUES(?,?,?,?,?,?,?);";
        Hashing hashpass = new Hashing();
        String deohashedpass = hashpass.Hashing(deoPasswordField.getText());
        PreStmt= Con.prepareStatement(sql);
        PreStmt.setString(1,deoNameTextField.getText());
        PreStmt.setString(2,deoUsernameTextField.getText());
        PreStmt.setString(3,deohashedpass);
        PreStmt.setString(4,deoAddressTextField.getText());
        PreStmt.setString(5,deoDobDatePicker.getValue().toString());
        PreStmt.setString(6,deoContactNoTextField.getText());
        PreStmt.setString(7,"male");
        
        int i = PreStmt.executeUpdate();
        if(i==1)
        {
            deoStatusLabel.setText("Registration Successful");
        }
        }
        catch(SQLException ex)
        {
            System.out.println("Error: "+ ex);
        }
        finally{
            PreStmt.close();
            deoNameTextField.setText("");
            deoUsernameTextField.setText("");
            deoPasswordField.setText("");
            deoAddressTextField.setText("");
            deoContactNoTextField.setText("");
            deoDobDatePicker.setValue(null);
        }
        
        
    }
    
    @FXML
    public void employeeRegisterBtnPushed() throws SQLException
    {
        try{
        String sql = "INSERT INTO other_employee (Name, Address,DOB, Contact_No, Gender) VALUES(?,?,?,?,?);";
        PreStmt= Con.prepareStatement(sql);
        PreStmt.setString(1,employeeNameTextField.getText());
        PreStmt.setString(2,employeeAddressTextField.getText());
        PreStmt.setString(3,employeeDobDatePicker.getValue().toString());
        PreStmt.setString(4,employeeContactNoTextField.getText());
        PreStmt.setString(5,"male");
        
        int i = PreStmt.executeUpdate();
        if(i==1)
        {
            employeeStatusLabel.setText("Registration Successful");
        }
        }
        catch(SQLException ex)
        {
            System.out.println("Error: "+ ex);
        }
        finally{
            PreStmt.close();
            employeeNameTextField.setText("");
            employeeAddressTextField.setText("");
            employeeContactNoTextField.setText("");
            employeeDobDatePicker.setValue(null);
        }
        
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        DbConnection connect = new DbConnection();
       try {
            Con = connect.DbConnect();
       } catch (ClassNotFoundException ex) {
           Logger.getLogger(ManagerScreenController.class.getName()).log(Level.SEVERE, null, ex);
       } catch (SQLException ex) {
           Logger.getLogger(ManagerScreenController.class.getName()).log(Level.SEVERE, null, ex);
       }
    }    
    
}
