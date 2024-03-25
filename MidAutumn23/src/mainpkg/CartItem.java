/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpkg;

/**
 *
 * @author Asus
 */
public class CartItem {
    private String productName;
    private final float unitPrice;
    private final int vatRate;
    private int quantity;

    public CartItem(String productName, float unitPrice, int vatRate, int quantity) {
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.vatRate = vatRate;
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getUnitPrice() {
        return unitPrice;
    }


    public int getVatRate() {
        return vatRate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "CartItem{" + "productName=" + productName + ", unitPrice=" + unitPrice + ", vatRate=" + vatRate + ", quantity=" + quantity + '}';
    }
    
    public float getVatAmount(){
        float answer = this.unitPrice * this.vatRate * this.quantity / 100;
        return answer;
    }
    
    public float getTotalAmount() {
        float answer2 = this.unitPrice * ((100 + this.vatRate) / 100);
        answer2 = answer2 * this.quantity;
        return answer2;
    }
    
}
