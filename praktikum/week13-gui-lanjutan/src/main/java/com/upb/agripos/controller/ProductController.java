package com.upb.agripos.controller;

import com.upb.agripos.model.Product;
import com.upb.agripos.service.ProductService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.Connection;

public class ProductController {
    private ProductService productService;
    private ObservableList<Product> productList;
    
    public ProductController(Connection connection) {
        this.productService = new ProductService(connection);
        this.productList = FXCollections.observableArrayList();
        loadData();
    }
    
    public ObservableList<Product> getProductList() {
        return productList;
    }
    
    public void loadData() {
        productList.clear();
        productList.addAll(productService.findAll());
    }
    
    public boolean addProduct(Product product) {
        boolean success = productService.addProduct(product);
        if (success) {
            loadData();
        }
        return success;
    }
    
    public boolean deleteProduct(String code) {
        boolean success = productService.deleteProduct(code);
        if (success) {
            loadData();
        }
        return success;
    }
}