package uzh.soco.group27.ex2.card;

import uzh.soco.group27.ex2.dice.DiceComp;
import uzh.soco.group27.ex2.game.Input;

public class Fireworks implements CardMode{

    @Override
    public void play(DiceComp pDiceComp, Input pIn) {
        while (true) {
            pDiceComp.roll();
            if (pDiceComp.isNull()) {
                System.out.println("You rolled a Null");
                System.out.println("Points saved: " + pDiceComp.getPoints());
                return;
            }
            if (pDiceComp.isTutto()) {
                System.out.println("You have a Tutto");
                System.out.println("Points so far: " + pDiceComp.getPoints());
                pDiceComp.clear();
                play(pDiceComp, pIn);
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
    public void setTuttoBack() {}

    @Override
    public String toString() {
        return "Fireworks";
    }
}
