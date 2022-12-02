package uzh.soco.group27.ex2.card;

import org.junit.jupiter.api.Test;
import uzh.soco.group27.ex2.dice.Dice;
import uzh.soco.group27.ex2.dice.DiceComp;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CloverleafTest {
    DiceComp diceComp = Dice.getDices();
    CardMode aCard = Card.get(0);
    List<Integer> allIndices = new ArrayList<>(6);
    List<Integer> OneFive = new ArrayList<>(3);
    List<Integer> OneThreeFive = new ArrayList<>(6);
    List<Integer> TwoFourSix = new ArrayList<>(6);
    List<Integer> OneTwoThreeFiveSix = new ArrayList<>(6);
    List<Integer> SixTwo = new ArrayList<>(6);
    List<Integer> One = new ArrayList<>(6);
    List<Integer> Two = new ArrayList<>(6);
    List<Integer> Three = new ArrayList<>(6);
    List<Dice> aDices = diceComp.getaDices();
    CloverleafTest() {
        setup();
    }
    public void setup() {
        for (int j=0; j<6; j++) {
            allIndices.add(j);
        }
        OneFive.add(0);
        OneFive.add(4);
        for (int j=0; j<6; j+=2) {
            OneThreeFive.add(j);
        }
        for (int j=1; j<6; j+=2) {
            TwoFourSix.add(j);
        }
        SixTwo.add(5);
        SixTwo.add(1);
        One.add(0);
        Two.add(1);
        Three.add(2);
        OneTwoThreeFiveSix.add(0);
        OneTwoThreeFiveSix.add(1);
        OneTwoThreeFiveSix.add(2);
        OneTwoThreeFiveSix.add(4);
        OneTwoThreeFiveSix.add(5);
    }

    @Test
    public void isCloverleafCard() {
        assertEquals(Cloverleaf.class, aCard.getClass());
    }
    @Test
    public void allNumbers() {
        diceComp.clear();
        int i = 1;
        for (Dice dice : aDices) {
            dice.setANumber(i);
            i++;
        }
        assertFalse(diceComp.split(allIndices, aCard));
    }
    @Test
    public void twoTimesTutto() {
        diceComp.clear();
        diceComp.setPointsToZero();
        aDices.get(0).setANumber(2);
        aDices.get(1).setANumber(1);
        aDices.get(2).setANumber(3);
        aDices.get(3).setANumber(5);
        aDices.get(4).setANumber(1);
        aDices.get(5).setANumber(5);
        assertTrue(diceComp.split(TwoFourSix, aCard));
        aDices.get(0).setANumber(5);
        aDices.get(1).setANumber(2);
        aDices.get(2).setANumber(5);
        assertTrue(diceComp.split(One, aCard));
        aDices.get(0).setANumber(2);
        aDices.get(1).setANumber(5);
        assertTrue(diceComp.split(Two, aCard));
        aDices.get(0).setANumber(1);
        assertTrue(diceComp.isTutto());
        diceComp.setPointsToZero();
        diceComp.setCloverleaf();
        assertEquals(0, diceComp.getPoints());

        diceComp.clear();
        diceComp.setPointsToZero();
        aDices.get(0).setANumber(2);
        aDices.get(1).setANumber(1);
        aDices.get(2).setANumber(3);
        aDices.get(3).setANumber(5);
        aDices.get(4).setANumber(1);
        aDices.get(5).setANumber(5);
        assertTrue(diceComp.split(TwoFourSix, aCard));
        aDices.get(0).setANumber(5);
        aDices.get(1).setANumber(2);
        aDices.get(2).setANumber(5);
        assertTrue(diceComp.split(One, aCard));
        aDices.get(0).setANumber(2);
        aDices.get(1).setANumber(5);
        assertTrue(diceComp.split(Two, aCard));
        aDices.get(0).setANumber(1);
        assertTrue(diceComp.isTutto());
        diceComp.setPointsToZero();
        diceComp.setCloverleaf();
        assertEquals(0, diceComp.getPoints());
        assertTrue(diceComp.isCloverleaf());
    }
}
