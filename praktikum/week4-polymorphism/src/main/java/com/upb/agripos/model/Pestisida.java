package com.upb.agripos.model;

public class Pestisida extends Produk {
    private String jenis;

    public Pestisida(String kode, String nama, double harga, int stok, String jenis) {
        super(kode, nama, harga, stok);
        this.jenis = jenis;
    }

    @Override
    public void getInfo() {
        System.out.println("=== PESTISIDA ===");
        super.getInfo();
        System.out.println("Jenis: " + jenis);
        System.out.println();
    }
}
