# Laporan Praktikum Minggu 10 
Topik: [Bab 10 – Design Pattern (Singleton, MVC) dan Unit Testing menggunakan JUnit]

## Identitas
- Nama  : Diva Nur Azizah
- NIM   : 240202859
- Kelas : 3IKRA

---

## Tujuan
Setelah mengikuti praktikum ini, mahasiswa mampu:

1. Menjelaskan konsep dasar design pattern dalam rekayasa perangkat lunak.
2. Mengimplementasikan Singleton Pattern dengan benar.
3. Menjelaskan dan menerapkan Model–View–Controller (MVC) pada aplikasi sederhana.
4. Membuat dan menjalankan unit test menggunakan JUnit.
5. Menganalisis manfaat penerapan design pattern dan unit testing terhadap kualitas perangkat lunak.


---

## Dasar Teori
### 1. Design Pattern

Design pattern adalah solusi desain yang telah teruji untuk menyelesaikan masalah umum dalam pengembangan perangkat lunak. Fokus minggu ini:
- Singleton Pattern
- MVC (Model–View–Controller)

### 2. Singleton Pattern

Tujuan: Menjamin suatu class hanya memiliki satu instance dan menyediakan titik akses global.

Karakteristik:
- Constructor `private`
- Atribut `static instance`
- Method `static getInstance()`

Contoh Implementasi:
```java
package com.upb.agripos.config;

public class DatabaseConnection {
    private static DatabaseConnection instance;
    private DatabaseConnection() {}

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }
}
```

Penerapan pada Agri-POS: koneksi database atau service global yang tidak boleh lebih dari satu instance.

### 3. MVC (Model–View–Controller)

Memisahkan tanggung jawab aplikasi:

| Komponen | Tanggung Jawab |
|---------|------------------|
| Model   | Data dan logika bisnis |
| View    | Tampilan/output |
| Controller | Penghubung Model dan View |

Contoh Struktur MVC Sederhana:
- Model → `Product`
- View → `ConsoleView`
- Controller → `ProductController`

---

## Implementasi Praktikum

### 1. Model
```java
package com.upb.agripos.model;

public class Product {
    private final String code;
    private final String name;

    public Product(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() { return code; }
    public String getName() { return name; }
}
```

### 2. View
```java
package com.upb.agripos.view;

public class ConsoleView {
    public void showMessage(String message) {
        System.out.println(message);
    }
}
```

### 3. Controller (WAJIB DIISI)
```java
package com.upb.agripos.controller;

import com.upb.agripos.model.Product;
import com.upb.agripos.view.ConsoleView;

public class ProductController {
    private final Product model;
    private final ConsoleView view;

    public ProductController(Product model, ConsoleView view) {
        this.model = model;
        this.view = view;
    }

    public void showProduct() {
        view.showMessage("Produk: " + model.getCode() + " - " + model.getName());
    }
}
```

### 4. Main Program (Integrasi MVC)
```java
package com.upb.agripos;

import com.upb.agripos.model.Product;
import com.upb.agripos.view.ConsoleView;
import com.upb.agripos.controller.ProductController;

public class AppMVC {
    public static void main(String[] args) {
        System.out.println("Hello, I am [Nama]-[NIM] (Week10)");
        Product product = new Product("P01", "Pupuk Organik");
        ConsoleView view = new ConsoleView();
        ProductController controller = new ProductController(product, view);
        controller.showProduct();
    }
}
```

---

## Unit Testing Menggunakan JUnit

Tujuan unit testing:
- Memastikan fungsi berjalan sesuai harapan
- Mendeteksi kesalahan lebih awal
- Meningkatkan kepercayaan terhadap kode

### Contoh Unit Test JUnit
```java
package com.upb.agripos;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.upb.agripos.model.Product;

public class ProductTest {
    @Test
    public void testProductName() {
        Product p = new Product("P01", "Benih Jagung");
        assertEquals("Benih Jagung", p.getName());
    }
}
```

Kriteria unit test benar:
- Menggunakan anotasi `@Test`
- Menggunakan assertion
- Test dapat dijalankan tanpa error

---

## Langkah Praktikum
1. Implementasikan Singleton untuk DatabaseConnection.
2. Buat struktur MVC sederhana untuk fitur Product.
3. Buat minimal 1 unit test JUnit.
4. Jalankan unit test dan dokumentasikan hasilnya.
Commit message:
`week10-pattern-testing: [fitur] [deskripsi singkat]`
---

## Kode Program
  
## Product.java
```java
package main.java.com.upb.agripos.model;

public class Product {
    private final String code;
    private final String name;
    private final double price;

    public Product(String code, String name, double price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }

    public String getCode() { return code; }
    public String getName() { return name; }
    public double getPrice() { return price; }
}
```

