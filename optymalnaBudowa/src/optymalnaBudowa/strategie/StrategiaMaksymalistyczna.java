package optymalnaBudowa.strategie;

import java.util.ArrayList;

import optymalnaBudowa.Oferta;
import optymalnaBudowa.PlanZakupu;
import optymalnaBudowa.Podział;

public class StrategiaMaksymalistyczna extends Strategia {

    @Override
    public PlanZakupu policzPlan(Oferta[] cennik, Integer[] projekt) {
        int ilość = projekt.length;
        int ilośćZałatwionych = 0;
        boolean[] załatwione = new boolean[projekt.length];
        ArrayList<Podział> podziały = new ArrayList<Podział>();
        int długość = cennik[cennik.length - 1].długość();
        int cena = cennik[cennik.length - 1].cena();

        while (ilośćZałatwionych < ilość) {
            int zostało = długość;
            ArrayList<Integer> kawałki = new ArrayList<Integer>();
            for (int i = ilość - 1; i >= 0; i--) {
                if (!załatwione[i]) {
                    if (projekt[i] <= zostało) {
                        załatwione[i] = true;
                        zostało -= projekt[i];
                        kawałki.add(projekt[i]);
                        ilośćZałatwionych++;
                    }
                }
            }
            podziały.add(new Podział(długość, cena, kawałki.toArray(new Integer[0])));

        }

        return new PlanZakupu(podziały.toArray(new Podział[0]));
    }

}
