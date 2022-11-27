package uzh.soco.group27.ex2.dice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiceTest {
    DiceComp diceComp = Dice.getDices();

    @Test
    public void hasSixDices() {
        assertEquals(6, diceComp.getLength());
    }

}