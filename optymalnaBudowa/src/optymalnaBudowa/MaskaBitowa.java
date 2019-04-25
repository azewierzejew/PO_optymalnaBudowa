package optymalnaBudowa;

import java.util.Arrays;

public class MaskaBitowa implements Comparable<MaskaBitowa> {

    private final boolean[] bity;

    private MaskaBitowa(boolean[] bity) {
        this.bity = bity;
    }

    public MaskaBitowa(int ilość) {
        bity = new boolean[ilość];
    }

    public boolean bit(int nr) {
        if (nr >= bity.length)
            return false;
        return bity[nr];
    }

    public boolean kolejnaMaska() {
        boolean akumulator = true;
        for (int i = 0; i < bity.length && akumulator; i++) {
            bity[i] ^= akumulator;
            akumulator = akumulator && !bity[i];
        }
        if (akumulator == true) { // przeszliśmy wszystkie bity
            return false;
        }
        return true;
    }

    public boolean kolejnaPodmaska(MaskaBitowa nadmaska) {
        boolean akumulator = true;
        for (int i = 0; i < bity.length && akumulator; i++) {
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

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = bity.length - 1; i >= 0; i--)
            builder.append(String.valueOf(bity[i] ? 1 : 0));
        return builder.toString();
    }

    @Override
    public int compareTo(MaskaBitowa maska) {
        for (int i = 0; i < Math.max(bity.length, maska.bity.length); i++) {
            if (!bity[i] && maska.bity[i])
                return 1;
            if (bity[i] && !maska.bity[i])
                return -1;
        }
        return 0;
    }

    public MaskaBitowa kopia() {
        return new MaskaBitowa(Arrays.copyOf(bity, bity.length));
    }

    public MaskaBitowa dopełnienie(MaskaBitowa nadmaska) {
        MaskaBitowa maska = new MaskaBitowa(bity.length);
        for (int i = 0; i < bity.length; i++) {

        }
    }

}
