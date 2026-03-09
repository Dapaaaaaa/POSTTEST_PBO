import java.util.ArrayList;
import java.util.Scanner;

//   CLASS MENU
    class Menu {
    int id;
    String namaMenu;
    String kategori;
    double harga;
    boolean tersedia;

    Menu(int id, String namaMenu, String kategori, double harga, boolean tersedia) {
        this.id = id;
        this.namaMenu = namaMenu;
        this.kategori = kategori;
        this.harga = harga;
        this.tersedia = tersedia;
    }
}

//   CLASS MEJA
    class Meja {
    int nomorMeja;
    int kapasitas;
    String lokasi;
    boolean terpesan;

    Meja(int nomorMeja, int kapasitas, String lokasi, boolean terpesan) {
        this.nomorMeja = nomorMeja;
        this.kapasitas = kapasitas;
        this.lokasi = lokasi;
        this.terpesan = terpesan;
    }
}

//    CLASS RESERVASI
    class Reservasi {
    int idReservasi;
    String namaPelanggan;
    String noTelepon;
    int nomorMeja;
    String tanggal;
    String jamReservasi;
    int jumlahTamu;
    String status;

    Reservasi(int idReservasi, String namaPelanggan, String noTelepon,
              int nomorMeja, String tanggal, String jamReservasi,
              int jumlahTamu, String status) {
        this.idReservasi = idReservasi;
        this.namaPelanggan = namaPelanggan;
        this.noTelepon = noTelepon;
        this.nomorMeja = nomorMeja;
        this.tanggal = tanggal;
        this.jamReservasi = jamReservasi;
        this.jumlahTamu = jumlahTamu;
        this.status = status;
    }
}

//   CLASS MAIN - Program Utama
public class Main {

    static ArrayList<Menu> daftarMenu = new ArrayList<>();
    static ArrayList<Meja> daftarMeja = new ArrayList<>();
    static ArrayList<Reservasi> daftarReservasi = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    static int menuIdCounter = 1;
    static int reservasiIdCounter = 1;

    public static void main(String[] args) {
        isiDataAwal();

        System.out.println("   SELAMAT DATANG DI SISTEM MANAJEMEN RESTORAN         ");
        System.out.println("          \"Restoran Nusantara Indah\"                  ");

        boolean jalan = true;
        while (jalan) {
            tampilMenuUtama();
            int pilihan = bacaAngka("Pilih menu: ");
            switch (pilihan) {
                case 1: menuManajemenMenu(); break;
                case 2: menuManajemenMeja(); break;
                case 3: menuManajemenReservasi(); break;
                case 0:
                    System.out.println("\nTerima kasih! Sampai jumpa :)");
                    jalan = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid! Coba lagi.");
            }
        }
        scanner.close();
    }

    // ==================== MENU UTAMA ====================
    static void tampilMenuUtama() {
        System.out.println("       MENU UTAMA           ");
        System.out.println("--------------------------------");
        System.out.println("  1. Manajemen Menu Makanan   ");
        System.out.println("  2. Manajemen Meja           ");
        System.out.println("  3. Manajemen Reservasi      ");
        System.out.println("  0. Keluar Program           ");
    }

    //         MENU MAKANAN - CRUD
    static void menuManajemenMenu() {
        boolean kembali = false;
        while (!kembali) {
            System.out.println("    MANAJEMEN MENU MAKANAN    ");
            System.out.println("--------------------------------");
            System.out.println("  1. Tampilkan Semua Menu     ");
            System.out.println("  2. Tambah Menu Baru         ");
            System.out.println("  3. Update Menu              ");
            System.out.println("  4. Hapus Menu               ");
            System.out.println("  5. Cari Menu                ");
            System.out.println("  0. Kembali ke Menu Utama    ");

            int pilihan = bacaAngka("Pilih: ");
            switch (pilihan) {
                case 1: tampilSemuaMenu(); break;
                case 2: tambahMenu(); break;
                case 3: updateMenu(); break;
                case 4: hapusMenu(); break;
                case 5: cariMenu(); break;
                case 0: kembali = true; break;
                default: System.out.println("Pilihan tidak valid!");
            }
        }
    }

