package optymalnaBudowa.problemPlecakowy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ZbiórLiczbowy implements Iterable<Integer>, Comparable<ZbiórLiczbowy> {

    private final boolean[] liczbaNależy;

    public int maximum() {
        int maximum = -1;
        for (int i : this) {
            if (i > maximum) {
                maximum = i;
            }
        }
        return maximum;
    }

    private ZbiórLiczbowy(boolean[] liczbaNależy) {
        this.liczbaNależy = Arrays.copyOf(liczbaNależy, liczbaNależy.length);
    }

    public ZbiórLiczbowy(int limit) {
        liczbaNależy = new boolean[limit];
        for (int i = 0; i < limit; i++) {
            liczbaNależy[i] = true;
        }
    }

    public boolean zawiera(int liczba) {
        if (liczba >= liczbaNależy.length)
            return false;
        return liczbaNależy[liczba];
    }

    @Override
    public Iterator<Integer> iterator() {
        List<Integer> liczby = new ArrayList<Integer>();
        for (int i = 0; i < liczbaNależy.length; i++) {
            if (liczbaNależy[i])
                liczby.add(i);
        }
        return liczby.iterator();
    }

    public Iterable<ZbiórLiczbowy> podzbiory() {
        List<ZbiórLiczbowy> lista = new ArrayList<ZbiórLiczbowy>();
        boolean[] liczbaNależyPodzbiór = new boolean[liczbaNależy.length];
        boolean akumulator = false;
        while (akumulator == false) {
            akumulator = true;
            for (int i = 0; i < liczbaNależy.length && akumulator; i++) {
                if (!liczbaNależy[i]) {
                    continue;
                }
                liczbaNależyPodzbiór[i] ^= akumulator;
                akumulator = akumulator && !liczbaNależyPodzbiór[i];
            }
            lista.add(new ZbiórLiczbowy(liczbaNależyPodzbiór));
        }
        return lista;
    }

    @Override
    public int compareTo(ZbiórLiczbowy zbiór) {
        for (int i = 0; i < Math.max(liczbaNależy.length, zbiór.liczbaNależy.length); i++) {
            if (!zawiera(i) && zbiór.zawiera(i))
                return 1;
            if (zawiera(i) && !zbiór.zawiera(i))
                return -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("{");
        for (int i : this) {
            builder.append(i + ", ");
        }
        builder.append("}");
        return builder.toString();
    }

}
