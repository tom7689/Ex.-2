package uzh.soco.group27.ex2.card;

import uzh.soco.group27.ex2.dice.DiceComp;
import uzh.soco.group27.ex2.game.Input;

public class Stop implements CardMode{

    @Override
    public void play(DiceComp pDiceComp, Input pIn) {
        pDiceComp.setPointsToZero();
    }

    @Override
    public boolean isTutto() {
        return false;
    }

    @Override
    public void setTuttoBack() {}

    @Override
    public String toString() {
        return "Stop";
    }
}
