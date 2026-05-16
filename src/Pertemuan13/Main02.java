package Pertemuan13;

import java.util.Scanner;

public class Main02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DLLAntrian02 antrian = new DLLAntrian02();
        DLLPesanan02 pesanan = new DLLPesanan02();

        // menggunakan tambahAntrianAwal agar tidak muncul pesan saat program start
        antrian.tambahAntrianAwal("Ainra", "08224500000");
        antrian.tambahAntrianAwal("Danra", "08224511111");
        antrian.tambahAntrianAwal("Sanri", "08224522222");

        int pilihan;
        do {
            System.out.println("\n==============================");
            System.out.println("SISTEM ANTRIAN ROYAL DELISH");
            System.out.println("==============================");
            System.out.println("1. Tambah Antrian");
            System.out.println("2. Cetak Antrian");
            System.out.println("3. Hapus Antrian dan Pesan");
            System.out.println("4. Laporan Pesanan");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu : ");
            pilihan = Integer.parseInt(sc.nextLine().trim());

            switch (pilihan) {
                case 1:
                    System.out.print("Nama Pembeli : ");
                    String nama = sc.nextLine();
                    System.out.print("No HP        : ");
                    String hp = sc.nextLine();
                    antrian.tambahAntrian(nama, hp);
                    break;

                case 2:
                    antrian.cetakAntrian();
                    break;

                case 3:
                    if (antrian.isEmpty()) {
                        System.out.println("Antrian kosong, tidak ada yang bisa dihapus.");
                        break;
                    }
                    System.out.print("Kode Pesanan  : ");
                    int kode = Integer.parseInt(sc.nextLine().trim());
                    System.out.print("Nama Pesanan  : ");
                    String namaPesan = sc.nextLine();
                    System.out.print("Harga         : ");
                    int harga = Integer.parseInt(sc.nextLine().trim());

                    Pembeli02 pembeli = antrian.hapusAntrianDepan();
                    pesanan.tambahPesanan(kode, namaPesan, harga);
                    System.out.println(pembeli.namaPembeli + " telah memesan " + namaPesan);
                    break;

                case 4:
                    pesanan.laporanPesanan();
                    break;

                case 0:
                    System.out.println("Terima kasih. Program selesai.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 0);
        
        sc.close();
    }
}