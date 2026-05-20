package Pertemuan13;

public class DLLAntrian02 {
    Pembeli02 head;
    Pembeli02 tail;
    int counterAntrian; //buat menghitung nomor antrian secara otomatis

    DLLAntrian02() {
        head = null;
        tail = null;
        counterAntrian = 0;
    }

    // L4 — Kompleksitas: O(1) — langsung tambah di tail
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

    // L4 — Kompleksitas: O(1) — langsung tambah di tail
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

    // L4 — Kompleksitas: O(n) — harus cari dulu secara linear
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

    // public Pembeli02 hapusAntrianDepan() {
    //     if (head == null)
    //         return null;
    //     Pembeli02 hapus = head;
    //     head = head.next;
    //     if (head != null)
    //         head.prev = null;
    //     else
    //         tail = null;
    //     return hapus;
    // }

    // L4 — Kompleksitas: O(1) — langsung hapus head, tanpa loop
    public Pembeli02 hapusAntrianDepan() {
        // Kasus 1: antrian kosong
        if (head == null) return null;
 
        Pembeli02 hapus = head;
        head = head.next;
 
        // Kasus 2: hanya 1 node
        if (head == tail) {
            head = tail = null;
        } else {
            // Kasus 3: lebih dari 1 node
            head = head.next;
            head.prev = null;
        }
 
        return hapus;
    }

    // L4 — Kompleksitas: O(n) — dalam kasus terburuk cek semua node
    public void cariPembeli(String nama) {
        Pembeli02 curr = head;
        boolean ditemukan = false;
        while (curr != null) {
            if (curr.namaPembeli.equalsIgnoreCase(nama)) {
                if (!ditemukan) {
                    System.out.println("[Sequential Search] Pembeli ditemukan:");
                    ditemukan = true;
                }
                System.out.printf("No Antrian: %d | Nama: %s | No HP: %s%n",
                        curr.noAntrian, curr.namaPembeli, curr.noHp);
            }
            curr = curr.next;
        }
        if (!ditemukan) System.out.println("Pembeli tidak ditemukan.");
    }

    // Kompleksitas: O(n^2) — dua loop bersarang (outer + inner geser)
    public void sortAntrian() {
        if (head == null || head.next == null) return;
 
        Pembeli02 curr = head.next;
        while (curr != null) {
            // Simpan data "key" dari posisi curr
            int keyNoAntrian = curr.noAntrian;
            String keyNama   = curr.namaPembeli;
            String keyNoHp   = curr.noHp;
 
            // runner bergerak mundur (ke kiri / prev) selama nama > key
            Pembeli02 runner = curr.prev;
            while (runner != null
                    && runner.namaPembeli.compareToIgnoreCase(keyNama) > 0) {
                // Geser data runner ke posisi runner.next
                runner.next.noAntrian  = runner.noAntrian;
                runner.next.namaPembeli = runner.namaPembeli;
                runner.next.noHp       = runner.noHp;
                runner = runner.prev;
            }
            // Letakkan key di posisi yang tepat
            Pembeli02 tempat = (runner == null) ? head : runner.next;
            tempat.noAntrian  = keyNoAntrian;
            tempat.namaPembeli = keyNama;
            tempat.noHp       = keyNoHp;
 
            curr = curr.next;
        }
        System.out.println("Antrian berhasil diurutkan berdasarkan nama (ascending).");
    }

}
