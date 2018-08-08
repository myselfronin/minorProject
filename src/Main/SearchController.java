/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Rabinson
 */
public class SearchController implements Initializable {

    /**
     * Initializes the controller class.
     */
    Connection Con;
    PreparedStatement PreStmt;
    ResultSet Result;

    @FXML
    private JFXComboBox searchDepartmentComboBox;
    @FXML
    private JFXComboBox searchCategoryComboBox;
    @FXML
    private JFXComboBox searchSubCategoryComboBox;
    @FXML
    private Label resultNotFoundLabel;
    @FXML
    private ScrollPane resultScrollPane;
    
    VBox vbox = new VBox();
    
    

    public void DepartmentComboList() throws SQLException {
        String sql = "select * from department_table order by department";

        PreStmt = Con.prepareStatement(sql);
        Result = PreStmt.executeQuery();
        while (Result.next()) {
            searchDepartmentComboBox.getItems().add(Result.getString("department"));
        }
    }

    public String DepartmentQuery() throws SQLException {
        String dept_id = " ";
        if (searchDepartmentComboBox.getValue() != null) {
            String temp = searchDepartmentComboBox.getValue().toString();
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
        if (searchCategoryComboBox.getValue() != null) {
            String sql = "select * from category_table where category = ?";

            PreStmt = Con.prepareStatement(sql);
            PreStmt.setString(1, searchCategoryComboBox.getValue().toString());
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
            searchCategoryComboBox.getItems().add(Result.getString("Category"));
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
            searchSubCategoryComboBox.getItems().add(Result.getString("SubCategory"));
        }

    }

    @FXML
    public void searchDeparmentComboBoxAction() throws SQLException {
        searchCategoryComboBox.getItems().clear();
        CategoryComboList();

    }

    @FXML
    public void searchCategoryComboBoxAction() throws SQLException {
        searchSubCategoryComboBox.getItems().clear();
        SubCategoryComboList();

    }

    @FXML
    public void searchSubCategoryComboBoxAction() throws SQLException {
        resultNotFoundLabel.setVisible(false);
        if (searchCategoryComboBox.getValue() != null) {
            String sql = "select distinct name,Department,Category,block,"
                    + "SubCategory from product_table where product_table.subcategory= ?";
            PreStmt = Con.prepareStatement(sql);
            PreStmt.setString(1, searchSubCategoryComboBox.getValue().toString());
            ResultSet rs = PreStmt.executeQuery();
            vbox.setSpacing(20);
            vbox.setPadding(new Insets(20,20,20,20));
            while (rs.next()==true) 
            {
                
                        Pane pane = new Pane();
                        pane.setPrefSize(500, 100);
                        pane.setStyle("-fx-background-color: #6ccccc;");
                        Label name = new Label();
                        name.setText(rs.getString("name"));
                        Label department = new Label();
                        department.setText(rs.getString("department"));
                        department.setTranslateX(300);
                        Label block = new Label();
                        block.setText("    block='"+rs.getString("block")+"'");
                        block.setTranslateX(200);
                        pane.getChildren().addAll(name, department,block);
                        
                         vbox.getChildren().add(pane);
   
                resultScrollPane.setContent(vbox);
     
            }
              
            }
          

}

@Override
        public void initialize(URL url, ResourceBundle rb) {
        // TODO
        DbConnection connect = new DbConnection();
        try {
            Con = connect.DbConnect();
             DepartmentComboList();
        

} catch (ClassNotFoundException ex) {
            Logger.getLogger(SearchController.class
.getName()).log(Level.SEVERE, null, ex);
        

} catch (SQLException ex) {
            Logger.getLogger(SearchController.class
.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
}
