package uzh.soco.group27.ex2.dice;

import java.util.Random;

public class Dice {
    private static final DiceComp DICES = new DiceComp();

    static
    {
        for (int i = 1; i <= 6; i++) {
            DICES.add(new Dice());
        }
    }
    Dice() {
    }
    public static DiceComp getDices() {
        return DICES;
    }
    private int aNumber;

    public void roll() {
        aNumber = new Random().nextInt(6) + 1;
        System.out.print(aNumber + " ");
    }
    public int getPoints() {
        return aNumber;
    }

    @Override
    public String toString() {
        return ""+aNumber;
    }

    public void setANumber(int i) {
        assert i>=1;
        assert i<=6;
        aNumber = i;
    }
}
