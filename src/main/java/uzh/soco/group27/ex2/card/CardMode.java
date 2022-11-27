package uzh.soco.group27.ex2.card;

import uzh.soco.group27.ex2.dice.DiceComp;
import uzh.soco.group27.ex2.game.Input;

public interface CardMode {
    int play(DiceComp pDiceComp, Input pIn);
    boolean isTutto();
    String toString();

}
