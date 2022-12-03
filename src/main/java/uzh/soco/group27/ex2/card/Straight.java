package uzh.soco.group27.ex2.card;

import uzh.soco.group27.ex2.dice.Dice;
import uzh.soco.group27.ex2.dice.DiceComp;
import uzh.soco.group27.ex2.game.Input;

public class Straight implements CardMode{
    public boolean isTutto = false;

    @Override
    public void play(DiceComp pDiceComp, Input pIn) {
        while (true) {
            pDiceComp.roll();
            if (pDiceComp.isNoStraight()) {
                pDiceComp.setPointsToZero();
                System.out.println("No Straight possible");
                return;
            }
            pIn.selectDices(pDiceComp, this);
            printStraight(pDiceComp);
            if (pDiceComp.isStraight()) {
                System.out.println("You have a Straight");
                printStraight(pDiceComp);
                isTutto = true;
                pDiceComp.addBonusPoints(2000);
                System.out.println("You get 2000 points");
                return;
            }
        }
    }
    private void printStraight(DiceComp pDiceComp) {
        for (Dice dice : pDiceComp.getStraightList()) {
            if (dice == null) {
                System.out.print("  ");
            } else {
                System.out.print(dice+" ");
            }
        }
        System.out.print("\n");
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
        return "Straight";
    }
}
