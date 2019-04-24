package optymalnaBudowa;

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

    public PlanZakupu rozwiąż(Oferta[] cennik, Integer[] projekt) {
        int ilość = projekt.length;
        /*
         * for (int i = 0; i < stany; i++) System.out.println(i + " " + optymalnyWynik[i]);
         * 
         * for (int i = 1; i < stany; i++) { int j = 0; while (j < i) { for (int k = 0; k < cennik.length;
         * k++) { int dodawanyRozmiar = 0; for (int l = 0; (1 << l) < i; l++) { if ((((i ^ j) >> l) & 1) !=
         * 0) { dodawanyRozmiar += projekt[l]; } } int najlepszy = znajdźNajlepszy(dodawanyRozmiar, cennik);
         * if (najlepszy != -1 && optymalnyWynik[j] != Integer.MAX_VALUE) { int nowyWynik =
         * optymalnyWynik[j] + cennik[najlepszy].cena(); if (nowyWynik < optymalnyWynik[i]) {
         * optymalnyWynik[i] = nowyWynik; } } } j = kolejnaPodmaskaBitowa(j, i); } }
         * 
         * for (int i = 0; i < stany; i++) System.out.println(i + " " + optymalnyWynik[i]);
         */
        return null;
    }

}
