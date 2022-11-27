package uzh.soco.group27.ex2.card;

import uzh.soco.group27.ex2.dice.DiceComp;
import uzh.soco.group27.ex2.game.Input;

public class Fireworks implements CardMode{

    @Override
    public int play(DiceComp pDiceComp, Input pIn) {
        while (true) {
            pDiceComp.roll();
            if (pDiceComp.isNull()) {
                System.out.println("You rolled a Null");
                return pDiceComp.getPoints();
            }
            if (pDiceComp.isTutto()) {
                System.out.println("You have a Tutto");
                System.out.println(pDiceComp.getPoints());
                return play(pDiceComp, pIn);
            }
            pIn.selectDices(pDiceComp, this);
            System.out.println("Points so far: " + pDiceComp.getPoints());
        }
    }

    @Override
    public boolean isTutto() {
        return false;
    }

    @Override
    public String toString() {
        return "Fireworks";
    }
}
