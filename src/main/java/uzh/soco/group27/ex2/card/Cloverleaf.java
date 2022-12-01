package uzh.soco.group27.ex2.card;

import uzh.soco.group27.ex2.dice.DiceComp;
import uzh.soco.group27.ex2.game.Input;

public class Cloverleaf implements CardMode {
    private int aTutto = 0;

    @Override
    public void play(DiceComp pDiceComp, Input pIn) {
        while (true) {
            pDiceComp.roll();
            if (pDiceComp.isNull()) {
                pDiceComp.setPointsToZero();
                System.out.println("You rolled a Null");
                return;
            }
            if (pDiceComp.isTutto()) {
                aTutto++;
                if (aTutto == 2) {
                    pDiceComp.setCloverleaf();
                    return;
                }
                System.out.println("You have the first Tutto");
                System.out.println(pDiceComp.getPoints());
                pDiceComp.clear();
                play(pDiceComp, pIn);
                return;
            }
            pIn.selectDices(pDiceComp, this);
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
        return "Cloverleaf";
    }

}



