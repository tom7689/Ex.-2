package uzh.soco.group27.ex2.dice;

import java.util.ArrayList;
import java.util.List;

public class DiceComp implements DiceRoll {

    private final List<DiceRoll> aDices;
    private final int[] drillingValues = {1000, 200, 300, 400, 500, 600,};
    private final int[] results = new int[6];
    private int points;

    public DiceComp() {
        aDices = new ArrayList<>();
        for (int i : results) {
            results[i] = 0;
        }
    }
    public void roll() {
        for (DiceRoll dice : aDices) {
            dice.roll();
            results[dice.getPoints() - 1] += 1;
        }
        getResults();
    }
    private void getResults() {
        for (int i = 0; i < results.length; i++) {
            if (results[i] >= 3) {
                points += drillingValues[i];
                if (results[i] == 6) {
                    points += drillingValues[i];
                }
            }
        }
        if (results[0] < 3) {
            points += (results[0]) * 100;
        } else if (results[0] > 3 && results[0] < 6) {
            points += (results[0]-3) * 100;
        }
        if (results[4] < 3) {
            points += (results[4]) * 50;
        } else if (results[4] > 3 && results[4] < 6) {
            points += (results[4]-3) * 50;
        }
    }
    public int getPoints() {
        return points;
    }
    public boolean hasPoints() {
        getResults();
        return getPoints() != 0;
    }
    public DiceRoll getDice(int i) {
        return aDices.get(i);
    }
    public void add(DiceRoll pDices) {
        aDices.add(pDices);
    }
    public DiceComp split(List<Integer> selectedDices) {
        DiceComp aSplit = new DiceComp();
        for (int selDice : selectedDices) {
            aSplit.add(aDices.get(selDice));
        }
        if (aSplit.hasPoints()) {
            for (int selDice : selectedDices) {
                aSplit.add(aDices.get(selDice));
                aDices.remove(selDice);
            }
            return this;
        } else return null;
    }

    @Override
    public String toString() {
        for (DiceRoll dr: aDices) {
            return dr.toString();
        }
        return null;
    }
}
