# Laporan Praktikum Minggu 4
Topik: Polymorphism (Info Produk)

## Identitas
- Nama  : [Diva Nur Azizah]
- NIM   : [2402027859]
- Kelas : [3IKRA]

---

## Tujuan
- Mahasiswa mampu **menjelaskan konsep polymorphism** dalam OOP.  
- Mahasiswa mampu **membedakan method overloading dan overriding**.  
- Mahasiswa mampu **mengimplementasikan polymorphism (overriding, overloading, dynamic binding)** dalam program.  
- Mahasiswa mampu **menganalisis contoh kasus polymorphism** pada sistem nyata (Agri-POS).  

---

## Dasar Teori
Polymorphism berarti “banyak bentuk” dan memungkinkan objek yang berbeda merespons panggilan method yang sama dengan cara yang berbeda.  
1. **Overloading** → mendefinisikan method dengan nama sama tetapi parameter berbeda.  
2. **Overriding** → subclass mengganti implementasi method dari superclass.  
3. **Dynamic Binding** → pemanggilan method ditentukan saat runtime, bukan compile time. 
 
Dalam konteks Agri-POS, misalnya:  
- Method `getInfo()` pada `Produk` dioverride oleh `Benih`, `Pupuk`, `AlatPertanian` untuk menampilkan detail spesifik.  
- Method `tambahStok()` bisa dibuat overload dengan parameter berbeda (int, double).

---

## Langkah Praktikum
1. **Overloading**  
   - Tambahkan method `tambahStok(int jumlah)` dan `tambahStok(double jumlah)` pada class `Produk`.

2. **Overriding**  
   - Tambahkan method `getInfo()` pada superclass `Produk`.  
   - Override method `getInfo()` pada subclass `Benih`, `Pupuk`, dan `AlatPertanian`.  

3. **Dynamic Binding**  
   - Buat array `Produk[] daftarProduk` yang berisi objek `Benih`, `Pupuk`, dan `AlatPertanian`.  
   - Loop array tersebut dan panggil `getInfo()`. Perhatikan bagaimana Java memanggil method sesuai jenis objek aktual. 

4. **Main Class**  
   - Buat `MainPolymorphism.java` untuk mendemonstrasikan overloading, overriding, dan dynamic binding.  

5. **CreditBy**  
   - Tetap panggil `"CreditBy: " + nama + " (" + nim + ")")` .  

6. **Commit dan Push**  
   - Commit dengan pesan: `week4-polymorphism`.  

---

## Kode Program
 
### Produk.java
```java
package com.upb.agripos.model;

public class Produk {
    protected String kode;
    protected String nama;
    protected double harga;
    protected int stok;

    public Produk(String kode, String nama, double harga, int stok) {
        this.kode = kode;
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    public void getInfo() {
        System.out.println("Kode: " + kode);
        System.out.println("Nama: " + nama);
        System.out.println("Harga: Rp" + harga);
        System.out.println("Stok: " + stok + " unit");
    }

    // === Overloading ===
    public void tambahStok(int jumlah) {
        stok += jumlah;
        System.out.println("Stok bertambah sebanyak " + jumlah + " unit (int). Stok baru " + nama + ": " + stok + " unit.");
    }

    public void tambahStok(double jumlah) {
        int jmlBulat = (int) Math.round(jumlah);
        stok += jmlBulat;
        System.out.println("Stok bertambah sebanyak " + jumlah + " unit (double, dibulatkan menjadi " + jmlBulat + "). Stok baru " + nama + ": " + stok + " unit.");
    }
}
```

### Benih.java
```java
package com.upb.agripos.model;

public class Benih extends Produk {
    private String varietas;

    public Benih(String kode, String nama, double harga, int stok, String varietas) {
        super(kode, nama, harga, stok);
        this.varietas = varietas;
    }

    @Override
    public void getInfo() {
        System.out.println("=== BENIH ===");
        super.getInfo();
        System.out.println("Varietas: " + varietas);
        System.out.println();
    }
}
```

### Pupuk.java
```java
package com.upb.agripos.model;

public class Pupuk extends Produk {
    private String jenis;

    public Pupuk(String kode, String nama, double harga, int stok, String jenis) {
        super(kode, nama, harga, stok);
        this.jenis = jenis;
    }

    @Override
    public void getInfo() {
        System.out.println("=== PUPUK ===");
        super.getInfo();
        System.out.println("Jenis: " + jenis);
        System.out.println();
    }
}
```

### AlatPertanian.java
```java
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
```

### ObatHama.java
```java
package com.upb.agripos.model;

public class ObatHama extends Produk {
    private String kandungan;

    public ObatHama(String kode, String nama, double harga, int stok, String kandungan) {
        super(kode, nama, harga, stok);
        this.kandungan = kandungan;
    }

    @Override
    public void getInfo() {
        System.out.println("=== OBAT HAMA ===");
        super.getInfo();
        System.out.println("Kandungan: " + kandungan);
        System.out.println();
    }
}
```

