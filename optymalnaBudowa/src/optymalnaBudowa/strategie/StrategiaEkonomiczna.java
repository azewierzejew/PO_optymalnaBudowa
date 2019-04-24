package optymalnaBudowa.strategie;

import optymalnaBudowa.Oferta;
import optymalnaBudowa.OpisProblemuEkonomicznego;
import optymalnaBudowa.PlanZakupu;
import optymalnaBudowa.ProblemPlecakowy;

public class StrategiaEkonomiczna extends Strategia {

    @Override
    public PlanZakupu policzPlan(Oferta[] cennik, Integer[] projekt) {
        ProblemPlecakowy plecak = new ProblemPlecakowy(new OpisProblemuEkonomicznego());

        return plecak.rozwiąż(cennik, projekt);
    }

}
