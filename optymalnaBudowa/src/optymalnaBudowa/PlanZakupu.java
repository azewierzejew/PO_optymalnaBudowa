package optymalnaBudowa;

import java.util.ArrayList;
import java.util.List;

public class PlanZakupu {

    private final List<Podział> podziały;

    public PlanZakupu(List<Podział> podziały) {
        this.podziały = new ArrayList<Podział>(podziały);
    }

    public PlanZakupu() {
        this.podziały = new ArrayList<Podział>();
    }

    @Override
    public String toString() {
        long cena = 0;
        long odpadki = 0;

        StringBuilder stringBuilder = new StringBuilder();

        for (Podział podział : podziały) {
            cena += podział.cena();
            odpadki += podział.odpadki();
            stringBuilder.append(podział + "\n");
        }

        stringBuilder.insert(0, cena + "\n" + odpadki + "\n");
        return stringBuilder.toString();
    }

    public PlanZakupu dodajPodział(Podział podział) {
        List<Podział> podziały = new ArrayList<Podział>(this.podziały);
        podziały.add(podział);
        return new PlanZakupu(podziały);
    }

}
