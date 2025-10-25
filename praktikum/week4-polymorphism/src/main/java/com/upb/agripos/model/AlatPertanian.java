package com.upb.agripos.model;

public class AlatPertanian extends Produk {
    private String bahan;

    public AlatPertanian(String kode, String nama, double harga, int stok, String bahan) {
        super(kode, nama, harga, stok);
        this.bahan = bahan;
    }

    @Override
    public void getInfo() {
        System.out.println("=== ALAT PERTANIAN ===");
        super.getInfo();
        System.out.println("Bahan: " + bahan);
        System.out.println();
    }
}

