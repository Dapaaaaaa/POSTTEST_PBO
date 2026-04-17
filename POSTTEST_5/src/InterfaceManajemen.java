import java.util.ArrayList;

public interface InterfaceManajemen<T> {
//    Method 1: tambahData untuk menambah objek kedalam list kita
    void tambahData(T data);

//    Method 2: hapusData untuk menghapus objek dari list kita
    boolean hapusData(int id);

//    Method 3: tampilkanSemua untuk menampilkan semua data dari list kita
    void tampilkanSemua(ArrayList<T> daftarData);

//    Method 4: cariData untuk mencari objek dari list kita
    void cariData(String keyword);
}
