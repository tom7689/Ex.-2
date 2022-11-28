package uzh.soco.group27.ex2.card;

import uzh.soco.group27.ex2.dice.DiceComp;
import uzh.soco.group27.ex2.game.Input;

public class X2 implements CardMode{

    public boolean isTutto = false;

    @Override
    public int play(DiceComp pDiceComp, Input pIn) {
        while (true) {
            if (pIn.toContinue()) {
                pDiceComp.roll();
                if (pDiceComp.isNull()) {
                    System.out.println("You rolled a Null");
                    return 0;
                }
                if (pDiceComp.isTutto()) {
                    System.out.println("You have a Tutto");
                    System.out.println("Points you could save: " + pDiceComp.getPoints());
                    isTutto = true;
                    return 2*pDiceComp.getPoints();
                }
                pIn.selectDices(pDiceComp, this);
                System.out.println("Points you could save: " + pDiceComp.getPoints());
            } else {
                System.out.println("Points saved: " + pDiceComp.getPoints());
                return pDiceComp.getPoints();
            }
        }
    }

    @Override
    public boolean isTutto() {
        return isTutto;
    }

    @Override
    public String toString() {
        return "X2";
    }
}
