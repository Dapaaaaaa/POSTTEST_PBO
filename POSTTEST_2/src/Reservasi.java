public class Reservasi {
    private int idReservasi;
    private String namaPelanggan;
    private String noTelepon;
    private int nomorMeja;
    private String tanggal;
    private String jamReservasi;
    private int jumlahTamu;
    private String status;

    public Reservasi(int idReservasi, String namaPelanggan, String noTelepon,
                     int nomorMeja, String tanggal, String jamReservasi,
                     int jumlahTamu, String status) {
        this.idReservasi = idReservasi;
        this.namaPelanggan = namaPelanggan;
        this.noTelepon = noTelepon;
        this.nomorMeja = nomorMeja;
        this.tanggal = tanggal;
        this.jamReservasi = jamReservasi;
        this.jumlahTamu = jumlahTamu;
        this.status = status;
    }

//    Metode Getter
    public int getIdReservasi() { return idReservasi; }
    public String getNamaPelanggan() { return namaPelanggan; }
    public String getNoTelepon() { return noTelepon; }
    public int getNomorMeja() { return nomorMeja; }
    public String getTanggal() { return tanggal; }
    public String getJamReservasi() { return jamReservasi; }
    public int getJumlahTamu() { return jumlahTamu; }
    public String getStatus() { return status; }

//    Metode Setter
    public void setStatus(String status) { this.status = status; }
    public void setJumlahTamu(int jumlahTamu) { this.jumlahTamu = jumlahTamu; }
}