    static void tampilSemuaMenu() {
        System.out.println("\n========== DAFTAR MENU RESTORAN ==========");
        if (daftarMenu.isEmpty()) {
            System.out.println("Belum ada data menu.");
            return;
        }
        System.out.println("| ID   | Nama Menu            | Kategori   | Harga          | Status     |");
        System.out.println("--------------------------------------------------------------------------");
        for (Menu m : daftarMenu) {
            System.out.printf("| %-4d | %-20s | %-10s | Rp%-12.0f | %-10s |\n",
                    m.id,
                    m.namaMenu,
                    m.kategori,
                    m.harga,
                    m.tersedia ? "Tersedia" : "Habis"
            );
        }
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("Total: " + daftarMenu.size() + " menu");
    }

    static void tambahMenu() {
        System.out.println("\n--- TAMBAH MENU BARU ---");
        scanner.nextLine();

        System.out.print("Nama Menu     : ");
        String nama = scanner.nextLine();

        System.out.println("Pilih Kategori: 1.Makanan  2.Minuman  3.Dessert");
        int katPilih = bacaAngka("Pilihan: ");
        String kategori;
        switch (katPilih) {
            case 1: kategori = "Makanan"; break;
            case 2: kategori = "Minuman"; break;
            case 3: kategori = "Dessert"; break;
            default: kategori = "Makanan";
        }

        System.out.print("Harga (Rp)    : ");
        double harga = scanner.nextDouble();

        System.out.print("Tersedia? (1=Ya / 0=Tidak): ");
        boolean tersedia = scanner.nextInt() == 1;

        daftarMenu.add(new Menu(menuIdCounter++, nama, kategori, harga, tersedia));
        System.out.println("Menu \"" + nama + "\" berhasil ditambahkan!");
    }

    static void updateMenu() {
        tampilSemuaMenu();
        if (daftarMenu.isEmpty()) return;

        int id = bacaAngka("Masukkan ID menu yang ingin diupdate: ");
        Menu target = cariMenuById(id);

        if (target == null) {
            System.out.println("Menu dengan ID " + id + " tidak ditemukan!");
            return;
        }

        System.out.println("\n--- UPDATE MENU: " + target.namaMenu + " ---");
        System.out.println("(Tekan Enter untuk melewati)");
        scanner.nextLine();

        System.out.print("Nama Menu baru [" + target.namaMenu + "]: ");
        String nama = scanner.nextLine();
        if (!nama.isEmpty()) target.namaMenu = nama;

        System.out.print("Kategori baru [" + target.kategori + "] (Makanan/Minuman/Dessert): ");
        String kat = scanner.nextLine();
        if (!kat.isEmpty()) target.kategori = kat;

        System.out.print("Harga baru [" + target.harga + "] (kosongkan=skip): ");
        String hargaStr = scanner.nextLine();
        if (!hargaStr.isEmpty()) target.harga = Double.parseDouble(hargaStr);

        System.out.print("Status tersedia [" + (target.tersedia ? "Ya" : "Tidak") + "] (1=Ya/0=Tidak/Enter=skip): ");
        String statusStr = scanner.nextLine();
        if (!statusStr.isEmpty()) target.tersedia = statusStr.equals("1");

        System.out.println("Menu berhasil diupdate!");
    }

    static void hapusMenu() {
        tampilSemuaMenu();
        if (daftarMenu.isEmpty()) return;

        int id = bacaAngka("Masukkan ID menu yang ingin dihapus: ");
        Menu target = cariMenuById(id);

        if (target == null) {
            System.out.println("Menu dengan ID " + id + " tidak ditemukan!");
            return;
        }

        System.out.print("Yakin hapus \"" + target.namaMenu + "\"? (y/n): ");
        scanner.nextLine();
        String konfirmasi = scanner.nextLine();
        if (konfirmasi.equalsIgnoreCase("y")) {
            daftarMenu.remove(target);
            System.out.println("Menu berhasil dihapus!");
        } else {
            System.out.println("Penghapusan dibatalkan.");
        }
    }

