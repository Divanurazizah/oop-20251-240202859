package com.upb.agripos.model;

import javafx.beans.property.*;

public class Product {
    private final StringProperty code;
    private final StringProperty name;
    private final DoubleProperty price;
    private final IntegerProperty stock;
    
    public Product() {
        this.code = new SimpleStringProperty();
        this.name = new SimpleStringProperty();
        this.price = new SimpleDoubleProperty();
        this.stock = new SimpleIntegerProperty();
    }
    
    public Product(String code, String name, double price, int stock) {
        this.code = new SimpleStringProperty(code);
        this.name = new SimpleStringProperty(name);
        this.price = new SimpleDoubleProperty(price);
        this.stock = new SimpleIntegerProperty(stock);
    }
    
    // Getters and Setters
    public String getCode() { return code.get(); }
    public void setCode(String code) { this.code.set(code); }
    public StringProperty codeProperty() { return code; }
    
    public String getName() { return name.get(); }
    public void setName(String name) { this.name.set(name); }
    public StringProperty nameProperty() { return name; }
    
    public double getPrice() { return price.get(); }
    public void setPrice(double price) { this.price.set(price); }
    public DoubleProperty priceProperty() { return price; }
    
    public int getStock() { return stock.get(); }
    public void setStock(int stock) { this.stock.set(stock); }
    public IntegerProperty stockProperty() { return stock; }
}