/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpkg;

/**
 *
 * @author Asus
 */
public class ProductInfo {
    private String productName;
    private int unitPrice;
    private int vatRate;

    public ProductInfo(String productName, int unitPrice, int vatRate) {
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.vatRate = vatRate;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getVatRate() {
        return vatRate;
    }

    public void setVatRate(int vatRate) {
        this.vatRate = vatRate;
    }

    @Override
    public String toString() {
        return "ProductInfo{" + "productName=" + productName + ", unitPrice=" + unitPrice + ", vatRate=" + vatRate + '}';
    }
}
