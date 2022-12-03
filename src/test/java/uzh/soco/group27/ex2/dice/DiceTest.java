package uzh.soco.group27.ex2.dice;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DiceTest {
    DiceComp diceComp = Dice.getDices();

    @Test
    public void hasSixDices() {
        diceComp.clear();
        assertEquals(6, diceComp.getLength());
    }

}