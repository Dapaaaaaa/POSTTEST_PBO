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
│               ├── Main.java         ← Program utama 
└── README.md                         ← Laporan
```

---

## 📦 Class yang Digunakan

### 1. Class Menu
Menyimpan data menu makanan/minuman restoran.

| Atribut     | Tipe Data | Keterangan                            |
|-------------|-----------|---------------------------------------|
| id          | int       | ID unik menu (auto-increment)         |
| namaMenu    | String    | Nama menu                             |
| kategori    | String    | Kategori: Makanan / Minuman / Dessert |
| harga       | double    | Harga menu dalam rupiah               |
| tersedia    | boolean   | Status ketersediaan menu              |

### 2. Class Meja
Menyimpan data meja yang ada di restoran.

| Atribut     | Tipe Data | Keterangan                          |
|-------------|-----------|-------------------------------------|
| nomorMeja   | int       | Nomor meja (unik)                   |
| kapasitas   | int       | Jumlah kursi / kapasitas meja       |
| lokasi      | String    | Lokasi: Indoor / Outdoor / VIP      |
| terpesan    | boolean   | Status apakah meja sedang terpesan  |

### 3. Class Reservasi
Menyimpan data reservasi / pemesanan meja oleh pelanggan.

| Atribut      | Tipe Data | Keterangan                                         |
|--------------|-----------|----------------------------------------------------|
| idReservasi  | int       | ID unik reservasi (auto-increment)                 |
| namaPelanggan| String    | Nama pelanggan yang memesan                        |
| noTelepon    | String    | Nomor telepon pelanggan                            |
| nomorMeja    | int       | Nomor meja yang dipesan                            |
| tanggal      | String    | Tanggal reservasi (format DD-MM-YYYY)              |
| jamReservasi | String    | Jam reservasi (format HH:MM)                       |
| jumlahTamu   | int       | Jumlah tamu yang akan datang                       |
| status       | String    | Status: Menunggu / Dikonfirmasi / Selesai / Dibatalkan |

---

## Fitur Program

### Menu Utama
Program memiliki 3 modul utama yang dapat diakses dari menu utama:
1. **Manajemen Menu Makanan** – Kelola daftar menu restoran
2. **Manajemen Meja** – Kelola data meja restoran
3. **Manajemen Reservasi** – Kelola pemesanan/reservasi pelanggan

### Operasi CRUD pada Setiap Modul

#### Manajemen Menu Makanan
| Operasi | Deskripsi |
|---------|-----------|
| **Create** | Menambah menu baru (nama, kategori, harga, ketersediaan) |
| **Read**   | Menampilkan seluruh daftar menu dalam bentuk tabel |
| **Update** | Mengubah data menu berdasarkan ID |
| **Delete** | Menghapus menu berdasarkan ID dengan konfirmasi |
| **Search** | Mencari menu berdasarkan kata kunci nama |

#### Manajemen Meja
| Operasi | Deskripsi |
|---------|-----------|
| **Create** | Menambah meja baru (nomor, kapasitas, lokasi) |
| **Read**   | Menampilkan seluruh data meja |
| **Update** | Mengubah data meja (kapasitas, lokasi, status) |
| **Delete** | Menghapus data meja |
| **Filter** | Menampilkan hanya meja yang tersedia |

#### Manajemen Reservasi
| Operasi | Deskripsi |
|---------|-----------|
| **Create** | Membuat reservasi baru (otomatis mengunci meja) |
| **Read**   | Menampilkan seluruh data reservasi |
| **Update** | Mengubah status reservasi (otomatis bebaskan meja jika Selesai/Dibatalkan) |
| **Delete** | Membatalkan dan menghapus reservasi (otomatis bebaskan meja) |
| **Search** | Mencari reservasi berdasarkan nama pelanggan |

---

## Alur Logika Program

```
Program Mulai
    │
    ▼
Tampilkan Menu Utama
    │
    ├── [1] Manajemen Menu ──► Sub-menu CRUD Menu
    ├── [2] Manajemen Meja ──► Sub-menu CRUD Meja
    ├── [3] Manajemen Reservasi ──► Sub-menu CRUD Reservasi
    └── [0] Keluar ──► Program Selesai
    
(Looping sampai pengguna memilih 0)
```

### Logika Otomatis: Relasi Meja & Reservasi
- Saat **membuat reservasi** → status meja otomatis berubah menjadi **"Terpesan"**
- Saat **reservasi selesai / dibatalkan** → status meja otomatis kembali menjadi **"Tersedia"**

---
agian dari tugas Posttest Praktikum Pemrograman Berbasis Objek.*
