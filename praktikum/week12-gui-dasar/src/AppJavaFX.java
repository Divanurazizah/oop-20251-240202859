package com.upb.agripos;

import com.upb.agripos.controller.ProductController;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AppJavaFX extends Application {

    @Override
    public void start(Stage stage) {
        ProductController controller = new ProductController();

        Button btn = new Button("Tambah Produk");
        btn.setOnAction(e -> controller.handleAddProduct());

        VBox root = new VBox(10, btn);
        Scene scene = new Scene(root, 300, 200);

        stage.setTitle("Aplikasi Agripos");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
