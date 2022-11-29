package uzh.soco.group27.ex2.dice;

import java.util.ArrayList;
import java.util.List;

public class Drilling{
    private final List<Dice> aDices;
    private final int points;

    public Drilling(List<Dice> pDices, int pNumber) {
        aDices = new ArrayList<>(3);
        aDices.addAll(pDices);
        int[] drillingValues = {1000, 200, 300, 400, 500, 600,};
        points = drillingValues[pNumber];
    }
    public int getPoints() {
        return points;
    }
    public List<Dice> getaDices() {
        return aDices;
    }

    @Override
    public String toString() {
        return ""+points;
    }
}
