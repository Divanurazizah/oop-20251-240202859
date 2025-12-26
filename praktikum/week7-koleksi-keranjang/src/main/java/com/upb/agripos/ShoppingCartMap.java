package main.java.com.upb.agripos;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCartMap {

    private Map<Product, Integer> items = new HashMap<>();

    public void tambahProduk(Product p) {
        items.put(p, items.getOrDefault(p, 0) + 1);
    }

    public void hapusProduk(Product p) {
        if (!items.containsKey(p)) return;

        int qty = items.get(p);
        if (qty > 1) {
            items.put(p, qty - 1);
        } else {
            items.remove(p);
        }
        System.out.println("\nMenghapus produk: " + p.getNama());
    }

    public double hitungTotal() {
        double total = 0;
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            total += entry.getKey().getHarga() * entry.getValue();
        }
        return total;
    }

    public void tampilkanKeranjang() {
        System.out.println("\nKeranjang Belanja (Map):");
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            System.out.println("- " + entry.getKey().getNama() + " x" + entry.getValue() +
                   " = " + (entry.getKey().getHarga() * entry.getValue()));
        }
        System.out.println("Total: " + hitungTotal());
    }
}
