package main.java.com.upb.agripos;

import java.util.ArrayList;

public class ShoppingCart {

    private ArrayList<Product> items = new ArrayList<>();

    public void tambahProduk(Product produk) {
        items.add(produk);
    }

    public void hapusProduk(Product produk) {
        items.remove(produk);
        System.out.println("\nMenghapus produk: " + produk.getNama());
    }

    public double hitungTotal() {
        double total = 0;
        for (Product p : items) {
            total += p.getHarga();
        }
        return total;
    }

    public void tampilkanKeranjang() {
        System.out.println("\nKeranjang Belanja:");
        for (Product p : items) {
            System.out.println("- " + p.getNama() + " = " + p.getHarga());
        }
        System.out.println("Total: " + hitungTotal());
    }
}
