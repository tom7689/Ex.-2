package uzh.soco.group27.ex2.card;

import uzh.soco.group27.ex2.dice.DiceComp;
import uzh.soco.group27.ex2.game.Input;

public class Cloverleaf implements CardMode {
    private int aTutto = 0;

    @Override
    public int play(DiceComp pDiceComp, Input pIn) {
        while (true) {
            pDiceComp.roll();
            if (pDiceComp.isNull()) {
                System.out.println("You rolled a Null");
                return 0;
            }
            if (pDiceComp.isTutto()) {
                aTutto++;
                if (aTutto == 2) {
                    System.out.println("You won the Game");
                    return 0;
                }
                System.out.println("You have the first Tutto");
                System.out.println(pDiceComp.getPoints());
                return play(pDiceComp, pIn);
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
        return "Cloverleaf";
    }

}



