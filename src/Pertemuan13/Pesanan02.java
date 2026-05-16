package Pertemuan13;

public class Pesanan02 {
    int kodePesanan;
    String namaPesanan;
    int harga;
    Pesanan02 prev;
    Pesanan02 next;

    public Pesanan02(int kodePesanan, String namaPesanan, int harga) {
        this.kodePesanan = kodePesanan;
        this.namaPesanan = namaPesanan;
        this.harga = harga;
        this.prev = null;
        this.next = null;
    }
}
