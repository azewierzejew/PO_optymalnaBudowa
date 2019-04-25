package optymalnaBudowa.problemPlecakowy;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import optymalnaBudowa.Oferta;
import optymalnaBudowa.PlanZakupu;

public class ProblemPlecakowy {

    private final OpisProblemuPlecakowego opisProblemu;
    private Oferta[] cennik;
    private Long[] projekt;
    private Map<ZbiórLiczbowy, Wynik> najlepszyWynik;

    public ProblemPlecakowy(OpisProblemuPlecakowego opisProblemu) {
        this.opisProblemu = opisProblemu;
    }

    private class Wynik {

        private final long wynik;
        private final PlanZakupu plan;

        public Wynik(long wynik, PlanZakupu plan) {
            this.wynik = wynik;
            this.plan = plan;
        }

        public PlanZakupu plan() {
            return plan;
        }

        public Wynik wybierzLepszy(Wynik wynik) {
            if (this.wynik < wynik.wynik) {
                return this;
            }
            return wynik;
        }

    }

    private void rozwiążRekurencyjnie(ZbiórLiczbowy zbiór) {
        Wynik wynik = najlepszyWynik.get(zbiór);
        if (wynik != null)
            return;

        wynik = new Wynik(Long.MAX_VALUE, null);
        List<ZbiórLiczbowy> podzbiory = zbiór.podzbiory();

        for (ZbiórLiczbowy podzbiór : podzbiory) {

        }
    }

    public PlanZakupu rozwiąż(Oferta[] cennik, Long[] projekt) {
        this.cennik = cennik;
        this.projekt = projekt;

        int ilość = projekt.length;

        najlepszyWynik = new TreeMap<ZbiórLiczbowy, Wynik>();

        ZbiórLiczbowy pełny = new ZbiórLiczbowy(ilość);
        ZbiórLiczbowy pusty = new ZbiórLiczbowy(0);

        najlepszyWynik.put(pusty.kopia(), new Wynik(0, null));

        rozwiążRekurencyjnie(pełny);

        return najlepszyWynik.get(pełny).plan();
    }

}
