/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import Cashier.CashierDetails; 
import Main.Hashing;
import Connectivity.DbConnection;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Rabinson
 */
public class ManagerScreenController implements Initializable {

    //Data Entry Operator Scene
    @FXML Label managerName;
    @FXML private AnchorPane deoPane;
    @FXML private TableView<?> deoTableView;
    @FXML private JFXTextField deoNameTextField;
    @FXML private JFXDatePicker deoDobDatePicker;
    @FXML private JFXTextField deoUsernameTextField;
    @FXML private JFXRadioButton deoMaleRadioBtn;
    @FXML private JFXRadioButton deoFemaleRadioBtn;
    @FXML private JFXPasswordField deoPasswordField;
    @FXML private JFXTextField deoContactNoTextField;
    @FXML private JFXTextField deoAddressTextField;
    @FXML private Label deoStatusLabel;
    private ToggleGroup deoGenderToggleGroup;

    //Cashier Scene
    @FXML private AnchorPane cashierPane;
    @FXML private TableView<CashierDetails> cashierTableView;
    @FXML private TableColumn<CashierDetails,String> cashierSNoColumn;
    @FXML private TableColumn<CashierDetails,String> cashierNameColumn;
    @FXML private TableColumn<CashierDetails,String> cashierUsernameColumn;
    @FXML private TableColumn<CashierDetails,String> cashierAddressColumn;
    @FXML private TableColumn<CashierDetails,String> cashierContactNoColumn;
    @FXML private TableColumn<CashierDetails,String> cashierGenderColumn;
    @FXML private TableColumn<CashierDetails,LocalDate> cashierDOBColumn;
    @FXML private TableColumn<CashierDetails,String> cashierCreatedByColumn;
    @FXML private TableColumn<CashierDetails,String> cashierCreatedAtColumn;
    @FXML private JFXTextField cashierNameTextField;
    @FXML private JFXDatePicker cashierDobDatePicker;
    @FXML private JFXTextField cashierUsernameTextField;
    @FXML private JFXRadioButton cashierMaleRadioBtn;
    @FXML private JFXRadioButton cashierFemaleRadioBtn;
    @FXML private JFXPasswordField cashierPasswordField;
    @FXML private JFXTextField cashierContactNoTextField;
    @FXML private JFXTextField cashierAddressTextField;
    @FXML private Label cashierStatusLabel;
    private ToggleGroup cashierGenderToggleGroup;

    //Employee Scene
    @FXML private AnchorPane employeePane;
    @FXML private TableView<?> employeeTableView;
    @FXML private JFXTextField employeeNameTextField;
    @FXML private JFXDatePicker employeeDobDatePicker;
    @FXML private JFXTextField employeeContactNoTextField;
    @FXML private JFXTextField employeeAddressTextField;
    @FXML private JFXRadioButton employeeMaleRadioBtn;
    @FXML private JFXRadioButton employeeFemaleRadioBtn;
    @FXML private Label employeeStatusLabel;
    private ToggleGroup employeeGenderToggleGroup;
    //for gender 
    String cashierGender;
    String deoGender;
    String employeeGender;
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
        String sql = "INSERT INTO cashier_info (Name, Username, Password, Address,DOB, Contact_No, Gender,Created_By,Created_At) VALUES(?,?,?,?,?,?,?,?,?);";
       
        //For password HASHING
        Hashing hashpass = new Hashing();
        String hashedpass = hashpass.Hashing(cashierPasswordField.getText());
        
        //For DATE AND TIME for Created At
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date dateobj = new Date();
       
        if(cashierGenderToggleGroup.getSelectedToggle().equals(cashierMaleRadioBtn))
            {
                 cashierGender = "Male";
            }
        else {
                 cashierGender = "Female";
             }
        
