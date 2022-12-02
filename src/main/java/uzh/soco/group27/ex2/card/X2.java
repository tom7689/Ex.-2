package uzh.soco.group27.ex2.card;

import uzh.soco.group27.ex2.dice.DiceComp;
import uzh.soco.group27.ex2.game.Input;

public class X2 implements CardMode{

    public boolean isTutto = false;

    @Override
    public void play(DiceComp pDiceComp, Input pIn) {
        while (true) {
            if (pIn.toContinue()) {
                pDiceComp.roll();
                if (pDiceComp.isNull()) {
                    pDiceComp.setPointsToZero();
                    System.out.println("You rolled a Null");
                    return;
                }
                if (pDiceComp.isTutto()) {
                    System.out.println("You have a Tutto");
                    System.out.println("Points you could save: " + (2*pDiceComp.getPoints()));
                    isTutto = true;
                    pDiceComp.addBonusPoints(pDiceComp.getPoints());
                    return;
                }
                pIn.selectDices(pDiceComp, this);
                System.out.println("Points you could save: " + pDiceComp.getPoints());
            } else {
                System.out.println("Points saved: " + pDiceComp.getPoints());
                return;
            }
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
        return "X2";
    }
}
