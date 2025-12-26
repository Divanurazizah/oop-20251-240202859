package main.java.com.upb.agripos;

public class Product {
    private String nama;
    private double harga;

    public Product(String nama, double harga) {
        this.nama = nama;
        this.harga = harga;
    }

    public String getNama() {
        return nama;
    }

    public double getHarga() {
        return harga;
    }
}
