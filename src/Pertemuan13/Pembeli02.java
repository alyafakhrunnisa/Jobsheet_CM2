package Pertemuan13;

public class Pembeli02 {
    int noAntrian;
    String namaPembeli;
    String noHp;
    Pembeli02 prev;
    Pembeli02 next;
 
    Pembeli02(int noAntrian, String b, String c) {
        this.noAntrian = noAntrian;
        this.namaPembeli = b;
        this.noHp = c;
        this.prev = null;
        this.next = null;
    }  
}
