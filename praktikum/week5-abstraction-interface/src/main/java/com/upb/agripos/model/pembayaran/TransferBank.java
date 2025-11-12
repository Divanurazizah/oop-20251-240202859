package com.upb.agripos.model.pembayaran;

import com.upb.agripos.model.kontrak.Validatable;
import com.upb.agripos.model.kontrak.Receiptable;

public class TransferBank extends Pembayaran implements Validatable, Receiptable {
    private String rekeningTujuan;
    private String kodeValidasi;

    public TransferBank(String invoiceNo, double total, String rekeningTujuan, String kodeValidasi) {
        super(invoiceNo, total);
        this.rekeningTujuan = rekeningTujuan;
        this.kodeValidasi = kodeValidasi;
    }

    @Override
    public double biaya() {
        return 3500.0; // biaya tetap
    }

    @Override
    public boolean validasi() {
        return kodeValidasi != null && kodeValidasi.length() >= 4;
    }

    @Override
    public boolean prosesPembayaran() {
        return validasi();
    }

    @Override
    public String cetakStruk() {
        return String.format(
            "\n=== PEMBAYARAN TRANSFER BANK ===\n" +
            "Invoice : %s\n" +
            "Rek     : %s\n" +
            "Total   : %.1f\n" +
            "Biaya   : %.1f\n" +
            "Status  : %s\n",
            invoiceNo, rekeningTujuan, total, biaya(),
            prosesPembayaran() ? "BERHASIL" : "GAGAL"
        );
    }
}
