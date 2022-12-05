package uzh.soco.group27.ex2.card;

import org.junit.jupiter.api.Test;
import uzh.soco.group27.ex2.dice.Dice;
import uzh.soco.group27.ex2.dice.DiceComp;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StraightTest {
    DiceComp diceComp = Dice.getDices();
    CardMode aCard = Card.get(16);


    List<Integer> allIndices = new ArrayList<>(6);
    List<Integer> OneThreeFive = new ArrayList<>(6);
    List<Integer> TwoFourSix = new ArrayList<>(6);

    List<Integer> OneTwoThreeFiveSix = new ArrayList<>(6);
    List<Integer> SixTwo = new ArrayList<>(6);
    List<Integer> One = new ArrayList<>(6);
    List<Integer> Two = new ArrayList<>(6);
    List<Integer> Three = new ArrayList<>(6);
    List<Dice> aDices = diceComp.getaDices();
    StraightTest() {
        setup();
    }
    public void setup() {
        for (int j=0; j<6; j++) {
            allIndices.add(j);
        }
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
    public void allNumbersSet() {
        diceComp.clear();
        int i = 1;
        for (Dice dice : aDices) {
            dice.setANumber(i);
            i++;
        }
        assertEquals(1, aDices.get(0).getPoints());
        assertEquals(2, aDices.get(1).getPoints());
        assertEquals(3, aDices.get(2).getPoints());
        assertEquals(4, aDices.get(3).getPoints());
        assertEquals(5, aDices.get(4).getPoints());
        assertEquals(6, aDices.get(5).getPoints());
    }
    @Test
    public void isStraightCard() {
        assertEquals(Straight.class, aCard.getClass());
    }
    @Test
    public void allNumbers() {
        diceComp.clear();
        int i = 1;
        for (Dice dice : aDices) {
            dice.setANumber(i);
            i++;
        }
        diceComp.split(allIndices, aCard);
        assertTrue(diceComp.isStraight());
    }
    @Test
    public void allNumbersPartlySelecting() {
        diceComp.clear();
        int i = 1;
        for (Dice dice : aDices) {
            dice.setANumber(i);
            i++;
        }
        diceComp.split(OneThreeFive, aCard);
        assertFalse(diceComp.isStraight());
        assertFalse(diceComp.isNoStraight());
    }
    @Test
    public void setNumbers135() {
        diceComp.clear();
        aDices.get(0).setANumber(1);
        aDices.get(1).setANumber(1);
        aDices.get(2).setANumber(2);
        aDices.get(3).setANumber(1);
        aDices.get(4).setANumber(3);
        aDices.get(5).setANumber(1);
        assertEquals(1, aDices.get(0).getPoints());
        assertEquals(1, aDices.get(1).getPoints());
        assertEquals(2, aDices.get(2).getPoints());
        assertEquals(1, aDices.get(3).getPoints());
        assertEquals(3, aDices.get(4).getPoints());
        assertEquals(1, aDices.get(5).getPoints());

        diceComp.split(OneThreeFive, aCard);
        aDices.get(0).setANumber(1);
        aDices.get(1).setANumber(1);
        aDices.get(2).setANumber(1);
        assertTrue(diceComp.isNoStraight());
        assertFalse(diceComp.isStraight());
    }
    @Test
    public void partlySelectingStraight() {
        diceComp.clear();
        aDices.get(0).setANumber(6);
        aDices.get(1).setANumber(2);
        aDices.get(2).setANumber(2);
        aDices.get(3).setANumber(1);
        aDices.get(4).setANumber(3);
        aDices.get(5).setANumber(1);
        diceComp.split(SixTwo, aCard);
        aDices.get(0).setANumber(1);
        aDices.get(1).setANumber(3);
        aDices.get(2).setANumber(1);
        aDices.get(3).setANumber(1);
        diceComp.split(Two, aCard);
        aDices.get(0).setANumber(4);
        aDices.get(1).setANumber(1);
        aDices.get(2).setANumber(1);
        diceComp.split(One, aCard);
        aDices.get(0).setANumber(1);
        aDices.get(1).setANumber(5);
        diceComp.split(Two, aCard);
        aDices.get(0).setANumber(6);
        diceComp.split(One, aCard);
        assertTrue(diceComp.isStraight());
    }
    @Test
    public void partlySelectingStraight2() {
        diceComp.clear();
        aDices.get(0).setANumber(4);
        aDices.get(1).setANumber(2);
        aDices.get(2).setANumber(6);
        aDices.get(3).setANumber(6);
        aDices.get(4).setANumber(5);
        aDices.get(5).setANumber(1);
        diceComp.split(OneTwoThreeFiveSix, aCard);
        aDices.get(0).setANumber(3);
        diceComp.split(One, aCard);
        assertTrue(diceComp.isStraight());
    }
    @Test
    public void FalseSplit() {
        diceComp.clear();
        aDices.get(0).setANumber(2);
        aDices.get(1).setANumber(2);
        aDices.get(2).setANumber(6);
        aDices.get(3).setANumber(6);
        aDices.get(4).setANumber(5);
        aDices.get(5).setANumber(2);
        assertFalse(diceComp.split(OneTwoThreeFiveSix, aCard));
    }
    @Test
    public void PlaceAlreadyChosen() {
        diceComp.clear();
        aDices.get(0).setANumber(2);
        aDices.get(1).setANumber(1);
        aDices.get(2).setANumber(6);
        aDices.get(3).setANumber(6);
        aDices.get(4).setANumber(5);
        aDices.get(5).setANumber(4);
        diceComp.split(One, aCard);
        aDices.get(0).setANumber(2);
        aDices.get(1).setANumber(1);
        aDices.get(2).setANumber(6);
        aDices.get(3).setANumber(6);
        aDices.get(4).setANumber(5);
        assertFalse(diceComp.split(One, aCard));
    }
    @Test
    public void printStraightList() {
        diceComp.clear();
        aDices.get(0).setANumber(2);
        aDices.get(1).setANumber(2);
        aDices.get(2).setANumber(6);
        aDices.get(3).setANumber(6);
        aDices.get(4).setANumber(5);
        aDices.get(5).setANumber(1);
        assertTrue(diceComp.split(TwoFourSix, aCard));
        List<Dice> straightList = diceComp.getStraightList();
        assertEquals(6, straightList.size());
    }
}
