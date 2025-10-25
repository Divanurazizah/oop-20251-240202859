package com.upb.agripos;

import com.upb.agripos.model.*;
import com.upb.agripos.util.CreditBy;

public class MainPolymorphism {
    public static void main(String[] args) {
        Produk[] daftarProduk = {
            new Benih("BNH-001", "Benih Padi IR64", 25000, 100, "IR64"),
            new Pupuk("PPK-101", "Pupuk Urea", 350000, 40, "Urea"),
            new AlatPertanian("ALT-501", "Cangkul Baja", 90000, 15, "Baja"),
            new ObatHama("OBH-301", "Insektisida Aman", 120000, 25, "Klorpirifos"),
            new Pestisida("PST-401", "Pestisida Organik", 135000, 18, "Organik")
        };

        // --- Dynamic Binding ---
        for (Produk p : daftarProduk) {
            p.getInfo();
        }

        // --- Overloading Demo ---
        System.out.println("--- OverLoading (tambahStok) ---");
        daftarProduk[0].tambahStok(10);    // versi int
        daftarProduk[0].tambahStok(13.9);  // versi double

        System.out.println();
        CreditBy.print("Diva Nur Azizah", "240202859");
    }
}
