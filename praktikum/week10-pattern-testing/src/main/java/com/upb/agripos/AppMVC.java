package main.java.com.upb.agripos;

import main.java.com.upb.agripos.config.DatabaseConnection;
import main.java.com.upb.agripos.controller.ProductController;
import main.java.com.upb.agripos.model.Product;
import main.java.com.upb.agripos.view.ConsoleView;

public class AppMVC {
    public static void main(String[] args) {
        System.out.println("Hello, I am Diva Nur Azizah-240202859 (Week10)");

        // Singleton Database Connection
        DatabaseConnection db = DatabaseConnection.getInstance();
        db.connect();

        // MVC Product
        Product product = new Product("P01", "Pupuk Organik", 50000);
        ConsoleView view = new ConsoleView();
        ProductController controller = new ProductController(product, view);
        controller.showProduct();
    }
}
