# Sistem Manajemen dan Reservasi Restoran

## Deskripsi Program

Program ini adalah **Sistem Manajemen dan Reservasi Restoran** berbasis terminal yang dibuat menggunakan Bahasa Pemrograman Java. Program ini mampu mengelola data restoran secara lengkap menggunakan operasi **CRUD (Create, Read, Update, Delete)** dengan penyimpanan data menggunakan `ArrayList`.



## Informasi Mahasiswa

 Nama          | Ananda Daffa Harahap       |
 NIM           | 2409106050                 |
 Kelas         | B1 2024                    |
 Mata Kuliah   | Pemrograman Berbasis Objek |
 

---

## Struktur Proyek

```
POSTTEST_1/
├── src/
│   └── main.java/
│           └── restaurant/
│               ├── Main.java         ← Program utama + Logika CRUDnya (Main) 
                ├── Meja.java         ← Kelas Meja (Enkasulasi + getter dan setter)
                ├── Menu.java         ← Kelas Menu (Inheritance dan parent dari Subclass)
                ├── MenuMakanan.java  ← Kelas MenuMakanan (Subclass dari Menu.java)
                ├── MenuMinuman.java  ← Kelas MenuMinuman (Subclass dari Menu.java)
                ├── MenuDessert.java  ← Kelas MenuDessert (Subclass dari Menu.java)
                ├── Reservasi.java    ← Kelas Reservasi (Enkasulasi + getter dan setter)
└── README.md                         ← Laporan
```

---

## Konsep Inheritance Yang Diterapkan
### 1. Parent (Hierarki)
Menjadikan file Menu.java sebagai _parent class_ dari beberapa _subclass___,
dengan atribut seperti id, nama menu, harga, dan status dari menu.

### 2. Subclass
Dari file Menu.java kita bagi menjadi 3 file _Subclass_, Yaitu :
1. MenuMakanan.java
2. MenuMinuman.java
3. MenuDessert

Setiap masing-masing _Subclass_ memiliki jenis menu yang berbeda

### 3. Metode Override
Masing-masing _Subclass_ melakukan metode ini untuk method kategori,
sehingga nilai kategori tetap benar dan sesuai nama file _Subclass_

---
## Fitur yang Digunakan
### 1. Manajemen Menu
Terdapat CRUD Standar seperti Tampilkan, Tambah, Update, Hapus dan Cari Menu Makanan.
### 2. Manajemen Meja
Sama seperti Manajemen Menu, ada Tambah, Tampilkan, Update, Hapus, Cek ketersediaan meja.
### 3. Manajemen Meja
Memiliki perbedaan dimana pada manajemen meja terdapat Buat, Tampilkan, Update Status, Batalkan, Cari Reservasi.


