package main.java.com.upb.agripos;

import main.java.com.upb.agripos.model.Produk;
import main.java.com.upb.agripos.util.CreditBy;

public class MainProduk {
    public static void main(String[] args) {
        Produk p1 = new Produk("PKR-001", "Helm", 250000, 120);
        Produk p2 = new Produk("BDS-002", "Kipas Angin", 300000, 50);
        Produk p3 = new Produk("GFS-003", "Headset", 100000, 25);

        System.out.println("\n=== Daftar Produk ===") ;
        System.out.println("Kode: " + p1.getKode() + ", Nama: " + p1.getNama() + ", Harga: " + p1.getHarga() + ", Stok: " + p1.getStok());
        System.out.println("Kode: " + p2.getKode() + ", Nama: " + p2.getNama() + ", Harga: " + p2.getHarga() + ", Stok: " + p2.getStok());
        System.out.println("Kode: " + p3.getKode() + ", Nama: " + p3.getNama() + ", Harga: " + p3.getHarga() + ", Stok: " + p3.getStok());
        
        System.out.println("\n=== perubahan stok ===") ;
        p1.tambahStok(17);
        p2.kurangiStok(20);
        p3.kurangiStok(8);

        System.out.println(p1.getNama() + " Sisa Stok: " + p1.getStok()) ;
        System.out.println(p2.getNama() + " Sisa Stok: " + p2.getStok()) ;
        System.out.println(p3.getNama() + " Sisa Stok: " + p3.getStok()) ;


        // Tampilkan identitas mahasiswa
        CreditBy.print("240202859", "Diva Nur Azizah");
    }
}
