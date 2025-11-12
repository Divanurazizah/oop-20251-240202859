package com.upb.agripos.model.pembayaran;

import com.upb.agripos.model.kontrak.Validatable;
import com.upb.agripos.model.kontrak.Receiptable;

public class EWallet extends Pembayaran implements Validatable, Receiptable {
    private String akun;
    private String otp;

    public EWallet(String invoiceNo, double total, String akun, String otp) {
        super(invoiceNo, total);
        this.akun = akun;
        this.otp = otp;
    }

    @Override
    public double biaya() {
        return total * 0.015; // 1.5% fee
    }

    @Override
    public boolean validasi() {
        return otp != null && otp.length() == 6;
    }

    @Override
    public boolean prosesPembayaran() {
        return validasi();
    }

    @Override
    public String cetakStruk() {
        return String.format(
            "\n=== PEMBAYARAN E-WALLET ===\n" +
            "Invoice : %s\n" +
            "Akun    : %s\n" +
            "Total   : %.1f\n" +
            "Biaya   : %.1f\n" +
            "Status  : %s\n",
            invoiceNo, akun, total, biaya(),
            prosesPembayaran() ? "BERHASIL" : "GAGAL"
        );
    }
}
