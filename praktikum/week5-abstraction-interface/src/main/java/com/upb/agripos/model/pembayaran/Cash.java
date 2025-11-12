package com.upb.agripos.model.pembayaran;

import com.upb.agripos.model.kontrak.Receiptable;

public class Cash extends Pembayaran implements Receiptable {
    private double tunai;

    public Cash(String invoiceNo, double total, double tunai) {
        super(invoiceNo, total);
        this.tunai = tunai;
    }

    @Override
    public double biaya() {
        return 0.0;
    }

    @Override
    public boolean prosesPembayaran() {
        return tunai >= totalBayar();
    }

    public double kembalian() {
        return Math.max(0, tunai - totalBayar());
    }

    @Override
    public String cetakStruk() {
        return String.format(
            "\n=== PEMBAYARAN CASH ===\n" +
            "Invoice : %s\n" +
            "Total   : %.1f\n" +
            "Biaya   : %.1f\n" +
            "Bayar   : %.1f\n" +
            "Kembali : %.1f\n" +
            "Status  : %s\n",
            invoiceNo, total, biaya(), tunai, kembalian(),
            prosesPembayaran() ? "BERHASIL" : "GAGAL"
        );
    }
}
