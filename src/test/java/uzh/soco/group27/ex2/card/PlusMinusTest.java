package uzh.soco.group27.ex2.card;

import org.junit.jupiter.api.Test;
import uzh.soco.group27.ex2.dice.Dice;
import uzh.soco.group27.ex2.dice.DiceComp;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PlusMinusTest {
    DiceComp diceComp = Dice.getDices();
    CardMode aCard = Card.get(21);
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
    PlusMinusTest() {
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
    public void isPlusMinusCard() {
        assertEquals(PlusMinus.class, aCard.getClass());
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
    public void allNumbersSelectingOneFive() {
        diceComp.clear();
        int i = 1;
        for (Dice dice : aDices) {
            dice.setANumber(i);
            i++;
        }
        assertFalse(diceComp.isNull());
        assertTrue(diceComp.split(OneFive, aCard));
        assertTrue(diceComp.isNull());
        assertFalse(diceComp.isTutto());
    }
    @Test
    public void allOnes() {
        diceComp.clear();
        aDices.get(0).setANumber(1);
        aDices.get(1).setANumber(1);
        aDices.get(2).setANumber(1);
        aDices.get(3).setANumber(1);
        aDices.get(4).setANumber(1);
        aDices.get(5).setANumber(1);
        assertTrue(diceComp.isTutto());
    }
    @Test
    public void Tutto1() {
        diceComp.clear();
        aDices.get(0).setANumber(1);
        aDices.get(1).setANumber(5);
        aDices.get(2).setANumber(2);
        aDices.get(3).setANumber(2);
        aDices.get(4).setANumber(2);
        aDices.get(5).setANumber(1);
        assertTrue(diceComp.isTutto());
    }
    @Test
    public void Tutto2() {
        diceComp.clear();
        aDices.get(0).setANumber(1);
        aDices.get(1).setANumber(3);
        aDices.get(2).setANumber(2);
        aDices.get(3).setANumber(2);
        aDices.get(4).setANumber(2);
        aDices.get(5).setANumber(1);
        assertFalse(diceComp.isTutto());
    }
    @Test
    public void PartlySelection1() {
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
        diceComp.addBonusPoints(1000);
        diceComp.setPlusMinusTutto();
        assertEquals(1000, diceComp.getPoints());
    }
}
