package optymalnaBudowa.strategie;

import optymalnaBudowa.Oferta;
import optymalnaBudowa.PlanZakupu;

public abstract class Strategia {

    public abstract PlanZakupu policzPlan(Oferta[] cennik, Integer[] projekt);

}
