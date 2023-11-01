/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mariq.rasyid.latihanmf1;

import com.mariq.rasyid.latihanmf1.Model.FunitureModel;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Blizzard
 */
public class FXMLInputController implements Initializable {
    //Model

    FunitureModel mdl = new FunitureModel();
    @FXML
    private TextField txt_name;
    @FXML
    private TextField txtqty;
    @FXML
    private ComboBox<String> cmbtype;
    @FXML
    private ComboBox<String> cmbcategory;
    @FXML
    private Button btnorder;
    @FXML
    private Button btn_cancel;
    @FXML
    private Button btn_quit;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        /*
        Initialize Funitures List
         */
        cmbtype.setItems(FXCollections.observableArrayList(
                "--Select your Funitures--", "Cupboard", "Table", "Chair"));
        cmbtype.getSelectionModel().select(0);

        /*
        Initialize Category List
         */
        cmbcategory.setItems(FXCollections.observableArrayList(
                "--Select Categories--", "Common", "Luxury"));
        cmbcategory.getSelectionModel().select(0);
    }

    @FXML
    private void orderclick(ActionEvent event) {
        mdl.setCustumername(txt_name.getText());
        mdl.setQty(Integer.parseInt(txtqty.getText()));
        mdl.setFunituretype(cmbtype.getSelectionModel().getSelectedIndex());
        mdl.setCategory(cmbcategory.getSelectionModel().getSelectedIndex());
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/mariq/rasyid/latihanmf1/FXML/FXMLOutput.fxml"));
            Parent root = (Parent) loader.load();
            
            FXMLOutputController value
                    = (FXMLOutputController) loader.getController();
            value.getValue(mdl);
            
            Scene scene = new Scene(root);
            Stage stg = new Stage();
            stg.setResizable(false);
            stg.setIconified(false);
            
            stg.setScene(scene);
            stg.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void cancelclick(ActionEvent event) {
        txt_name.setText("");
        txtqty.setText("");
        cmbtype.setValue("--Select your Funitures--");
        cmbcategory.setValue("--Select Categories--");

    }

    @FXML
    private void quitclick(ActionEvent event) {
        System.exit(0);
    }

}
