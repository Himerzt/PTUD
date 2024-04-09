/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Huynguyen
 */
public class DichVuPhong {
    
    private String name;
    private int quantity;
    private double prices;

    public DichVuPhong(String name, double price) {
        this.name = name;
        this.quantity = 1; // Số lượng ban đầu là 1
        this.prices = price;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void increaseQuantity() {
        quantity++; // Tăng số lượng lên 1
    }

    public double getPrices() {
        return prices;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrices(double prices) {
        this.prices = prices;
    }
    
    
    
    
}
