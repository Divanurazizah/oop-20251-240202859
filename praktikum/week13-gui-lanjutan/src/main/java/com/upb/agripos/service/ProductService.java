package com.upb.agripos.service;

import com.upb.agripos.dao.ProductDAO;
import com.upb.agripos.model.Product;
import java.sql.Connection;
import java.util.List;

public class ProductService {
    private ProductDAO productDAO;
    
    public ProductService(Connection connection) {
        this.productDAO = new ProductDAO(connection);
    }
    
    public List<Product> findAll() {
        return productDAO.findAll();
    }
    
    public boolean addProduct(Product product) {
        // Validasi: cek apakah kode sudah ada
        Product existing = productDAO.findByCode(product.getCode());
        if (existing != null) {
            throw new IllegalArgumentException("Kode produk sudah ada");
        }
        
        return productDAO.insert(product);
    }
    
    public boolean deleteProduct(String code) {
        return productDAO.delete(code);
    }
    
    public Product getProductByCode(String code) {
        return productDAO.findByCode(code);
    }
}