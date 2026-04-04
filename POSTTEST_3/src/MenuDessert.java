public class MenuDessert extends Menu{
    public MenuDessert(int id, String namaMenu, double hargaMenu, boolean tersedia)
    {
        super(id, namaMenu, hargaMenu, tersedia);
    }

    @Override
    public  String getKategori() {
        return "Dessert";
    }
}
