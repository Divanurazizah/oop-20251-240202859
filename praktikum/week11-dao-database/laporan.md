# Laporan Praktikum Minggu 11
Topik: Bab 11 – Data Access Object (DAO) dan CRUD Database dengan JDBC

## Identitas
- Nama  : [Diva Nur Azizah]
- NIM   : [240202859]
- Kelas : [3IKRA]

---

## Tujuan
Setelah mengikuti praktikum ini, mahasiswa mampu:
1. Menjelaskan konsep Data Access Object (DAO) dalam pengembangan aplikasi OOP.
2. Menghubungkan aplikasi Java dengan basis data menggunakan JDBC.
3. Mengimplementasikan operasi CRUD (Create, Read, Update, Delete) secara lengkap.
4. Mengintegrasikan DAO dengan class aplikasi OOP sesuai prinsip desain yang baik.
---

## Dasar Teori
### 1. Konsep Data Access Object (DAO)

DAO adalah pola desain yang memisahkan logika akses data dari logika bisnis aplikasi. Dengan DAO, perubahan teknologi basis data tidak memengaruhi logika utama aplikasi.

Manfaat DAO:
- Kode lebih terstruktur dan mudah dipelihara
- Mengurangi tight coupling antara aplikasi dan database
- Mendukung pengujian dan pengembangan lanjutan

---

### 2. JDBC dan Koneksi Database

JDBC (Java Database Connectivity) digunakan untuk menghubungkan aplikasi Java dengan basis data relasional, dalam praktikum ini menggunakan PostgreSQL.

Komponen utama JDBC:
- DriverManager
- Connection
- PreparedStatement
- ResultSet

---

---

## Langkah Praktikum
1. Persiapan Database
- Pastikan PostgreSQL sudah terinstal.
- Buat database `agripos`.
- Buat tabel `products` sesuai skrip SQL:

```java
CREATE TABLE products (
    code VARCHAR(10) PRIMARY KEY,
    name VARCHAR(100),
    price DOUBLE PRECISION,
    stock INT
);
```

2. Membuat Class Model
- Buat class `Product` di package `com.upb.agripos.model`.
- Tambahkan atribut `code`, `name`, `price`, `stock` beserta getter dan setter.

3. Membuat Interface DAO
- Buat interface `ProductDAO` di package `com.upb.agripos.dao`.
- Definisikan method: `insert`, `findByCode`, `findAll`, `update`, `delete`.

4. Implementasi DAO
- Buat class `ProductDAOImpl` yang mengimplementasikan `ProductDAO`.
- Gunakan `PreparedStatement` untuk semua operasi CRUD.
- Pastikan setiap method menutup resource (`PreparedStatement`, `ResultSet`) dengan try-with-resources.

5. Integrasi DAO dengan Aplikasi
- Buat class `MainDAOTest `untuk menguji DAO.
- Hubungkan ke database melalui `DriverManager.getConnection()`.
- Lakukan operasi: insert → update → read → delete.

6. Jalankan dan Dokumentasikan
- Pastikan semua operasi CRUD berjalan tanpa error.
- Ambil screenshot hasil eksekusi (`crud_result.png`).

7. Commit dan Push ke Repository
- Gunakan format commit:

`week11-dao-database: implement DAO Product dengan JDBC dan CRUD lengkap`


---

## Kode Program
## Product.java
```java
package com.upb.agripos.model;

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

    public String getCode() { return code; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getStock() { return stock; }

    public void setName(String name) { this.name = name; }
    public void setPrice(double price) { this.price = price; }
    public void setStock(int stock) { this.stock = stock; }

    @Override
    public String toString() {
        return "Product{" +
               "code='" + code + '\'' +
               ", name='" + name + '\'' +
               ", price=" + price +
               ", stock=" + stock +
               '}';
    }
}
```

