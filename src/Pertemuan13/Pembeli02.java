package Pertemuan13;

public class Pembeli02 {
    int noAntrian;
    String namaPembeli;
    String noHp;
    Pembeli02 prev;
    Pembeli02 next;
 
    public Pembeli02(int noAntrian, String namaPembeli, String noHp) {
        this.noAntrian = noAntrian;
        this.namaPembeli = namaPembeli;
        this.noHp = noHp;
        this.prev = null;
        this.next = null;
    }
}
