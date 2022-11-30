package uzh.soco.group27.ex2.dice;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DiceTest {
    DiceComp diceComp = Dice.getDices();
    List<Dice> aDices = diceComp.getaDices();


    @Test
    public void hasSixDices() {
        assertEquals(6, diceComp.getLength());
    }

}