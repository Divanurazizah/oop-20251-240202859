package com.upb.agripos.model;

public class ObatHama extends Produk {
    private String kandungan;

    public ObatHama(String kode, String nama, double harga, int stok, String kandungan) {
        super(kode, nama, harga, stok);
        this.kandungan = kandungan;
    }

    @Override
    public void getInfo() {
        System.out.println("=== OBAT HAMA ===");
        super.getInfo();
        System.out.println("Kandungan: " + kandungan);
        System.out.println();
    }
}
