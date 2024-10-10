package ProjectRestoran;

import java.util.ArrayList;
import java.util.Scanner;


class Pesanan {
    private String namaPembeli;
    private String item;
    private int kuantitas;
    private String status;


    public Pesanan(String namaPembeli, String item,int kuantitas, String status) {
        this.namaPembeli = namaPembeli;
        this.item = item;
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

    public int getKuantitas(){
        return kuantitas;
    }
    public void setKuantitas(int kuantitas){
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


public class crudPembeli {
    public static ArrayList<Pesanan> pesananList = new ArrayList<>();

    public static void DaftarMenu(){    //dibuat oleh Poda tanggal 10/10/2024 jam 11.14
        System.out.println("Daftar Menu Restoran Mandalika");
        System.out.println("Daftar Makanan==================");
        System.out.println("1.Nasi                  Rp.5000");
        System.out.println("2.Ayam Panggang         Rp.10.000");
        System.out.println("3.Ayam Goreng           Rp.8.000");
        System.out.println("4.Gulai Tunjang         Rp.15.000");
        System.out.println("5.Telor Balado          Rp.10.000");
        System.out.println("Daftar Minuman==================");
        System.out.println("1.Air Putih             Rp.3000");
        System.out.println("2.Teh Manis Dingin      Rp.5000");
        System.out.println("3.Es Jeruk              Rp.6000");
        System.out.println("4.Aneka Jus             Rp.12.000");
        System.out.println("5.Es krim               Rp.5000");
    }

    public static void buatPesanan(String namaPembeli, String item, int kuantitas) {
        Pesanan pesananBaru = new Pesanan(namaPembeli, item, kuantitas, "Sedang Diproses");
        pesananList.add(pesananBaru);
        System.out.println("Pesanan berhasil dibuat untuk " + namaPembeli);
    }

    public static void inputPesananPembeli(Scanner scanner) { //dibuat oleh Yesaya tanggal 10/10/2024 jam 10.14
        boolean adaPesananLain = true;
        while (adaPesananLain) {
            DaftarMenu();
            System.out.print("Masukkan nama pembeli: ");
            String namaPembeli = scanner.nextLine();
            System.out.print("Masukkan item pesanan: ");
            String item = scanner.nextLine();
            System.out.print("Berapa Banyak: ");
            int kuantitasItem = scanner.nextInt();
            scanner.nextLine();
            buatPesanan(namaPembeli, item, kuantitasItem);

            System.out.print("Apakah ada pesanan lain? (y/n): ");
            String jawab = scanner.nextLine();
            adaPesananLain = jawab.equalsIgnoreCase("y");
        }
    }

    public static void bacaPesanan() { //dibuat tanggal 10/10/2024 jam 09.05
        if (pesananList.isEmpty()) {
            System.out.println("Tidak ada pesanan untuk ditampilkan.");
            return;
        }

        int counter = 1;
        for (Pesanan data : pesananList) {
            System.out.println(counter + ". " + data.getNamaPembeli() + "\t" + data.getItem() + "\t" + data.getKuantitas() + "\t" + data.getStatus());
            counter++;
        }
    }

    public static void updatePesanan(Scanner scanner) { // dibuat oleh Yesaya tanggal 10/10/2024 jam 10.52
        bacaPesanan();
        System.out.print("Masukkan nomor pesanan yang ingin diperbarui: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();

        DaftarMenu();
        if (index >= 0 && index < pesananList.size()) {
            Pesanan pesanan = pesananList.get(index);

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
            System.out.println("Pesanan berhasil diperbarui.");
        } else {
            System.out.println("Pesanan tidak ditemukan.");
        }
    }

    public static void hapusPesanan(int index) {
        if (index >= 0 && index < pesananList.size()) {
            pesananList.remove(index);
            System.out.println("Pesanan berhasil dihapus.");
        } else {
            System.out.println("Pesanan tidak ditemukan.");
        }
    }


        public static void run(Scanner scanner){
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
                        inputPesananPembeli(scanner);
                        break;

                    case 2:
                        bacaPesanan();//dibuat tanggal 10/10/2024 jam 09.05
                        break;

                    case 3:
                        updatePesanan(scanner);
                        break;

                    case 4:
                        System.out.print("Masukkan nomor pesanan yang ingin dihapus: "); //dibuat tanggal 10/10/2024 Yesaya Sitompul jam 09:22
                        int nomorHapus = scanner.nextInt() - 1;
                        hapusPesanan(nomorHapus);
                        break;

                    case 5:
                        System.out.println("Terima kasih Telah Menggunakan Aplikasi ini!");//dibuat tanggal 10/10/2024 jam 09.05
                        break;

                    default:
                        System.out.println("Pilihan tidak valid.");
                        break;
                }
            } while (pilihan != 5);

        }
    }
