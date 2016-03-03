/*
author : 
Elke Cahya Putri
Fikri Arroisi
Ferdi Cezano Santosa
Miftah Dhiaulhaq
*/
package Pingdol;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Pingdol {

    static Scanner input = new Scanner(System.in);
    static char[][] isi;
    static int ukuran; //ukuran panjang dan lebar papan
    static int cek; //cek kemenangan digunakan sebagai parameter pengecekan kemenangan
    static int kemenangan; //parameter kemenangan
    static String player, nama1, nama2;
    static int poin1, poin2, kalah1, kalah2, seri, permainan; //untuk statistik
    
    //membersihkan tampilan
    static void clean() {
        for (int i = 0; i <= 100; i++) {
            System.out.println("");
        }
    }
    
    //pembuat
    static void credit() {
        clean();
        System.out.println("=====================Credit=======================");
        System.out.println("-Elke Cahya Putri");
        System.out.println("-Fikri Arroisi");
        System.out.println("-Ferdi Cezano Santosa ");
        System.out.println("-Miftah Dhiaulhaq");
        System.out.println("==================================================");
        System.out.print("Kembali ke Menu(Y/N)? ");
        char pilul = input.next().charAt(0);
        if (pilul == 'y' || pilul == 'Y') {
            clean();
            menu();
        } else {
            System.out.println("==================================================");
            System.out.println("\t\tKeluar dari permainan");
            System.out.println("==================================================");
            System.exit(0);
        }
    }
    
    //untuk menampilkan cara bermain
    static void caramain() {
        clean();
        System.out.println("====================Cara Bermain===================");
        System.out.println("-Masukkan Nama player 1 dan Player 2 terlebih dahulu");
        System.out.println("-Kemudian masukkan panjang dan lebar papan permainan");
        System.out.println("-Player 1 akan memegang nilai X");
        System.out.println("-Player 2 akan memegang nilai O");
        System.out.println("-Permainan dijalankan secara bergantian antara Player 1 dan Player 2");
        System.out.println("-Setiap player masukkan nomor baris terlebih dahulu, kemudian tekan ENTER");
        System.out.println("-Kemudian masukkan nomor kolom, lalu tekan ENTER");
        System.out.println("-kemudian bergantian ke pmain selanjutnya");
        System.out.println("==================================================");
        System.out.print("Kembali ke Menu(Y/N)? ");
        char pilul = input.next().charAt(0);
        if (pilul == 'y' || pilul == 'Y') {
            clean();
            menu();
        } else {
            System.out.println("==================================================");
            System.out.println("\t\tKeluar dari permainan");
            System.out.println("==================================================");
            System.exit(0);
        }
    }
    
    //untuk menampilkan statistik
    static void statistik() {
        clean();
        if (nama1 == null || nama2 == null) {
            System.out.println("==================== Statistik =======================");
            System.out.println("Belum ada Permainan, Mulai Permainan Baru");
            System.out.println("======================================================");
        } else {
            System.out.println("==================== Statistik =======================");
            System.out.println("Banyak permainan yang dilakukan\t:" + permainan);
            System.out.println(nama1 + " mendapatkan poin\t\t:" + poin1);
            System.out.println(nama1 + " kalah sebanyak\t\t:" + kalah1);
            System.out.println(nama2 + " mendapatkan poin\t\t:" + poin2);
            System.out.println(nama2 + " kalah sebanyak\t\t:" + kalah2);
            System.out.println("Seri\t\t\t\t:" + seri);
            if (poin1 > poin2) {
                System.out.println("Pemenang\t\t\t:" + nama1);
            } else if (poin2 > poin1) {
                System.out.println("Pemenang\t\t\t:" + nama2);
            } else {
                System.out.println("Pemenang\t\t\t:tidak ada pemenang");
            }
            System.out.println("======================================================");
        }
        System.out.print("Kembali ke Menu(Y/N)? ");
        char pilul = input.next().charAt(0);
        if (pilul == 'y' || pilul == 'Y') {
            clean();
            menu();
        } else {
            System.out.println("==================================================");
            System.out.println("\t\tKeluar dari permainan");
            System.out.println("==================================================");
            System.exit(0);
        }
    }
    
    //untuk menampilkan menu
    static void menu() {
        System.out.println("===================== Menu =======================");
        System.out.println("1. Credit");
        System.out.println("2. Cara Bermain");
        System.out.println("3. Mulai Permainan Baru");
        System.out.println("4. Statistik");
        System.out.println("5. Exit");
        System.out.println("==================================================");
        int ulangi;
        do {
            try {
                ulangi = 0;
                System.out.print("Masukkan nomor pilihan anda\t:");
                int pilihan = input.nextInt();

                switch (pilihan) {
                    case 1:
                        credit();
                        break;
                    case 2:
                        caramain();
                        break;
                    case 3:
                        startpermainan();
                        break;
                    case 4:
                        statistik();
                        break;
                    case 5:
                        System.out.println("==================================================");
                        System.out.println("\t\tKeluar dari permainan");
                        System.out.println("==================================================");
                        System.exit(0);
                    default:
                        System.out.println("========================ERROR=====================");
                        System.out.println("Masukan angka 1-5");
                        System.out.println("ULANGI!");
                        System.out.println("==================================================");
                        ulangi = 1;
                }
            } catch (InputMismatchException e) {
                System.out.println("========================ERROR=====================");
                System.out.println("Masukan harus berupa ANGKA");
                System.out.println("ULANGI!");
                System.out.println("==================================================");
                ulangi = 1;
                input.next();
            }
        } while (ulangi == 1);
    }
    
    //mengosongkan papan bermain
    static void pengosonganPapan() {
        for (int a = 0; a < ukuran; a++) {
            for (int b = 0; b < ukuran; b++) {
                isi[a][b] = ' ';
            }
        }
    }
    
    //pembuatan papan bermain
    static void papan() {
        System.out.println("");
        for (int a = 0; a < ukuran; a++) {
            System.out.print("      " + (a + 1) + "     ");
        }
        System.out.println("");
        for (int a = 0; a < ukuran; a++) {
            for (int b = 0; b < ukuran; b++) {
                System.out.print("------------");
            }
            System.out.println("");
            for (int b = 0; b < ukuran; b++) {
                System.out.print(" |         |");
            }
            System.out.println("");
            for (int b = 0; b < ukuran; b++) {
                if (b == 0) {
                    System.out.print((a + 1) + "|    " + isi[a][b] + "    |");
                } else {
                    System.out.print(" " + "|    " + isi[a][b] + "    |");
                }
            }
            System.out.println("");
            for (int b = 0; b < ukuran; b++) {
                System.out.print(" |         |");
            }
            System.out.println("");
            for (int b = 0; b < ukuran; b++) {
                System.out.print("------------");
            }
            System.out.println("");
        }
    }
    
    //input bari dan kolom
    static void inputData(char input, int baris, int kolom) {
        isi[baris][kolom] = input;
    }
    
    static String inputString() { //untuk input String (nama menggunakan .nextLine)
        Scanner masukan = new Scanner(System.in);
        String nama = masukan.nextLine();
        return nama;
    }

    static void inputNama() {
        int ulangNama;
        do {
            ulangNama=0;
            System.out.print("Masukkan nama player 1\t\t\t:");
            nama1 = inputString().toUpperCase();
            System.out.print("Masukkan nama player 2\t\t\t:");
            nama2 = inputString().toUpperCase();
            if (nama1.equals(nama2)) {
                ulangNama = 1;
                System.out.println("========================ERROR=====================");
                System.out.println("Masukan nama harus BERBEDA");
                System.out.println("ULANGI!");
                System.out.println("==================================================");
            } else {
                ulangNama = 0;
            }
        } while (ulangNama == 1);
    }
    
    //untuk perintah memasukkan panjang dan lebar papan
    static void inputPapan() {
        int ulangi;
        do {
            try {
                ulangi = 0;
                System.out.print("Masukkan panjang dan lebar papan\t:");
                ukuran = input.nextInt();
                if (ukuran < 3) {
                    System.out.println("========================ERROR=====================");
                    System.out.println("Panjang dan lebar papan minimal 3");
                    System.out.println("ULANGI!");
                    System.out.println("==================================================");
                    ulangi = 1;
                }
            } catch (InputMismatchException e) {
                System.out.println("========================ERROR=====================");
                System.out.println("Masukan harus berupa ANGKA");
                System.out.println("ULANGI!");
                System.out.println("==================================================");
                ulangi = 1;
                input.next();
            }
        } while (ulangi == 1);
    }
    
    //input tiap playernya
    static void inputPerPlayer(char XO) {
        int ulangi;
        do {
            try {
                ulangi = 0;
                System.out.print("Masukkan baris\t:");
                int baris = input.nextInt() - 1;
                System.out.print("Masukkan kolom\t:");
                int kolom = input.nextInt() - 1;
                if (isi[baris][kolom] == ' ') {
                    inputData(XO, baris, kolom);
                } else {
                    System.out.println("========================ERROR=====================");
                    System.out.println("baris " + (baris + 1) + " kolom " + (kolom + 1) + " SUDAH TERISI");
                    System.out.println("ULANGI!");
                    System.out.println("==================================================");
                    ulangi = 1;
                }

            } catch (InputMismatchException e) {
                System.out.println("========================ERROR=====================");
                System.out.println("Masukan harus berupa ANGKA");
                System.out.println("ULANGI!");
                System.out.println("==================================================");
                ulangi = 1;
                input.next();

            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("========================ERROR=====================");
                System.out.println("Masukan baris dan kolom adalah 1-" + ukuran);
                System.out.println("ULANGI!");
                System.out.println("==================================================");
                ulangi = 1;
            }
        } while (ulangi == 1);
    }

    static void player1() {
        player = nama1;
        System.out.println("===================" + nama1 + "(X) main=========================");
        inputPerPlayer('X');
    }

    static void player2() {
        player = nama2;
        System.out.println("===================" + nama2 + "(O) main=========================");
        inputPerPlayer('O');
    }

    static void cek(char XO) {
        for (int a = 0; a < ukuran; a++) {

            for (int b = 0; b < ukuran; b++) {
                if (isi[a][b] == XO) {
                    cek = 1;
                } else {
                    cek = 0;
                    break;
                }
            }
            if (cek == 1) {
                kemenangan = 1;
                break;
            }

            for (int c = 0; c < ukuran; c++) {
                if (isi[c][a] == XO) {
                    cek = 1;
                } else {
                    cek = 0;
                    break;
                }
            }
            if (cek == 1) {
                kemenangan = 1;
                break;
            }
        }

        if (kemenangan != 1) {
            for (int a = 0; a < ukuran; a++) {
                if (isi[a][a] == XO) {
                    cek = 1;
                } else {
                    cek = 0;
                    break;
                }
            }
            if (cek == 1) {
                kemenangan = 1;
            }
        }

        if (kemenangan != 1) {
            int b = ukuran - 1;
            for (int a = 0; a < ukuran; a++) {
                if (isi[a][b] == XO) {
                    cek = 1;
                    b--;
                } else {
                    cek = 0;
                    break;
                }
            }
            if (cek == 1) {
                kemenangan = 1;
            }
        }
    }

    static void menang() {
        clean();
        papan();
        System.out.println("===================================================");
        System.out.println("\t\t" + player + " MENANG!!!");
        System.out.println("===================================================");
        if (player == nama1) {
            poin1++;
            kalah2++;
        } else {
            poin2++;
            kalah1++;
        }
    }

    static void seri() {
        clean();
        papan();
        seri++;
        System.out.println("===================================================");
        System.out.println("\t\tPermainan SERI");
        System.out.println("===================================================");
    }
    
    //permainan dimulai
    static void startpermainan() {
        clean();
        System.out.println("================ Mulai Permainan =====================");
        permainan = 0;
        seri = 0;
        poin1 = 0;
        poin2 = 0;
        kalah1 = 0;
        kalah2 = 0;
        inputNama();
        int ulangi;
        do {
            ulangi = 0;
            permainan++;
            kemenangan = 0;
            inputPapan();
            isi = new char[ukuran][ukuran];
            pengosonganPapan();
            for (int a = 0; a < ukuran * ukuran; a++) {
                clean();
                papan();
                if (a % 2 == 0) {
                    player1();
                } else {
                    player2();
                }
                cek('X');
                cek('O');
                if (kemenangan == 1) {
                    break;
                }
            }
            char ulangper;
            if (kemenangan == 1) {
                menang();
                System.out.print("Ulangi(Y/N)? ");
                ulangper = input.next().charAt(0);
                if (ulangper == 'y' || ulangper == 'Y') {
                    ulangi = 1;
                } else {
                    clean();
                    menu();
                }
            } else if (kemenangan != 1) {
                seri();
                System.out.print("Ulangi(Y/N)? ");
                ulangper = input.next().charAt(0);
                if (ulangper == 'y' || ulangper == 'Y') {
                    ulangi = 1;
                } else {
                    clean();
                    menu();
                }
            }
        } while (ulangi == 1);
    }

    public static void main(String[] args) {
        clean();
        menu();
    }
}
