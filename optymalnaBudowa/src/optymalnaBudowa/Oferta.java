package optymalnaBudowa;

public class Oferta {

    private final long długość;
    private final long cena;

    public Oferta(long długość, long cena) {
        this.długość = długość;
        this.cena = cena;
    }

    public long długość() {
        return długość;
    }

    public long cena() {
        return cena;
    }

}
