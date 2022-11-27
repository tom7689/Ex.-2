package uzh.soco.group27.ex2.card;

import uzh.soco.group27.ex2.dice.DiceComp;
import uzh.soco.group27.ex2.game.Input;

public class PlusMinus implements CardMode{

    public boolean isTutto = false;

    @Override
    public int play(DiceComp pDiceComp, Input pIn) {
        while (true) {
            pDiceComp.roll();
            if (pDiceComp.isNull()) {
                System.out.println("You rolled a Null");
                return 0;
            }
            if (pDiceComp.isTutto()) {
                System.out.println("You have a Tutto");
                System.out.println(pDiceComp.getPoints());
                isTutto = true;
                int aValue = 1000;
                return -aValue;
            }
            pIn.selectDices(pDiceComp, this);
        }
    }

    @Override
    public boolean isTutto() {
        return false;
    }

    @Override
    public String toString() {
        return "Plus/Minus";
    }
}
