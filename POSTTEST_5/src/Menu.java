public abstract class Menu {
    protected int id;
    protected String namaMenu;
    protected double hargaMenu;
    protected boolean tersedia;

    public Menu (int id, String namaMenu, Double hargaMenu, boolean tersedia) {
        this.id = id;
        this.namaMenu = namaMenu;
        this.hargaMenu = hargaMenu;
        this.tersedia = tersedia;
    }

//    Nambah Abstract untuk method "getKategori" sama "getInfoTambahan"
    public abstract String getKategori();
    public abstract String getInfoTambahan();

//    Method untuk override
    public void tampilkanInfo() {
        System.out.printf("| %-4d | %-20s | %-10s | Rp%-12.0f | %-10s |\n",
                id,
                namaMenu,
                getKategori(),
                hargaMenu,
                tersedia ? "Tersedia" : "Habis"
        );
    }
    
//    OVERLOADING
public void updateMenu(String namaBaru, Double hargaBaru) {
        this.namaMenu = namaBaru;
        this.hargaMenu = hargaBaru;
    }

//    Overloading 1 untuk update menu
    public void updateMenu(String namaBaru) {
        this.namaMenu = namaBaru;
    }

//    Overloading 2 untuk update status dari menu baru
    public void updateMenu(double hargaBaru) {
        this.hargaMenu = hargaBaru;
    }

    public int getId() {return id;}
    public String getNamaMenu() {return namaMenu;}
    public double getHarga() {return hargaMenu;}
    public boolean isTersedia() {return tersedia;}

    public void setNamaMenu(String namaMenu) {
        this.namaMenu = namaMenu;
    }

    public void setHarga(double hargaMenu) {
        this.hargaMenu = hargaMenu;
    }

    public void setTersedia(boolean tersedia) {
        this.tersedia = tersedia;
    }
}
