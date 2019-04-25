package optymalnaBudowa;

public class Podział {

    private final long długość;
    private final long cena;
    private final Long[] kawałki;

    public Podział(long długość, long cena, Long[] kawałki) {
        this.długość = długość;
        this.cena = cena;
        this.kawałki = kawałki;
    }

    public long długość() {
        return długość;
    }

    public long cena() {
        return cena;
    }

    public int ilośćKawałków() {
        return kawałki.length;
    }

    public long kawałek(int numer) {
        return kawałki[numer];
    }

}
