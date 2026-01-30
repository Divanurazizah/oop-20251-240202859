package com.upb.agripos.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.upb.agripos.model.Product;

public class ProductDAOImpl implements ProductDAO {

    private Connection conn;

    public ProductDAOImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Product product) {
        System.out.println("Produk ditambahkan: " + product.getName());
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>();
    }
}
