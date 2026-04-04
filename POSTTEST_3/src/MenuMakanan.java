public class MenuMakanan extends Menu{
    public MenuMakanan(int id, String namaMenu, double hargaMenu, boolean tersedia)
    {
        super(id, namaMenu, hargaMenu, tersedia);
    }

    @Override
    public  String getKategori() {
        return "Makanan";
    }
}
