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
    List<Integer> OneThreeFive = new ArrayList<>(6);
    List<Integer> TwoFourSix = new ArrayList<>(6);
    List<Integer> SixTwo = new ArrayList<>(6);
    List<Dice> aDices = diceComp.getaDices();

    FireworksTest() {
        setupIndices();
    }
    public void setupIndices() {
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
    public void allOnes() {
        diceComp.clear();
        aDices.get(0).setANumber(1);
        aDices.get(1).setANumber(1);
        aDices.get(2).setANumber(1);
        aDices.get(3).setANumber(1);
        aDices.get(4).setANumber(1);
        aDices.get(5).setANumber(1);
        //assertTrue(diceComp.isTutto());

    }

}
