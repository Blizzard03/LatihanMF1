/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mariq.rasyid.latihanmf1;

import com.mariq.rasyid.latihanmf1.Model.FunitureModel;
import java.net.URL;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Blizzard
 */
public class FXMLOutputController implements Initializable {
    // //Curency Formatter

    Locale Indonesia = new Locale("in", "ID");
    NumberFormat formater = NumberFormat.getCurrencyInstance(Indonesia);
    
    @FXML
    private Label custumername;
    @FXML
    private Label funituretype;
    @FXML
    private Label qty;
    @FXML
    private Label qty_total;
    @FXML
    private Label price;
    @FXML
    private Label sumprice;
    @FXML
    private Label discount;
    @FXML
    private Label totalprice;
    @FXML
    private Button closebtn;
    @FXML
    private Button Backbtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    @FXML
    private void close_btn_click(ActionEvent event) {
        System.exit(0);
    }
    
    @FXML
    private void Backbtnclick(ActionEvent event) {
        Backbtn.getScene().getWindow().hide();
    }
    
    public void getValue(FunitureModel mdl) {
        String Funiture = "";
        double Price = 0, Discount = 0;
        switch (mdl.getFunituretype()) {
            case 1: {
                Funiture = "Cupboard";
                if (mdl.getCategory() == 1) {
                    Price = 800000;
                    Discount = 0;
                } else if (mdl.getCategory() == 2) {
                    Price = 1000000;
                    Discount = 0;
                }
                break;
            }
            case 2: {
                Funiture = "Table";
                if (mdl.getCategory() == 1) {
                    Price = 300000;
                    Discount = 0;
                } else if (mdl.getCategory() == 2) {
                    Price = 500000;
                    Discount = 0;
                }
                break;
            }
            case 3: {
                Funiture = "Chair";
                if (mdl.getCategory() == 1) {
                    Price = 200000;
                    if (Price <= 10000000) {
                        Discount = Price * 0.1;
                    } else {
                        Discount = 0;
                    }
                    
                } else if (mdl.getCategory() == 2) {
                    Price = 350000;
                    if (Price <= 10000000) {
                        Discount = Price * 0.1;
                    } else {
                        Discount = 0;
                    }
                }
                break;
            }
            default: {
                Funiture = "404 NOT FOUND";
                Price = 0;
               Discount = 0;
                break;
            }
        }
        
        double total_price = Price * mdl.getQty();
        double SumTotal = total_price - Discount;
        custumername.setText(mdl.getCustumername());
        funituretype.setText(Funiture);
        qty.setText(String.valueOf(mdl.getQty()));
        qty_total.setText(String.valueOf(mdl.getQty()));
        price.setText(formater.format(Price));
        sumprice.setText(formater.format(total_price));
        discount.setText(formater.format(Discount));
        totalprice.setText(formater.format(SumTotal));
        
        
    }
    
}
