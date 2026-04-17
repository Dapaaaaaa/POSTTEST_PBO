# Sistem Manajemen dan Reservasi Restoran

## Deskripsi Program

Program ini adalah **Sistem Manajemen dan Reservasi Restoran** berbasis terminal yang dibuat menggunakan Bahasa Pemrograman Java. Program ini mampu mengelola data restoran secara lengkap menggunakan operasi **CRUD (Create, Read, Update, Delete)** dengan penyimpanan data menggunakan `ArrayList`.
Pada versi terbaru ini kita menggunakan 



## Informasi Mahasiswa
| **Atribut**     | Nilai                            |
|-----------------|----------------------------------|
| **Nama**        | Ananda Daffa Harahap             |
| **NIM**         | 2409106050                       |
| **Kelas**       | B1 Angkatan 2024                 |
| **Mata Kuliah** | Pemrograman Berbasis Objek (PBO) |

---

## Struktur Proyek

```
POSTTEST_4/
├── src/
│   └── main.java/
│       └── restaurant/
│           ├── Main.java            ← Program utama + logika CRUD & pemanggilan polymorphism
│           ├── InterfaceMenu.java   ← Interface
│           ├── ManajemenMenu.java   ← Implementasi dari Interface untuk menu
│           ├── Menu.java            ← Abstract Superclass Menu (Base Class)
│           ├── MenuMakanan.java     ← Subclass Menu (Implementasi Abstract Method)
│           ├── MenuMinuman.java     ← Subclass Menu (Implementasi Abstract Method)
│           ├── MenuDessert.java     ← Subclass Menu (Implementasi Abstract Method)
│           ├── Meja.java            ← Kelas Meja (enkapsulasi + getter/setter)
│           ├── Reservasi.java       ← Kelas Reservasi (enkapsulasi + getter/setter)
└── README.md                        ← Laporan & penjelasan konsep OOP
```

---

## Konsep OOP Yang Diterapkan
### 1. Enkapsulasi
Field yang ada pada kelas `Menu`, `Meja`, dan `Reservasi` menggunakan access modifier
`private` sehingga tidak akan bisa di akses dari luar kelas.

**Access Modifier**

Terdapat 2 Access Modifier yang digunakan, yaitu:
1. "Private" → Digunakan pada semua field didalam kelas (Menu,Meja, dan Reservasi).
2. "Public" → Digunakan pada semua method seperti *getter*, *setter*, dan *method* di file Main.

### 2. Getter & Setter
Saat ini semua kelas sudah menggunakan method getter & setter untuk mengakses 
dan untuk mengubah nilai field secara terkendali.

### #### Contoh pada class Menu
```java
// Getter
public String getNamaMenu() { return namaMenu; }
 
// Setter
public void setNamaMenu(String namaMenu) { this.namaMenu = namaMenu; }
``` 

---
### 3. Inheritance (Pewarisan)
Kelas `menu` menjadi sebuah super class dan memiliki 3 subclass, yaitu:

1. MenuMakanan
2. MenuMinuman
3. MenuDessert

### #### Contoh
``` Java
public class MenuMakanan extend Menu
```
---
### 4. Polymorphism
Terdapat 2 method yang digunakan pada poin `4`, yaitu:
_Overriding_ dan _Overloading_.

#### Overriding
Subclass akan mengubah perilaku method dari superclass.

#### Contoh
```java
@Override
public void tampilkanInfo() {
    System.out.println("[Makanan] " + getNamaMenu() + " - Rp" + getHarga());
}
```

#### Overloading
Method yang sama tetapi parameter berbeda.

#### Contoh
```java
public void updateMenu(String namaBaru, Double hargaBaru) {
 this.namaMenu = namaBaru;
 this.hargaMenu = hargaBaru;
}

public void updateMenu(String namaBaru) {
 this.namaMenu = namaBaru;
}

public void updateMenu(Double hargaBaru) {
 this.hargaMenu = hargaBaru;
}
```

### 5. Abstraction
Kelas `Menu` diubah menjadi `Abstract Class`. Hal ini dilakukan
karena `Menu` bersifat umum serta memastikan bahwa tidak ada
objek yang dibuat langsung dikelas ini, melainkan harus
melalui `Subclass`-nya dan `Abstract Method` wajib diimplementasikan
oleh setiap `Subclass`.

#### Contoh
```java
public abstract class Menu {
    public abstract String getKategori();
    public abstract String getInfoTambahan();
}
```

### 6. Interface
Menggunakan `Interface` sebagai sebuah fungsi manajemen data.
Interface ini menggunakan `Generics <T>` agar dapat digunakan
secara fleksibel diberbagai macam tipe data.

#### Contoh
```java
public interface InterfaceManajemen<T> {
    void tambahData(T data);
    boolean hapusData(int id);
    void tampilkanSemua();
    void cariData(String keyword); 
}
```


---
## Fitur yang Digunakan
### 1. Manajemen Menu
1. Tampilkan Menu
2. Tambah Menu
3. Update Menu
4. Hapus Menu
5. Cari Menu
### 2. Manajemen Meja
1. Tampilkan Meja
2. Tambah Meja
3. Update Meja
4. Hapus Meja
5. Cek Meja Tersedia
### 3. Manajemen Reservasi
1. Buat Reservasi
2. Tampilkan Reservasi
3. Update Status Reservasi
4. Batalkan Reservasi
5. Cari Reservasi