/*
     * To change this license header, choose License Headers in Project Properties.
     * To change this template file, choose Tools | Templates
     * and open the template in the editor.
 */
package DEO;

import Main.HomeController;
import Connectivity.DbConnection;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Rabinson
 */
public class ScreenController implements Initializable {

    String product_id;//for editautoinfogenerate to get product id from barcodeQuery
    String deoId;// deoid from home controller
    String deoName;//deo name for home controller
    HomeController info;// to access homecontroller method
    // for jdbc connection
    private Connection Con;
    private PreparedStatement PreStmt;
    private ResultSet Result;

    @FXML
    private AnchorPane barcodeAnchorPane;
    @FXML
    private BorderPane deoPDF;
    // for the new product in deo screen
    @FXML
    private AnchorPane productAnchorPane;
    @FXML
    private Label usernameLabel;
    @FXML
    private TextField newBarCodeTextField;
    @FXML
    private TextField BlockTextField;
   
    @FXML
    private TextField newNameTextField;
    @FXML
    private JFXComboBox newDepartmentComboBox;
    @FXML
    private TextField newDepartmentTextField;
    @FXML
    private JFXComboBox newCategoryComboBox;
    @FXML
    private TextField newCategoryTextField;
    @FXML
    private JFXComboBox newSubCategoryComboBox;
    @FXML
    private TextField newSubCategoryTextField;

    // anchor pane for edit new and add scene
    @FXML
    private AnchorPane newAnchorPane;
    @FXML
    private AnchorPane editAnchorPane;
    @FXML
    private AnchorPane addAnchorPane;

    //for the add product in deo screen
    @FXML
    private TextField addBarCodeTextField;
    
    @FXML
    private TextField addCostPriceTextField;
    @FXML
    private TextField addMRPTextField;
    @FXML
    private DatePicker addExpireDatePicker;
    @FXML
    private TextField addQtyTextField;
    @FXML
    private Label addNameLabel;
    @FXML
    private Label addDepartmentLabel;
    @FXML
    private Label addCategoryLabel;
    @FXML
    private Label addSubCategoryLabel;
    @FXML
    private JFXButton departmentAddBtn;
    @FXML
    private JFXButton categoryAddBtn;
    @FXML
    private JFXButton subcategoryAddBtn;
    
    //for edit deo screen
    @FXML
    private TextField editBarcodeTextField;
    @FXML
    private TextField editEntryQtyTextField;
    @FXML
    private TextField editNameTextField;
    @FXML
    private TextField editCostPriceTextField;
    @FXML
    private TextField editMRPTextField;
    @FXML
    private JFXComboBox editBatchComboBox;
    @FXML
    private Label editDepartmentLabel;
    @FXML
    private Label editCategoryLabel;
    @FXML
    private Label editSubCategoryLabel;
    @FXML
    private DatePicker editExpireDatePicker;
    
    @FXML
     public void logoutBtnPushed(ActionEvent event)
    {
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }
    
    
    public void DepartmentComboList() throws SQLException {
        String sql = "select department from department_table order by department";

        PreStmt = Con.prepareStatement(sql);
        Result = PreStmt.executeQuery();
        while (Result.next()) {
            newDepartmentComboBox.getItems().add(Result.getString("department"));
        }
       
    }

    public String DepartmentQuery() throws SQLException {
        String dept_id = " ";
        if(newDepartmentComboBox.getValue()!=null)
        {
              String temp = newDepartmentComboBox.getValue().toString();
        String sql = "select * from department_table where department = ?";
        PreparedStatement Stmt;

        Stmt = Con.prepareStatement(sql);
        Stmt.setString(1, temp);
        ResultSet rs = Stmt.executeQuery();
        if (rs.next()) {
            dept_id = rs.getString("department_id");
        }

        
        }
        return dept_id; 
    }

    public String CategoryQuery() throws SQLException {
        String cat_id = " ";
        String sql = "select * from category_table where category = ?";
        if(newCategoryComboBox.getValue()!=null)
        {
           PreStmt = Con.prepareStatement(sql);
        PreStmt.setString(1, newCategoryComboBox.getValue().toString());
        Result = PreStmt.executeQuery();
        if (Result.next()) {
            cat_id = Result.getString("category_id");
        }
  
        }
       
        return cat_id;
    }

    public void CategoryComboList() throws SQLException {
        String id;

        id = DepartmentQuery();
        String sql = "select * from category_table where Department_Id = ? order by category";
        PreStmt = Con.prepareStatement(sql);
        PreStmt.setString(1, id);
        Result = PreStmt.executeQuery();
        while (Result.next()) {
            newCategoryComboBox.getItems().add(Result.getString("Category"));
        }
    }

    public void SubCategoryComboList() throws SQLException {
        String id;

        id = CategoryQuery();
        String sql = "select * from subcategory_table where Category_Id = ? order by subcategory";
        PreStmt = Con.prepareStatement(sql);
        PreStmt.setString(1, id);
        Result = PreStmt.executeQuery();
        while (Result.next()) {
            newSubCategoryComboBox.getItems().add(Result.getString("SubCategory"));
        }

    }

