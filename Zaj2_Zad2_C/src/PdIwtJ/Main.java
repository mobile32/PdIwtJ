package PdIwtJ;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Wakacje> wakacje = new ArrayList<>();
        Scanner odczyt = new Scanner(System.in); //obiekt do odebrania danych od użytkownika

        while (true) {
            System.out.println("Czy dodać kolejną ofertę wakacji? [T/N]");
            String kontynuować = odczyt.next();
            if ((kontynuować == "N") || (kontynuować == "n")) {
                break;
            }

            String kraj, miejscowość, hotel, wyżywienie;

            ArrayList<Termin> wolneTerminy = new ArrayList<>();
            ArrayList<Pokój> pokoje = new ArrayList<>();

            System.out.println("Podaj kraj:");
            kraj = odczyt.nextLine();
            System.out.println("Podaj miejscowość:");
            miejscowość = odczyt.nextLine();
            System.out.println("Podaj hotel:");
            hotel = odczyt.nextLine();
            System.out.println("Podaj zakres wyżywienia:");
            wyżywienie = odczyt.nextLine();

            while (true) {
                System.out.println("Czy dodać termin?: [T/N]");
                kontynuować = odczyt.next();
                if ((kontynuować == "N") || (kontynuować == "n")) {
                    break;
                }

                Termin t = new Termin();

                try {
                    System.out.println("Podaj cenę:");
                    t.CenaTerminu = odczyt.nextDouble();
                    System.out.println("Podaj datę: [dd.MM.yyyy");
                    String dzieńWyjazdu = odczyt.next();
                    DateFormat formatter = new SimpleDateFormat("dd.MMM.yyyy");
                    Date date = formatter.parse(dzieńWyjazdu);
                    t.DzieńWyjazdu = date;
                } catch (Exception e) {
                    System.out.println("Podano błędne dane.");
                    continue;
                }

                wolneTerminy.add(t);
            }

            while (true) {
                System.out.println("Czy dodać pokój?: [T/N]");
                kontynuować = odczyt.next();
                if ((kontynuować == "N") || (kontynuować == "n")) {
                    break;
                }

                Pokój p = new Pokój();

                try {
                    System.out.println("Podaj cenę:");
                    p.Cena = odczyt.nextDouble();
                    System.out.println("Podaj oznaczenie pokoju:");
                    p.Oznacznie = odczyt.next();
                    System.out.println("Podaj ilość miejsc w pokoju:");
                    p.Miejsca = odczyt.nextInt();
                } catch (Exception e) {
                    System.out.println("Podano błędne dane.");
                    continue;
                }

                pokoje.add(p);
            }

            wakacje.add(new Wakacje(kraj, miejscowość, hotel, wyżywienie, wolneTerminy, pokoje));
        }

        try {
            PrintWriter zapis = new PrintWriter("Wakacje.txt");
            for (Wakacje w : wakacje) {
                zapis.print("Kraj: " + w.Kraj);
                zapis.print("Miejscowość: " + w.Miejscowość);
                zapis.print("Hotel: " + w.Hotel);
                zapis.print("Wyżywienie: " + w.Wyżywienie);
                zapis.println();
                for (Termin t : w.WolneTerminy) {
                    zapis.println("\t" + "Cena terminu: " + t.CenaTerminu);
                    zapis.println("\t" + "Dzień wyjazdu: " + t.DzieńWyjazdu);
                    zapis.println();
                }
                for (Pokój p : w.Pokoje) {
                    zapis.println("\t" + "Ilośc miejsc: " + p.Miejsca);
                    zapis.println("\t" + "Oznaczenie pokoju: " + p.Oznacznie);
                    zapis.println("\t" + "Cena: " + p.Cena);
                    zapis.println();
                }
                zapis.println();
            }
            zapis.close();
        }
        catch (Exception e){
            System.out.println("Nie udało się zapisać listy wakacji do pliku");
        }
    }
}

