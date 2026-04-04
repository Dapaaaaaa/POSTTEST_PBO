public class MenuMinuman extends Menu{
    public MenuMinuman(int id, String namaMenu, double hargaMenu, boolean tersedia)
    {
        super(id, namaMenu, hargaMenu, tersedia);
    }

    @Override
    public  String getKategori() {
        return "Minuman";
    }
}