    static void cariMenu() {
        scanner.nextLine();
        System.out.print("Masukkan nama menu yang dicari: ");
        String keyword = scanner.nextLine().toLowerCase();

        System.out.println("\n--- HASIL PENCARIAN: \"" + keyword + "\" ---");
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("| ID   | Nama Menu            | Kategori   | Harga          | Status     |");
        System.out.println("--------------------------------------------------------------------------");
        boolean ketemu = false;
        for (Menu m : daftarMenu) {
            if (m.namaMenu.toLowerCase().contains(keyword)) {
                System.out.printf("| %-4d | %-20s | %-10s | Rp%-12.0f | %-10s |\n",
                        m.id, m.namaMenu, m.kategori,
                        m.harga, m.tersedia ? "Tersedia" : "Habis");
                ketemu = true;
            }
        }
        System.out.println("--------------------------------------------------------------------------");
        if (!ketemu) System.out.println("Menu tidak ditemukan.");
    }

    static Menu cariMenuById(int id) {
        for (Menu m : daftarMenu) {
            if (m.id == id) return m;
        }
        return null;
    }

    //           MEJA - CRUD
    static void menuManajemenMeja() {
        boolean kembali = false;
        while (!kembali) {
            System.out.println("      MANAJEMEN MEJA          ");
            System.out.println("--------------------------------");
            System.out.println("  1. Tampilkan Semua Meja     ");
            System.out.println("  2. Tambah Meja Baru         ");
            System.out.println("  3. Update Data Meja         ");
            System.out.println("  4. Hapus Meja               ");
            System.out.println("  5. Cek Meja Tersedia        ");
            System.out.println("  0. Kembali ke Menu Utama    ");

            int pilihan = bacaAngka("Pilih: ");
            switch (pilihan) {
                case 1: tampilSemuaMeja(); break;
                case 2: tambahMeja(); break;
                case 3: updateMeja(); break;
                case 4: hapusMeja(); break;
                case 5: cekMejaTersedia(); break;
                case 0: kembali = true; break;
                default: System.out.println("Pilihan tidak valid!");
            }
        }
    }

    static void tampilSemuaMeja() {
        System.out.println("\n========== DAFTAR MEJA RESTORAN ==========");
        if (daftarMeja.isEmpty()) {
            System.out.println("Belum ada data meja.");
            return;
        }
        System.out.println("-------------------------------------------------");
        System.out.println("| No Meja| Kapasitas  | Lokasi     | Status     |");
        System.out.println("-------------------------------------------------");
        for (Meja m : daftarMeja) {
            System.out.printf("| %-6d | %-10d | %-10s | %-10s |\n",
                    m.nomorMeja,
                    m.kapasitas,
                    m.lokasi,
                    m.terpesan ? "Terpesan" : "Tersedia"
            );
        }
        System.out.println("-------------------------------------------------");
        System.out.println("Total: " + daftarMeja.size() + " meja");
    }

    static void tambahMeja() {
        System.out.println("\n--- TAMBAH MEJA BARU ---");
        int nomor = bacaAngka("Nomor Meja  : ");

        if (cariMejaByNomor(nomor) != null) {
            System.out.println("Meja nomor " + nomor + " sudah ada!");
            return;
        }

        int kapasitas = bacaAngka("Kapasitas   : ");

        System.out.println("Pilih Lokasi: 1.Indoor  2.Outdoor  3.VIP");
        int lokPilih = bacaAngka("Pilihan: ");
        String lokasi;
        switch (lokPilih) {
            case 1: lokasi = "Indoor"; break;
            case 2: lokasi = "Outdoor"; break;
            case 3: lokasi = "VIP"; break;
            default: lokasi = "Indoor";
        }

        daftarMeja.add(new Meja(nomor, kapasitas, lokasi, false));
        System.out.println("Meja nomor " + nomor + " berhasil ditambahkan!");
    }