    @FXML
    public void newDeparmentComboBoxAction() throws SQLException {
        newCategoryComboBox.getItems().clear();
        CategoryComboList();
        categoryAddBtn.setDisable(false);
    }

    @FXML
    public void newCategoryComboBoxAction() throws SQLException {
        newSubCategoryComboBox.getItems().clear();
        SubCategoryComboList();
        subcategoryAddBtn.setDisable(false);
    }

    @FXML
    public void newDepartmentAddBtn() {
        newDepartmentTextField.setVisible(true);
    }

    @FXML
    public void newCategoryAddBtn() {
        newCategoryTextField.setVisible(true);
    }

    @FXML
    public void newSubCategoryAddBtn() {
        newSubCategoryTextField.setVisible(true);
    }

    @FXML
    public void newDepartmentTextFieldAction() throws SQLException {
        String temp = newDepartmentTextField.getText().toString();
        String sql = "insert into department_table (department) values (?)";
        PreStmt = Con.prepareStatement(sql);
        PreStmt.setString(1, temp);
        PreStmt.executeUpdate();
        newDepartmentTextField.setText("");
        newDepartmentTextField.setVisible(false);
        newDepartmentComboBox.getItems().clear();
        DepartmentComboList();

    }

    @FXML
    public void newCategoryTextFieldAction() throws SQLException {
        String id = DepartmentQuery();
        String sql = "insert into category_table(category,department_id) values (?,?)";
        PreStmt = Con.prepareStatement(sql);
        PreStmt.setString(1, newCategoryTextField.getText());
        PreStmt.setString(2, id);
        PreStmt.executeUpdate();
        newCategoryComboBox.getItems().clear();
        CategoryComboList();
        newCategoryTextField.setText("");
        newCategoryTextField.setVisible(false);

    }

    @FXML
    public void newSubCategoryTextFieldAction() throws SQLException {

        String id = CategoryQuery();
        String sql = "insert into subcategory_table(subcategory,category_id) values(?,?)";
        PreStmt = Con.prepareStatement(sql);
        PreStmt.setString(1, newSubCategoryTextField.getText());
        PreStmt.setString(2, id);
        PreStmt.executeUpdate();
        newSubCategoryComboBox.getItems().clear();
        SubCategoryComboList();
        newSubCategoryTextField.setText("");
        newSubCategoryTextField.setVisible(false);

    }

