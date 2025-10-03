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
(Sertakan screenshot hasil eksekusi program.  
![Screenshot hasil](screenshots/hasil.png)
)
---

## Analisis
(
- Jelaskan bagaimana kode berjalan.  
- Apa perbedaan pendekatan minggu ini dibanding minggu sebelumnya.  
- Kendala yang dihadapi dan cara mengatasinya.  
)
---

## Kesimpulan
(Tuliskan kesimpulan dari praktikum minggu ini.  
Contoh: *Dengan menggunakan class dan object, program menjadi lebih terstruktur dan mudah dikembangkan.*)

---

## Quiz
(1. [Tuliskan kembali pertanyaan 1 dari panduan]  
   **Jawaban:** …  

2. [Tuliskan kembali pertanyaan 2 dari panduan]  
   **Jawaban:** …  

3. [Tuliskan kembali pertanyaan 3 dari panduan]  
   **Jawaban:** …  )
