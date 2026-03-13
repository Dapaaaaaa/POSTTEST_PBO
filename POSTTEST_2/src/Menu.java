public class Menu {
    private int id;
    private String namaMenu;
    private String kategori;
    private double harga;
    private boolean tersedia;

    Menu(int id, String namaMenu, String kategori, double harga, boolean tersedia) {
        this.id = id;
        this.namaMenu = namaMenu;
        this.kategori = kategori;
        this.harga = harga;
        this.tersedia = tersedia;
    }

//    Metode Getter
    public int getId() {return id;}
    public String getNamaMenu() { return namaMenu; }
    public String getKategori() { return kategori; }
    public double getHarga() { return harga; }
    public boolean isTersedia() { return tersedia; }

//    Metode Setter
    public void setNamaMenu(String namaMenu) { this.namaMenu = namaMenu; }
    public void setKategori(String kategori) { this.kategori = kategori; }
    public void setHarga(double harga) { this.harga = harga; }
    public void setTersedia(boolean tersedia) { this.tersedia = tersedia; }
}
