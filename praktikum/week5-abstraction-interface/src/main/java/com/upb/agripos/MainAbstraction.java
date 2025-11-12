package com.upb.agripos;

import com.upb.agripos.model.pembayaran.*;
import com.upb.agripos.model.kontrak.*;
import com.upb.agripos.util.CreditBy;

public class MainAbstraction {
    public static void main(String[] args) {
        Pembayaran cash = new Cash("INV-001", 100000, 120000);
        Pembayaran ewallet = new EWallet("INV-002", 150000, "dv@ewallet", "123456");
        Pembayaran transfer = new TransferBank("INV-003", 200000, "9876543210", "9999");

        System.out.println(((Receiptable) cash).cetakStruk());
        System.out.println(((Receiptable) ewallet).cetakStruk());
        System.out.println(((Receiptable) transfer).cetakStruk());

        CreditBy.print("240202859", "Diva Nur Azizah");
    }
}
