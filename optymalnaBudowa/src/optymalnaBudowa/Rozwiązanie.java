package optymalnaBudowa;

import java.util.Scanner;

import optymalnaBudowa.strategie.Strategia;
import optymalnaBudowa.strategie.StrategiaEkologiczna;
import optymalnaBudowa.strategie.StrategiaEkonomiczna;
import optymalnaBudowa.strategie.StrategiaMaksymalistyczna;
import optymalnaBudowa.strategie.StrategiaMinimalistyczna;

public class Rozwiązanie {

    public static void main(String[] args) {
        Scanner wiersze = new Scanner(System.in);

        int rozmiarCennika;
        rozmiarCennika = Integer.parseInt(wiersze.nextLine());
        Oferta[] cennik = new Oferta[rozmiarCennika];
        for (int i = 0; i < rozmiarCennika; i++) {
            String wiersz = wiersze.nextLine();
            String[] liczby = wiersz.split(" ");
            int długość = Integer.parseInt(liczby[0]);
            int cena = Integer.parseInt(liczby[1]);
            cennik[i] = new Oferta(długość, cena);
        }

        int rozmiarProjektu;
        rozmiarProjektu = Integer.parseInt(wiersze.nextLine());
        Integer[] projekt = new Integer[rozmiarProjektu];

        String wiersz = wiersze.nextLine();
        String[] liczby = wiersz.split(" ");
        for (int i = 0; i < rozmiarProjektu; i++) {
            projekt[i] = Integer.parseInt(liczby[i]);
        }

        String nazwaStrategii = wiersze.nextLine();
        wiersze.close();

        Strategia strategia = null;

        if (nazwaStrategii.equals("minimalistyczna")) {
            strategia = new StrategiaMinimalistyczna();
        } else if (nazwaStrategii.equals("maksymalistyczna")) {
            strategia = new StrategiaMaksymalistyczna();
        } else if (nazwaStrategii.equals("ekonomiczna")) {
            strategia = new StrategiaEkonomiczna();
        } else if (nazwaStrategii.equals("ekologiczna")) {
            strategia = new StrategiaEkologiczna();
        }

        PlanZakupu planZakupu = strategia.policzPlan(cennik, projekt);

        System.out.println(planZakupu);
    }

}
