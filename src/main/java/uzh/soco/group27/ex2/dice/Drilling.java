package uzh.soco.group27.ex2.dice;

import java.util.ArrayList;
import java.util.List;

public class Drilling extends DiceComp{
    private final List<Dice> aDices;
    private final int points;
    private final int aNumber;

    public Drilling(DiceComp pDiceComp, int pNumber) {
        aDices = new ArrayList<>(3);
        aDices.addAll(pDiceComp.getaDices());
        aNumber = pNumber;
        int[] drillingValues = {1000, 200, 300, 400, 500, 600,};
        points = drillingValues[pNumber];
    }
    public int getaNumber() {
        return aNumber;
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
