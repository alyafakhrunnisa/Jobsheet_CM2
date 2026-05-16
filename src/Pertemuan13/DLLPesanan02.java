package Pertemuan13;

public class DLLPesanan02 {
    Pesanan02 head;
    Pesanan02 tail;
    int totalPendapatan;

    DLLPesanan02() {
        head = null;
        tail = null;
        totalPendapatan = 0;
    }

    void tambahPesanan(int kode, String nama, int harga) {
        Pesanan02 baru = new Pesanan02(kode, nama, harga);
        if (head == null) {
            head = tail = baru;
        } else {
            baru.prev = tail;
            tail.next = baru;
            tail = baru;
        }
        totalPendapatan += harga;
    }

    // Bubble Sort berdasarkan nama pesanan (ascending)
    void sortByNama() {
        if (head == null || head.next == null)
            return;
        boolean swapped;
        do {
            swapped = false;
            Pesanan02 curr = head;
            while (curr.next != null) {
                if (curr.namaPesanan.compareToIgnoreCase(curr.next.namaPesanan) > 0) {
                    // Tukar data (bukan node)
                    int tmpKode = curr.kodePesanan;
                    String tmpNama = curr.namaPesanan;
                    int tmpHarga = curr.harga;

                    curr.kodePesanan = curr.next.kodePesanan;
                    curr.namaPesanan = curr.next.namaPesanan;
                    curr.harga = curr.next.harga;

                    curr.next.kodePesanan = tmpKode;
                    curr.next.namaPesanan = tmpNama;
                    curr.next.harga = tmpHarga;

                    swapped = true;
                }
                curr = curr.next;
            }
        } while (swapped);
    }

    void laporanPesanan() {
        if (head == null) {
            System.out.println("Belum ada pesanan.");
            return;
        }
        sortByNama();
        System.out.println("======================================");
        System.out.println("LAPORAN PESANAN (URUT NAMA PESANAN)");
        System.out.println("======================================");
        System.out.printf("%-15s %-20s %-10s%n", "Kode Pesanan", "Nama Pesanan", "Harga");
        Pesanan02 curr = head;
        while (curr != null) {
            System.out.printf("%-15d %-20s %-10d%n", curr.kodePesanan, curr.namaPesanan, curr.harga);
            curr = curr.next;
        }
        System.out.println("--------------------------------------");
        System.out.println("Total Pendapatan : Rp " + totalPendapatan);
    }
}
