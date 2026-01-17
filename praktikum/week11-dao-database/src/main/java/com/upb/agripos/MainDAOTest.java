package com.upb.agripos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import com.upb.agripos.dao.ProductDAO;
import com.upb.agripos.dao.ProductDAOImpl;
import com.upb.agripos.model.Product;

public class MainDAOTest {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/agripos";
        String user = "postgres";
        String pass = "1234";

        try (Connection conn = DriverManager.getConnection(url, user, pass)) {

            ProductDAO dao = new ProductDAOImpl(conn);

            // Insert
            Product p1 = new Product("P01", "Pupuk Organik", 25000, 10);
            dao.insert(p1);
            System.out.println("Inserted: " + p1);

            // Update
            p1.setName("Pupuk Organik Premium");
            p1.setPrice(30000);
            p1.setStock(8);
            dao.update(p1);
            System.out.println("Updated: " + p1);

            // Find by code
            Product found = dao.findByCode("P01");
            System.out.println("Found: " + found);

            // Find all
            List<Product> allProducts = dao.findAll();
            System.out.println("All Products:");
            for (Product prod : allProducts) {
                System.out.println(prod);
            }

            // Delete
            dao.delete("P01");
            System.out.println("Deleted P01");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