        PreStmt= Con.prepareStatement(sql);
        PreStmt.setString(1,cashierNameTextField.getText());
        PreStmt.setString(2,cashierUsernameTextField.getText());
        PreStmt.setString(3,hashedpass);
        PreStmt.setString(4,cashierAddressTextField.getText());
        PreStmt.setString(5,cashierDobDatePicker.getValue().toString());
        PreStmt.setString(6,cashierContactNoTextField.getText());
        PreStmt.setString(7,cashierGender);
        PreStmt.setString(8,"jasmine");
        PreStmt.setString(9,df.format(dateobj));
        
        int i = PreStmt.executeUpdate();
        if(i==1)
        {
            
            cashierStatusLabel.setText("Registration Successful");
            cashierNameTextField.setText("");
            cashierUsernameTextField.setText("");
            cashierPasswordField.setText("");
            cashierAddressTextField.setText("");
            cashierContactNoTextField.setText("");
            cashierDobDatePicker.setValue(null);
        }
        }
        catch(SQLException ex)
        {
            System.out.println("Error: "+ ex);
        }
        finally{
            PreStmt.close();
             cashierTableView.setItems(getCashier());
           
        }
        
    }
    
    @FXML
    public void deoRegisterBtnPushed() throws SQLException, NoSuchAlgorithmException
    {
        try{
        String sql = "INSERT INTO deo_info (Name, Username, Password, Address,DOB, Contact_No, Gender,Created_By,Created_At) VALUES(?,?,?,?,?,?,?,?,?);";
        
        //Password HASHING
        Hashing hashpass = new Hashing();
        String deohashedpass = hashpass.Hashing(deoPasswordField.getText());
        
     
       
        //For Registration date and time
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date dateobj = new Date();
        
         if(deoGenderToggleGroup.getSelectedToggle().equals(deoMaleRadioBtn))
        {
            deoGender= "Male";
        }
        else 
        {
            deoGender = "Female";
        }
         
        PreStmt= Con.prepareStatement(sql);
        PreStmt.setString(1,deoNameTextField.getText());
        PreStmt.setString(2,deoUsernameTextField.getText());
        PreStmt.setString(3,deohashedpass);
        PreStmt.setString(4,deoAddressTextField.getText());
        PreStmt.setString(5,deoDobDatePicker.getValue().toString());
        PreStmt.setString(6,deoContactNoTextField.getText());
        PreStmt.setString(7,deoGender);
        PreStmt.setString(8,"jasmine");
        PreStmt.setString(9, df.format(dateobj));
        
        int i = PreStmt.executeUpdate();
        if(i==1)
        {
            deoStatusLabel.setText("Registration Successful");
            deoNameTextField.setText("");
            deoUsernameTextField.setText("");
            deoPasswordField.setText("");
            deoAddressTextField.setText("");
            deoContactNoTextField.setText("");
            deoDobDatePicker.setValue(null);
        }
        }
        catch(SQLException ex)
        {
            System.out.println("Error: "+ ex);
        }
        finally{
            PreStmt.close();
            
        }
        
        
    }
    
    @FXML
    public void employeeRegisterBtnPushed() throws SQLException
    {
        try{
        String sql = "INSERT INTO employee_info(Name, Address,DOB, Contact_No, Gender,Created_By, Created_At) VALUES(?,?,?,?,?,?,?);";
        
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date dateobj = new Date();
        
         if(employeeGenderToggleGroup.getSelectedToggle().equals(employeeMaleRadioBtn))
        {
            employeeGender = "Male";
        }
        else
        {
            employeeGender = "Female";
        }
        
         
        PreStmt= Con.prepareStatement(sql);
        PreStmt.setString(1,employeeNameTextField.getText());
        PreStmt.setString(2,employeeAddressTextField.getText());
        PreStmt.setString(3,employeeDobDatePicker.getValue().toString());
        PreStmt.setString(4,employeeContactNoTextField.getText());
        PreStmt.setString(5,employeeGender);
        PreStmt.setString(6,"jasmine");
        PreStmt.setString(7,df.format(dateobj));
        int i = PreStmt.executeUpdate();
        if(i==1)
        {
            employeeStatusLabel.setText("Registration Successful");
            employeeNameTextField.setText("");
            employeeAddressTextField.setText("");
            employeeContactNoTextField.setText("");
            employeeDobDatePicker.setValue(null);
        }
        }
        catch(SQLException ex)
        {
            System.out.println("Error: "+ ex);
        }
        finally{
            PreStmt.close();
            
        }
        
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        DbConnection connect = new DbConnection();
        
       try {
            Con = connect.DbConnect();
       } catch (ClassNotFoundException ex) {
           Logger.getLogger(ManagerScreenController.class.getName()).log(Level.SEVERE, null, ex);
       } catch (SQLException ex) {
           Logger.getLogger(ManagerScreenController.class.getName()).log(Level.SEVERE, null, ex);
       }
 
        employeeGenderToggleGroup = new ToggleGroup();
        this.employeeMaleRadioBtn.setToggleGroup(employeeGenderToggleGroup);
        this.employeeFemaleRadioBtn.setToggleGroup(employeeGenderToggleGroup);
        
       
        cashierGenderToggleGroup = new ToggleGroup();
        this.cashierMaleRadioBtn.setToggleGroup(cashierGenderToggleGroup);
        this.cashierFemaleRadioBtn.setToggleGroup(cashierGenderToggleGroup);
       
        
        deoGenderToggleGroup = new ToggleGroup();
        this.deoMaleRadioBtn.setToggleGroup(deoGenderToggleGroup);
        this.deoFemaleRadioBtn.setToggleGroup(deoGenderToggleGroup);
        
       
       cashierSNoColumn.setCellValueFactory(new PropertyValueFactory<CashierDetails, String>("SNo"));
       cashierNameColumn.setCellValueFactory(new PropertyValueFactory<CashierDetails, String>("Name")); 
       cashierUsernameColumn.setCellValueFactory(new PropertyValueFactory<CashierDetails, String>("Username"));
       cashierAddressColumn.setCellValueFactory(new PropertyValueFactory<CashierDetails, String>("Address"));
       cashierContactNoColumn.setCellValueFactory(new PropertyValueFactory<CashierDetails, String>("ContactNo"));
       cashierDOBColumn.setCellValueFactory(new PropertyValueFactory<CashierDetails, LocalDate>("dob"));
       cashierGenderColumn.setCellValueFactory(new PropertyValueFactory<CashierDetails, String>("Gender"));
       cashierCreatedByColumn.setCellValueFactory(new PropertyValueFactory<CashierDetails, String>("CreatedBy"));
       cashierCreatedAtColumn.setCellValueFactory(new PropertyValueFactory<CashierDetails, String>("CreatedAt"));
       
        try {
            cashierTableView.setItems(getCashier());
        } catch (SQLException ex) {
            Logger.getLogger(ManagerScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }    
    
    public ObservableList<CashierDetails> getCashier() throws SQLException
    {
        ObservableList<CashierDetails> Cashier = FXCollections.observableArrayList();
        PreparedStatement PreStm;
        String sql = "Select * from cashier_info";
        PreStm = Con.prepareStatement(sql);
        ResultSet Result = PreStm.executeQuery();
        while(Result.next())
        {
            Cashier.add(new CashierDetails(Result.getString("cashier_Id"),Result.getString("Name"),
                                           Result.getString("Username"), Result.getString("Address"),
                                           Result.getString("Contact_No"),Result.getString("Gender"),
                                           Result.getString("Created_By"),Result.getString("Created_At"),LocalDate.of(1996,Month.SEPTEMBER,14)));
            
        }
        
        //Cashier.add(new CashierDetails("1","Rabinson","72bct635","Jawalakhel","98989898","Male","jasmine","2018/07/07 07:00:00",LocalDate.of(1996,Month.SEPTEMBER,14)));
        return Cashier;
    }
    
}
