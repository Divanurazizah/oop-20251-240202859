package main.java.com.upb.agripos.view;

public class ConsoleView {
    public void showProduct(String code, String name, double price) {
        System.out.println("Produk: " + code + " | " + name + " | Harga: " + price);
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}
