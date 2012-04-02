package projektas1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

/*
 * L5-6. Turime tekstiniame faile studentų sąrašą: pavardė, vardas, grupės
 * šifras, visų egzaminų pažymiai. Suformuoti nurodyto egzamino sąrašą (egzas
 * įvedamas): pavardė, vardas, grupės šifras, pažymys. Sąrašą surikiuoti pažymių
 * mažėjimo tvarka. Išvesti dvi lenteles: duomenų ir rezultatų..
 */
/**
 *
 * @author Agne
 */
public class Studentas {
    // Iraso apie viena studenta laukai ir metodai darbui su siais laukais.
    // SVARBU: Klase neturi jokios informacijos apie tai, kaip sie objektai (irasai) bus saugomi -
    //    tai gali buti masyvas, dinaminis sarasas ar kolekcija.

    private String pavarde = "";
    private String vardas = "";
    private String grupe = "";
    private double matematika;
    private double logika;
    private double statistika;

    public Studentas() {       
    }

    public Studentas(String pav, String v, String gr, double mat, double log, double stat) {
        pavarde = pav;
        vardas = v; //lklklkl
        grupe = gr;
        matematika = mat;
        logika = log;
        statistika = stat;
    }

    public Studentas tarpinis() {
        Studentas klonas = new Studentas();
        klonas.pavarde = pavarde;
        klonas.vardas = vardas;
        klonas.grupe = grupe;
        klonas.matematika = matematika;
        klonas.logika = logika;
        klonas.statistika = statistika;
        return klonas;
    }
    // String tipo eilute isskaido i atskirus duomenu laukelius

    public boolean dalinaStringEilute(String eilute) {
        try {
            Locale.setDefault(Locale.US); // suvienodiname skaičių formatus (kitaip duomenys tures buti ne su tasku, o su kableliu)
            Scanner sc = new Scanner(eilute); // skiriklis tarpai (bet kiek), tabuliacija, eilutes pabaiga
            pavarde = sc.next();	                      // Norint skirikliai keicismi useDelimiter() metodu
            vardas = sc.next();
            grupe = sc.next();
            matematika = sc.nextDouble();
            logika = sc.nextDouble();
            statistika = sc.nextDouble();
            // irasas geras
            return true;
        } catch (InputMismatchException e) {
            System.out.println("Blogi duomenys - irasas praleistas");
        }
        // Irasas blogas
        return false;
    }

    // Duomenys ivedami klaviatura - kiekvienas duomuo naujoje eiluteje
    public void isKlaviaturos(BufferedReader in) {
        System.out.println("Iveskite pavardę");
        try {
            pavarde = in.readLine();
        } catch (IOException e) {
        }
        System.out.println("Iveskite vardą: ");
        try {
            vardas = in.readLine();
        } catch (IOException e) {
        }
        System.out.println("Iveskite grupę: ");
        try {

            grupe = in.readLine();
        } catch (IOException ex) {
        }

        System.out.println("Iveskite matematikos pažymį");
        try {
            try {
                matematika = Double.parseDouble(in.readLine());
            } catch (IOException ex) {
            }
        } catch (NumberFormatException e) {
        }
        System.out.println("Iveskite logikos pažymį");
        try {
            try {
                logika = Double.parseDouble(in.readLine());
            } catch (IOException ex) {
            }
        } catch (NumberFormatException e) {
        }
        System.out.println("Iveskite matematikos pažymį");
        try {
            try {
                statistika = Double.parseDouble(in.readLine());
            } catch (IOException ex) {
            }
        } catch (NumberFormatException e) {
        }
    }

//Ar sutampa raktinis laukas?          
    public boolean lyginimasPavarde(String pavarde) {
        if ((this.pavarde.trim().equals(pavarde.trim()))) {
            return true;
        } else {
            return false;
        }
    }

// Formuojamas irasas isvedimui i Ekrana viena eilute    
    @Override
    public String toString() {
        String pav = ilgioFormatas(pavarde, 14);
        String var = ilgioFormatas(vardas, 10);
        return (pav + " " + var + "  " + grupe + "    " + matematika + "  " + logika + "  " + statistika);
    }

    public String ilgioFormatas(String kas, int kiek) {
        String eilute = kas;
        int ilgis = kas.length();
        if (ilgis < kiek) {
            for (int i = 1; i <= (kiek - ilgis); i++) {
                eilute = eilute + " ";
            }
        }
        return eilute;
    }

    // Formuojamas irasas eilute irasymui i faila
    public void iFaila(PrintWriter rasyti) {
        rasyti.println(pavarde + " " + vardas + " " + grupe + " " + " " + matematika + " " + logika + " " + statistika);
    }
}
