package uzh.soco.group27.ex2.card;

import uzh.soco.group27.ex2.dice.DiceComp;
import uzh.soco.group27.ex2.game.Input;

public class Stop implements CardMode{

    @Override
    public int play(DiceComp pDiceComp, Input pIn) {
        return 0;
    }

    @Override
    public boolean isTutto() {
        return false;
    }

    @Override
    public String toString() {
        return "Stop";
    }
}
