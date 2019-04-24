package optymalnaBudowa;

public class PlanZakupu {

    private final Podział[] podziały;

    public PlanZakupu(Podział[] podziały) {
        this.podziały = podziały;
    }

    @Override
    public String toString() {
        Integer cena = 0;
        Integer odpadki = 0;

        StringBuilder stringBuilder = new StringBuilder();

        for (Podział podział : podziały) {
            cena += podział.cena();
            Integer długość = podział.długość();
            stringBuilder.append(długość);

            Integer ilośćKawałków = podział.ilośćKawałków();
            for (Integer i = 0; i < ilośćKawałków; i++) {
                Integer kawałek = podział.kawałek(i);
                długość -= kawałek;
                stringBuilder.append(" " + kawałek);
            }
            odpadki += długość;
            stringBuilder.append("\n");
        }

        stringBuilder.insert(0, cena + "\n" + odpadki + "\n");
        return stringBuilder.toString();
    }

}
