package optymalnaBudowa;

import java.util.ArrayList;
import java.util.List;

public class Podział {

    private final Oferta oferta;
    private final List<Long> kawałki;

    public Podział(Oferta oferta, List<Long> kawałki) {
        this.oferta = oferta;
        this.kawałki = new ArrayList<Long>(kawałki);
    }

    public long cena() {
        return oferta.cena();
    }

    public long odpadki() {
        long długość = oferta.długość();

        for (long kawałek : kawałki) {
            długość -= kawałek;
        }

        return długość;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(oferta.długość());

        for (long kawałek : kawałki) {
            stringBuilder.append(" " + kawałek);
        }

        return stringBuilder.toString();
    }

}