    static void updateMeja() {
        tampilSemuaMeja();
        if (daftarMeja.isEmpty()) return;

        int nomor = bacaAngka("Masukkan nomor meja yang ingin diupdate: ");
        Meja target = cariMejaByNomor(nomor);

        if (target == null) {
            System.out.println("Meja nomor " + nomor + " tidak ditemukan!");
            return;
        }

        System.out.println("\n--- UPDATE MEJA NO. " + nomor + " ---");
        int kapasitasBaru = bacaAngka("Kapasitas baru [" + target.kapasitas + "] (0=skip): ");
        if (kapasitasBaru > 0) target.kapasitas = kapasitasBaru;

        System.out.println("Pilih Lokasi baru: 1.Indoor  2.Outdoor  3.VIP  0.Skip");
        int lokPilih = bacaAngka("Pilihan: ");
        if (lokPilih > 0) {
            switch (lokPilih) {
                case 1: target.lokasi = "Indoor"; break;
                case 2: target.lokasi = "Outdoor"; break;
                case 3: target.lokasi = "VIP"; break;
            }
        }

        System.out.print("Status (1=Terpesan / 0=Tersedia): ");
        target.terpesan = bacaAngka("") == 1;

        System.out.println("Data meja berhasil diupdate!");
    }

    static void hapusMeja() {
        tampilSemuaMeja();
        if (daftarMeja.isEmpty()) return;

        int nomor = bacaAngka("Masukkan nomor meja yang ingin dihapus: ");
        Meja target = cariMejaByNomor(nomor);

        if (target == null) {
            System.out.println("Meja nomor " + nomor + " tidak ditemukan!");
            return;
        }

        daftarMeja.remove(target);
        System.out.println("Meja nomor " + nomor + " berhasil dihapus!");
    }

    static void cekMejaTersedia() {
        System.out.println("\n========== MEJA YANG TERSEDIA ==========");
        System.out.println("-------------------------------------------------");
        System.out.println("| No Meja| Kapasitas  | Lokasi     | Status     |");
        System.out.println("-------------------------------------------------");
        boolean ada = false;
        for (Meja m : daftarMeja) {
            if (!m.terpesan) {
                System.out.printf("| %-6d | %-10d | %-10s | %-10s |\n",
                        m.nomorMeja, m.kapasitas, m.lokasi, "Tersedia");
                ada = true;
            }
        }
        System.out.println("------------------------------------------------");
        if (!ada) System.out.println("Tidak ada meja yang tersedia saat ini.");
    }

    static Meja cariMejaByNomor(int nomor) {
        for (Meja m : daftarMeja) {
            if (m.nomorMeja == nomor) return m;
        }
        return null;
    }

    //         RESERVASI - CRUD
    static void menuManajemenReservasi() {
        boolean kembali = false;
        while (!kembali) {
            System.out.println("    MANAJEMEN RESERVASI       ");
            System.out.println("------------------------------");
            System.out.println("  1. Tampilkan Semua Reservasi");
            System.out.println("  2. Buat Reservasi Baru      ");
            System.out.println("  3. Update Reservasi         ");
            System.out.println("  4. Batalkan Reservasi       ");
            System.out.println("  5. Cari Reservasi Pelanggan ");
            System.out.println("  0. Kembali ke Menu Utama    ");

            int pilihan = bacaAngka("Pilih: ");
            switch (pilihan) {
                case 1: tampilSemuaReservasi(); break;
                case 2: buatReservasi(); break;
                case 3: updateReservasi(); break;
                case 4: batalkanReservasi(); break;
                case 5: cariReservasi(); break;
                case 0: kembali = true; break;
                default: System.out.println("Pilihan tidak valid!");
            }
        }
    }

