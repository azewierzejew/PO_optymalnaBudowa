package optymalnaBudowa;

public class OpisProblemuEkonomicznego implements OpisProblemuPlecakowego {

    @Override
    public int nowyWynik(Oferta oferta, int wynikPodproblemu) {
        return oferta.cena() + wynikPodproblemu;
    }

}