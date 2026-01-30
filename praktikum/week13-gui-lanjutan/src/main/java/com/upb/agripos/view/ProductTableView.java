package com.upb.agripos.view;

import com.upb.agripos.controller.ProductController;
import com.upb.agripos.model.Product;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.sql.Connection;

public class ProductTableView {
    private TableView<Product> tableView;
    private ProductController controller;
    private Stage primaryStage;
    
    public ProductTableView(Connection connection, Stage primaryStage) {
        this.controller = new ProductController(connection);
        this.primaryStage = primaryStage;
        initializeTableView();
    }
    
    private void initializeTableView() {
        // Create TableView
        tableView = new TableView<>();
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        
        // Create columns
        TableColumn<Product, String> codeCol = new TableColumn<>("Kode");
        codeCol.setCellValueFactory(new PropertyValueFactory<>("code"));
        codeCol.setMinWidth(100);
        
        TableColumn<Product, String> nameCol = new TableColumn<>("Nama Produk");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        nameCol.setMinWidth(200);
        
        TableColumn<Product, Double> priceCol = new TableColumn<>("Harga");
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        priceCol.setCellFactory(tc -> new TableCell<Product, Double>() {
            @Override
            protected void updateItem(Double price, boolean empty) {
                super.updateItem(price, empty);
                if (empty || price == null) {
                    setText(null);
                } else {
                    setText(String.format("Rp %,.2f", price));
                }
            }
        });
        priceCol.setMinWidth(150);
        
        TableColumn<Product, Integer> stockCol = new TableColumn<>("Stok");
        stockCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        stockCol.setMinWidth(80);
        
        tableView.getColumns().addAll(codeCol, nameCol, priceCol, stockCol);
        
        // Load data
        tableView.setItems(controller.getProductList());
    }
    
    public VBox getView() {
        // Create buttons
        Button btnAdd = new Button("Tambah Produk");
        Button btnDelete = new Button("Hapus Produk");
        Button btnRefresh = new Button("Refresh");
        
        // Apply styling
        btnAdd.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");
        btnDelete.setStyle("-fx-background-color: #f44336; -fx-text-fill: white;");
        btnRefresh.setStyle("-fx-background-color: #2196F3; -fx-text-fill: white;");
        
        // Button sizes
        btnAdd.setPrefWidth(120);
        btnDelete.setPrefWidth(120);
        btnRefresh.setPrefWidth(120);
        
        // Using Lambda Expressions for Event Handling
        btnAdd.setOnAction(e -> showAddProductDialog());
        btnDelete.setOnAction(e -> deleteSelectedProduct());
        btnRefresh.setOnAction(e -> controller.loadData());
        
        // Create button container
        HBox buttonBox = new HBox(10);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setPadding(new Insets(10));
        buttonBox.getChildren().addAll(btnAdd, btnDelete, btnRefresh);
        
        // Create main layout
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(10));
        vbox.getChildren().addAll(tableView, buttonBox);
        
        return vbox;
    }
    
    private void showAddProductDialog() {
        Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner(primaryStage);
        dialog.setTitle("Tambah Produk Baru");
        
        // Create form
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20));
        
        TextField txtCode = new TextField();
        TextField txtName = new TextField();
        TextField txtPrice = new TextField();
        TextField txtStock = new TextField();
        
        grid.add(new Label("Kode Produk:"), 0, 0);
        grid.add(txtCode, 1, 0);
        grid.add(new Label("Nama Produk:"), 0, 1);
        grid.add(txtName, 1, 1);
        grid.add(new Label("Harga:"), 0, 2);
        grid.add(txtPrice, 1, 2);
        grid.add(new Label("Stok:"), 0, 3);
        grid.add(txtStock, 1, 3);
        
        // Create buttons
        Button btnSave = new Button("Simpan");
        Button btnCancel = new Button("Batal");
        
        // Lambda expressions for button actions
        btnSave.setOnAction(e -> {
            try {
                String code = txtCode.getText().trim();
                String name = txtName.getText().trim();
                double price = Double.parseDouble(txtPrice.getText());
                int stock = Integer.parseInt(txtStock.getText());
                
                if (code.isEmpty() || name.isEmpty()) {
                    showAlert("Error", "Kode dan Nama tidak boleh kosong!");
                    return;
                }
                
                Product product = new Product(code, name, price, stock);
                boolean success = controller.addProduct(product);
                
                if (success) {
                    dialog.close();
                    showAlert("Sukses", "Produk berhasil ditambahkan!");
                } else {
                    showAlert("Error", "Gagal menambahkan produk!");
                }
            } catch (NumberFormatException ex) {
                showAlert("Error", "Harga dan Stok harus angka!");
            } catch (IllegalArgumentException ex) {
                showAlert("Error", ex.getMessage());
            }
        });
        
        btnCancel.setOnAction(e -> dialog.close());
        
        HBox buttonBox = new HBox(10);
        buttonBox.setAlignment(Pos.CENTER_RIGHT);
        buttonBox.getChildren().addAll(btnSave, btnCancel);
        
        grid.add(buttonBox, 1, 4);
        
        Scene scene = new Scene(grid, 400, 250);
        dialog.setScene(scene);
        dialog.showAndWait();
    }
    
    private void deleteSelectedProduct() {
        Product selected = tableView.getSelectionModel().getSelectedItem();
        if (selected != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Konfirmasi Hapus");
            alert.setHeaderText("Hapus Produk");
            alert.setContentText("Yakin ingin menghapus produk: " + selected.getName() + "?");
            
            // Lambda expression for confirmation
            alert.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    boolean success = controller.deleteProduct(selected.getCode());
                    if (success) {
                        showAlert("Sukses", "Produk berhasil dihapus!");
                    } else {
                        showAlert("Error", "Gagal menghapus produk!");
                    }
                }
            });
        } else {
            showAlert("Peringatan", "Pilih produk yang akan dihapus!");
        }
    }
    
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}