    static void tampilSemuaReservasi() {
        System.out.println("\n========== DAFTAR RESERVASI ==========");
        if (daftarReservasi.isEmpty()) {
            System.out.println("Belum ada data reservasi.");
            return;
        }
        System.out.println("--------------------------------------------------------------------------------------------------");
        System.out.println("| ID   | Nama Pelanggan  | No. Telepon   | Meja  | Tanggal      | Jam    | Tamu   | Status       |");
        System.out.println("--------------------------------------------------------------------------------------------------");
        for (Reservasi r : daftarReservasi) {
            System.out.printf("| %-4d | %-15s | %-13s | %-5d | %-12s | %-6s | %-6d | %-12s |\n",
                    r.idReservasi,
                    r.namaPelanggan,
                    r.noTelepon,
                    r.nomorMeja,
                    r.tanggal,
                    r.jamReservasi,
                    r.jumlahTamu,
                    r.status
            );
        }
        System.out.println("--------------------------------------------------------------------------------------------------");
        System.out.println("Total: " + daftarReservasi.size() + " reservasi");
    }

    static void buatReservasi() {
        System.out.println("\n--- BUAT RESERVASI BARU ---");
        scanner.nextLine();

        System.out.print("Nama Pelanggan  : ");
        String nama = scanner.nextLine();

        System.out.print("No. Telepon     : ");
        String telepon = scanner.nextLine();

        cekMejaTersedia();
        int nomorMeja = bacaAngka("Pilih Nomor Meja: ");
        Meja meja = cariMejaByNomor(nomorMeja);

        if (meja == null) {
            System.out.println("Meja tidak ditemukan!");
            return;
        }
        if (meja.terpesan) {
            System.out.println("Maaf, meja ini sudah terpesan!");
            return;
        }

        scanner.nextLine();
        System.out.print("Tanggal (DD-MM-YYYY): ");
        String tanggal = scanner.nextLine();

        System.out.print("Jam (HH:MM)         : ");
        String jam = scanner.nextLine();

        int jumlahTamu = bacaAngka("Jumlah Tamu         : ");

        daftarReservasi.add(new Reservasi(
                reservasiIdCounter++, nama, telepon,
                nomorMeja, tanggal, jam, jumlahTamu, "Dikonfirmasi"
        ));
        meja.terpesan = true;

        System.out.println("Reservasi berhasil dibuat!");
        System.out.println("  ID Reservasi : " + (reservasiIdCounter - 1));
        System.out.println("  Nama         : " + nama);
        System.out.println("  Meja No.     : " + nomorMeja);
        System.out.println("  Tanggal      : " + tanggal + " pukul " + jam);
    }

    static void updateReservasi() {
        tampilSemuaReservasi();
        if (daftarReservasi.isEmpty()) return;

        int id = bacaAngka("Masukkan ID reservasi yang ingin diupdate: ");
        Reservasi target = cariReservasiById(id);

        if (target == null) {
            System.out.println("Reservasi ID " + id + " tidak ditemukan!");
            return;
        }

        System.out.println("\n--- UPDATE STATUS RESERVASI ID: " + id + " ---");
        System.out.println("1. Menunggu");
        System.out.println("2. Dikonfirmasi");
        System.out.println("3. Selesai       (meja akan dibebaskan)");
        System.out.println("4. Dibatalkan    (meja akan dibebaskan)");
        System.out.println("0. Skip");

        int statusPilih = bacaAngka("Pilihan: ");
        if (statusPilih > 0) {
            switch (statusPilih) {
                case 1: target.status = "Menunggu"; break;
                case 2: target.status = "Dikonfirmasi"; break;
                case 3:
                    target.status = "Selesai";
                    Meja meja = cariMejaByNomor(target.nomorMeja);
                    if (meja != null) meja.terpesan = false;
                    System.out.println("  Meja no." + target.nomorMeja + " sudah dibebaskan.");
                    break;
                case 4:
                    target.status = "Dibatalkan";
                    Meja mejaBatal = cariMejaByNomor(target.nomorMeja);
                    if (mejaBatal != null) mejaBatal.terpesan = false;
                    System.out.println("  Meja no." + target.nomorMeja + " sudah dibebaskan.");
                    break;
            }
        }

        int tamuBaru = bacaAngka("Jumlah tamu baru [" + target.jumlahTamu + "] (0=skip): ");
        if (tamuBaru > 0) target.jumlahTamu = tamuBaru;

        System.out.println("Reservasi berhasil diupdate!");
    }

