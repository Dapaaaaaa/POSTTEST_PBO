public class MenuMinuman extends Menu{
    public MenuMinuman(int id, String namaMenu, double hargaMenu, boolean tersedia)
    {
        super(id, namaMenu, hargaMenu, tersedia);
    }

    @Override
    public  String getKategori() {
        return "Minuman";
    }

    @Override
    public void tampilkanInfo() {
        System.out.printf("| %-4d | %-20s | %-10s | Rp%-12.0f | %-10s |\n",
                getId(),
                getNamaMenu(),
                "[Minuman]",
                getHarga(),
                isTersedia() ? "Tersedia" : "Habis"
        );
    }
}
