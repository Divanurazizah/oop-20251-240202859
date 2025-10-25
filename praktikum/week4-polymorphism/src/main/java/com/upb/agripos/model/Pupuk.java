package com.upb.agripos.model;

public class Pupuk extends Produk {
    private String jenis;

    public Pupuk(String kode, String nama, double harga, int stok, String jenis) {
        super(kode, nama, harga, stok);
        this.jenis = jenis;
    }

    @Override
    public void getInfo() {
        System.out.println("=== PUPUK ===");
        super.getInfo();
        System.out.println("Jenis: " + jenis);
        System.out.println();
    }
}



