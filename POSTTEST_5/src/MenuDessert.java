public class MenuDessert extends Menu{
    public MenuDessert(int id, String namaMenu, double hargaMenu, boolean tersedia)
    {
        super(id, namaMenu, hargaMenu, tersedia);
    }

    @Override
    public  String getKategori() {
        return "Dessert";
    }

    //    Method baru untuk abstract class
    @Override
    public String getInfoTambahan() {
        return "Jenis: Dessert";
    }

    @Override
    public void tampilkanInfo() {
        System.out.printf("| %-4d | %-20s | %-10s | Rp%-12.0f | %-10s |\n",
                getId(),
                getNamaMenu(),
                "[Dessert]",
                getHarga(),
                isTersedia() ? "Tersedia" : "Habis"
        );
    }
}
