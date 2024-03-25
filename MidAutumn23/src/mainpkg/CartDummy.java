/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpkg;

/**
 *
 * @author Asus
 */
public class CartDummy {
    private String productName;
    private float unitPrice;
    private int vatRate;
    private int quantity;
    private float vatAmount;
    private float totalAmount;

    public CartDummy(String productName, float unitPrice, int vatRate, int quantity, float vatAmount, float totalAmount) {
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.vatRate = vatRate;
        this.quantity = quantity;
        this.vatAmount = vatAmount;
        this.totalAmount = totalAmount;
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

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getVatRate() {
        return vatRate;
    }

    public void setVatRate(int vatRate) {
        this.vatRate = vatRate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getVatAmount() {
        return vatAmount;
    }

    public void setVatAmount(float vatAmount) {
        this.vatAmount = vatAmount;
    }

    public float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return "CartDummy{" + "productName=" + productName + ", unitPrice=" + unitPrice + ", vatRate=" + vatRate + ", quantity=" + quantity + ", vatAmount=" + vatAmount + ", totalAmount=" + totalAmount + '}';
    }
    
}
