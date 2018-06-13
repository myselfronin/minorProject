/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DEO;

import com.jfoenix.controls.JFXComboBox;
import java.net.URL;
import java.util.ResourceBundle;
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

    @FXML private AnchorPane productAnchorPane;
    
@FXML private Label usernameLabel;
@FXML private TextField newBarCodeTextField;
@FXML private TextField newCodeTextField;
@FXML private TextField newNameTextField;
@FXML private JFXComboBox<?> newDepartmentComboBox;
@FXML private JFXComboBox<?> newCategoryComboBox;
@FXML private ChoiceBox<?> newSubCategoryChoiceBox;

@FXML private AnchorPane newAnchorPane;
@FXML private AnchorPane editAnchorPane;
@FXML private AnchorPane addAnchorPane;

@FXML private TextField addBarCodeTextField;
@FXML private TextField addCodeTextField;
@FXML private TextField  addCostPriceTextField;
@FXML private TextField  addMRPTextField;
@FXML private DatePicker addExpireDatePicker;
@FXML private Label addNameLabel;
@FXML private Label addDepartmentLabel;
@FXML private Label addCategoryLabel;
@FXML private Label addSubCategoryLabel;
        


    @FXML
    void customerBtnPushed(ActionEvent event) {
        
    }

    @FXML
    void productAddSideMenuBtnPushed(ActionEvent event) {
            addAnchorPane.toFront();
    }

    @FXML
    void productBtnPushed(ActionEvent event) {
            productAnchorPane.toFront();
    }

    @FXML
    void productEditSideMenuBtnPushed(ActionEvent event) {
           editAnchorPane.toFront();
    }

    @FXML
    void productNewSideMenuBtnPushed(ActionEvent event) {
            newAnchorPane.toFront();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
