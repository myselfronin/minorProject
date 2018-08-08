/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Connectivity.DbConnection;
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
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.controlsfx.control.textfield.TextFields;

/**
 * FXML Controller class
 *
 * @author Rabinson
 */
public class HomeController implements Initializable {

    public static String managerName;//for manager Name in manager window
    public static String deoId;//for Id in deo window
    public static String deoName;// for deo name in deo window
    public static String cashierId;//for cashier id
    public static String cashierName;//for cashier name

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
    @FXML
    private JFXButton firstSearchBtn;
    @FXML
    private JFXButton secondSearchBtn;

    //PANE
    @FXML
    private Pane loginBtnPane;
    @FXML
    private Pane managerLoginPane;
    @FXML
    private Pane cashierLoginPane;
    @FXML
    private Pane deoLoginPane;
    @FXML
    private AnchorPane searchAnchorPane;
    @FXML
    private Pane searchSecondPane;
    @FXML
    private Pane searchFirstPane;

    //LABELS
    @FXML
    private Label managerStatus;
    @FXML
    private Label cashierStatus;
    @FXML
    private Label deoStatus;
    @FXML
    private Label resultStatus;

    @FXML
    private Label resultNumber;

    @FXML
    private Label resultName;

    @FXML
    private Label resultDepartment;

    @FXML
    private Label resultCategory;

    @FXML
    private Label resultSubCategory;

    //TEXTFIELDS
    @FXML
    private JFXTextField managerUsernameTextField;
    @FXML
    private JFXTextField cashierUsernameTextField;
    @FXML
    private JFXTextField deoUsernameTextField;
    @FXML
    private TextField searchTextField;
    @FXML
    private TextField searchSecondTextField;

    //PASSWORDFIELDS
    @FXML
    private JFXPasswordField managerPasswordField;
    @FXML
    private JFXPasswordField cashierPasswordField;
    @FXML
    private JFXPasswordField deoPasswordField;

    //FOR JDBC 
    private Connection Con, myConn;
    private PreparedStatement PreStmt;
    private ResultSet Rs;

