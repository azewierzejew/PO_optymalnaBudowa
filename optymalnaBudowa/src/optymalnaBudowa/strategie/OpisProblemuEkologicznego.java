package optymalnaBudowa.strategie;

import optymalnaBudowa.Oferta;
import optymalnaBudowa.problemPlecakowy.OpisProblemuPlecakowego;

public class OpisProblemuEkologicznego implements OpisProblemuPlecakowego {

    @Override
    public long nowyWynik(Oferta oferta, long wynikPodproblemu) {
        return oferta.długość() + wynikPodproblemu;
    }

}