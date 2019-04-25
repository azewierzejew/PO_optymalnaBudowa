package optymalnaBudowa.problemPlecakowy;

import java.util.NavigableMap;
import java.util.TreeMap;

import optymalnaBudowa.MaskaBitowa;
import optymalnaBudowa.Oferta;
import optymalnaBudowa.PlanZakupu;
import optymalnaBudowa.Podział;

public class ProblemPlecakowy {

    private final OpisProblemuPlecakowego opisProblemu;

    public ProblemPlecakowy(OpisProblemuPlecakowego opisProblemu) {
        this.opisProblemu = opisProblemu;
    }

    static private int kolejnaPodmaskaBitowa(int podmaska, int maska) {
        podmaska++;
        while ((podmaska & (~maska)) != 0) {
            podmaska += podmaska & (~maska);
        }
        return podmaska;
    }

    private class Wynik {

        private final long wynik;
        private final Podział sposób;

        public Wynik(long wynik, Podział sposób) {
            super();
            this.wynik = wynik;
            this.sposób = sposób;
        }

        public Podział sposób() {
            return sposób;
        }

        public Wynik wybierzLepszy(Wynik wynik) {
            if (this.wynik < wynik.wynik) {
                return this;
            }
            return wynik;
        }

    }

    public PlanZakupu rozwiąż(Oferta[] cennik, Integer[] projekt) {
        int ilość = projekt.length;

        NavigableMap<MaskaBitowa, Wynik> najlepszyWynik = new TreeMap<MaskaBitowa, Wynik>();

        MaskaBitowa maska = new MaskaBitowa(ilość);

        najlepszyWynik.put(maska.kopia(), new Wynik(0, null));

        do {
            MaskaBitowa maskaWybranych = new MaskaBitowa(ilość);
            while (maskaWybranych.kolejnaPodmaska(maska)) {

            }
        } while (maska.kolejnaMaska());

        return null;
    }

}
