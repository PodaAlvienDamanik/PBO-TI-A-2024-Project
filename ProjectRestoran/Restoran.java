package ProjectRestoran;

import java.util.Scanner;

public class Restoran {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Selamat Datang di Restoran Mandalika");
            System.out.println("Silakan Masukkan Pilihan Anda");
            System.out.println("1.Penjual");
            System.out.println("2.Pembeli");
            System.out.println("3.Keluar dari Aplikasi");
            System.out.print("Pilihan Anda: ");
            int pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan){
                case 1:
                    System.out.print("Masukkan Username Anda: ");
                    String inputUsername = input.nextLine();
                    System.out.print("Masukkan Password Anda: ");
                    int inputPassword = input.nextInt();
                    if (cekUserNamePenjual(inputUsername, inputPassword)) {
                        crudPenjual.run(input);
                    }else{
                        System.out.println("Username atau password anda tidak valid!");

                    }
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
    private static boolean cekUserNamePenjual(String username,int password){//07 Oktober 2024/22.53 WIB Malam Membuat fitur password untuk penjual
        if (password == 1234){
            return username.equals("Poda") || username.equals("Arvind") || username.equals("Yesaya");
        }
        return false;
    }
}