package tugas4;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.Period;
import java.time.DateTimeException;

/**
 * Kelas Person merepresentasikan data seseorang dengan atribut
 * nama, jenis kelamin, dan tanggal lahir, serta metode untuk menampilkan
 * informasi dan menghitung umur.
 */
class Person extends Variabel {

    /**
     * Konstruktor untuk membuat objek Person dengan atribut yang telah ditentukan.
     *
     * @param name Nama dari orang tersebut
     * @param gender Jenis kelamin ('L' untuk laki-laki, 'P' untuk perempuan)
     * @param year Tahun lahir
     * @param month Bulan lahir
     * @param day Tanggal lahir
     */
    public Person(String name, char gender, int year, int month, int day) {
        this.setName(name);
        this.setGender(gender);
        this.setBirthDate(LocalDate.of(year, month, day));
    }

    /**
     * Metode statis untuk menghitung umur berdasarkan input dari pengguna.
     *
     * @param objinput Scanner untuk membaca input pengguna
     */
    static void hitungUmur(Scanner objinput) {
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.print("Masukkan Nama : ");
                String nama = objinput.nextLine();
                System.out.print("Masukkan jenis kelamin (L/P) : ");
                char gender = objinput.next().charAt(0);

                if (gender != 'L' && gender != 'P') {
                    throw new IllegalArgumentException("Jenis kelamin harus 'L' atau 'P'.\n");
                }

                System.out.println("Masukkan tanggal lahir (yyyy/mm/dd) : ");
                int tahun = objinput.nextInt();
                int bulan = objinput.nextInt();
                int tanggal = objinput.nextInt();

                Person person = new Person(nama, gender, tahun, bulan, tanggal);
                person.displayInfo();

                validInput = true;

            } catch (DateTimeException e) {
                System.out.println("Tanggal tidak valid. Harap masukkan tanggal yang benar.\n");
                objinput.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                objinput.nextLine();
            }
        }
    }

    /**
     * Metode untuk menampilkan informasi lengkap dari objek Person, termasuk
     * nama, jenis kelamin, umur, inisial, dan nama dalam huruf kapital.
     */
    public void displayInfo() {
        System.out.println("\nNama          : " + getName());

        if (getGender() == 'L') {
            System.out.println("Jenis kelamin : Laki-laki");
        } else if (getGender() == 'P') {
            System.out.println("Jenis kelamin : Perempuan");
        } else {
            System.out.println("Jenis kelamin : ?");
        }

        LocalDate today = LocalDate.now();
        Period age = Period.between(getBirthDate(), today);

        System.out.println("Usia          : " + age.getYears() + " tahun " + age.getMonths() + " bulan");
        System.out.println("Inisial       : " + getInitials());
        System.out.println("Capslock      : " + getUpperCaseName());
    }

    /**
     * Mendapatkan inisial dari nama.
     *
     * @return Inisial dari nama (huruf pertama dari setiap kata)
     */
    public String getInitials() {
        String[] words = getName().split(" ");
        StringBuilder initials = new StringBuilder();
        for (String word : words) {
            if (!word.isEmpty()) {
                initials.append(word.charAt(0));
            }
        }
        return initials.toString();
    }

    /**
     * Mendapatkan nama dalam huruf kapital.
     *
     * @return Nama dalam huruf kapital
     */
    public String getUpperCaseName() {
        return getName().toUpperCase();
    }

    /**
     * Mendapatkan nama dari objek Person.
     *
     * @return Nama dari objek Person
     */
    public String getName() {
        return name;
    }

    /**
     * Menetapkan nama untuk objek Person.
     *
     * @param name Nama yang akan diatur
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Mendapatkan jenis kelamin dari objek Person.
     *
     * @return Jenis kelamin ('L' untuk laki-laki, 'P' untuk perempuan)
     */
    public char getGender() {
        return gender;
    }

    /**
     * Menetapkan jenis kelamin untuk objek Person.
     *
     * @param gender Jenis kelamin yang akan diatur ('L' untuk laki-laki, 'P' untuk perempuan)
     */
    public void setGender(char gender) {
        this.gender = gender;
    }

    /**
     * Mendapatkan tanggal lahir dari objek Person.
     *
     * @return Tanggal lahir dalam bentuk LocalDate
     */
    public LocalDate getBirthDate() {
        return birthDate;
    }

    /**
     * Menetapkan tanggal lahir untuk objek Person.
     *
     * @param birthDate Tanggal lahir dalam bentuk LocalDate
     */
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
