package com.upb.agripos;

import com.upb.agripos.view.ProductTableView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.DriverManager;

public class AppJavaFX extends Application {
    private Connection connection;
    
    @Override
    public void init() throws Exception {
        // Initialize database connection
        String url = "jdbc:postgresql://localhost:5432/agripos_db";
        String user = "postgres";
        String password = "password";
        
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Database connected successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Agri-POS - Management Produk");
        
        ProductTableView productView = new ProductTableView(connection, primaryStage);
        Scene scene = new Scene(productView.getView(), 800, 500);
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    @Override
    public void stop() throws Exception {
        if (connection != null && !connection.isClosed()) {
            connection.close();
            System.out.println("Database connection closed.");
        }
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}