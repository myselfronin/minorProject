/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DEO;

import Main.HomeController;
import Connectivity.DbConnection;
import com.jfoenix.controls.JFXComboBox;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Rabinson
 */
public class ScreenController implements Initializable {

   
    String deoId;
    String deoName;
    private Connection Con;
    private PreparedStatement PreStmt;
    private ResultSet Result;
    @FXML private AnchorPane productAnchorPane;
    
@FXML private Label usernameLabel;
@FXML private TextField newBarCodeTextField;
@FXML private TextField newCodeTextField;
@FXML private TextField newNameTextField;
@FXML private JFXComboBox newDepartmentComboBox;
@FXML private JFXComboBox newCategoryComboBox;
@FXML private ChoiceBox newSubCategoryChoiceBox;

@FXML private AnchorPane newAnchorPane;
@FXML private AnchorPane editAnchorPane;
@FXML private AnchorPane addAnchorPane;

@FXML private TextField addBarCodeTextField;
@FXML private TextField addCodeTextField;
@FXML private TextField  addCostPriceTextField;
@FXML private TextField  addMRPTextField;
@FXML private DatePicker addExpireDatePicker;
@FXML private TextField addQtyTextField;
@FXML private Label addNameLabel;
@FXML private Label addDepartmentLabel;
@FXML private Label addCategoryLabel;
@FXML private Label addSubCategoryLabel;
        

    @FXML
    public void DepartmentComboBoxAction() throws SQLException{
        newCategoryComboBox.getItems().clear();
        String temp = newDepartmentComboBox.getValue().toString();
        String sql = "select * from department_table, category_table "
                + "where category_table.department_Id = department_table.department_Id and department_table.Department = ?";
        PreStmt = Con.prepareStatement(sql);
        PreStmt.setString(1, temp);
        Result = PreStmt.executeQuery();
        while(Result.next())
        {
            newCategoryComboBox.getItems().add(Result.getString("Category"));
        }
    }
    
    @FXML
    public void CategoryComboBoxAction() throws SQLException{
        newSubCategoryChoiceBox.getItems().clear();
        String temp = newCategoryComboBox.getValue().toString();
        String sql = "select * from category_table, subcategory_table "
                + "where subcategory_table.Category_Id = category_table.Category_Id and category_table.Category = ?";
        PreStmt = Con.prepareStatement(sql);
        PreStmt.setString(1,temp);
        Result = PreStmt.executeQuery();
        while(Result.next())
        {
            newSubCategoryChoiceBox.getItems().add(Result.getString("Subcategory"));
        }
    }
    @FXML
    void customerBtnPushed() {
        
    }

    @FXML
    void productAddSideMenuBtnPushed() {
            addAnchorPane.toFront();
    }

    @FXML
    void productBtnPushed() {
            productAnchorPane.toFront();
    }

    @FXML
    void productEditSideMenuBtnPushed() {
           editAnchorPane.toFront();
    }

    @FXML
    void productNewSideMenuBtnPushed() {
            newAnchorPane.toFront();
    }
    
    @FXML
    public void newConfirmBtnPushed() throws SQLException
    {
        String sql= "INSERT INTO product_table(Code, BarCode,Name, Department,Category,SubCategory)"
                + "VALUES (?,?,?,?,?,?);";
        PreStmt = Con.prepareStatement(sql);
        if(newCodeTextField.getText().isEmpty())
        {
            PreStmt.setString(1,"0000000000");
        }
        else
        {
             PreStmt.setString(1,newCodeTextField.getText());
        }
        if(newBarCodeTextField.getText().isEmpty())
        {
             PreStmt.setString(2,"0000000000");
        }
        else
        {
            PreStmt.setString(2,newBarCodeTextField.getText());
        }
        
        PreStmt.setString(3,newNameTextField.getText());
        PreStmt.setString(4,newDepartmentComboBox.getValue().toString());
        PreStmt.setString(5,newCategoryComboBox.getValue().toString());
        PreStmt.setString(6,newSubCategoryChoiceBox.getValue().toString());
        PreStmt.executeUpdate();
        newCodeTextField.setText("");
        newBarCodeTextField.setText("");
        newNameTextField.setText("");
        newDepartmentComboBox.getItems().clear();
        newCategoryComboBox.getItems().clear();
        newSubCategoryChoiceBox.getItems().clear();
    }
    public void addAutoInfoGeneratedWithCode(){
        try{
             String sql = "select * from product_table where code = ?";
        PreStmt = Con.prepareStatement(sql);
        PreStmt.setString(1,addCodeTextField.getText());
        Result=PreStmt.executeQuery();
        if(Result.next())
        {
            addBarCodeTextField.setText(Result.getString("barcode"));
            addNameLabel.setText(Result.getString("Name"));
            addDepartmentLabel.setText(Result.getString("Department"));
            addCategoryLabel.setText(Result.getString("Category"));
            addSubCategoryLabel.setText(Result.getString("SubCategory"));
        }
        }
        catch(SQLException ex)
        {
            System.out.println(ex);
        }
       
        
    }
    
    public void addAutoInfoGeneratedWithBarCode() throws SQLException{
     try{
             String sql = "select * from product_table where Barcode = ?";
        PreStmt = Con.prepareStatement(sql);
        PreStmt.setString(1,addBarCodeTextField.getText());
        Result=PreStmt.executeQuery();
        if(Result.next())
        {
            addCodeTextField.setText(Result.getString("code"));
            addNameLabel.setText(Result.getString("Name"));
            addDepartmentLabel.setText(Result.getString("Department"));
            addCategoryLabel.setText(Result.getString("Category"));
            addSubCategoryLabel.setText(Result.getString("SubCategory"));
        }
        }
        catch(SQLException ex)
        {
            System.out.println(ex);
        }
    }
    
    public void AddProductBtnPushed() throws SQLException
    {

        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        DbConnection connect = new DbConnection();
        try {
            Con = connect.DbConnect();
        
           String sql = "select * from department_table order by Department";     
            PreStmt = Con.prepareStatement(sql);
            Result = PreStmt.executeQuery();
           while(Result.next())
           {
               newDepartmentComboBox.getItems().add(Result.getString("Department"));
           }
           
        } catch (SQLException ex) {
            Logger.getLogger(ScreenController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        HomeController deousr = new HomeController();
        deoId= deousr.deoId;
        deoName = deousr.deoName;
        usernameLabel.setText(deoName);
        System.out.println(deoId);
         
    
    }    
    
}
