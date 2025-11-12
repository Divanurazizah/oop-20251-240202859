package com.upb.agripos.util;

/**
 * Utilitas untuk menampilkan identitas pembuat program.
 */
public class CreditBy {
    public static void print(String nim, String nama) {
        System.out.println("\n---");
        System.out.println("Credit by: " + nim + " - " + nama);
    }
}