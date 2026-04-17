public class MenuMakanan extends Menu{
    public MenuMakanan(int id, String namaMenu, double hargaMenu, boolean tersedia)
    {
        super(id, namaMenu, hargaMenu, tersedia);
    }

    @Override
    public  String getKategori() {
        return "Makanan";
    }

//    Method baru untuk abstract class
    @Override
    public String getInfoTambahan() {
        return "Jenis: Makanan Utama";
    }

//    Tetap digunakan guna agar output tampilan rapi
    @Override
    public void tampilkanInfo() {
        System.out.printf("| %-4d | %-20s | %-10s | Rp%-12.0f | %-10s |\n",
                getId(),
                getNamaMenu(),
                "[Makanan]",
                getHarga(),
                isTersedia() ? "Tersedia" : "Habis"
        );
    }
}
