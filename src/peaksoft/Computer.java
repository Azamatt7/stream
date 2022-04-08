package peaksoft;

public class Computer implements Sides {
    @Override
    public int dice() {
        int d = Sides.super.dice();
        int e = Sides.super.dice();
        return d + e;
    }
}
