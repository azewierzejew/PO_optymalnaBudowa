package optymalnaBudowa;

public class MaskaBitowa {

    private boolean[] bity;

    public MaskaBitowa(int ilość) {
        bity = new boolean[ilość];
    }

    public boolean bit(int nr) {
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
            if (!nadmaska.bit(i)) {
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

}
