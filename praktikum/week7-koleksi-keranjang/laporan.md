# Laporan Praktikum Minggu 7
Topik: [Collections dan Implementasi Keranjang Belanja]

## Identitas
- Nama  : [Diva Nur Azizah]
- NIM   : [240202859]
- Kelas : [3IKRA]

---

## Tujuan
Mahasiswa mampu:

1. Menjelaskan konsep collection dalam Java (List, Map, Set).
2. Menggunakan ArrayList untuk menyimpan dan mengelola objek.
3. Mengimplementasikan Map atau Set sesuai kebutuhan pengelolaan data.
4. Melakukan operasi dasar pada collection: tambah, hapus, dan hitung total.
5. Menganalisis efisiensi penggunaan collection dalam konteks sistem Agri-POS.

---

## Dasar Teori

### 1. Collections Framework
 Java Collections Framework menyediakan struktur data untuk mengelola objek secara dinamis dan efisien.

 Struktur utama:
 - List (implementasi: ArrayList) — Terurut, dapat menyimpan elemen duplikat.
- Map (implementasi: HashMap) — Menyimpan pasangan key–value, akses cepat berdasarkan key.
- Set (implementasi: HashSet) — Tidak menerima duplikat dan tidak mempertahankan urutan.
  
### 2. Studi Kasus: Keranjang Belanja Agri-POS
Keranjang belanja harus dapat:
- Menambahkan produk
- Menghapus produk
- Menampilkan isi keranjang
- Menghitung total nilai transaksi
- Menangani jumlah (quantity) menggunakan Map

Kasus ini mencerminkan penggunaan struktur data dalam aplikasi nyata seperti POS.


---

## Langkah Praktikum
1. Membuat class `Product.java` untuk representasi produk.  
2. Membuat class `ShoppingCart.java` untuk keranjang dengan ArrayList.  
3. Membuat class `ShoppingCartMap.java` untuk keranjang dengan Map dan quantity.  
4. Membuat class `MainCart.java` untuk menjalankan demo penambahan, penghapusan, dan menampilkan keranjang.  
---

## Kode Program  

### Product.java
```java
package main.java.com.upb.agripos;

public class Product {
    private String nama;
    private double harga;

    public Product(String nama, double harga) {
        this.nama = nama;
        this.harga = harga;
    }

    public String getNama() {
        return nama;
    }

    public double getHarga() {
        return harga;
    }
}
```

### ShoppingCart.java
```java
package main.java.com.upb.agripos;

import java.util.ArrayList;

public class ShoppingCart {

    private ArrayList<Product> items = new ArrayList<>();

    public void tambahProduk(Product produk) {
        items.add(produk);
    }

    public void hapusProduk(Product produk) {
        items.remove(produk);
        System.out.println("\nMenghapus produk: " + produk.getNama());
    }

    public double hitungTotal() {
        double total = 0;
        for (Product p : items) {
            total += p.getHarga();
        }
        return total;
    }

    public void tampilkanKeranjang() {
        System.out.println("\nKeranjang Belanja:");
        for (Product p : items) {
            System.out.println("- " + p.getNama() + " = " + p.getHarga());
        }
        System.out.println("Total: " + hitungTotal());
    }
} 

````

### ShoppingCartMap.java
```java
package main.java.com.upb.agripos;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCartMap {

    private Map<Product, Integer> items = new HashMap<>();

    public void tambahProduk(Product p) {
        items.put(p, items.getOrDefault(p, 0) + 1);
    }

    public void hapusProduk(Product p) {
        if (!items.containsKey(p)) return;

        int qty = items.get(p);
        if (qty > 1) {
            items.put(p, qty - 1);
        } else {
            items.remove(p);
        }
        System.out.println("\nMenghapus produk: " + p.getNama());
    }

    public double hitungTotal() {
        double total = 0;
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            total += entry.getKey().getHarga() * entry.getValue();
        }
        return total;
    }

    public void tampilkanKeranjang() {
        System.out.println("\nKeranjang Belanja (Map):");
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            System.out.println("- " + entry.getKey().getNama() + " x" + entry.getValue() +
                   " = " + (entry.getKey().getHarga() * entry.getValue()));
        }
        System.out.println("Total: " + hitungTotal());
    }
}
```

### MainCart.java
```java
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

```

---

## Hasil Eksekusi
(Sertakan screenshot hasil eksekusi program.  
![Screenshot hasil](screenshots/hasil.png)
)
---

## Analisis

- Program menggunakan class Product untuk menyimpan nama dan harga produk.
- ShoppingCart menggunakan ArrayList untuk daftar produk, sedangkan ShoppingCartMap menggunakan HashMap untuk menghitung jumlah (quantity).
- MainCart menambahkan produk, menampilkan keranjang, menghapus produk, dan menghitung total belanja.
- Perbedaan dengan minggu sebelumnya: sekarang menggunakan Collections, sehingga lebih mudah menambah, hapus, dan hitung total dibanding menggunakan array biasa.
- Kendala: menampilkan harga dan quantity di output.

---

## Kesimpulan
- Dengan menggunakan class dan object, program menjadi lebih terstruktur dan modular.
- Collections Framework (ArrayList dan HashMap) memudahkan pengelolaan data dinamis seperti keranjang belanja, termasuk menambah, menghapus, dan menghitung total harga.
- Program sekarang lebih fleksibel dan mudah dikembangkan, misalnya menambahkan produk baru atau fitur quantity tanpa mengubah banyak kode.

---

## Quiz
1. [Jelaskan perbedaan mendasar antara List, Map, dan Set.]  
   **Jawaban:** List, Map, dan Set merupakan bagian dari Collections Framework yang memiliki fungsi berbeda. List digunakan untuk menyimpan data secara berurutan dan memperbolehkan adanya data yang sama (duplikasi). Set digunakan untuk menyimpan data yang unik sehingga tidak memperbolehkan adanya data yang sama. Sedangkan Map digunakan untuk menyimpan data dalam bentuk pasangan key–value, di mana setiap key harus unik dan digunakan untuk mengakses value dengan cepat.

2. [Mengapa ArrayList cocok digunakan untuk keranjang belanja sederhana?]  
   **Jawaban:** Arraylist cocok digunakan karena mudah untuk menyimpan daftar produk, mendukung penambahan dan penghapusan data fleksibel, cocok untuk keranjang belanja sederhana yang tidak memerlukan pengelolaan jumlah, dan data dpat ditampilkan sesuai penambahan. 

3. [Bagaimana struktur Set mencegah duplikasi data?]  
   **Jawaban:** Set menggunakan mekanisme pengecekan elemen yang sama berdasarkan metode `equals()` dan `hashCode()`.
Jika data yang dimasukkan sudah ada, maka data tersebut tidak akan ditambahkan lagi, sehingga tidak terjadi duplikasi.

4. [Kapan sebaiknya menggunakan Map dibandingkan List? Jelaskan dengan contoh.]  
   **Jawaban:**  Map digunakan ketika data memiliki pasangan key dan value, misalnya produk dan jumlahnya.
   Contoh:
   Dalam keranjang belanja, jika satu produk bisa dibeli lebih dari satu, maka Map lebih tepat digunakan:
   - key → produk
   - value → jumlah produk
   Dengan Map, kita bisa dengan mudah menambah, mengurangi, dan menghitung total berdasarkan quantity.