## ProductDAO.java
```java
package com.upb.agripos.dao;

import java.util.List;
import com.upb.agripos.model.Product;

public interface ProductDAO {
    void insert(Product product) throws Exception;
    Product findByCode(String code) throws Exception;
    List<Product> findAll() throws Exception;
    void update(Product product) throws Exception;
    void delete(String code) throws Exception;
}
```

## ProductDAOImpl.java
```java
package com.upb.agripos.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.upb.agripos.model.Product;

public class ProductDAOImpl implements ProductDAO {

    private final Connection connection;

    public ProductDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(Product p) throws Exception {
        String sql = "INSERT INTO products(code, name, price, stock) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, p.getCode());
            ps.setString(2, p.getName());
            ps.setDouble(3, p.getPrice());
            ps.setInt(4, p.getStock());
            ps.executeUpdate();
        }
    }

    @Override
    public Product findByCode(String code) throws Exception {
        String sql = "SELECT * FROM products WHERE code = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, code);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Product(
                        rs.getString("code"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getInt("stock")
                    );
                }
            }
        }
        return null;
    }

    @Override
    public List<Product> findAll() throws Exception {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM products";
        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(new Product(
                    rs.getString("code"),
                    rs.getString("name"),
                    rs.getDouble("price"),
                    rs.getInt("stock")
                ));
            }
        }
        return list;
    }

    @Override
    public void update(Product p) throws Exception {
        String sql = "UPDATE products SET name=?, price=?, stock=? WHERE code=?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, p.getName());
            ps.setDouble(2, p.getPrice());
            ps.setInt(3, p.getStock());
            ps.setString(4, p.getCode());
            ps.executeUpdate();
        }
    }

    @Override
    public void delete(String code) throws Exception {
        String sql = "DELETE FROM products WHERE code=?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, code);
            ps.executeUpdate();
        }
    }
}
```

## MainDAOTest.java
```java
package com.upb.agripos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import com.upb.agripos.dao.ProductDAO;
import com.upb.agripos.dao.ProductDAOImpl;
import com.upb.agripos.model.Product;

public class MainDAOTest {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/agripos";
        String user = "postgres";
        String pass = "1234";

        try (Connection conn = DriverManager.getConnection(url, user, pass)) {

            ProductDAO dao = new ProductDAOImpl(conn);

            // Insert
            Product p1 = new Product("P01", "Pupuk Organik", 25000, 10);
            dao.insert(p1);
            System.out.println("Inserted: " + p1);

            // Update
            p1.setName("Pupuk Organik Premium");
            p1.setPrice(30000);
            p1.setStock(8);
            dao.update(p1);
            System.out.println("Updated: " + p1);

            // Find by code
            Product found = dao.findByCode("P01");
            System.out.println("Found: " + found);

            // Find all
            List<Product> allProducts = dao.findAll();
            System.out.println("All Products:");
            for (Product prod : allProducts) {
                System.out.println(prod);
            }

            // Delete
            dao.delete("P01");
            System.out.println("Deleted P01");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

## products.sql
```sql
CREATE TABLE IF NOT EXISTS products (
    code VARCHAR(10) PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    price DOUBLE PRECISION NOT NULL,
    stock INT NOT NULL
);
```
---

## Hasil Eksekusi
(Sertakan screenshot hasil eksekusi program.  
![Screenshot hasil](screenshots/hasil.png)
)
---

## Analisis
1. DAO berhasil memisahkan logika akses data dari logika aplikasi.
2. CRUD berjalan lengkap tanpa SQL langsung di main program.
3. Integrasi dengan OOP mempermudah pengembangan dan pemeliharaan aplikasi.

Manfaat:
- Kode lebih terstruktur
- Memudahkan pengujian unit
- Mengurangi risiko kesalahan SQL di UI
---

## Kesimpulan
- Interface DAO dan implementasinya menggunakan JDBC berhasil dibuat.
- Operasi CRUD berjalan sesuai spesifikasi.
- Integrasi DAO dengan aplikasi OOP berhasil dilakukan tanpa menulis SQL langsung di main.
- Praktikum ini menunjukkan pentingnya DAO untuk kualitas dan maintainability kode.

---