## ConsoleView.java
```java
package main.java.com.upb.agripos.view;

public class ConsoleView {
    public void showProduct(String code, String name, double price) {
        System.out.println("Produk: " + code + " | " + name + " | Harga: " + price);
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}
```

## ProductController.java
```java
package main.java.com.upb.agripos.controller;

import main.java.com.upb.agripos.model.Product;
import main.java.com.upb.agripos.view.ConsoleView;

public class ProductController {
    private final Product model;
    private final ConsoleView view;

    public ProductController(Product model, ConsoleView view) {
        this.model = model;
        this.view = view;
    }

    public void showProduct() {
        view.showProduct(model.getCode(), model.getName(), model.getPrice());
    }
}
```

## DatabaseConnection.java
```java
package main.java.com.upb.agripos.config;

public class DatabaseConnection {
    private static DatabaseConnection instance;

    private DatabaseConnection() {
        System.out.println("Database connection created.");
    }

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public void connect() {
        System.out.println("Connected to database.");
    }
}
```

## AppMVC.java
```java
package main.java.com.upb.agripos;

import main.java.com.upb.agripos.config.DatabaseConnection;
import main.java.com.upb.agripos.controller.ProductController;
import main.java.com.upb.agripos.model.Product;
import main.java.com.upb.agripos.view.ConsoleView;

public class AppMVC {
    public static void main(String[] args) {
        System.out.println("Hello, I am Diva Nur Azizah-240202859 (Week10)");

        // Singleton Database Connection
        DatabaseConnection db = DatabaseConnection.getInstance();
        db.connect();

        // MVC Product
        Product product = new Product("P01", "Pupuk Organik", 50000);
        ConsoleView view = new ConsoleView();
        ProductController controller = new ProductController(product, view);
        controller.showProduct();
    }
}
```

## ProductTest.java
```java
package test.java.com.upb.agripos;

import static org.junit.jupiter.api.Assertions.assertEquals; // import model Product
import org.junit.jupiter.api.Test;     // JUnit 5

import main.java.com.upb.agripos.model.Product;

public class ProductTest {

    @Test
    void testProductName() {
        Product p = new Product("P01", "Pupuk Organik", 50000);
        assertEquals("Pupuk Organik", p.getName(), "Nama product harus sama");
    }

    @Test
    void testProductId() {
        Product p = new Product("P01", "Pupuk Organik", 50000);
        assertEquals("P01", p.getCode(), "ID product harus sama");
    }

    @Test
    void testProductPrice() {
        Product p = new Product("P01", "Pupuk Organik", 50000);
        assertEquals(50000, p.getPrice(), "Harga product harus sama");
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
1. Singleton Pattern: memastikan hanya ada satu instance `DatabaseConnection`.
2. MVC: memisahkan kode menjadi Model, View, dan Controller sehingga mudah dirawat dan dikembangkan.
3. Unit Testing: membantu memastikan fungsi aplikasi berjalan sesuai harapan sebelum diintegrasikan lebih lanjut.

Manfaat:
- Mengurangi bug
- Mempermudah maintenance
- Struktur kode lebih rapi dan terorganisir
---

## Kesimpulan
- Singleton Pattern diterapkan dengan benar.
- Struktur MVC sederhana berhasil dibuat dan dijalankan.
- Unit test JUnit berjalan tanpa error, memverifikasi fungsi `Product.getName()`.
- Praktikum ini menunjukkan pentingnya design pattern dan unit testing untuk kualitas software.

---

## Quiz
(1. [Mengapa constructor pada Singleton harus bersifat private?]  
   **Jawaban:** Agar class tidak bisa dibuat instance baru dari luar, sehingga hanya satu instance yang dapat dibuat dan digunakan secara global.

2. [Jelaskan manfaat pemisahan Model, View, dan Controller.]  
   **Jawaban:** Memisahkan tanggung jawab membuat kode lebih terstruktur, mudah dikembangkan dan dipelihara, serta memudahkan pengujian karena logika bisnis, tampilan, dan kontrol tidak bercampur.

3. [Apa peran unit testing dalam menjaga kualitas perangkat lunak?]  
   **Jawaban:** Unit testing memastikan setiap fungsi berjalan sesuai harapan, mendeteksi bug lebih awal, dan meningkatkan kepercayaan terhadap kode sebelum integrasi.

4. [Apa risiko jika Singleton tidak diimplementasikan dengan benar?]  
   **Jawaban:** Bisa terjadi banyak instance, menyebabkan inkonsistensi data, konflik resource, atau perilaku yang tidak diinginkan dalam aplikasi. )
