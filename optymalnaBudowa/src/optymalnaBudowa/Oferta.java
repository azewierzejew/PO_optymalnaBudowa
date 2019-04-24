package optymalnaBudowa;

public class Oferta {

    private final int długość;
    private final int cena;

    public Oferta(int długość, int cena) {
        this.długość = długość;
        this.cena = cena;
    }

    public Integer długość() {
        return długość;
    }

    public Integer cena() {
        return cena;
    }

}