### Pestisida.java
```java
package com.upb.agripos.model;

public class Pestisida extends Produk {
    private String jenis;

    public Pestisida(String kode, String nama, double harga, int stok, String jenis) {
        super(kode, nama, harga, stok);
        this.jenis = jenis;
    }

    @Override
    public void getInfo() {
        System.out.println("=== PESTISIDA ===");
        super.getInfo();
        System.out.println("Jenis: " + jenis);
        System.out.println();
    }
}
```
### CreditBy.java
```java
package com.upb.agripos.util;

public class CreditBy {
    public static void print(String nama, String nim) {
        System.out.println("CreditBy: " + nama + " (" + nim + ")");
    }
}
```
### MainPolymorphism.java
```java
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
```

---

## Hasil Eksekusi
![alt text](<Screenshot (273).png>)
![alt text](<Screenshot (274).png>)
---

## Analisis
Pada praktikum minggu ini, konsep polymorphism berhasil diterapkan melalui tiga mekanisme utama:
1. Overloading (Compile-time Polymorphism)
- Method `tambahStok()` dibuat dengan dua versi: satu menerima parameter bertipe `int`, satu lagi bertipe `double`.  
2. Overriding (Runtime Polymorphism)
- Method `getInfo()` pada superclass `Produk` dioverride oleh subclass `Benih`, `Pupuk`, `AlatPertanian`, `ObatHama`, dan `Pestisida`.
- Setiap subclass menampilkan informasi berbeda sesuai jenis produknya.  
- Ini menunjukkan bahwa subclass dapat mengganti perilaku bawaan dari superclass tanpa mengubah struktur dasarnya.
3. Dynamic Binding
-  Saat array Produk[] daftarProduk berisi berbagai objek subclass, method `getInfo()` yang dipanggil akan disesuaikan dengan tipe objek aktual pada runtime.
Kendala yang sempat muncul adalah memastikan setiap subclass benar-benar melakukan override terhadap method `getInfo()` dengan penulisan `@Override`, agar tidak tertukar dengan method baru.

## Kesimpulan
Subclass dapat menambahkan perilaku spesifik tanpa mengubah struktur utama superclass.
Selain itu, Overloading dan Overriding membuat kode lebih efisien, fleksibel, dan mudah dibaca.
Dengan menerapkan polymorphism, program menjadi lebih mudah dikembangkan karena setiap objek dapat berperilaku sesuai jenisnya masing-masing.
Konsep ini juga membantu dalam pembuatan sistem besar seperti Agri-POS, di mana berbagai produk memiliki karakteristik berbeda tetapi tetap dapat dikelola melalui satu antarmuka umum (Produk).
Secara keseluruhan, penerapan polymorphism meningkatkan modularitas, memudahkan pemeliharaan kode, dan memperkuat prinsip Object-Oriented Programming (OOP) secara menyeluruh

---

## Quiz
1. Apa perbedaan overloading dan overriding?  
   **Jawaban:** Overloading terjadi ketika dua atau lebih method memiliki nama yang sama tetapi parameter berbeda (jumlah atau tipe datanya berbeda). Pemilihan method dilakukan saat compile time.Sedangkan Overriding terjadi ketika subclass menggantikan implementasi method dari superclass dengan isi yang berbeda, tetapi nama dan parameternya sama. Pemilihan method dilakukan saat runtime.

2. Bagaimana Java menentukan method mana yang dipanggil dalam dynamic binding? 
   **Jawaban:** Java menentukan method yang dipanggil berdasarkan objek aktual yang direferensikan, bukan berdasarkan tipe variabel referensinya.
Artinya, jika variabel bertipe  `Produk` menyimpan objek `Pupuk`, maka saat `getInfo()` dipanggil, method `getInfo()` milik `Pupuk` yang dijalankan, bukan milik `Produk`.

3. Berikan contoh kasus polymorphism dalam sistem POS selain produk pertanian. 
   **Jawaban:** Dalam sistem POS toko elektronik:
   - Superclass: `Produk`
   - Subclass: `Laptop`, `Smartphone`, `Aksesoris`
Masing-masing subclass dapat mengoverride method `getInfo()` untuk menampilkan informasi berbeda seperti “Prosesor”, “Kapasitas Baterai”, atau “Jenis Aksesoris”, tetapi semua dipanggil menggunakan referensi `Produk`.
Ini menunjukkan penerapan polymorphism di dunia nyata — satu tipe umum (`Produk`) yang dapat mewakili berbagai bentuk produk berbeda.
