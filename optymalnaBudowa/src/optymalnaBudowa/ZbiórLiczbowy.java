package optymalnaBudowa;

import java.util.ArrayList;
import java.util.Iterator;

public class ZbiórLiczbowy implements Iterable<Integer> {

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

    public ZbiórLiczbowy(int limit) {
        liczbaNależy = new boolean[limit];
        for (int i = 0; i < limit; i++) {
            liczbaNależy[i] = true;
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        ArrayList<Integer> liczby = new ArrayList<Integer>();
        for (int i = 0; i < liczbaNależy.length; i++) {
            if (liczbaNależy[i])
                liczby.add(i);
        }
        return liczby.iterator();
    }

    private class IteratorPodzbiorów implements Iterator<ZbiórLiczbowy> {

        private final int limit;

        private final boolean[] liczbaNależyZbiór;
        private final boolean[] liczbaNależyPodzbiór;

        public IteratorPodzbiorów(ZbiórLiczbowy zbiór) {
            int maximum = zbiór.maximum();
            limit = maximum + 1;
            liczbaNależyZbiór = new boolean[limit];
            liczbaNależyPodzbiór = new boolean[limit];
            for (int i : zbiór) {
                liczbaNależyZbiór[i] = true;
            }
        }

        @Override
        public boolean hasNext() {
            return !liczbaNależyZbiór.equals(liczbaNależyPodzbiór);
        }

        @Override
        public ZbiórLiczbowy next() {
            boolean akumulator = true;
            for (int i = 0; i < liczbaNależyZbiór.length && akumulator; i++) {
                if (!nadmaska.bity[i]) {
                    continue;
                }
                bity[i] ^= akumulator;
                akumulator = akumulator && !bity[i];
            }
            if (akumulator == true) { // przeszliśmy wszystkie bity
                return false;
            }
            return true;
        }

    }

    public Iterator<ZbiórLiczbowy> podzbiory() {
        return new IteratorPodzbiorów(this);
    }

}
