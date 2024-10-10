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

    private static void inputPesanan(Scanner scanner) { //dibuat oleh Poda tanggal 10/10/2024 jam 09.36
        boolean adaPesananLain = true;
        while (adaPesananLain) {
            System.out.print("Masukkan nama pembeli: ");
            String namaPembeli = scanner.nextLine();
            System.out.print("Masukkan item pesanan: ");
            String item = scanner.nextLine();
            System.out.print("Berapa Banyak: ");
            int kuantitasItem = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            buatPesanan(namaPembeli, item, kuantitasItem);

            System.out.print("Apakah ada pesanan lain? (y/n): ");
            String jawab = scanner.nextLine();
            adaPesananLain = jawab.equalsIgnoreCase("y");
        }
    }

    public static void bacaPesanan() {//dibuat oleh Arvind tanggal 10/10/2024 jam 09.42
        if (pesananList.isEmpty()) {
            System.out.println("Tidak ada pesanan untuk ditampilkan.");
            return;
        }
        int counter = 1;
        for (PesananOnline data : pesananList) {
            System.out.println(counter + ". " + data.getNamaPembeli() + "\t" + data.getItem() + "\t" + data.getKuantitas() + "\t" + data.getStatus());
            counter++;
        }
    }

    public static void updatePesanan(Scanner scanner) { // dibuat oleh Poda tanggal 10/10/2024 jam 10.41
        bacaPesanan();
        System.out.print("Masukkan nomor pesanan yang ingin diperbarui: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();

        if (index >= 0 && index < pesananList.size()) {
            PesananOnline pesanan = pesananList.get(index);

            System.out.println("Pesanan Saat Ini: " + pesanan);

            System.out.print("Ingin mengubah nama pembeli? (y/n): ");
            if (scanner.nextLine().equalsIgnoreCase("y")) {
                System.out.print("Masukkan nama baru: ");
                pesanan.setNamaPembeli(scanner.nextLine());
            }

            System.out.print("Ingin mengubah item? (y/n): ");
            if (scanner.nextLine().equalsIgnoreCase("y")) {
                System.out.print("Masukkan item baru: ");
                pesanan.setItem(scanner.nextLine());
            }

            System.out.print("Ingin mengubah kuantitas? (y/n): ");
            if (scanner.nextLine().equalsIgnoreCase("y")) {
                System.out.print("Masukkan kuantitas baru: ");
                pesanan.setKuantitas(scanner.nextInt());
                scanner.nextLine();
            }

            System.out.print("Ingin mengubah status? (y/n): ");
            if (scanner.nextLine().equalsIgnoreCase("y")) {
                System.out.print("Masukkan status baru: ");
                pesanan.setStatus(scanner.nextLine());
            }

            System.out.println("Pesanan berhasil diperbarui.");
        } else {
            System.out.println("Pesanan tidak ditemukan.");
        }
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
                    inputPesanan(scanner);//dibuat oleh Poda tanggal 10/10/2024 jam 09.36
                    break;

                case 2:
                    // Read
                    bacaPesanan();
                    break;

                case 3:
                    updatePesanan(scanner);
                    break;

                case 4:

                    break;

                case 5:
                    System.out.println("Kamu Sukses Keluar,Silakan Kembali lagi!");//dibuat oleh Arvind tanggal 10/10/2024 jam 09.54
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
        } while (pilihan != 5);
    }
}
