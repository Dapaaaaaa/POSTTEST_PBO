public class Meja {
    private int nomorMeja;
    private int kapasitas;
    private String lokasi;
    private boolean terpesan;

    Meja(int nomorMeja, int kapasitas, String lokasi, boolean terpesan) {
        this.nomorMeja = nomorMeja;
        this.kapasitas = kapasitas;
        this.lokasi = lokasi;
        this.terpesan = terpesan;
    }

//    Metode Getter
    public int getNomorMeja() {return nomorMeja;}
    public int getKapasitas() {return kapasitas;}
    public String getLokasi() {return lokasi;}
    public boolean isTerpesan() {return terpesan;}

//    Metode Setter
    public void setKapasitas(int kapasitas) {this.kapasitas = kapasitas;}
    public void setLokasi(String lokasi) {this.lokasi = lokasi;}
    public void setTerpesan(boolean terpesan) {this.terpesan = terpesan;}
}
