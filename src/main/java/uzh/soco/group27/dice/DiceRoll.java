package uzh.soco.group27.dice;

public interface DiceRoll {
    void roll();
    int getPoints();
    void add(DiceRoll pDices);
    DiceRoll getDice(int i);
}
