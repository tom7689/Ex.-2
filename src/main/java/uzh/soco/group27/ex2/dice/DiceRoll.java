package uzh.soco.group27.ex2.dice;

import java.util.List;

public interface DiceRoll {
    void roll();
    int getPoints();
    void add(Dice pDice);
    int getLength();
    boolean split(List<Integer> pDices);

}
