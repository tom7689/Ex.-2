package uzh.soco.group27.ex2.card;

import org.junit.jupiter.api.Test;
import uzh.soco.group27.ex2.dice.Dice;
import uzh.soco.group27.ex2.dice.DiceComp;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FireworksTest {

    DiceComp diceComp = Dice.getDices();
    CardMode aCard = Card.get(1);

    List<Integer> allIndices = new ArrayList<>(6);
    List<Integer> OneFive = new ArrayList<>(3);
    List<Integer> OneThreeFive = new ArrayList<>(3);
    List<Integer> TwoFourSix = new ArrayList<>(3);
    List<Integer> SixTwo = new ArrayList<>(2);
    List<Integer> One = new ArrayList<>(1);
    List<Integer> Two = new ArrayList<>(1);
    List<Dice> aDices = diceComp.getaDices();

    FireworksTest() {
        setupIndices();
    }
    public void setupIndices() {
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

    }

    @Test
    public void isFireworksCard() {
        assertEquals(Fireworks.class, aCard.getClass());
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
        diceComp.setPointsToZero();
        int i = 1;
        for (Dice dice : aDices) {
            dice.setANumber(i);
            i++;
        }
        assertFalse(diceComp.isNull());
        assertTrue(diceComp.split(OneFive, aCard));
        assertTrue(diceComp.isNull());
        assertFalse(diceComp.isTutto());
        assertEquals(150, diceComp.getPoints());
    }
    @Test
    public void allOnes() {
        diceComp.clear();
        diceComp.setPointsToZero();
        aDices.get(0).setANumber(1);
        aDices.get(1).setANumber(1);
        aDices.get(2).setANumber(1);
        aDices.get(3).setANumber(1);
        aDices.get(4).setANumber(1);
        aDices.get(5).setANumber(1);
        assertTrue(diceComp.isTutto());
        assertEquals(2000, diceComp.getPoints());
    }
    @Test
    public void Tutto1() {
        diceComp.clear();
        diceComp.setPointsToZero();
        aDices.get(0).setANumber(1);
        aDices.get(1).setANumber(5);
        aDices.get(2).setANumber(2);
        aDices.get(3).setANumber(2);
        aDices.get(4).setANumber(2);
        aDices.get(5).setANumber(1);
        assertTrue(diceComp.isTutto());
        assertEquals(450, diceComp.getPoints());
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
    public void Null1() {
        diceComp.clear();
        aDices.get(0).setANumber(2);
        aDices.get(1).setANumber(3);
        aDices.get(2).setANumber(2);
        aDices.get(3).setANumber(4);
        aDices.get(4).setANumber(6);
        aDices.get(5).setANumber(6);
        assertTrue(diceComp.isNull());
    }
    @Test
    public void notAllDicesWithPointsSelected() {
        diceComp.clear();
        aDices.get(0).setANumber(1);
        aDices.get(1).setANumber(2);
        aDices.get(2).setANumber(2);
        aDices.get(3).setANumber(2);
        aDices.get(4).setANumber(5);
        aDices.get(5).setANumber(2);
        assertFalse(diceComp.split(One, aCard));
        assertFalse(diceComp.split(OneFive, aCard));
        assertFalse(diceComp.split(TwoFourSix, aCard));
    }
    @Test
    public void PartlySelection1() {
        diceComp.clear();
        diceComp.setPointsToZero();
        aDices.get(0).setANumber(2);
        aDices.get(1).setANumber(1);
        aDices.get(2).setANumber(3);
        aDices.get(3).setANumber(5);
        aDices.get(4).setANumber(6);
        aDices.get(5).setANumber(5);
        assertTrue(diceComp.split(TwoFourSix, aCard));
        assertEquals(200, diceComp.getPoints());
        aDices.get(0).setANumber(1);
        aDices.get(1).setANumber(2);
        aDices.get(2).setANumber(3);
        assertTrue(diceComp.split(One, aCard));
        assertEquals(300, diceComp.getPoints());
        aDices.get(0).setANumber(2);
        aDices.get(1).setANumber(5);
        assertTrue(diceComp.split(Two, aCard));
        assertEquals(350, diceComp.getPoints());
        aDices.get(0).setANumber(1);
        assertTrue(diceComp.isTutto());
        assertEquals(450, diceComp.getPoints());
        diceComp.clear();
        aDices.get(0).setANumber(6);
        aDices.get(1).setANumber(3);
        aDices.get(2).setANumber(6);
        aDices.get(3).setANumber(2);
        aDices.get(4).setANumber(6);
        aDices.get(5).setANumber(4);
        assertTrue(diceComp.split(OneThreeFive, aCard));
        assertEquals(1050, diceComp.getPoints());
        aDices.get(0).setANumber(2);
        aDices.get(1).setANumber(5);
        aDices.get(2).setANumber(3);
        assertTrue(diceComp.split(Two, aCard));
        assertEquals(1100, diceComp.getPoints());
        aDices.get(0).setANumber(1);
        aDices.get(1).setANumber(5);
        assertTrue(diceComp.isTutto());
        assertEquals(1250, diceComp.getPoints());
        diceComp.clear();
        aDices.get(0).setANumber(6);
        aDices.get(1).setANumber(3);
        aDices.get(2).setANumber(6);
        aDices.get(3).setANumber(2);
        aDices.get(4).setANumber(2);
        aDices.get(5).setANumber(4);
        assertTrue(diceComp.isNull());
    }

}
