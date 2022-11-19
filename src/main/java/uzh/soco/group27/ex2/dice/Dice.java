package uzh.soco.group27.ex2.dice;

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
    private int aNumber;
    private int points = 0;

    public void roll() {
        aNumber = new Random().nextInt(6) + 1;
        System.out.print(aNumber + " ");
    }
    public int getPoints() {
        return aNumber;
    }
    @Override
    public void add(DiceRoll pDices) {

    }

    private void getResults() {
        if (aNumber == 1) {
            points = 100;
        } else if (aNumber == 5) {
            points = 50;
        }
    }
    @Override
    public DiceRoll getDice(int i) {
        return this;
    }

    @Override
    public String toString() {
        return " "+aNumber;
    }
}
