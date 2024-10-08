package ProjectRestoran;

import java.util.ArrayList;
import java.util.Scanner;


class Pesanan {
    private String namaPembeli;
    private String item;
    private String status;


    public Pesanan(String namaPembeli, String item, String status) {
        this.namaPembeli = namaPembeli;
        this.item = item;
        this.status = status;
    }

    public String getNamaPembeli() {
        return namaPembeli;
    }

    public void setNamaPembeli(String namaPembeli) {

        this.namaPembeli = namaPembeli;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Pesanan{" +
                "Nama Pembeli='" + namaPembeli + '\'' +
                ", Item='" + item + '\'' +
                ", Status='" + status + '\'' +
                '}';
    }
}


public class crudPembeli {
    public static ArrayList<Pesanan> pesananList = new ArrayList<>();

    public static void buatPesanan(String namaPembeli, String item) {
        Pesanan pesananBaru = new Pesanan(namaPembeli, item, "Sedang Diproses");
        pesananList.add(pesananBaru);
        System.out.println("Pesanan berhasil dibuat untuk " + namaPembeli);
    }

    public static void hapusPesanan(int index) {
        if (index >= 0 && index < pesananList.size()) {
            pesananList.remove(index);
            System.out.println("Pesanan berhasil dihapus.");
        } else {
            System.out.println("Pesanan tidak ditemukan.");
        }
    }


    public static void bacaPesanan(ArrayList<Pesanan> dataPesanan) {
        int counter = 1;
        for(Pesanan data: dataPesanan) {
            System.out.println(counter+".\t"+data.getNamaPembeli() +"\t" + data.getItem() + "\t" + data.getStatus());
            counter++;
        }

    }

    public static void run(Scanner scanner) {
        int pilihan;

        do {
            System.out.println("\n== Manajemen Pesanan Restoran ==");
            System.out.println("1. Buat Pesanan");
            System.out.println("2. Lihat Semua Pesanan");
            System.out.println("3. Update Pesanan");
            System.out.println("4. Hapus Pesanan");
            System.out.println("5. Keluar");
            System.out.print("Masukkan pilihan: ");
            pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan nama pembeli: ");
                    String namaPembeli = scanner.nextLine();
                    System.out.print("Masukkan item pesanan: ");
                    String item = scanner.nextLine();
                    buatPesanan(namaPembeli, item);
                    break;

                case 2:
                    break;

                case 3:
                    break;

                case 4:
                    System.out.print("Masukkan nomor pesanan yang ingin dihapus: ");
                    int nomorHapus = scanner.nextInt() - 1;
                    hapusPesanan(nomorHapus);
                    break;

                case 5:
                    System.out.println("Terima kasih!");
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
        } while (pilihan != 5);

    }
}
