package com.upb.agripos.model;

public class Produk {
    protected String kode;
    protected String nama;
    protected double harga;
    protected int stok;

    public Produk(String kode, String nama, double harga, int stok) {
        this.kode = kode;
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    public void getInfo() {
        System.out.println("Kode: " + kode);
        System.out.println("Nama: " + nama);
        System.out.println("Harga: Rp" + harga);
        System.out.println("Stok: " + stok + " unit");
    }

    // === Overloading ===
    public void tambahStok(int jumlah) {
        stok += jumlah;
        System.out.println("Stok bertambah sebanyak " + jumlah + " unit (int). Stok baru " + nama + ": " + stok + " unit.");
    }

    public void tambahStok(double jumlah) {
        int jmlBulat = (int) Math.round(jumlah);
        stok += jmlBulat;
        System.out.println("Stok bertambah sebanyak " + jumlah + " unit (double, dibulatkan menjadi " + jmlBulat + "). Stok baru " + nama + ": " + stok + " unit.");
    }
}
