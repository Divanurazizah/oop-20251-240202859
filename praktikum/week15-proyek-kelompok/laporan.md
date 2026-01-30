# Laporan Praktikum Minggu 1 (sesuaikan minggu ke berapa?)
Topik: Bab 15 – Proyek Kelompok (Desain Sistem + Implementasi Terintegrasi + Testing + Dokumentasi)

## Identitas
- Nama  : Diva Nur Azizah
- NIM   : 240202859
- Kelas : 3IKRA

---

## Tujuan
Setelah mengikuti proyek ini, mahasiswa mampu:

1. Berkolaborasi dalam tim untuk membangun aplikasi terintegrasi.
2. Mendesain sistem secara lengkap menggunakan UML (Use Case, Class, Sequence).
3. Mengimplementasikan sistem sesuai desain dengan arsitektur yang rapi (SOLID + DIP).
4. Menyusun dokumentasi teknis dan laporan proyek yang lengkap.
5. Menyusun test plan dan test case, serta menjalankan unit/integration test dasar.

---

## Dasar Teori
Agri-POS adalah sistem kasir terintegrasi yang dirancang khusus untuk toko pertanian. Sistem ini mengelola inventaris produk, memproses transaksi penjualan dengan berbagai metode pembayaran, dan menyediakan laporan penjualan harian untuk admin.
Fitur Utama:
- Manajemen Inventaris (CRUD Produk).
- Sistem Penjualan (Cart & Checkout).
- Multi-Payment (Cash & E-Wallet) menggunakan Strategy Pattern.
- Manajemen Hak Akses (Admin & Kasir).
- Laporan Penjualan & Cetak Struk.

---

## Desain Sistem & Arsitektur
Sistem dibangun menggunakan Arsitektur Layered untuk memisahkan tanggung jawab (Separation of Concerns):
1. View (JavaFX): Menangani tampilan .fxml dan komponen UI.
2. Controller: Jembatan antara UI dan logika bisnis.
3. Service Layer: Berisi logika bisnis (validasi, perhitungan pajak/diskon). Di sini prinsip DIP (Dependency Inversion) diterapkan.
4. DAO (Data Access Object): Menangani query SQL ke PostgreSQL menggunakan PreparedStatement.
5. Model/Entity: Representasi data (Product, Transaction, User).

---

## UML Diagram
A. Use Case Diagram
(Aktor Admin mengelola produk dan laporan. Aktor Kasir mengelola transaksi dan pembayaran. Keduanya melakukan Login.)

B. Class Diagram
Sistem menggunakan Strategy Pattern untuk FR-3 (Payment):
- Interface: PaymentStrategy
- Concrete: CashPayment, EWalletPayment

C. Sequence Diagram: Checkout Transaksi
1. `CartController` memanggil `TransactionService.processCheckout()`.
2. `TransactionService` melakukan validasi stok via `ProductDAO`.
3. `TransactionService` menyimpan data via `TransactionDAO`.
4. `ProductDAO` memperbarui stok produk di database.
---

## Test Plan & Test Case
A. Unit Test (JUnit)
Kami melakukan pengujian pada logika perhitungan total di CartService.
- Method: calculateTotal()
- Result: PASSED (Screenshot terlampir di folder /screenshots)

B. Test Case Manual
ID,Fitur,Langkah,Hasil yang Diharapkan,Status
TC-01,Login,Input username admin/admin,Masuk ke dashboard Admin,Pass
TC-02,CRUD,Tambah produk stok 0,Muncul pesan error validasi,Pass
TC-03,Transaksi,"Klik ""Bayar"" tanpa item",Tombol disable atau muncul peringatan,Pass
TC-04,Stok,Checkout 5 barang,Stok di database berkurang 5,Pass
---

## Traceability Matrix
Artefak,Referensi,Implementasi (Kelas/Metode),Bukti
FR-1,Manajemen Produk,"ProductService.save(), ProductDAO.findAll()",Screenshot CRUD Produk
FR-2,Transaksi,"CartService.addItem(), TransactionService",Screenshot Tabel Keranjang
FR-3,Pembayaran,Interface PaymentStrategy (OCP),Pilihan Dropdown Tunai/E-Wallet
FR-4,Struk,ReceiptGenerator.printText(),Output Console/UI Struk
FR-5,Login/Role,"AuthService.authenticate(), SessionManager",Menu berbeda untuk Admin/Kasir
OFR-2,Diskon (Opt),DiscountService.applyVoucher(),Total harga berkurang otomatis
---

## Pembagian Kerja
Ditha Elita Putri (240202832)
Peran: UI Designer & Frontend Developer.
Kontribusi: Mengembangkan PosView.java (Layout Admin & Kasir), LoginView.java, dan integrasi event handler tombol.

Fauzatul Farhanah (240202834)
Peran: Backend Logic (Authentication).
Kontribusi: Implementasi AuthService, JdbcUserDAO, dan keamanan login serta manajemen sesi user.

Muhammad Nuur Fathan (240202840)
Peran: Backend Logic (Transaction & Cart).
Kontribusi: Membangun logika inti TransactionService, CartService, dan perhitungan total belanja.

Diva Nur Azizah (240202859)
Peran: Database Specialist & Product Management.
Kontribusi: Implementasi CRUD pada JdbcProductDAO, ProductService, dan desain skema database PostgreSQL.

Hanifah (240202864)
Peran: Reporting & Testing Specialist.
Kontribusi: Implementasi ReportService, Receipt (Struk), Strategy Pattern pada PaymentMethod, serta penyusunan Unit Testing.
---

## Kendala & Solusi
- Kendala: Database Connection Leak (koneksi tidak tertutup).
Solusi: Menggunakan try-with-resources pada setiap statement JDBC.

- Kendala: Kesulitan sinkronisasi UI JavaFX saat data di DB berubah.
Solusi: Menggunakan ObservableList untuk binding data dari DAO ke TableView.

- Kendala: Perubahan struktur class di tengah pengerjaan.
Solusi: Refactoring menggunakan fitur IDE dan melakukan koordinasi via Git Pull Request.
