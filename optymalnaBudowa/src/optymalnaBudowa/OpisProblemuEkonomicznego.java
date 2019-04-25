package optymalnaBudowa;

import optymalnaBudowa.problemPlecakowy.OpisProblemuPlecakowego;

public class OpisProblemuEkonomicznego implements OpisProblemuPlecakowego {

    @Override
    public int nowyWynik(Oferta oferta, int wynikPodproblemu) {
        return oferta.cena() + wynikPodproblemu;
    }

}