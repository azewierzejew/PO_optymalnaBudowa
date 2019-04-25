package optymalnaBudowa.strategie;

import optymalnaBudowa.Oferta;
import optymalnaBudowa.problemPlecakowy.OpisProblemuPlecakowego;

public class OpisProblemuEkonomicznego implements OpisProblemuPlecakowego {

    @Override
    public long nowyWynik(Oferta oferta, long wynikPodproblemu) {
        return oferta.cena() + wynikPodproblemu;
    }

}