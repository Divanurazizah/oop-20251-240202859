package main.java.com.upb.agripos;

public class MainCart {
    public static void main(String[] args) {

        System.out.println("Hello, I am Diva Nur Azizah-240202859 (Week 7)");

        Product alatPertanian = new Product("Alat Pertanian (cangkul)", 75000);
        Product benih = new Product("Benih (padi)", 25000);
        Product obatHama = new Product("Obat Hama (biowasil)", 35000);
        Product pupuk = new Product("Pupuk organik", 45000);

        // Demo ShoppingCart (ArrayList)
        ShoppingCart cartList = new ShoppingCart();
        cartList.tambahProduk(alatPertanian);
        cartList.tambahProduk(benih);
        cartList.tambahProduk(obatHama);
        cartList.tambahProduk(pupuk);
        cartList.tampilkanKeranjang();

        cartList.hapusProduk(pupuk);
        cartList.tampilkanKeranjang();

        // Demo ShoppingCartMap (Map, quantity)
        ShoppingCartMap cartMap = new ShoppingCartMap();
        cartMap.tambahProduk(alatPertanian);
        cartMap.tambahProduk(benih);
        cartMap.tambahProduk(obatHama);
        cartMap.tambahProduk(pupuk);
        cartMap.tambahProduk(alatPertanian); // contoh duplikasi
        cartMap.tampilkanKeranjang();

        cartMap.hapusProduk(pupuk);
        cartMap.tampilkanKeranjang();
    }
}
