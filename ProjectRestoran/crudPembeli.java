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

    public static void buatPesanan(String namaPembeli, String item,int kuantitas) {
        Pesanan pesananBaru = new Pesanan(namaPembeli, item,kuantitas ,"Sedang Diproses");
        pesananList.add(pesananBaru);
        System.out.println("Pesanan berhasil dibuat untuk " + namaPembeli);
    }


    public static void bacaPesanan() { //dibuat tanggal 10/10/2024 jam 09.05
        if (pesananList.isEmpty()) {
            System.out.println("Tidak ada pesanan untuk ditampilkan.");
            return;
        }

        int counter = 1;
        for (Pesanan data : pesananList) {
            System.out.println(counter + ". " + data.getNamaPembeli() + "\t" + data.getItem() + "\t" + data.getKuantitas()+ "\t" + data.getStatus());
            counter++;
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

                    break;

                case 2:
                    bacaPesanan();//dibuat tanggal 10/10/2024 jam 09.05
                    break;

                case 3:
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
