package optymalnaBudowa;

public class Podział {

    private final Oferta oferta;
    private final Long[] kawałki;

    public Podział(Oferta oferta, Long[] kawałki) {
        this.oferta = oferta;
        this.kawałki = kawałki;
    }

    public Oferta oferta() {
        return oferta;
    }

    public int ilośćKawałków() {
        return kawałki.length;
    }

    public long kawałek(int numer) {
        return kawałki[numer];
    }

}
