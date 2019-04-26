package optymalnaBudowa;

import java.util.Scanner;

import optymalnaBudowa.strategie.Strategia;
import optymalnaBudowa.strategie.StrategiaEkologiczna;
import optymalnaBudowa.strategie.StrategiaEkonomiczna;
import optymalnaBudowa.strategie.StrategiaMaksymalistyczna;
import optymalnaBudowa.strategie.StrategiaMinimalistyczna;

public class Rozwiązanie {

    public static void main(String[] args) {
        Scanner wejście = new Scanner(System.in);

        int rozmiarCennika;
        rozmiarCennika = wejście.nextInt();
        Oferta[] cennik = new Oferta[rozmiarCennika];

        for (int i = 0; i < rozmiarCennika; i++) {
            long długość = wejście.nextLong();
            long cena = wejście.nextLong();
            cennik[i] = new Oferta(długość, cena);
        }

        int rozmiarProjektu;
        rozmiarProjektu = wejście.nextInt();
        Long[] projekt = new Long[rozmiarProjektu];

        for (int i = 0; i < rozmiarProjektu; i++) {
            projekt[i] = wejście.nextLong();
        }

        String nazwaStrategii = wejście.next();
        wejście.close();

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
