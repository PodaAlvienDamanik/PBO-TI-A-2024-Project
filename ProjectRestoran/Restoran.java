package ProjectRestoran;

import java.util.Scanner;

public class Restoran {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Selamat Datang di Restoran Asian FI");
            System.out.println("Silakan Masukkan Pilihan Anda");
            System.out.println("1.Penjual");
            System.out.println("2.Pembeli");
            System.out.println("3.Keluar dari Aplikasi");
            System.out.print("Pilihan Anda: ");
            int pilihan = input.nextInt();

            switch (pilihan){
                case 1:
                    crudPenjual.run(input);
                    break;

                case 2:
                    crudPembeli.run(input);
                    break;

                case 3:
                    System.out.println("Thanks to join us in this trip");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Masukkan Angka yang betol!");
                    break;

            }
        }
    }
}
