package ProjectRestoran;

import java.util.ArrayList;
import java.util.Scanner;

class PesananOnline {
    private String namaPembeli;
    private String item;                //dibuat tanggal 09/10/2024 jam 23.00
    private String status;
    private int kuantitas;

    public PesananOnline(String namaPembeli, String item,int kuantitas, String status) {
        this.namaPembeli = namaPembeli;
        this.item = item;               //dibuat tanggal 09/10/2024 jam 23.00
        this.kuantitas = kuantitas;
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

    public int getKuantitas() {
        return kuantitas;
    }

    public void setKuantitas(int kuantitas) {
        this.kuantitas = kuantitas;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Pesanan{" + "Nama Pembeli='" + namaPembeli + '\'' + ", Item='" + item + '\'' + ", Kuantitas='" + kuantitas + '\'' + ", Status='" + status + '\'' + '}';
    }
}

public class crudPenjual {
    private static final ArrayList<PesananOnline> pesananList = new ArrayList<>();

    public static void buatPesanan(String namaPembeli, String item,int kuantitas) {
        PesananOnline pesananBaru = new PesananOnline(namaPembeli, item,kuantitas, "Sedang Diproses");//dibuat tanggal 09/10/2024 jam 23.00
        pesananList.add(pesananBaru);
        System.out.println("Pesanan berhasil dibuat untuk " + namaPembeli);
        System.out.println();
    }




    public static void run(Scanner scanner) {
        int pilihan;

        do {
            System.out.println("\n== Manajemen Pesanan Restoran ==");
            System.out.println("1. Buat Pesanan");
            System.out.println("2. Lihat Semua Pesanan");
            System.out.println("3. Update Status Pesanan");
            System.out.println("4. Hapus Pesanan");
            System.out.println("5. Keluar");
            System.out.print("Masukkan pilihan: ");
            pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    boolean adaPesananLain = true;
                    while (adaPesananLain) {
                        System.out.print("Masukkan nama pembeli: ");
                        String namaPembeli = scanner.nextLine();
                        System.out.print("Masukkan item pesanan: ");//dibuat tanggal 09/10/2024 jam 23.00
                        String item = scanner.nextLine();
                        System.out.print("Berapa Banyak: ");
                        int kuantitasItem = scanner.nextInt();
                        scanner.nextLine();
                        buatPesanan(namaPembeli, item,kuantitasItem);

                        System.out.print("Apakah ada pesanan lain? (y/n): ");
                        String jawab = scanner.nextLine();
                        adaPesananLain = jawab.equalsIgnoreCase("y");
                    }
                    break;

                case 2:
                    // Read
                    break;

                case 3:
                    //Update
                    break;

                case 4:
                    // Delete
                    break;

                case 5:
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
        } while (pilihan != 5);
    }
}
