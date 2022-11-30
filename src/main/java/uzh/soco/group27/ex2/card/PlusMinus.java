package uzh.soco.group27.ex2.card;

import uzh.soco.group27.ex2.dice.DiceComp;
import uzh.soco.group27.ex2.game.Input;

public class PlusMinus implements CardMode{

    public boolean isTutto = false;

    @Override
    public void play(DiceComp pDiceComp, Input pIn) {
        while (true) {
            pDiceComp.roll();
            if (pDiceComp.isNull()) {
                System.out.println("You rolled a Null");
                return;
            }
            if (pDiceComp.isTutto()) {
                System.out.println("You have a Tutto");
                isTutto = true;
                pDiceComp.addBonusPoints(1000);
                pDiceComp.setPlusMinusTutto();
                return;
            }
            pIn.selectDices(pDiceComp, this);
        }
    }

    @Override
    public boolean isTutto() {
        return isTutto;
    }

    @Override
    public void setTuttoBack() {
        this.isTutto = false;
    }

    @Override
    public String toString() {
        return "Plus/Minus";
    }
}
