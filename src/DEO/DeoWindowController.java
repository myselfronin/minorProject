/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DEO;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Rabinson
 */
public class DeoWindowController implements Initializable {

    /**
     * Initializes the controller class.
     */
     @FXML
    private TextField addBarCodeTextField;

    @FXML
    private TextField addCodeTextField;

    @FXML
    private TextField addNameTextField;

    @FXML
    private ChoiceBox<?> addCategoryTextField;
    
    @FXML
    private ChoiceBox<?> addSubCategoryTextField;

    @FXML
    private TextField addCostPriceTextField;

    @FXML
    private TextField addMRPTextField;

    @FXML
    private TextField addQtyTextField;

    @FXML
    private DatePicker addExpireDatePicker;

    @FXML
    private TextField updateBarCodeTextField;

    @FXML
    private TextField updateCodeTextField;

    @FXML
    private Label updateNameLabel;

    @FXML
    private Label updateCategoryLabel;
    
      @FXML
    private Label updateSubCategoryLabel;

    @FXML
    private TextField updateCostPriceTextField;

    @FXML
    private TextField updateMRPTextField;

    @FXML
    private Label updateQtyLabel;

    @FXML
    private Label updateExpireDateLabel;

    @FXML
    private TextField updateQtyTextField;
    
  
    @FXML
    private AnchorPane ProductPane;
    @FXML
    private AnchorPane OtherPane;
    @FXML
    private AnchorPane AddPane;
    @FXML
    private AnchorPane UpdatePane;
    
    @FXML
    public void productSideMenuAddBtnPushed()
    {
       AddPane.toFront();
    }
    
    @FXML
    public void productSideMenuUpdateBtnPushed()
    {
        UpdatePane.toFront();
    }
    
    @FXML
    public void ProductBtnPushed()
    {
         ProductPane.toFront();
    }
    
    @FXML
    public void OtherBtnPushed()
    {
        OtherPane.toFront();
    }
    
    @FXML
    public void addProductBtnPushed(){
        
    }
    
    @FXML
    public void updateProductBtnPushed()
    {
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
