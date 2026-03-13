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
                ├── Menu.java         ← Kelas Menu (Enkasulasi + getter dan setter)
                ├── Reservasi.java    ← Kelas Reservasi (Enkasulasi + getter dan setter)
└── README.md                         ← Laporan
```

---

## Konsep OOP Yang Diterapkan
### 1. Enkapsulasi
Field yang ada pada kelas "Menu", "Meja", dan "Reservasi" menggunakan access modifier
"private" sehingga tidak akan bisa di akses dari luar kelas.

**Access Modifier**
Terdapat 2 Access Modifier yang digunakan, yaitu:
1. "Private" → Digunakan pada semua field didalam kelas (Menu,Meja, dan Reservasi).
2. "Public" → Digunakan pada semua method seperti *getter*, *setter*, dan *method* di file Main.

### 2. Getter & Setter
Saat ini semua kelas sudah menggunakan method getter & setter untuk mengakses 
dan untuk mengubah nilai field secara terkendali.

---
## Contoh pada class Menu
```java
// Getter
public String getNamaMenu() { return namaMenu; }
 
// Setter
public void setNamaMenu(String namaMenu) { this.namaMenu = namaMenu; }
``` 

---
## Fitur yang Digunakan
### 1. Manajemen Menu
Terdapat CRUD Standar seperti Tampilkan, Tambah, Update, Hapus dan Cari Menu Makanan.
### 2. Manajemen Meja
Sama seperti Manajemen Menu, ada Tambah, Tampilkan, Update, Hapus, Cek ketersediaan meja.
### 3. Manajemen Meja
Memiliki perbedaan dimana pada manajemen meja terdapat Buat, Tampilkan, Update Status, Batalkan, Cari Reservasi.


