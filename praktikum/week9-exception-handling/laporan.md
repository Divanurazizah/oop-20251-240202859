# Laporan Praktikum Minggu 9
Topik: Bab 9 – Exception Handling, Custom Exception, dan Penerapan Design Pattern

## Identitas
- Nama  : [Diva Nur Azizah]
- NIM   : [240202859]
- Kelas : [3IKRA ]

---

## Tujuan
Mahasiswa mampu:

1. Menjelaskan perbedaan antara error dan exception.
2. Mengimplementasikan try–catch–finally dengan tepat.
3. Membuat custom exception sesuai kebutuhan program.
4. Mengintegrasikan exception handling ke dalam aplikasi sederhana (kasus keranjang belanja).
5. (Opsional) Menerapkan design pattern sederhana (Singleton/MVC) dan unit testing dasar.

---

## Dasar Teori
### 1. Error vs Exception

- Error → kondisi fatal, tidak dapat ditangani (contoh: OutOfMemoryError).
- Exception → kondisi tidak normal yang dapat ditangani oleh program.

### 2. Struktur try–catch–finally

```java
try {
    // kode yang berpotensi menimbulkan kesalahan
} catch (Exception e) {
    // penanganan
} finally {
    // blok yang selalu dijalankan
}
```

### 3. Membuat Custom Exception

```java
package com.upb.agripos;

public class InvalidQuantityException extends Exception {
    public InvalidQuantityException(String message) {
        super(message);
    }
}
```

## Studi Kasus Agri-POS: Keranjang Belanja

Keranjang belanja harus memvalidasi:

- Jumlah pembelian > 0
- Produk ada dalam keranjang
- Stok mencukupi

Kesalahan–kesalahan tersebut ditangani menggunakan custom exception.


---

## Langkah Praktikum

1. Setup Project
Membuat struktur folder `week9-exception-handling` dan package `com.upb.agripos.`
2. Coding
- Membuat class Product
- Membuat custom exception:
   InvalidQuantityException
   ProductNotFoundException
   InsufficientStockException
- Membuat class ShoppingCart
- Membuat class MainExceptionDemo
3. Run Program  
Program dijalankan untuk menguji berbagai kondisi error dan exception.
4. Commit Message
`week9-exception: implement custom exception pada shopping cart`


---

## Kode Program

### Product.java
```java

package com.upb.agripos;

public class Product {
    private String code;
    private String name;
    private double price;
    private int stock;

    public Product(String code, String name, double price, int stock) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public void reduceStock(int qty) {
        this.stock -= qty;
    }
}
```

### InvalidQuantityException.java
```java
package com.upb.agripos;

public class InvalidQuantityException extends Exception {
    public InvalidQuantityException(String message) {
        super(message);
    }
}
```

### ProductNotFoundException.java
```java
package com.upb.agripos;

public class ProductNotFoundException extends Exception {
    public ProductNotFoundException(String message) {
        super(message);
    }
}
```

### InsufficientStockException.java
```java
package com.upb.agripos;

public class InsufficientStockException extends Exception {
    public InsufficientStockException(String message) {
        super(message);
    }
}
```

### ShoppingCart.java
```java
package com.upb.agripos;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {

    private Map<Product, Integer> items = new HashMap<>();

    // tambah produk
    public void addProduct(Product product, int qty)
            throws InvalidQuantityException {

        if (qty <= 0) {
            throw new InvalidQuantityException(
                "Jumlah pembelian harus lebih dari 0."
            );
        }

        items.put(product, items.getOrDefault(product, 0) + qty);
    }

    // hapus produk
    public void removeProduct(Product product)
            throws ProductNotFoundException {

        if (!items.containsKey(product)) {
            throw new ProductNotFoundException(
                "Produk tidak ditemukan dalam keranjang."
            );
        }

        items.remove(product);
    }

    // checkout
    public void checkout()
            throws InsufficientStockException {

        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            Product product = entry.getKey();
            int qty = entry.getValue();

            if (product.getStock() < qty) {
                throw new InsufficientStockException(
                    "Stok tidak mencukupi untuk produk: "
                    + product.getName()
                );
            }
        }

        // jika stok cukup → kurangi stok
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            entry.getKey().reduceStock(entry.getValue());
        }

        System.out.println("Checkout berhasil.");
    }
}
```

### MainExceptionDemo.java
```java
package com.upb.agripos;

public class MainExceptionDemo {
    public static void main(String[] args) {

        System.out.println("Hello, I am Diva Nur Azizah-240202859 (Week 9)");

        ShoppingCart cart = new ShoppingCart();
        Product p1 = new Product("P01", "Pupuk Organik", 25000, 3);

        // Uji quantity tidak valid
        try {
            cart.addProduct(p1, -2);
        } catch (InvalidQuantityException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Uji hapus produk yang belum ada
        try {
            cart.removeProduct(p1);
        } catch (ProductNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Uji stok tidak cukup
        try {
            cart.addProduct(p1, 5);
            cart.checkout();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
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
- Program berjalan dengan cara memvalidasi setiap aksi pada keranjang belanja menggunakan exception.

- Perbedaan dengan minggu sebelumnya adalah pada minggu ini program sudah mampu menangani kesalahan secara terstruktur menggunakan try–catch dan custom exception.

- Kendala yang dihadapi adalah memahami jenis exception yang tepat untuk setiap kondisi, namun dapat diatasi dengan membuat custom exception yang sesuai kebutuhan.
---

## Kesimpulan
Dengan penerapan exception handling dan custom exception, program menjadi lebih aman, terstruktur, dan mudah dipahami. Kesalahan yang terjadi dapat ditangani dengan baik tanpa menghentikan program secara tiba-tiba.
---

## Quiz
(1. [Jelaskan perbedaan error dan exception.]  
   **Jawaban:** Error adalah kesalahan fatal yang terjadi pada sistem dan tidak dapat ditangani oleh program, sedangkan exception adalah kesalahan yang masih dapat ditangani oleh program agar aplikasi tidak langsung berhenti.

2. [Apa fungsi finally dalam blok try–catch–finally?]  
   **Jawaban:** Blok `finally` berfungsi untuk mengeksekusi kode yang selalu dijalankan, baik terjadi exception maupun tidak, misalnya untuk menutup resource atau menampilkan pesan akhir.

3. [Mengapa custom exception diperlukan?]  
   **Jawaban:** Custom exception diperlukan agar penanganan kesalahan lebih spesifik, mudah dipahami, dan sesuai dengan kebutuhan bisnis aplikasi.

4. [Berikan contoh kasus bisnis dalam POS yang membutuhkan custom exception.]  
   **Jawaban:** Contohnya saat melakukan checkout tetapi stok produk tidak mencukupi, maka sistem dapat menampilkan custom exception seperti `InsufficientStockException`.)

