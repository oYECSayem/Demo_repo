/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package mainpkg;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author Asus
 */
public class MainSceneController implements Initializable {
    
    @FXML
    private ComboBox<String> productCB;
    @FXML
    private ComboBox<Integer> qtyCB;
    @FXML
    private Label afterCheckoutLabel;
    @FXML
    private TableView<CartDummy> cartTV;
    @FXML
    private TableColumn<CartDummy, String> productNameTC;
    @FXML
    private TableColumn<CartDummy, Float> priceTC;
    @FXML
    private TableColumn<CartDummy, Integer> qtyTC;
    @FXML
    private TableColumn<CartDummy, Integer> vatTC;
    @FXML
    private TableColumn<CartDummy, Float> vatAmountTC;
    @FXML
    private TableColumn<CartDummy, Float> totalAmountTC;
    @FXML
    private TextField maxPriceTF;
    @FXML
    private ComboBox<Integer> vatCB;
    @FXML
    private Label totalVatLabel;
    @FXML
    private Label unitPriceLabel;
    @FXML
    private Label vatLabel;
    private ArrayList<CartItem> cartList = new ArrayList<>();
    private ArrayList<ProductInfo> prodList = new ArrayList<>();
    Alert tryAgain = new Alert(Alert.AlertType.WARNING, "Error, try again!");
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String[] products = {"Lux Soap White 100gm", "Lux Soap Pink 200gm", "Nescafe Gold 100gm",
        "Rui Fish kg Pack", "Aarong Milk 1ltr", "Aarong Mocha Milk", "Mr. Twist Chips 50gm",
        "Lay's Chips 100gm", "Mojo 500ml", "CP Sausage 250gm"};
        productCB.getItems().addAll(products);
        
        for (int i=1; i<11; i++) {
            qtyCB.getItems().add(i);
        }
        
        for (int j=1; j<26; j++) {
            vatCB.getItems().add(j);
        }
        
        for (int k=0; k<10; k++) {
            prodList.add(new ProductInfo(products[k], (200-10*k), k+2));
        }
        
        System.out.println(prodList);
        
    }    

    @FXML
    private void addProductToCartButtonOnClick(ActionEvent event) {
        String productName = productCB.getValue();
        if (productName.isEmpty()) {
            tryAgain.show();
            return;
        }
        
        int qty = qtyCB.getValue();
//        if (qty == null) {
//            tryAgain.show();
//            return;
//        }
        
        int unitP = 0;
        int vatR = 0;
        for (ProductInfo p : prodList){
            if (p.getProductName().equals(productName)){
                unitP = p.getUnitPrice();
                vatR = p.getVatRate();
                break;
            }
        }
        
        boolean flag = true;
        for (CartItem c : cartList){
            if (c.getProductName().equals(productName)){
                c.setQuantity(c.getQuantity()+qty);
                flag = false;
            }
        }
        
        if (flag){
            CartItem newItem = new CartItem(productName, unitP, qty, vatR);
            cartList.add(newItem);
        }
        
        System.out.println(cartList);
        
        productNameTC.setCellValueFactory(new PropertyValueFactory<>("productName"));
        priceTC.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        qtyTC.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        vatTC.setCellValueFactory(new PropertyValueFactory<>("vatRate"));
        vatAmountTC.setCellValueFactory(new PropertyValueFactory<>("vatAmount"));
        totalAmountTC.setCellValueFactory(new PropertyValueFactory<>("totalAmount"));
    }

    @FXML
    private void checkOutAndShowBillButtonOnClick(ActionEvent event) {
        
        float sum = 0f;
        //for i in myList
        for (CartItem c : cartList) {
            cartTV.getItems().add(
                    new CartDummy(c.getProductName(), c.getUnitPrice(), c.getVatRate(), c.getQuantity(),
                                    c.getVatAmount(), c.getTotalAmount()));
            sum += c.getTotalAmount();
        }
        
        afterCheckoutLabel.setText("After checkout, TOTAL amount payable is "+String.valueOf(sum)+" Tk, and the cart detail is:");
        
    }

    @FXML
    private void showTotalVatForQualifiedProductsButtonOnClick(ActionEvent event) {
        int maxPrice = 0;
        int vatSearch = 0;
        String maxPriceInput = maxPriceTF.getText();
        
        if (maxPriceInput.isEmpty()){
            tryAgain.show();
            return;
        } else {
            maxPrice = Integer.parseInt(maxPriceInput);
        }
        
        vatSearch = vatCB.getValue();
        
        float totalVat = 0f;
        for (CartItem c : cartList){
            if (c.getUnitPrice() <= maxPrice) {
                if (c.getVatRate() == vatSearch){
                    totalVat += c.getVatAmount();
                }
            }
        }
        
        System.out.println(totalVat);
        
        totalVatLabel.setText("The total VAT Amount for the products in the cart having unit price <="
                                + String.valueOf(maxPrice)+ " Tk with "+ String.valueOf(vatSearch) 
                                + "% vat is: "+ String.valueOf(totalVat) + " Tk");
        
        
        
    }

    @FXML
    private void updateProductValuesOnClick(ActionEvent event) {
        String productName = productCB.getValue();
        if (productName.isEmpty()) {
            return;
        }
        
        int unitP = 0;
        int vatR = 0;
        for (ProductInfo p : prodList){
            if (p.getProductName().equals(productName)){
                unitP = p.getUnitPrice();
                vatR = p.getVatRate();
                break;
            }
        }
        
        unitPriceLabel.setText(String.valueOf(unitP));
        vatLabel.setText(String.valueOf(vatR));
        
    }
    
}
