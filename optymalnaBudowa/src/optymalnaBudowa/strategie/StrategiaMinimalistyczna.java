package optymalnaBudowa.strategie;

import java.util.ArrayList;

import optymalnaBudowa.Oferta;
import optymalnaBudowa.PlanZakupu;
import optymalnaBudowa.Podział;

public class StrategiaMinimalistyczna extends Strategia {

    @Override
    public PlanZakupu policzPlan(Oferta[] cennik, Integer[] projekt) {
        int ilość = projekt.length;
        int ilośćZałatwionych = 0;
        boolean[] załatwione = new boolean[projekt.length];
        ArrayList<Podział> podziały = new ArrayList<Podział>();
        int numerOferty = cennik.length - 1;
        int najdłuższy = projekt[ilość - 1];

        while (ilośćZałatwionych < ilość) {
            while (numerOferty > 0 && cennik[numerOferty - 1].długość() >= najdłuższy) {
                numerOferty--;
            }

            int długość = cennik[numerOferty].długość();
            int zostało = długość;
            int cena = cennik[numerOferty].cena();
            najdłuższy = -1;
            ArrayList<Integer> kawałki = new ArrayList<Integer>();
            for (int i = ilość - 1; i >= 0; i--) {
                if (!załatwione[i]) {
                    if (projekt[i] <= zostało) {
                        załatwione[i] = true;
                        zostało -= projekt[i];
                        kawałki.add(projekt[i]);
                        ilośćZałatwionych++;
                    } else if (najdłuższy == -1) {
                        najdłuższy = projekt[i];
                    }
                }
            }
            podziały.add(new Podział(długość, cena, kawałki.toArray(new Integer[0])));

        }

        return new PlanZakupu(podziały.toArray(new Podział[0]));
    }

}
