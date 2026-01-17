package com.upb.agripos;

public class MainExceptionDemo {
    public static void main(String[] args) {

        System.out.println("Hello, I am Diva Nur Azizah-240202859 (Week 9)");

        ShoppingCart cart = new ShoppingCart();
        Product p1 = new Product("P01", "Pupuk Organik", 25000, 3);

        // Uji quantity tidak valid
        try {
            cart.addProduct(p1, -2);
        } catch (InvalidQuantityException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Uji hapus produk yang belum ada
        try {
            cart.removeProduct(p1);
        } catch (ProductNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Uji stok tidak cukup
        try {
            cart.addProduct(p1, 5);
            cart.checkout();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
