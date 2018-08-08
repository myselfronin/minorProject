/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cashier;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.Month;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import Connectivity.DbConnection;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.layout.AnchorPane;
import Main.HomeController;
import javafx.scene.Node;
import javax.print.*;



/**
 * FXML Controller class
 *
 * @author Rabinson
 */
public class CashierWindowController implements Initializable 
{ 
    int Price,Quantity,total_price,pid;
    static int sn=1;
    String Name, cashier_id;
    
    @FXML
    private Label cashierNameLabel;
    @FXML
    private AnchorPane returnAnchorPane;
    @FXML
    private AnchorPane saleAnchorPane;
    @FXML
    private TextField barcode;
    @FXML
    private Label iName, iPrice;
    @FXML
    private ComboBox combo_batch;
    @FXML
    private Label invoiceDateLabel;
    @FXML
    private Label invoiceNoLabel;
    ResultSet result1;
    Connection Con;
   
    LocalDate exp1,exp2,exp;
    int batch1,batch2;
    public void logoutBtnPushed(ActionEvent event)
    {
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }
    public void barcode_action(ActionEvent event) throws SQLException
    {
        combo_batch.setVisible(false);
        combo_batch.getItems().clear();
        try
        {
            String iBarcode=barcode.getText();
             
            String sql="SELECT batch_table.batch_No,batch_table.MRP, product_table.Name,batch_table.expire_date "
                    + "from batch_table inner join product_table "
                    + "on product_table.product_Id=batch_table.product_Id "
                    + "and product_table.BarCode like'"+iBarcode+"' and batch_table.Type like 'regular'" ;
            Statement statement=Con.createStatement();
            
            ResultSet result = statement.executeQuery(sql);
            
                    
     //hya change xa
            result.next();           
            combo_batch.getItems().add(result.getInt("batch_no")+"   "+result.getDate("expire_date"));
            exp1=result.getDate("expire_date").toLocalDate();
            batch1=result.getInt("batch_no");
            result.next();  
            combo_batch.getItems().add(result.getInt("batch_no")+"   "+result.getDate("expire_date"));
            exp2=result.getDate("expire_date").toLocalDate();
            batch2=result.getInt("batch_no");
              
        }
        catch (SQLException ex)
        {
             System.out.println(ex);
                    
        }
        combo_batch.setVisible(true);
       
       
        
    }
    public void batch_combo(ActionEvent e) throws SQLException
    {
        String iBarcode=barcode.getText();
        String a=combo_batch.getValue().toString();
        
        char b=a.charAt(0); 
        
        int batch= Integer.parseInt(String.valueOf(b));
        if(batch1==batch)
        {
            exp=exp1;
        }
        else
        {
            exp=exp2;
        }
        
        try
        {
            String sql="SELECT batch_table.batch_No,batch_table.MRP,batch_table.product_Id ,product_table.Name,batch_table.expire_date "
               + "from batch_table inner join product_table "
               + "on product_table.product_Id=batch_table.product_Id "
                    + "and product_table.BarCode='"+iBarcode+"' and batch_table.Type like 'regular' and  batch_table.batch_No="+batch  ;
            Statement statement=Con.createStatement();
            
            ResultSet result = statement.executeQuery(sql);
            result.next();
            Price=result.getInt("MRP");
            pid=result.getInt("product_Id");
            Name=result.getString("Name");
            
            iName.setText(Name);
            iPrice.setText(Integer.toString(Price));
        }
        catch(SQLException ex)            
        {
           System.out.println(ex); 
        }       
    }
    //quantty enter gare paxi ko
    @FXML
    Label subTotal;
    @FXML
    TextField quantity;
    public void quantity(ActionEvent e)
    {
        String quan= quantity.getText();
        Quantity= Integer.parseInt(String.valueOf(quan));
        total_price=Price*Quantity;
        subTotal.setText(Integer.toString(total_price));  
        
    }
    
   
    @FXML public TableView<bill_table> billTable;
    @FXML public TableColumn<bill_table, Integer> billSN;
    @FXML public TableColumn<bill_table, Integer> billPid;
    @FXML public TableColumn<bill_table, String> billName;
    @FXML public TableColumn<bill_table, Integer> billQuantity;
    @FXML public TableColumn<bill_table, Integer> billRate;
    @FXML public TableColumn<bill_table, Integer> billAmount;
    @FXML public TableColumn<bill_table, LocalDate> billexp;
    
    
    ObservableList<bill_table> items=FXCollections.observableArrayList();
    @FXML Label total;
    int total_sum=0;
    public void submit(ActionEvent e)
    {
         
         
       items.add(new bill_table(sn,pid,Name,Quantity,Price,total_price,exp));
        billTable.setItems(items);
        sn++; 

        total_sum=total_sum+total_price;
        total.setText(Integer.toString(total_sum));
        
    }
    @FXML TextField discount;
    @FXML Label final_amount;
    public void discount()
    {
        int dis=Integer.parseInt(discount.getText());
        int tot=total_sum-total_sum*dis/100;
        final_amount.setText(Integer.toString(tot));
        
       
    }
    public void remove_row(ActionEvent e)
    {
        int selectedIndex = billTable.getSelectionModel().getSelectedIndex();
        int dec= billAmount.getCellObservableValue(selectedIndex).getValue();  
        total_sum = total_sum -dec;
        total.setText(Integer.toString(total_sum));
        billTable.getItems().remove(selectedIndex);
    }
    public void print() throws FileNotFoundException, IOException, PrintException, SQLException,NullPointerException
    {
        
        File print = new File("print.txt");
        print.delete();
        RandomAccessFile output=null;
        output=new RandomAccessFile("print.txt","rw");
        
        int type=0,seek=0;
        //System.out.print(billSN.getCellObservableValue(3).getValue());
        int SN,qty,rate,amount;
        String name;
       
        try{
        for(;billSN.getCellObservableValue(type).getValue()!=null;)
        {
            SN= billSN.getCellObservableValue(type).getValue();
            name= billName.getCellObservableValue(type).getValue();
            qty= billQuantity.getCellObservableValue(type).getValue();
            rate= billRate.getCellObservableValue(type).getValue();
            amount= billAmount.getCellObservableValue(type).getValue();
            
            
            output.seek(seek);
            output.writeChars(Integer.toString(SN));
            output.seek(seek+8);
            output.writeChars(name);
            output.seek(seek+32);
            output.writeChars(Integer.toString(qty));
            output.seek(seek+40);
            output.writeChars(Integer.toString(rate));
            output.seek(seek+48);
            output.writeChars(Integer.toString(amount));
            type++;
            seek=1024*type;                        
        }}
        catch (NullPointerException ex)
                {
                    
                }
        output.seek(seek+36);
        output.writeChars("total= "+total.getText());
        output.seek(seek+1024*2+9);
        output.writeChars("total with discount= "+final_amount.getText());
        
        File file = new File("print.vbs");
        Desktop desktop = Desktop.getDesktop();       
        desktop.open(file);
        String sql = "insert into invoice_table (amount,date, cashier_id) values(?,?,?); ";
        PreparedStatement PreS = Con.prepareStatement(sql);
        PreS.setString(1, total.getText());
        PreS.setString(2,invoiceDateLabel.getText());
        PreS.setString(3,cashier_id);
        PreS.executeUpdate();
        //aaba database ma change garaune
        
        type=0;
        try{
        for(;billSN.getCellObservableValue(type).getValue()!=null;)
        {
              try{     
                    sql="update batch_table set "
                    + "SoldQty=SoldQty+'"+billQuantity.getCellObservableValue(type).getValue()+"' Where Product_Id='"+billPid.getCellObservableValue(type).getValue()+"'and expire_date='"+Date.valueOf(billexp.getCellObservableValue(type).getValue())+"'";
                    Statement statement=Con.prepareStatement(sql);            
                    int result = statement.executeUpdate(sql);
                    sql="update batch_table set Type='sold' where batch_table.Entry_Qty=batch_table.SoldQty";
                    statement=Con.prepareStatement(sql);            
                    result = statement.executeUpdate(sql);
              }
              catch (SQLException exe)
                      {
                        System.out.println(exe);  
                      }
             type++;
        }
        }
        catch(NullPointerException ex)
        {
            
        }
        barcode.setText(null);
        combo_batch.setVisible(false);
        quantity.setText(null);
        iName.setText(null);
        iPrice.setText(null);
        subTotal.setText(null);
        total.setText(null);
        final_amount.setText(null);
        discount.setText(null);
        billTable.getItems().clear();
        invoiceNoQuery();
        sn=1;
        
    }
    public void invoiceNoQuery() throws SQLException
    {
        String sql = "SELECT * FROM invoice_table ORDER BY invoice_number DESC LIMIT 1";
        PreparedStatement statement = Con.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();
        int number = 0;
        if(rs.next())
        {
            number = rs.getInt("invoice_number") + 1;
            
        }
        else
        {
            number = 1;
        }
       invoiceNoLabel.setText(Integer.toString(number));

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        sn=1;
        HomeController home = new HomeController();
        cashierNameLabel.setText(home.cashierName);
        cashier_id = home.cashierId;
        DbConnection connect = new DbConnection();
        try {
            Con= connect.DbConnect();
             invoiceNoQuery();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CashierWindowController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CashierWindowController.class.getName()).log(Level.SEVERE, null, ex);
        }
        combo_batch.setVisible(false);
        exp=LocalDate.of(0000, Month.JANUARY, 1);
         DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        java.util.Date dateobj = new java.util.Date();
        
        invoiceDateLabel.setText(df.format(dateobj));
        
        
        billName.setCellValueFactory(new PropertyValueFactory<bill_table,String>("billName"));
        billPid.setCellValueFactory(new PropertyValueFactory<bill_table,Integer>("billPid"));
        billSN.setCellValueFactory(new PropertyValueFactory<bill_table,Integer>("billSN"));
        billQuantity.setCellValueFactory(new PropertyValueFactory<bill_table,Integer>("billQuantity"));
        billRate.setCellValueFactory(new PropertyValueFactory<bill_table,Integer>("billRate"));
        billAmount.setCellValueFactory(new PropertyValueFactory<bill_table,Integer>("billAmount"));
        billexp.setCellValueFactory(new PropertyValueFactory<bill_table,LocalDate>("billexp"));
    }    
}

