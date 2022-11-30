package uzh.soco.group27.ex2.card;

import org.junit.jupiter.api.Test;
import uzh.soco.group27.ex2.dice.Dice;
import uzh.soco.group27.ex2.dice.DiceComp;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BonusTest {
    DiceComp diceComp = Dice.getDices();
    CardMode aCard = Card.get(56);

    List<Integer> allIndices = new ArrayList<>(6);
    List<Integer> OneThreeFive = new ArrayList<>(6);
    List<Integer> TwoFourSix = new ArrayList<>(6);
    List<Integer> SixTwo = new ArrayList<>(6);
    List<Dice> aDices = diceComp.getaDices();
    BonusTest() {
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
    }

    @Test
    public void isBonusCard() {
        assertEquals(Bonus.class, aCard.getClass());
    }

    @Test
    public void isNull(){
        diceComp.clear();
        aDices.get(0).setANumber(2);
        aDices.get(1).setANumber(2);
        aDices.get(2).setANumber(4);
        aDices.get(3).setANumber(4);
        aDices.get(4).setANumber(6);
        aDices.get(5).setANumber(6);
        assertTrue(diceComp.isNull());
    }


}