    static void batalkanReservasi() {
        tampilSemuaReservasi();
        if (daftarReservasi.isEmpty()) return;

        int id = bacaAngka("Masukkan ID reservasi yang ingin dibatalkan: ");
        Reservasi target = cariReservasiById(id);

        if (target == null) {
            System.out.println("Reservasi ID " + id + " tidak ditemukan!");
            return;
        }

        System.out.print("Yakin batalkan reservasi \"" + target.namaPelanggan + "\"? (y/n): ");
        scanner.nextLine();
        String konfirmasi = scanner.nextLine();

        if (konfirmasi.equalsIgnoreCase("y")) {
            Meja meja = cariMejaByNomor(target.nomorMeja);
            if (meja != null) meja.terpesan = false;
            daftarReservasi.remove(target);
            System.out.println("Reservasi berhasil dibatalkan!");
        } else {
            System.out.println("Pembatalan dibatalkan.");
        }
    }

    static void cariReservasi() {
        scanner.nextLine();
        System.out.print("Masukkan nama pelanggan yang dicari: ");
        String keyword = scanner.nextLine().toLowerCase();

        System.out.println("\n--- HASIL PENCARIAN: \"" + keyword + "\" ---");
        System.out.println("--------------------------------------------------------------------------------------------------");
        System.out.println("| ID   | Nama Pelanggan  | No. Telepon   | Meja  | Tanggal      | Jam    | Tamu   | Status       |");
        System.out.println("--------------------------------------------------------------------------------------------------");
        boolean ketemu = false;
        for (Reservasi r : daftarReservasi) {
            if (r.namaPelanggan.toLowerCase().contains(keyword)) {
                System.out.printf("| %-4d | %-15s | %-13s | %-5d | %-12s | %-6s | %-6d | %-12s |\n",
                        r.idReservasi, r.namaPelanggan, r.noTelepon,
                        r.nomorMeja, r.tanggal, r.jamReservasi,
                        r.jumlahTamu, r.status);
                ketemu = true;
            }
        }
        System.out.println("--------------------------------------------------------------------------------------------------");
        if (!ketemu) System.out.println("Reservasi tidak ditemukan.");
    }

    static Reservasi cariReservasiById(int id) {
        for (Reservasi r : daftarReservasi) {
            if (r.idReservasi == id) return r;
        }
        return null;
    }

    //       DATA AWAL
    static void isiDataAwal() {
        daftarMenu.add(new Menu(menuIdCounter++, "Nasi Goreng Spesial", "Makanan", 35000, true));
        daftarMenu.add(new Menu(menuIdCounter++, "Mie Ayam Bakso",      "Makanan", 28000, true));
        daftarMenu.add(new Menu(menuIdCounter++, "Soto Ayam",           "Makanan", 25000, true));
        daftarMenu.add(new Menu(menuIdCounter++, "Es Teh Manis",        "Minuman",  8000, true));
        daftarMenu.add(new Menu(menuIdCounter++, "Jus Alpukat",         "Minuman", 18000, true));
        daftarMenu.add(new Menu(menuIdCounter++, "Es Krim Coklat",      "Dessert", 22000, true));

        daftarMeja.add(new Meja(1, 2, "Indoor",  false));
        daftarMeja.add(new Meja(2, 4, "Indoor",  true));
        daftarMeja.add(new Meja(3, 6, "Outdoor", false));
        daftarMeja.add(new Meja(4, 4, "Outdoor", false));
        daftarMeja.add(new Meja(5, 8, "VIP",     false));

        daftarReservasi.add(new Reservasi(
                reservasiIdCounter++, "Budi Santoso", "081234567890",
                2, "10-03-2025", "19:00", 3, "Dikonfirmasi"
        ));
    }

    //       UTILITY: Baca Input Angka
    static int bacaAngka(String pesan) {
        while (true) {
            try {
                if (!pesan.isEmpty()) System.out.print(pesan);
                int angka = scanner.nextInt();
                return angka;
            } catch (Exception e) {
                System.out.println("Input tidak valid! Masukkan angka.");
                scanner.nextLine();
            }
        }
    }
}