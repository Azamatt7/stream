package peaksoft.dice;

import peaksoft.Sides;


public class User implements Sides {
    @Override
    public int dice() {
        int d = Sides.super.dice();
        int e = Sides.super.dice();
        return d + e;
    }

}
