package com.upb.agripos;

import com.upb.agripos.controller.ProductController;
import com.upb.agripos.dao.ProductDAO;
import com.upb.agripos.service.ProductService;
import com.upb.agripos.view.ProductFormView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppJavaFX extends Application {

    @Override
    public void start(Stage stage) {
        ProductDAO dao = new ProductDAO();
        ProductService service = new ProductService(dao);
        ProductController controller = new ProductController(service);

        ProductFormView view = new ProductFormView(controller);

        stage.setTitle("Agri-POS - Form Produk");
        stage.setScene(new Scene(view, 400, 400));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