    @FXML
    void barcodeBtnPushed() {
        barcodeAnchorPane.toFront();
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
    public void newConfirmBtnPushed() {
        try {
            String barcode = newBarCodeTextField.getText();
            String name = newNameTextField.getText();
            String Department = newDepartmentComboBox.getValue().toString();
            String Category = newCategoryComboBox.getValue().toString();
            String SubCategory = newSubCategoryComboBox.getValue().toString();
            String sql = "INSERT INTO product_table( BarCode,Name, Department,Category,SubCategory,block)"
                    + "VALUES (?,?,?,?,?,?);";
            PreStmt = Con.prepareStatement(sql);
            PreStmt.setString(1, barcode);
            PreStmt.setString(2, name);
            PreStmt.setString(3, Department);
            PreStmt.setString(4, Category);
            PreStmt.setString(5, SubCategory);
            PreStmt.setString(6, BlockTextField.getText());
            PreStmt.executeUpdate();   
            newBarCodeTextField.setText("");
            newNameTextField.setText("");
            newSubCategoryComboBox.setValue(null);
            newCategoryComboBox.setValue(null);
            newDepartmentComboBox.setValue(null);
            categoryAddBtn.setDisable(true);
            subcategoryAddBtn.setDisable(true);
           newSubCategoryComboBox.getItems().clear();
           newCategoryComboBox.getItems().clear();
          
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }
    public ResultSet BarCodeQuery(String code) throws SQLException
    {
        String sql = "select * from product_table where Barcode = ?";
        PreStmt = Con.prepareStatement(sql);
        PreStmt.setString(1, code);
         ResultSet rs = PreStmt.executeQuery();
            return rs; 
    }
    public void NoProductErrorMsg() throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("codeNotFound.fxml"));
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();
    }
    @FXML
    public void addAutoInfoGeneratedWithBarCode() throws IOException {
        try {
            Result = BarCodeQuery(addBarCodeTextField.getText());
            if (Result.next()) {
                addNameLabel.setText(Result.getString("Name"));
                addDepartmentLabel.setText(Result.getString("Department"));
                addCategoryLabel.setText(Result.getString("Category"));
                addSubCategoryLabel.setText(Result.getString("SubCategory"));
                product_id = Result.getString("product_id");
            } else {
                NoProductErrorMsg();
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    @FXML
    public void EditAutoInfoGeneratedwithBarCode() throws IOException, SQLException
    {
        try {
            ResultSet rs = BarCodeQuery(editBarcodeTextField.getText());
            if (rs.next()) {
                editNameTextField.setText(rs.getString("Name"));
                editDepartmentLabel.setText(rs.getString("Department"));
                editCategoryLabel.setText(rs.getString("Category"));
                editSubCategoryLabel.setText(rs.getString("SubCategory"));
                product_id = rs.getString("product_id");
            } else {
                NoProductErrorMsg();
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        String sql = "select * from batch_table where product_id = ?";
        PreparedStatement ps = Con.prepareStatement(sql);
        ps.setString(1,product_id);
        ResultSet Rs = ps.executeQuery();
        while(Rs.next())
        {
            editBatchComboBox.getItems().add(Rs.getString("batch_no"));
        }

    }
    public void editBatchComboBoxAction() throws SQLException, NullPointerException// for getting cost price by batch no in edit of deo
    {
      try{
          
                 String batch = editBatchComboBox.getValue().toString();
        String sql = " select * from batch_table where batch_no =? and product_id =?";
        PreparedStatement Ps = Con.prepareStatement(sql);
        Ps.setString(1,batch);
        Ps.setString(2, product_id);
        ResultSet res = Ps.executeQuery();
        if(res.next())
        {
            editCostPriceTextField.setText(res.getString("cost_price"));
            editMRPTextField.setText(res.getString("MRP"));
            editEntryQtyTextField.setText(res.getString("entryQty"));
            editExpireDatePicker.setValue(LocalDate.parse(res.getString("expire_date")));
           
        }
        }
      catch(NullPointerException ex)
      {
          
      }
   
    }

    public void AddProductBtnPushed() throws SQLException {
        int batch_no;
        PreStmt = Con.prepareStatement("select max(batch_No) from batch_table where product_Id =?");
        PreStmt.setString(1, product_id);
        Result = PreStmt.executeQuery();
        if (Result.next()) {
            batch_no = Result.getInt("max(batch_No)");
        } else {
            batch_no = 0;
        }
        String sql = "INSERT INTO batch_table( batch_No,product_Id,EntryQty,Expire_Date,cost_price,MRP,deo_id,entry_date,entry_time)"
                + "VALUES(?,?,?,?,?,?,?,now(),now())";
        PreStmt = Con.prepareStatement(sql);
        PreStmt.setInt(1, batch_no + 1);
        PreStmt.setString(2, product_id);
        PreStmt.setInt(3, Integer.parseInt(addQtyTextField.getText()));
        PreStmt.setString(4, addExpireDatePicker.getValue().toString());
        PreStmt.setFloat(5, Float.parseFloat(addCostPriceTextField.getText()));
        PreStmt.setFloat(6, Float.parseFloat(addMRPTextField.getText()));
        PreStmt.setString(7, deoId);
        PreStmt.executeUpdate();
        addBarCodeTextField.setText(null);
        addNameLabel.setText(null);
        addDepartmentLabel.setText(null);
        addCategoryLabel.setText(null);
        addSubCategoryLabel.setText(null);
        addCostPriceTextField.setText(null);
        addMRPTextField.setText(null);
        addExpireDatePicker.setValue(null);
        addQtyTextField.setText(null);
        
    }
    
    public void editBtnPushed() throws SQLException
    {
        String sql = "update product_table set name = ? where product_id = ?";
        PreparedStatement ps = Con.prepareStatement(sql);
        ps.setString(1,editNameTextField.getText());
        ps.setString(2,product_id);
        ps.executeUpdate();
        
        sql = "update batch_table set cost_price =? , MRP = ? , expire_date = ?,entryqty = ? where product_id =? and batch_no = ?";
        ps = Con.prepareStatement(sql);
        ps.setString(1,editCostPriceTextField.getText());
        ps.setString(2, editMRPTextField.getText());
        ps.setString(3,editExpireDatePicker.getValue().toString());
        ps.setString(4, editEntryQtyTextField.getText());
        ps.setString(5,product_id);
        ps.setString(6,editBatchComboBox.getValue().toString());
        ps.executeUpdate();
        editBarcodeTextField.setText(null);
        editNameTextField.setText(null);
        editCostPriceTextField.setText(null);
        editMRPTextField.setText(null);
        editExpireDatePicker.setValue(null);
        editEntryQtyTextField.setText(null);
        editBatchComboBox.getItems().clear();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
        info = new HomeController();
        DbConnection connect = new DbConnection();
        
        try {
            Con = connect.DbConnect();
            DepartmentComboList();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ScreenController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        HomeController deousr = new HomeController();
        deoId = deousr.deoId;
        deoName = deousr.deoName;
        usernameLabel.setText(deoName);
        newDepartmentTextField.setVisible(false);
        newCategoryTextField.setVisible(false);
        newSubCategoryTextField.setVisible(false);
        categoryAddBtn.setDisable(true);
        subcategoryAddBtn.setDisable(true);
        

    }

}
