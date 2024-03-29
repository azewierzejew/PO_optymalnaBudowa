package optymalnaBudowa.problemPlecakowy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import optymalnaBudowa.Oferta;
import optymalnaBudowa.PlanZakupu;
import optymalnaBudowa.Podział;

public class ProblemPlecakowy {

    private final OpisProblemuPlecakowego opisProblemu;
    private Oferta[] cennik;
    private Long[] projekt;
    private Map<ZbiórLiczbowy, Wynik> najlepszyWynik;

    public ProblemPlecakowy(OpisProblemuPlecakowego opisProblemu) {
        this.opisProblemu = opisProblemu;
    }

    private class Wynik {

        private final long koszt;
        private final PlanZakupu plan;

        public Wynik(long koszt, PlanZakupu plan) {
            this.koszt = koszt;
            this.plan = plan;
        }

        public PlanZakupu plan() {
            return plan;
        }

        public Wynik wybierzLepszy(Wynik wynik) {
            if (this.koszt < wynik.koszt) {
                return this;
            }
            return wynik;
        }

        public Wynik dodaj(Oferta oferta, Podział podział) {
            long nowyKoszt = opisProblemu.nowyWynik(oferta, koszt);
            PlanZakupu nowyPlan = plan.dodajPodział(podział);
            return new Wynik(nowyKoszt, nowyPlan);
        }

        @Override
        public String toString() {
            return "koszt: " + koszt + " plan: " + plan;
        }

    }

    private void rozwiążRekurencyjnie(ZbiórLiczbowy zbiór) {
        Wynik wynik = najlepszyWynik.get(zbiór);
        if (wynik != null)
            return;

        wynik = new Wynik(Long.MAX_VALUE, null);
        Iterable<ZbiórLiczbowy> podzbiory = zbiór.podzbiory();

        for (ZbiórLiczbowy poprzedni : podzbiory) {
            long sumaDługości = 0;
            List<Long> kawałki = new ArrayList<Long>();
            for (int i : zbiór) {
                if (!poprzedni.zawiera(i)) {
                    sumaDługości += projekt[i];
                    kawałki.add(projekt[i]);
                }
            }

            if (kawałki.isEmpty()) {
                continue;
            }

            rozwiążRekurencyjnie(poprzedni);

            for (Oferta oferta : cennik) {
                if (oferta.długość() >= sumaDługości) {
                    Wynik wynikPoprzedniego = najlepszyWynik.get(poprzedni);
                    Podział podział = new Podział(oferta, kawałki);
                    Wynik nowyWynik = wynikPoprzedniego.dodaj(oferta, podział);
                    wynik = wynik.wybierzLepszy(nowyWynik);
                }
            }

        }

        najlepszyWynik.put(zbiór, wynik);
    }

    public PlanZakupu rozwiąż(Oferta[] cennik, Long[] projekt) {
        this.cennik = cennik;
        this.projekt = projekt;

        int ilość = projekt.length;

        najlepszyWynik = new TreeMap<ZbiórLiczbowy, Wynik>();

        ZbiórLiczbowy pełny = new ZbiórLiczbowy(ilość);
        ZbiórLiczbowy pusty = new ZbiórLiczbowy(0);

        najlepszyWynik.put(pusty, new Wynik(0, new PlanZakupu()));

        rozwiążRekurencyjnie(pełny);

        return najlepszyWynik.get(pełny).plan();
    }

}
