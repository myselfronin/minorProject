/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import Cashier.CashierDetails;
import DEO.DEODetails;
import Main.Hashing;
import Connectivity.DbConnection;
import com.jfoenix.controls.JFXButton;
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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Rabinson
 */
public class ManagerScreenController implements Initializable {

    
    @FXML
    private AnchorPane employeeAnchorPane;
    //Data Entry Operator Scene
    @FXML
    Label managerName;
    @FXML
    private AnchorPane deoPane;
    @FXML
    private TableView<DEODetails> deoTableView;
    @FXML
    private TableColumn<DEODetails, String> deoSNoColumn;
    @FXML
    private TableColumn<DEODetails, String> deoNameColumn;
    @FXML
    private TableColumn<DEODetails, String> deoUsernameColumn;
    @FXML
    private TableColumn<DEODetails, String> deoAddressColumn;
    @FXML
    private TableColumn<DEODetails, String> deoContactNoColumn;
    @FXML
    private TableColumn<DEODetails, String> deoGenderColumn;
    @FXML
    private TableColumn<DEODetails, LocalDate> deoDOBColumn;
    @FXML
    private TableColumn<DEODetails, String> deoCreatedByColumn;
    @FXML
    private TableColumn<DEODetails, String> deoCreatedAtColumn;
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
    private JFXButton saleBtn;
       private Label nameLabel;
    private Label expireLabel;
    private ToggleGroup deoGenderToggleGroup;

    //Cashier Scene
    @FXML
    private AnchorPane cashierPane;
    @FXML
    private TableView<CashierDetails> cashierTableView;
    @FXML
    private TableColumn<CashierDetails, String> cashierSNoColumn;
    @FXML
    private TableColumn<CashierDetails, String> cashierNameColumn;
    @FXML
    private TableColumn<CashierDetails, String> cashierUsernameColumn;
    @FXML
    private TableColumn<CashierDetails, String> cashierAddressColumn;
    @FXML
    private TableColumn<CashierDetails, String> cashierContactNoColumn;
    @FXML
    private TableColumn<CashierDetails, String> cashierGenderColumn;
    @FXML
    private TableColumn<CashierDetails, LocalDate> cashierDOBColumn;
    @FXML
    private TableColumn<CashierDetails, String> cashierCreatedByColumn;
    @FXML
    private TableColumn<CashierDetails, String> cashierCreatedAtColumn;
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
    private ToggleGroup cashierGenderToggleGroup;

    //Employee Scene
    @FXML
    private AnchorPane employeePane;
    @FXML
    private TableView<EmployeeDetails> employeeTableView;
    @FXML
    private TableColumn<EmployeeDetails, String> employeeSNoColumn;
    @FXML
    private TableColumn<EmployeeDetails, String> employeeNameColumn;
    @FXML
    private TableColumn<EmployeeDetails, String> employeePositionColumn;
    @FXML
    private TableColumn<EmployeeDetails, String> employeeAddressColumn;
    @FXML
    private TableColumn<EmployeeDetails, String> employeeContactNoColumn;
    @FXML
    private TableColumn<EmployeeDetails, String> employeeGenderColumn;
    @FXML
    private TableColumn<EmployeeDetails, Date> employeeDOBColumn;
    @FXML
    private TableColumn<EmployeeDetails, String> employeeCreatedByColumn;
    @FXML
    private TableColumn<EmployeeDetails, String> employeeCreatedAtColumn;
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
    private ChoiceBox employeePositionChoiceBox;
    @FXML
    private Label employeeStatusLabel;

    // notification scene
    
    @FXML
    private AnchorPane notificationAnchorPane;
    @FXML
    private ScrollPane notifyExpireDate;
    @FXML
    private ScrollPane notifyQty;
    private VBox expireVbox = new VBox();
    private VBox qtyVbox = new VBox();
  

    private ToggleGroup employeeGenderToggleGroup;
    //for gender 
    String cashierGender;
    String deoGender;
    String employeeGender;
    //variable for database action

    private PreparedStatement PreStmt;
    private Connection Con;
    private Connection myConn;
    private ResultSet Result;

    //Button Actions
    @FXML
    public void employeeBtnPushed() {
        employeeAnchorPane.toFront();
    }

    @FXML
    public void notificationBtnPushed() {
        notificationAnchorPane.toFront();
    }

