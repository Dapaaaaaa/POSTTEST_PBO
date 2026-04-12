import java.util.ArrayList;
import java.util.Scanner;

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

    static void tampilMenuUtama() {
        System.out.println("\n       MENU UTAMA           ");
        System.out.println("--------------------------------");
        System.out.println("  1. Manajemen Menu Makanan   ");
        System.out.println("  2. Manajemen Meja           ");
        System.out.println("  3. Manajemen Reservasi      ");
        System.out.println("  0. Keluar Program           ");
    }

    // ==================== MENU MAKANAN ====================
    static void menuManajemenMenu() {
        boolean kembali = false;
        while (!kembali) {
            System.out.println("\n    MANAJEMEN MENU MAKANAN    ");
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
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("| ID   | Nama Menu            | Kategori   | Harga          | Status     |");
        System.out.println("--------------------------------------------------------------------------");

        for (Menu m : daftarMenu) {
            System.out.printf("| %-4d | %-20s | %-10s | Rp%-12.0f | %-10s |\n",
                    m.getId(),
                    m.getNamaMenu(),
                    m.getKategori(),
                    m.getHarga(),
                    m.isTersedia() ? "Tersedia" : "Habis"
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

        Menu menuBaru;

        switch (katPilih) {
            case 1:
                menuBaru = new MenuMakanan(menuIdCounter++, nama, harga, tersedia);
                break;
            case 2:
                menuBaru = new MenuMinuman(menuIdCounter++, nama, harga, tersedia);
                break;
            case 3:
                menuBaru = new MenuDessert(menuIdCounter++, nama, harga, tersedia);
                break;
            default:
                menuBaru = new MenuMakanan(menuIdCounter++, nama, harga, tersedia);
        }

        daftarMenu.add(menuBaru);
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

        System.out.println("\n--- UPDATE MENU: " + target.getNamaMenu() + " ---");
        System.out.println("(Tekan Enter untuk melewati)");
        scanner.nextLine();

        System.out.print("Nama Menu baru [" + target.getNamaMenu() + "]: ");
        String nama = scanner.nextLine();
        if (!nama.isEmpty()) target.setNamaMenu(nama);

        System.out.print("Harga baru [" + target.getHarga() + "] (kosongkan=skip): ");
        String hargaStr = scanner.nextLine();
        if (!hargaStr.isEmpty()) target.setHarga(Double.parseDouble(hargaStr));

        System.out.print("Status tersedia [" + (target.isTersedia() ? "Ya" : "Tidak") + "] (1=Ya/0=Tidak/Enter=skip): ");
        String statusStr = scanner.nextLine();
        if (!statusStr.isEmpty()) target.setTersedia(statusStr.equals("1"));

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

        System.out.print("Yakin hapus \"" + target.getNamaMenu() + "\"? (y/n): ");
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
            if (m.getNamaMenu().toLowerCase().contains(keyword)) {
                System.out.printf("| %-4d | %-20s | %-10s | Rp%-12.0f | %-10s |\n",
                        m.getId(), m.getNamaMenu(), m.getKategori(),
                        m.getHarga(), m.isTersedia() ? "Tersedia" : "Habis");
                ketemu = true;
            }
        }
        System.out.println("--------------------------------------------------------------------------");
        if (!ketemu) System.out.println("Menu tidak ditemukan.");
    }

    static Menu cariMenuById(int id) {
        for (Menu m : daftarMenu) {
            if (m.getId() == id) return m;
        }
        return null;
    }

    // ==================== MEJA ====================
    static void menuManajemenMeja() {
        boolean kembali = false;
        while (!kembali) {
            System.out.println("\n      MANAJEMEN MEJA          ");
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
                    m.getNomorMeja(),
                    m.getKapasitas(),
                    m.getLokasi(),
                    m.isTerpesan() ? "Terpesan" : "Tersedia"
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
        int kapasitasBaru = bacaAngka("Kapasitas baru [" + target.getKapasitas() + "] (0=skip): ");
        if (kapasitasBaru > 0) target.setKapasitas(kapasitasBaru);

        System.out.println("Pilih Lokasi baru: 1.Indoor  2.Outdoor  3.VIP  0.Skip");
        int lokPilih = bacaAngka("Pilihan: ");
        if (lokPilih > 0) {
            switch (lokPilih) {
                case 1: target.setLokasi("Indoor"); break;
                case 2: target.setLokasi("Outdoor"); break;
                case 3: target.setLokasi("VIP"); break;
            }
        }

        System.out.print("Status (1=Terpesan / 0=Tersedia): ");
        target.setTerpesan(bacaAngka("") == 1);

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
            if (!m.isTerpesan()) {
                System.out.printf("| %-6d | %-10d | %-10s | %-10s |\n",
                        m.getNomorMeja(), m.getKapasitas(), m.getLokasi(), "Tersedia");
                ada = true;
            }
        }
        System.out.println("------------------------------------------------");
        if (!ada) System.out.println("Tidak ada meja yang tersedia saat ini.");
    }

    static Meja cariMejaByNomor(int nomor) {
        for (Meja m : daftarMeja) {
            if (m.getNomorMeja() == nomor) return m;
        }
        return null;
    }

    // ==================== RESERVASI ====================
    static void menuManajemenReservasi() {
        boolean kembali = false;
        while (!kembali) {
            System.out.println("\n    MANAJEMEN RESERVASI       ");
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
                    r.getIdReservasi(),
                    r.getNamaPelanggan(),
                    r.getNoTelepon(),
                    r.getNomorMeja(),
                    r.getTanggal(),
                    r.getJamReservasi(),
                    r.getJumlahTamu(),
                    r.getStatus()
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
        if (meja.isTerpesan()) {
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
        meja.setTerpesan(true);

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
                case 1: target.setStatus("Menunggu"); break;
                case 2: target.setStatus("Dikonfirmasi"); break;
                case 3:
                    target.setStatus("Selesai");
                    Meja meja = cariMejaByNomor(target.getNomorMeja());
                    if (meja != null) meja.setTerpesan(false);
                    System.out.println("  Meja no." + target.getNomorMeja() + " sudah dibebaskan.");
                    break;
                case 4:
                    target.setStatus("Dibatalkan");
                    Meja mejaBatal = cariMejaByNomor(target.getNomorMeja());
                    if (mejaBatal != null) mejaBatal.setTerpesan(false);
                    System.out.println("  Meja no." + target.getNomorMeja() + " sudah dibebaskan.");
                    break;
            }
        }

        int tamuBaru = bacaAngka("Jumlah tamu baru [" + target.getJumlahTamu() + "] (0=skip): ");
        if (tamuBaru > 0) target.setJumlahTamu(tamuBaru);

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

        System.out.print("Yakin batalkan reservasi \"" + target.getNamaPelanggan() + "\"? (y/n): ");
        scanner.nextLine();
        String konfirmasi = scanner.nextLine();

        if (konfirmasi.equalsIgnoreCase("y")) {
            Meja meja = cariMejaByNomor(target.getNomorMeja());
            if (meja != null) meja.setTerpesan(false);
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
            if (r.getNamaPelanggan().toLowerCase().contains(keyword)) {
                System.out.printf("| %-4d | %-15s | %-13s | %-5d | %-12s | %-6s | %-6d | %-12s |\n",
                        r.getIdReservasi(), r.getNamaPelanggan(), r.getNoTelepon(),
                        r.getNomorMeja(), r.getTanggal(), r.getJamReservasi(),
                        r.getJumlahTamu(), r.getStatus());
                ketemu = true;
            }
        }
        System.out.println("--------------------------------------------------------------------------------------------------");
        if (!ketemu) System.out.println("Reservasi tidak ditemukan.");
    }

    static Reservasi cariReservasiById(int id) {
        for (Reservasi r : daftarReservasi) {
            if (r.getIdReservasi() == id) return r;
        }
        return null;
    }

    // ==================== DATA AWAL ====================
    static void isiDataAwal() {
        daftarMenu.add(new MenuMakanan(menuIdCounter++, "Nasi Goreng Spesial", 35000, true));
        daftarMenu.add(new MenuMakanan(menuIdCounter++, "Mie Ayam Bakso", 28000, true));
        daftarMenu.add(new MenuMakanan(menuIdCounter++, "Soto Ayam", 25000, true));

        daftarMenu.add(new MenuMinuman(menuIdCounter++, "Es Teh Manis", 8000, true));
        daftarMenu.add(new MenuMinuman(menuIdCounter++, "Jus Alpukat", 18000, true));

        daftarMenu.add(new MenuDessert(menuIdCounter++, "Es Krim Coklat", 22000, true));

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

    // ==================== UTILITY ====================
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