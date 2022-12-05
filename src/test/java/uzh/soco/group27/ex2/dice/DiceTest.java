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
    @Test
    public void checkNumber() {
        List<Dice> dices = diceComp.getaDices();
        dices.get(0).setANumber(1);
        assertEquals(1, dices.get(0).getPoints());
    }
    @Test
    public void setANumberAssertions(){
        List<Dice> dices = diceComp.getaDices();
        assertThrows(AssertionError.class,()->dices.get(0).setANumber(0));
        assertThrows(AssertionError.class,()->dices.get(0).setANumber(7));
    }
    @Test
    public void toStringTest(){
        Dice testDice = new Dice();
        testDice.setANumber(3);
        assertEquals(String.valueOf(testDice.getPoints()),"3");
    }
}