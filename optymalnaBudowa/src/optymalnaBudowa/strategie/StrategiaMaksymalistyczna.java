package optymalnaBudowa.strategie;

import java.util.ArrayList;
import java.util.List;

import optymalnaBudowa.Oferta;
import optymalnaBudowa.PlanZakupu;
import optymalnaBudowa.Podział;

public class StrategiaMaksymalistyczna extends Strategia {

    @Override
    public PlanZakupu policzPlan(Oferta[] cennik, Long[] projekt) {
        int ilość = projekt.length;
        int ilośćZałatwionych = 0;
        boolean[] załatwione = new boolean[projekt.length];
        List<Podział> podziały = new ArrayList<Podział>();
        Oferta oferta = cennik[cennik.length - 1];

        while (ilośćZałatwionych < ilość) {
            long zostało = oferta.długość();
            List<Long> kawałki = new ArrayList<Long>();
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
            podziały.add(new Podział(oferta, kawałki));

        }

        return new PlanZakupu(podziały);
    }

}
