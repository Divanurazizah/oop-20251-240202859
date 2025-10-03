# Laporan Praktikum Minggu 1
Topik: Pengenalan Paradigma dan Setup Proyek

## Identitas
- Nama  : Diva Nur Azizah
- NIM   : 240202859
- Kelas : 3IKRA

---

## Tujuan
- Mahasiswa mampu mendefinisikan paradigma prosedural, OOP, dan fungsional.
- Mahasiswa mampu membandingkan kelebihan dan keterbatasan tiap paradigma.
- Mahasiswa dapat membuat program sederhana “Hello World, I am [Nama]-[NIM]” dengan ketiga pendekatan.

---

## Dasar Teori  
1. Pemrograman Prosedural: Menyelesaikan masalah dengan langkah-langkah terurut dari atas ke bawah, menggunakan variabel dan perintah secara langsung.
2. Pemrograman OOP (Object-Oriented Programming): Memodelkan masalah dengan class dan object. Class adalah blueprint yang memiliki atribut (data) dan method (perilaku).
3. Pemrograman Fungsional: Menekankan penggunaan fungsi murni dan lambda expression untuk membuat kode singkat, reusable, dan mudah di-parallel-kan.
4. Perbandingan:
   - Prosedural → sederhana, cocok untuk program kecil.
   - OOP → terstruktur, cocok untuk program kompleks.
   - Fungsional → deklaratif, cocok untuk operasi data intensif.

---

## Langkah Praktikum

1. Menyiapkan Java JDK serta editor (misalnya VS Code).  
2. Membuat tiga file terpisah: HelloProsedural.java, HelloOOP.java, HelloFunctional.java.  
3. Menulis kode sesuai paradigma yang dipilih.
4. Melakukan kompilasi dengan javac, lalu menjalankan program dengan java.
5. Menyimpan hasil output untuk dokumentasi.

---

## Kode Program
  
```
public class HelloProcedural {
    public static void main(String[] args) {
        // Paradigma prosedural: langsung instruksi urut
        String nama = "Diva Nur Azizah";
        String nim = "240202859";
        System.out.println("Hello World, I am " + nama + "-" + nim);
    }
}

```

```
class Person {
    private String name;
    private String nim;

    public Person(String name, String nim) {
        this.name = name;
        this.nim = nim;
    }

    public void sayHello() {
        System.out.println("Hello World, I am " + name + "-" + nim);
    }
}

public class HelloOOP {
    public static void main(String[] args) {
        Person me = new Person("Diva Nur Azizah", "240202859");
        me.sayHello();
    }
}
```

```
import java.util.function.BiConsumer;

public class HelloFunctional {
    public static void main(String[] args) {
        // Paradigma fungsional: pakai fungsi murni (lambda)
        BiConsumer<String, String> sayHello = (name, nim) -> 
            System.out.println("Hello World, I am " + name + "-" + nim);

        sayHello.accept("Diva Nur Azizah", "240202859");
    }
}
```

---

## Hasil Eksekusi

1. Procedural <img width="1111" height="681" alt="Screenshot 2025-10-03 105229" src="https://github.com/user-attachments/assets/9223318b-6ca9-4fb6-8338-51485539fdb8" />
2. OOP <img width="1061" height="618" alt="Screenshot 2025-10-03 105331" src="https://github.com/user-attachments/assets/8e2ec7d6-9611-47cb-952c-dbfeae791d5c" />
3. Functional <img width="1054" height="608" alt="Screenshot 2025-10-03 105416" src="https://github.com/user-attachments/assets/92dae2c2-dd0e-409e-90e3-00b6acbfc3ff" />

---

## Analisis

- Pada prosedural, kode sederhana dan langsung dijalankan, namun tidak fleksibel bila program semakin kompleks.
- Pada OOP, struktur program lebih jelas. Data (nama, nim) dan perilaku (tampilkan()) dibungkus dalam satu class. 
- Pada fungsional, pendekatan lebih ringkas. Dengan lambda, tidak perlu membuat class tambahan, cukup mendefinisikan fungsi singkat.
- Ketiganya menghasilkan output sama, namun pola penulisan berbeda.
- Perbandingan Paradigma:
  *Prosedural
  Kelebihan:Mudah dibuat, cocok untuk program kecil.
  Kekurangan:Susah diatur kalau program besar.
  *OOP
  Kelebihan:Lebih terstruktur, gampang dikembangkan.
  Kekurangan:Kodenya lebih panjang, agak ribet di awal.
  *Fungsional
  Kelebihan:Ringkas, enak untuk olah data, minim bug.
  Kekuangan:Kurang familiar, tidak semua kasus cocok.
---

## Kesimpulan

- Paradigma berbeda menawarkan kelebihan masing-masing:
  -Prosedural cocok untuk program kecil.
  -OOP sesuai untuk aplikasi yang butuh pengelolaan data lebih kompleks.
  -Fungsional lebih ringkas dan praktis untuk operasi data.
- Pemilihan paradigma harus menyesuaikan dengan konteks aplikasi dan kebutuhan pengembangan.
  


---

## Quiz
1. Apakah OOP selalu lebih baik dari prosedural?  
   **Jawaban:**
   Tidak selalu. OOP lebih baik untuk aplikasi yang besar, kompleks, dan butuh struktur jelas (misalnya aplikasi dengan banyak fitur). Tetapi untuk program kecil atau skrip sederhana, prosedural bisa lebih cepat dan mudah tanpa harus membuat class dan object.

3. Kapan functional programming lebih cocok digunakan dibanding OOP atau prosedural? 
   **Jawaban:**
    Functional programming lebih cocok untuk kasus yang membutuhkan perhitungan matematis, data processing, manipulasi data dalam jumlah besar, atau parallel computing. Karena sifat fungsi murni (pure function) membuat program lebih mudah diuji, diprediksi, dan dijalankan secara paralel tanpa efek samping.

4. Bagaimana paradigma (prosedural, OOP, fungsional) memengaruhi maintainability dan scalability aplikasi?
    **Jawaban:**
    Prosedural: mudah dipahami untuk program kecil, tetapi sulit di-maintain jika aplikasi makin besar karena kode bercampur dan tidak terstruktur.
   OOP: lebih mudah di-maintain dan scalable karena data dan perilaku terorganisir dalam class dan object. Cocok untuk aplikasi jangka panjang.
   Fungsional: mengurangi kompleksitas dengan fungsi murni, memudahkan debugging, serta lebih aman untuk aplikasi besar yang butuh performa tinggi atau paralelisasi.
   
4. Mengapa OOP lebih cocok untuk mengembangkan aplikasi POS dibanding prosedural?
   **Jawaban:**
    Karena aplikasi POS (Point of Sale) biasanya punya banyak entitas (Produk, Transaksi, Kasir, Pelanggan). Dengan OOP, setiap entitas bisa dibuat sebagai class sehingga lebih mudah dikembangkan, diperluas, dan di-maintain. Kalau pakai prosedural, data dan logika bercampur sehingga sulit dikelola kalau fitur bertambah.
   
6. Bagaimana paradigma fungsional dapat membantu mengurangi kode berulang (boilerplate code)?
   **Jawaban:**
    Functional programming mendorong penggunaan fungsi murni, higher-order function, dan immutability. Dengan itu, kita bisa menulis fungsi sekali lalu dipakai ulang tanpa perlu banyak kode tambahan. Misalnya, operasi seperti map(), filter(), atau reduce() bisa menggantikan looping manual berulang-ulang, sehingga kode jadi lebih singkat, jelas, dan bebas dari boilerplate. 
