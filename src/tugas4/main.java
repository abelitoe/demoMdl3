package tugas4;

import java.util.Scanner;

/**
 * Kelas main adalah titik masuk utama untuk menjalankan aplikasi.
 * Kelas ini menginisialisasi proses input pengguna untuk menghitung
 * umur seseorang menggunakan kelas Person.
 */
public class main {

    /**
     * Metode utama untuk menjalankan aplikasi.
     * Menginisialisasi Scanner untuk input pengguna dan memanggil metode
     * hitungUmur dari kelas Person untuk menghitung umur berdasarkan input.
     */
    public static void main(String[] args) {
        Scanner objinput = new Scanner(System.in);

        Person.hitungUmur(objinput);
    }
}
