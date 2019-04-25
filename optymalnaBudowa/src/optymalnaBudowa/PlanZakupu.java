package optymalnaBudowa;

import java.util.Arrays;

public class PlanZakupu {

    private final Podział[] podziały;

    public PlanZakupu(Podział[] podziały) {
        this.podziały = podziały;
    }

    @Override
    public String toString() {
        long cena = 0;
        long odpadki = 0;

        StringBuilder stringBuilder = new StringBuilder();

        for (Podział podział : podziały) {
            cena += podział.cena();
            long długość = podział.długość();
            stringBuilder.append(długość);

            Integer ilośćKawałków = podział.ilośćKawałków();
            for (Integer i = 0; i < ilośćKawałków; i++) {
                long kawałek = podział.kawałek(i);
                długość -= kawałek;
                stringBuilder.append(" " + kawałek);
            }
            odpadki += długość;
            stringBuilder.append("\n");
        }

        stringBuilder.insert(0, cena + "\n" + odpadki + "\n");
        return stringBuilder.toString();
    }

    public PlanZakupu dodajPodział(Podział podział) {
        Podział[] podziały = Arrays.copyOf(this.podziały, this.podziały.length + 1);
        podziały[podziały.length - 1] = podział;
        return new PlanZakupu(podziały);
    }

}
