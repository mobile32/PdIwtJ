package PdIwtJ;

import java.util.ArrayList;
import java.util.Date;

public class Wakacje{
    String Kraj, Miejscowość, Hotel, Wyżywienie;

    ArrayList<Termin>WolneTerminy;
    ArrayList<Pokój>Pokoje;

    public Wakacje(String kraj, String miejscowość, String hotel, String wyżywienie, ArrayList<Termin> wolneTerminy, ArrayList<Pokój> pokoje) {
        Kraj = kraj;
        Miejscowość = miejscowość;
        Hotel = hotel;
        Wyżywienie = wyżywienie;
        WolneTerminy = wolneTerminy;
        Pokoje = pokoje;
    }

    public double ObliczCene(String OznaczeniePokoju, Date DzieńWyjazdu){
        for (Termin termin : WolneTerminy) {
            if(termin.DzieńWyjazdu == DzieńWyjazdu){
                for(Pokój pokój: Pokoje){
                    if (pokój.Oznacznie == OznaczeniePokoju){
                        return termin.CenaTerminu + pokój.Cena;
                    }
                }
            }
        }

        return -1;
    }
}

