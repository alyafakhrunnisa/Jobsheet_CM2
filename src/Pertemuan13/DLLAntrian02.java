package Pertemuan13;

public class DLLAntrian02 {
    Pembeli02 head;
    Pembeli02 tail;
    int counterAntrian;

    DLLAntrian02() {
        head = null;
        tail = null;
        counterAntrian = 0;
    }

    void tambahAntrianAwal(String nama, String noHp) {
        counterAntrian++;
        Pembeli02 baru = new Pembeli02(counterAntrian, nama, noHp);
        if (head == null) {
            head = tail = baru;
        } else {
            baru.prev = tail;
            tail.next = baru;
            tail = baru;
        }
    }

    void tambahAntrian(String nama, String noHp) {
        counterAntrian++;
        Pembeli02 baru = new Pembeli02(counterAntrian, nama, noHp);
        if (head == null) {
            head = tail = baru;
        } else {
            baru.prev = tail;
            tail.next = baru;
            tail = baru;
        }
        System.out.println("Antrian berhasil ditambahkan dengan nomor: " + counterAntrian);
    }

    void cetakAntrian() {
        if (head == null) {
            System.out.println("Antrian kosong.");
            return;
        }
        System.out.println("==============================");
        System.out.println("Daftar Antrian Pembeli");
        System.out.println("==============================");
        System.out.printf("%-15s %-20s %-15s%n", "No Antrian", "Nama", "No HP");
        Pembeli02 curr = head;
        while (curr != null) {
            System.out.printf("%-15d %-20s %-15s%n", curr.noAntrian, curr.namaPembeli, curr.noHp);
            curr = curr.next;
        }
    }

    public Pembeli02 hapusAntrian(int noAntrian) {
        Pembeli02 curr = head;
        while (curr != null) {
            if (curr.noAntrian == noAntrian) {

                if (curr.prev != null)
                    curr.prev.next = curr.next;
                else
                    head = curr.next; // curr adalah head
                if (curr.next != null)
                    curr.next.prev = curr.prev;
                else
                    tail = curr.prev; // curr adalah tail
                return curr;
            }
            curr = curr.next;
        }
        return null;
    }

    boolean isEmpty() {
        return head == null;
    }

    public Pembeli02 hapusAntrianDepan() {
        if (head == null)
            return null;
        Pembeli02 hapus = head;
        head = head.next;
        if (head != null)
            head.prev = null;
        else
            tail = null;
        return hapus;
    }
}