    @FXML
    public void cashierSideMenuBtnPushed() {
        cashierPane.toFront();
    }

    @FXML
    public void deoSideMenuBtnPushed() {
        deoPane.toFront();
    }

    @FXML
    public void employeeSideMenuBtnPushed() {
        employeePane.toFront();
    }

    @FXML
    public void cashierRegisterBtnPushed() throws SQLException, NoSuchAlgorithmException {
        try {
            String sql = "INSERT INTO cashier_info (Name, Username, Password, Address,DOB, Contact_No, Gender,Created_By,Created_At) VALUES(?,?,?,?,?,?,?,?,?);";

            //For password HASHING
            Hashing hashpass = new Hashing();
            String hashedpass = hashpass.Hashing(cashierPasswordField.getText());

            //For DATE AND TIME for Created At
            DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date dateobj = new Date();

            if (cashierGenderToggleGroup.getSelectedToggle().equals(cashierMaleRadioBtn)) {
                cashierGender = "Male";
            } else {
                cashierGender = "Female";
            }

            PreStmt = Con.prepareStatement(sql);
            PreStmt.setString(1, cashierNameTextField.getText());
            PreStmt.setString(2, cashierUsernameTextField.getText());
            PreStmt.setString(3, hashedpass);
            PreStmt.setString(4, cashierAddressTextField.getText());
            PreStmt.setString(5, cashierDobDatePicker.getValue().toString());
            PreStmt.setString(6, cashierContactNoTextField.getText());
            PreStmt.setString(7, cashierGender);
            PreStmt.setString(8, "jasmine");
            PreStmt.setString(9, df.format(dateobj));

            int i = PreStmt.executeUpdate();
            if (i == 1) {

                cashierStatusLabel.setText("Registration Successful");
                cashierNameTextField.setText("");
                cashierUsernameTextField.setText("");
                cashierPasswordField.setText("");
                cashierAddressTextField.setText("");
                cashierContactNoTextField.setText("");
                cashierDobDatePicker.setValue(null);
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
        } finally {
            PreStmt.close();
            cashierTableView.setItems(getCashier());

        }

    }

    @FXML
    public void deoRegisterBtnPushed() throws SQLException, NoSuchAlgorithmException {
        try {
            String sql = "INSERT INTO deo_info (Name, Username, Password, Address,DOB, Contact_No, Gender,Created_By,Created_At) VALUES(?,?,?,?,?,?,?,?,?);";

            //Password HASHING
            Hashing hashpass = new Hashing();
            String deohashedpass = hashpass.Hashing(deoPasswordField.getText());

            //For Registration date and time
            DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date dateobj = new Date();

            if (deoGenderToggleGroup.getSelectedToggle().equals(deoMaleRadioBtn)) {
                deoGender = "Male";
            } else {
                deoGender = "Female";
            }

            PreStmt = Con.prepareStatement(sql);
            PreStmt.setString(1, deoNameTextField.getText());
            PreStmt.setString(2, deoUsernameTextField.getText());
            PreStmt.setString(3, deohashedpass);
            PreStmt.setString(4, deoAddressTextField.getText());
            PreStmt.setString(5, deoDobDatePicker.getValue().toString());
            PreStmt.setString(6, deoContactNoTextField.getText());
            PreStmt.setString(7, deoGender);
            PreStmt.setString(8, "jasmine");
            PreStmt.setString(9, df.format(dateobj));

            int i = PreStmt.executeUpdate();
            if (i == 1) {
                deoStatusLabel.setText("Registration Successful");
                deoNameTextField.setText("");
                deoUsernameTextField.setText("");
                deoPasswordField.setText("");
                deoAddressTextField.setText("");
                deoContactNoTextField.setText("");
                deoDobDatePicker.setValue(null);
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
        } finally {
            PreStmt.close();
            deoTableView.setItems(getDeo());

        }

    }

    @FXML
    public void employeeRegisterBtnPushed() throws SQLException {
        try {
            String sql = "INSERT INTO employee_info(Name, Position, Address,DOB, Contact_No, Gender,Created_By, Created_At) VALUES(?,?,?,?,?,?,?,?);";

            DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date dateobj = new Date();

            if (employeeGenderToggleGroup.getSelectedToggle().equals(employeeMaleRadioBtn)) {
                employeeGender = "Male";
            } else {
                employeeGender = "Female";
            }

            PreStmt = Con.prepareStatement(sql);
            PreStmt.setString(1, employeeNameTextField.getText());
            PreStmt.setString(2, employeePositionChoiceBox.getValue().toString());
            PreStmt.setString(3, employeeAddressTextField.getText());
            PreStmt.setString(4, employeeDobDatePicker.getValue().toString());
            PreStmt.setString(5, employeeContactNoTextField.getText());
            PreStmt.setString(6, employeeGender);
            PreStmt.setString(7, "jasmine");
            PreStmt.setString(8, df.format(dateobj));
            int i = PreStmt.executeUpdate();
            if (i == 1) {
                employeeStatusLabel.setText("Registration Successful");
                employeeNameTextField.setText("");
                employeeAddressTextField.setText("");
                employeeContactNoTextField.setText("");
                employeeDobDatePicker.setValue(null);
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
        } finally {
            PreStmt.close();
            employeeTableView.setItems(getEmployee());

        }

    }
   
 ///for notification in manager screen
    
    public void managerExpireDateNotification() throws SQLException {
        expireVbox.getChildren().clear();
        expireVbox.setStyle("-fx-background-color: white;");
        expireVbox.setSpacing(10);
        String sql = "update batch_table set expire_status = 'expiring' where datediff(Expire_date,now())<30;";

        PreStmt = Con.prepareStatement(sql);
        PreStmt.executeUpdate();

        String query = "update batch_table set expire_status = 'expired' where datediff(Expire_date,now())<0";
        PreStmt = Con.prepareStatement(query);
        PreStmt.executeUpdate();
        
        String sqll = "SELECT * FROM batch_table inner join product_table"
                + " on batch_table.product_Id = product_table.product_Id "
                + "where expire_status like 'expiring' or expire_status like 'expired'";
        PreStmt= Con.prepareStatement(sqll);
        Result= PreStmt.executeQuery();
       String[] product_id = new String[100];
       int[] batch_no = new int[100];
       JFXButton[] btn = new JFXButton[100];
       int i=0;
        if(Result.next())
        {
             while(Result.next())
        {
            int j= i;
            product_id[j]= Result.getString("product_id");
            batch_no[j]= Result.getInt("batch_no");
             Pane pane2= new Pane();
            pane2.setPrefSize(400,100);
            pane2.setStyle("-fx-background-color: rgb(253, 227, 167);");
            Label name = new Label();
            name.setText("NAME\t" + Result.getString("name"));
            Label department = new Label();
            department.setText("DEPARTMENT\t" + Result.getString("department"));
           department.setTranslateX(150);
             Label category = new Label();
            category.setText("CATEGORY\t" +Result.getString("category"));
            category.setTranslateY(30);
             Label subcategory= new Label();
            subcategory.setText("SUBCATEGORY\t" + Result.getString("subcategory"));
            subcategory.setTranslateX(150);
            subcategory.setTranslateY(30);
             Label status = new Label();
            status.setText("STATUS\t" + Result.getString( "expire_status"));
            status.setTranslateY(60);
             status.setTranslateX(150);
            btn[i] = new JFXButton("SALE");
             if("Sale".equals(Result.getString("type")))
            {
                btn[i].setDisable(true);
            }
            btn[i].setOnAction(new EventHandler<ActionEvent>(){
               @Override public void handle(ActionEvent e){
                   
                   try {
                       String sql = "update batch_table set type = 'Sale' where batch_no = ? and product_id = ?";
                        PreStmt= Con.prepareStatement(sql);
                       PreStmt.setInt(1, batch_no[j]);
                       PreStmt.setString(2, product_id[j]);
                       PreStmt.executeUpdate();
                   } catch (SQLException ex) {
                       Logger.getLogger(ManagerScreenController.class.getName()).log(Level.SEVERE, null, ex);
                   }
                   
                }
            });
           
             btn[i].setStyle("-fx-background-color:rgb(25, 181, 254);");
             btn[i].setTranslateY(30);
             btn[i].setTranslateX(300);
             pane2.getChildren().addAll(name,department,category,subcategory,status,btn[i]);
            expireVbox.getChildren().add(pane2);
            i++;
        }
        }
        else
        {     Pane pane= new Pane();
            pane.setPrefSize(400,100);
            pane.setStyle("-fx-background-color: rgb(162, 222, 208);");
            Label name = new Label();
            name.setText("NO ANY NOFICATION");
            pane.getChildren().add(name);
            expireVbox.getChildren().add(pane);
            
        }
      notifyExpireDate.setContent(expireVbox);

    }
    
    // Notification of low quantity in the store
    public void managerQtyNotification() throws SQLException
    {
         qtyVbox.getChildren().clear();
        qtyVbox.setStyle("-fx-background-color: white;");
        qtyVbox.setSpacing(10);
        
         String sqll = "select product_table.name, product_table.Department, product_table.Category,"
                 + "product_table.SubCategory , (sum(EntryQty) - sum( SoldQty)) as remaining "
                 + "from batch_table inner join product_table "
                 + "on batch_table.product_Id = product_table.product_Id "
                 + "where not type = 'sold'"
                 + "group by batch_table.product_Id";
         PreStmt = Con.prepareStatement(sqll);
         Result = PreStmt.executeQuery();
         if(Result.next())
         {
         while(Result.next())
         {
             if(Result.getInt("remaining")<100)
             {
               Pane pane= new Pane();
            pane.setPrefSize(400,100);
            pane.setStyle("-fx-background-color: rgb(253, 227, 167);");
            Label name = new Label();
            name.setText("NAME\t" + Result.getString("name"));
            Label department = new Label();
            department.setText("DEPARTMENT\t" + Result.getString("department"));
           department.setTranslateX(150);
             Label category = new Label();
            category.setText("CATEGORY\t" +Result.getString("category"));
            category.setTranslateY(30);
             Label subcategory= new Label();
            subcategory.setText("SUBCATEGORY\t" + Result.getString("subcategory"));
            subcategory.setTranslateX(150);
            subcategory.setTranslateY(30);
             Label remaining = new Label();
             int num = Result.getInt("remaining");
            remaining.setText("STATUS\t" + num);
            remaining.setTranslateY(60);
            remaining.setTranslateX(150);
             pane.getChildren().addAll(name,department,category,subcategory,remaining);
             qtyVbox.getChildren().add(pane);
         }
         }
         }
         else
        {     Pane pane= new Pane();
            pane.setPrefSize(400,100);
            pane.setStyle("-fx-background-color: rgb(162, 222, 208);");
            Label name = new Label();
            name.setText("NO ANY NOFICATION");
            pane.getChildren().add(name);
            qtyVbox.getChildren().add(pane);
            
        }  
             
             
         notifyQty.setContent(qtyVbox);
         
    }
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        
        DbConnection connect = new DbConnection();

        try {
            Con = connect.DbConnect();
            managerExpireDateNotification();
            managerQtyNotification();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManagerScreenController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManagerScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }

        employeeGenderToggleGroup = new ToggleGroup();
        this.employeeMaleRadioBtn.setToggleGroup(employeeGenderToggleGroup);
        this.employeeFemaleRadioBtn.setToggleGroup(employeeGenderToggleGroup);
        employeePositionChoiceBox.getItems().addAll("Security", "Stock Clerk", "Sanitary");
        employeePositionChoiceBox.setValue("Shop Walker");

        cashierGenderToggleGroup = new ToggleGroup();
        this.cashierMaleRadioBtn.setToggleGroup(cashierGenderToggleGroup);
        this.cashierFemaleRadioBtn.setToggleGroup(cashierGenderToggleGroup);

        deoGenderToggleGroup = new ToggleGroup();
        this.deoMaleRadioBtn.setToggleGroup(deoGenderToggleGroup);
        this.deoFemaleRadioBtn.setToggleGroup(deoGenderToggleGroup);
        
        cashierSNoColumn.setCellValueFactory(new PropertyValueFactory<>("SNo"));
        cashierNameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
        cashierUsernameColumn.setCellValueFactory(new PropertyValueFactory<>("Username"));
        cashierAddressColumn.setCellValueFactory(new PropertyValueFactory<>("Address"));
        cashierContactNoColumn.setCellValueFactory(new PropertyValueFactory<>("ContactNo"));
        cashierDOBColumn.setCellValueFactory(new PropertyValueFactory<>("dob"));
        cashierGenderColumn.setCellValueFactory(new PropertyValueFactory<>("Gender"));
        cashierCreatedByColumn.setCellValueFactory(new PropertyValueFactory<>("CreatedBy"));
        cashierCreatedAtColumn.setCellValueFactory(new PropertyValueFactory<>("CreatedAt"));

        try {
            cashierTableView.setItems(getCashier());
        } catch (SQLException ex) {
            Logger.getLogger(ManagerScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }

        deoSNoColumn.setCellValueFactory(new PropertyValueFactory<>("SNo"));
        deoNameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
        deoUsernameColumn.setCellValueFactory(new PropertyValueFactory<>("Username"));
        deoAddressColumn.setCellValueFactory(new PropertyValueFactory<>("Address"));
        deoContactNoColumn.setCellValueFactory(new PropertyValueFactory<>("ContactNo"));
        deoDOBColumn.setCellValueFactory(new PropertyValueFactory<>("dob"));
        deoGenderColumn.setCellValueFactory(new PropertyValueFactory<>("Gender"));
        deoCreatedByColumn.setCellValueFactory(new PropertyValueFactory<>("CreatedBy"));
        deoCreatedAtColumn.setCellValueFactory(new PropertyValueFactory<>("CreatedAt"));

        try {
            deoTableView.setItems(getDeo());
        } catch (SQLException ex) {
            Logger.getLogger(ManagerScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        employeeSNoColumn.setCellValueFactory(new PropertyValueFactory<>("SNo"));
        employeeNameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
        employeePositionColumn.setCellValueFactory(new PropertyValueFactory<>("Position"));
        employeeAddressColumn.setCellValueFactory(new PropertyValueFactory<>("Address"));
        employeeContactNoColumn.setCellValueFactory(new PropertyValueFactory<>("ContactNo"));
        employeeDOBColumn.setCellValueFactory(new PropertyValueFactory<>("dob"));
        employeeGenderColumn.setCellValueFactory(new PropertyValueFactory<>("Gender"));
        employeeCreatedByColumn.setCellValueFactory(new PropertyValueFactory<>("CreatedBy"));
        employeeCreatedAtColumn.setCellValueFactory(new PropertyValueFactory<>("CreatedAt"));

        try {
            employeeTableView.setItems(getEmployee());
        } catch (SQLException ex) {
            Logger.getLogger(ManagerScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ObservableList<CashierDetails> getCashier() throws SQLException {
        ObservableList<CashierDetails> Cashier = FXCollections.observableArrayList();
        PreparedStatement PreStm;
        String sql = "Select * from cashier_info";
        PreStm = Con.prepareStatement(sql);
        ResultSet Result = PreStm.executeQuery();
        while (Result.next()) {
            Cashier.add(new CashierDetails(Result.getString("cashier_Id"), Result.getString("Name"),
                    Result.getString("Username"), Result.getString("Address"),
                    Result.getString("Contact_No"), Result.getString("Gender"),
                    Result.getString("Created_By"), Result.getString("Created_At"), LocalDate.of(1996, Month.SEPTEMBER, 14)));

        }
        return Cashier;
    }

    public ObservableList<DEODetails> getDeo() throws SQLException {
        ObservableList<DEODetails> Deo = FXCollections.observableArrayList();
        PreparedStatement PreStm;
        String sql = "SELECT * FROM deo_info";
        PreStm = Con.prepareStatement(sql);
        ResultSet Result = PreStm.executeQuery();
        while (Result.next()) {
            Deo.add(new DEODetails(Result.getString("deo_Id"), Result.getString("Name"),
                    Result.getString("Username"), Result.getString("Address"),
                    Result.getString("Contact_No"), Result.getString("Gender"),
                    Result.getString("Created_By"), Result.getString("Created_At"), LocalDate.of(1996, Month.SEPTEMBER, 14)));
        }
        return Deo;
    }

    public ObservableList<EmployeeDetails> getEmployee() throws SQLException {
        ObservableList<EmployeeDetails> Employee = FXCollections.observableArrayList();
        PreparedStatement PreStm;
        String sql = "SELECT * FROM employee_info";
        PreStm = Con.prepareStatement(sql);
        ResultSet Result = PreStm.executeQuery();
        while (Result.next()) {
            Employee.add(new EmployeeDetails(Result.getString("employee_Id"), Result.getString("Name"),
                    Result.getString("Position"),
                    Result.getString("Address"), Result.getString("Contact_No"),
                    Result.getString("Gender"), Result.getString("Created_By"),
                    Result.getString("Created_At"), Result.getDate("DOB")));
        }
        return Employee;
    }
    
}
