public class Menu {
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

    public String getKategori() {
        return "Umum";
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
