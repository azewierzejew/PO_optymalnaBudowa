package optymalnaBudowa;

public class Podział {

    private final int długość;
    private final int cena;
    private final Integer[] kawałki;

    public Podział(int długość, int cena, Integer[] kawałki) {
        this.długość = długość;
        this.cena = cena;
        this.kawałki = kawałki;
    }

    public int długość() {
        return długość;
    }

    public int cena() {
        return cena;
    }

    public int ilośćKawałków() {
        return kawałki.length;
    }

    public int kawałek(Integer numer) {
        return kawałki[numer];
    }

}
