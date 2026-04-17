import java.util.ArrayList;

public class ManajemenMenu implements InterfaceManajemen<Menu> {
    private ArrayList<Menu> daftarMenu;

//    Buat pake constructor: buat ambil data dari list biar Main tetap sinkron datanya
    public ManajemenMenu(ArrayList<Menu> daftarMenu) {
        this.daftarMenu = daftarMenu;
    }
//    Implementasi method 1 yaitu tambahData dari Interface
//    untuk menambahkan objek menu (ya makanan dll) ke dalam list
    @Override
    public void tambahData(Menu data) {
        daftarMenu.add(data);
        System.out.println("Menu :" + data.getNamaMenu() + "Berhasil Ditambahkan!");
    }

//    Implementasi method 2 yaitu hapusData dari interface
//    menghapus dengan mencari berdasarkan id
    @Override
    public boolean hapusData(int id) {
        for (Menu m : daftarMenu) {
            if (m.getId() == id) {
                daftarMenu.remove(m);
                System.out.println("Menu ID " + id + " berhasil dihapus!");
                return true;
            }
        }
        System.out.println("Menu dengan ID " + id + " tidak ditemukan!");
        return false;
    }

//    Implementasi method 3 yaitu tampilkanSemua dari interface
//    Menampilkan data
    @Override
    public void tampilkanSemua(ArrayList<Menu> daftarData) {
        System.out.println("\n========== DAFTAR MENU RESTORAN ==========");
        if (daftarData.isEmpty()) {
            System.out.println("Belum ada data menu.");
            return;
        }
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("| ID   | Nama Menu            | Kategori   | Harga          | Status     |");
        System.out.println("--------------------------------------------------------------------------");
        for (Menu m : daftarData) {
            m.tampilkanInfo(); // memanggil method dari abstract class Menu
        }
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("Total: " + daftarData.size() + " menu");
    }

//    Implementasi method 4 yaitu cariData dari interface
//    Mencari menu menggunakan keyword bebas tidak sensitive-case
    @Override
    public void cariData(String keyword) {
        System.out.println("\n--- HASIL PENCARIAN: \"" + keyword + "\" ---");
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("| ID   | Nama Menu            | Kategori   | Harga          | Status     |");
        System.out.println("--------------------------------------------------------------------------");
        boolean ketemu = false;
        for (Menu m : daftarMenu) {
            if (m.getNamaMenu().toLowerCase().contains(keyword.toLowerCase())) {
                m.tampilkanInfo();
                // BARU: Tampilkan juga info tambahan dari abstract method getInfoTambahan()
                System.out.println("         >> " + m.getInfoTambahan());
                ketemu = true;
            }
        }
        System.out.println("--------------------------------------------------------------------------");
        if (!ketemu) System.out.println("Menu tidak ditemukan.");
    }
}