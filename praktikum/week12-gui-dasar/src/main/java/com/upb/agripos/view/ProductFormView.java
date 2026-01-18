package com.upb.agripos.view;

import com.upb.agripos.controller.ProductController;
import com.upb.agripos.model.Product;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class ProductFormView extends VBox {

    public ProductFormView(ProductController controller) {

        TextField txtCode = new TextField();
        txtCode.setPromptText("Kode Produk");

        TextField txtName = new TextField();
        txtName.setPromptText("Nama Produk");

        TextField txtPrice = new TextField();
        txtPrice.setPromptText("Harga");

        TextField txtStock = new TextField();
        txtStock.setPromptText("Stok");

        Button btnAdd = new Button("Tambah Produk");

        ListView<String> listView = new ListView<>();

        btnAdd.setOnAction(event -> {
            try {
                Product product = new Product(
                        txtCode.getText(),
                        txtName.getText(),
                        Double.parseDouble(txtPrice.getText()),
                        Integer.parseInt(txtStock.getText())
                );

                controller.addProduct(product);

                listView.getItems().add(
                        product.getCode() + " - " + product.getName()
                );

                txtCode.clear();
                txtName.clear();
                txtPrice.clear();
                txtStock.clear();

            } catch (NumberFormatException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Harga dan stok harus berupa angka!");
                alert.show();
            }
        });

        this.setSpacing(10);
        this.getChildren().addAll(
                txtCode, txtName, txtPrice, txtStock,
                btnAdd, listView
        );
    }
}
