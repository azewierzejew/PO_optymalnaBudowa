package optymalnaBudowa.strategie;

import optymalnaBudowa.Oferta;
import optymalnaBudowa.PlanZakupu;
import optymalnaBudowa.problemPlecakowy.ProblemPlecakowy;

public class StrategiaEkologiczna extends Strategia {

    @Override
    public PlanZakupu policzPlan(Oferta[] cennik, Long[] projekt) {
        ProblemPlecakowy plecak = new ProblemPlecakowy(new OpisProblemuEkologicznego());

        return plecak.rozwiąż(cennik, projekt);
    }

}
