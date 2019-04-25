package optymalnaBudowa.strategie;

import java.util.ArrayList;

import optymalnaBudowa.Oferta;
import optymalnaBudowa.PlanZakupu;
import optymalnaBudowa.Podział;

public class StrategiaMinimalistyczna extends Strategia {

    @Override
    public PlanZakupu policzPlan(Oferta[] cennik, Long[] projekt) {
        int ilość = projekt.length;
        int ilośćZałatwionych = 0;
        boolean[] załatwione = new boolean[projekt.length];
        ArrayList<Podział> podziały = new ArrayList<Podział>();
        int numerOferty = cennik.length - 1;
        long najdłuższy = projekt[ilość - 1];

        while (ilośćZałatwionych < ilość) {
            while (numerOferty > 0 && cennik[numerOferty - 1].długość() >= najdłuższy) {
                numerOferty--;
            }
            Oferta oferta = cennik[numerOferty];
            long zostało = oferta.długość();
            najdłuższy = -1;
            ArrayList<Long> kawałki = new ArrayList<Long>();
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
            podziały.add(new Podział(oferta, kawałki.toArray(new Long[0])));

        }

        return new PlanZakupu(podziały.toArray(new Podział[0]));
    }

}
