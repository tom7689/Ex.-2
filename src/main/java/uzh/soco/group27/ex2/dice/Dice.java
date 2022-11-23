package uzh.soco.group27.ex2.dice;

import java.util.List;
import java.util.Random;

public class Dice implements DiceRoll{
    private static final DiceComp DICES = new DiceComp();

    static
    {
        for (int i = 1; i <= 6; i++) {
            DICES.add(new Dice());
        }
    }
    private Dice() {
    }
    public static DiceComp getDices() {
        return DICES;
    }
    private int aNumber = 0;

    public void roll() {
        aNumber = new Random().nextInt(6) + 1;
        getResults();
        System.out.print(aNumber + " ");
    }
    public int getPoints() {
        return aNumber;
    }
    @Override
    public void add(Dice pDice) {
    }

    @Override
    public int getLength() {
        return 1;
    }


    @Override
    public boolean split(List<Integer> pDices) {
        return false;
    }

    private void getResults() {
        int points = 0;
        if (aNumber == 1) {
            points = 100;
        } else if (aNumber == 5) {
            points = 50;
        }
    }
    @Override
    public String toString() {
        return ""+aNumber;
    }
}