    //LOGIN MANAGER 
    @FXML
    public void managerNxtButtonPushed() throws ClassNotFoundException, IOException {
        try {

            String sql = "SELECT * FROM manager_info where Username = ? AND Password = ?;";

            PreStmt = Con.prepareStatement(sql);
            String user = managerUsernameTextField.getText();
            String pass = managerPasswordField.getText();
            PreStmt.setString(1, user);
            PreStmt.setString(2, pass);

            ResultSet rs = PreStmt.executeQuery();
            if (rs.next()) {
                managerName = rs.getString("name");
                loginExitBtnPushed();
                managerUsernameTextField.setText("");
                managerPasswordField.setText("");
                loginBtnPane.toBack();
                Parent root = FXMLLoader.load(getClass().getResource("/manager/managerScreen.fxml"));

                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setOnCloseRequest(event -> {
                    searchSecondPane.setVisible(false);
                    searchAnchorPane.setVisible(false);
                    searchFirstPane.setVisible(true);
                    searchTextField.setText("");
                });
                stage.show();

            } else {
                managerUsernameTextField.setText("");
                managerPasswordField.setText("");
                managerStatus.setVisible(true);
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }

    //LOGIN CASHIER
    @FXML
    public void cashierNxtButtonPushed() throws ClassNotFoundException, IOException, SQLException, NoSuchAlgorithmException {
        try {

            String sql = "SELECT * FROM cashier_info where Username = ? AND Password = ?;";

            PreStmt = Con.prepareStatement(sql);
            String user = cashierUsernameTextField.getText();
            Hashing HashBack = new Hashing();
            String pass = HashBack.Hashing(cashierPasswordField.getText());
            PreStmt.setString(1, user);
            PreStmt.setString(2, pass);

            ResultSet rs = PreStmt.executeQuery();
            if (rs.next()) {
                loginExitBtnPushed();
                cashierName = rs.getString("name");
                cashierId = rs.getString("cashier_id");
                cashierUsernameTextField.setText("");
                cashierPasswordField.setText("");
                loginBtnPane.toBack();
                Parent root = FXMLLoader.load(getClass().getResource("/Cashier/CashierWindow.fxml"));
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setOnCloseRequest(event -> {
                    searchSecondPane.setVisible(false);
                    searchAnchorPane.setVisible(false);
                    searchFirstPane.setVisible(true);
                    searchTextField.setText("");
                });
                stage.show();
            } else {
                cashierStatus.setVisible(true);
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            PreStmt.close();
        }

    }

    @FXML
    public void deoNxtButtonPushed() throws ClassNotFoundException, IOException, SQLException, NoSuchAlgorithmException {

        try {

            String sql = "SELECT * FROM deo_info where Username = ? AND Password = ?;";

            PreStmt = Con.prepareStatement(sql);
            String user = deoUsernameTextField.getText();
            Hashing HashBack = new Hashing();
            String pass = HashBack.Hashing(deoPasswordField.getText());
            PreStmt.setString(1, user);
            PreStmt.setString(2, pass);

            ResultSet rs = PreStmt.executeQuery();
            if (rs.next()) {
                deoId = rs.getString("deo_id");
                deoName = rs.getString("name");
                loginExitBtnPushed();
                deoUsernameTextField.setText("");
                deoPasswordField.setText("");
                loginBtnPane.toBack();
                Parent root = FXMLLoader.load(getClass().getResource("/DEO/Screen.fxml"));
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setOnCloseRequest(event -> {
                    searchSecondPane.setVisible(false);
                    searchAnchorPane.setVisible(false);
                    searchFirstPane.setVisible(true);
                    searchTextField.setText("");
                });
                stage.show();
            } else {
                deoStatus.setVisible(true);
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {

            PreStmt.close();
        }

    }

    @FXML
    public void exitBtnPushed() {
        System.exit(0);
    }

    @FXML
    private AnchorPane mainPane;

    @FXML
    public void loginExitBtnPushed() {
        mainPane.toFront();
        loginBtnPane.toBack();
        searchSecondPane.setVisible(false);
                    searchAnchorPane.setVisible(false);
                    searchFirstPane.setVisible(true);
                    searchTextField.setText("");
    }

    @FXML
    public void loginBtnPushed() {

        loginBtnPane.toFront();

    }

    public void loginBtnPushed2() {

        loginBtnPane.toBack();

    }

    @FXML
    public void managerLoginBtnHandler() {

        managerLoginPane.toFront();

    }

    @FXML
    public void cashierLoginBtnHandler() {
        cashierLoginPane.toFront();
    }

    @FXML
    public void deoLoginBtbHandler() {

        deoLoginPane.toFront();
    }

    @FXML
    public void searchBtnPushed(ActionEvent e) throws SQLException, IOException {
        if (e.getSource() == firstSearchBtn) {
            if (searchTextField.getText().trim().isEmpty()) {

            } else {
                searchSecondPane.setVisible(true);
                searchAnchorPane.setVisible(true);
                searchFirstPane.setVisible(false);
                searchSecondTextField.setText("");
                searchAction(e);
            }
        }
        if (e.getSource() == secondSearchBtn) {
            if (searchSecondTextField.getText().trim().isEmpty()) {

            } else {

                searchAction(e);
            }
        }

    }
    @FXML
    private Label Block;
    public void searchAction(ActionEvent e) throws SQLException, IOException {
        int total = 0;
        String sql = "select product_table.name,product_table.Department,product_table.Category,product_table.block, "
                + "product_table.SubCategory,sum(batch_table.EntryQty-batch_table.SoldQty) as 'sum'"
                + " from product_table left outer join batch_table "
                + "on batch_table.product_Id = product_table.product_Id "
                + "where product_table.name = ?";
        PreStmt = Con.prepareStatement(sql);
        if (e.getSource() == firstSearchBtn) {
            PreStmt.setString(1, searchTextField.getText());
        } else if (e.getSource() == secondSearchBtn) {
            PreStmt.setString(1, searchSecondTextField.getText());
        }
        
        Rs = PreStmt.executeQuery();
        if (Rs.next()) {

            total = Rs.getInt("sum");

            resultName.setText(Rs.getString("name"));
            resultDepartment.setText(Rs.getString("department"));
            resultCategory.setText(Rs.getString("category"));
            resultSubCategory.setText(Rs.getString("subcategory"));
            resultNumber.setText(Rs.getString("sum"));
            Block.setText(Rs.getString("block"));
            if (total > 0) {
                resultStatus.setText("Available");
            } else {
                resultStatus.setText("Out Of Stock");
            }

            if (Rs.getString("name") == null) {

                Parent root = FXMLLoader.load(getClass().getResource("/Main/search.fxml"));
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();
                stage.setOnCloseRequest(event -> {
                    searchFirstPane.setVisible(true);
                    searchTextField.setText("");
                });
                searchAnchorPane.setVisible(false);
                searchSecondPane.setVisible(false);
            }
        }

    }
    public void searchAutoCompletion()
    {
         //for autocomplete textfield
        ArrayList<String> obj = new ArrayList<String>();
        String sql = "select * from product_table";
        try {
            PreparedStatement prest = Con.prepareStatement(sql);
            ResultSet Rs  = prest.executeQuery();
            while (Rs.next()) {
                obj.add(Rs.getString("name"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }

        TextFields.bindAutoCompletion(searchTextField, obj);
        TextFields.bindAutoCompletion(searchSecondTextField, obj);
    }
    public void initialize(URL url, ResourceBundle rb) {

        searchAnchorPane.setVisible(false);
        searchSecondPane.setVisible(false);
        DbConnection connect = new DbConnection();

        try {
            Con = connect.DbConnect();
            myConn = connect.DbConnect();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }

        managerStatus.setVisible(false);
        cashierStatus.setVisible(false);
        deoStatus.setVisible(false);
       
        searchAutoCompletion();
       

    }

}
