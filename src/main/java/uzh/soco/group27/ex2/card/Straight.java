package uzh.soco.group27.ex2.card;

import uzh.soco.group27.ex2.dice.DiceComp;
import uzh.soco.group27.ex2.game.Input;

public class Straight implements CardMode{
    public boolean isTutto = false;

    @Override
    public int play(DiceComp pDiceComp, Input pIn) {
        while (true) {
            pDiceComp.roll();
            if (pDiceComp.isNoStraight()) {
                System.out.println("You rolled a Null");
                return 0;
            }
            if (pDiceComp.isStraight()) {
                System.out.println("You have a Straight");
                System.out.println(pDiceComp.getPoints());
                isTutto = true;
                System.out.println("You get 2000 points");
                return 2000;
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
        return "Straight";
    }
}
