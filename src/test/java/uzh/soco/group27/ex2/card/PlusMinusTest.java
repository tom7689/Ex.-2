package uzh.soco.group27.ex2.card;

import org.junit.jupiter.api.Test;
import uzh.soco.group27.ex2.dice.Dice;
import uzh.soco.group27.ex2.dice.DiceComp;
import uzh.soco.group27.ex2.game.GameModel;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlusMinusTest {
    DiceComp diceComp = Dice.getDices();
    CardMode aCard = Card.get(21);

    List<Integer> allIndices = new ArrayList<>(6);
    List<Integer> OneThreeFive = new ArrayList<>(6);
    List<Integer> TwoFourSix = new ArrayList<>(6);
    List<Integer> SixTwo = new ArrayList<>(6);
    List<Dice> aDices = diceComp.getaDices();
    PlusMinusTest() {
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
    public void isPlusMinusCard() {
        assertEquals(PlusMinus.class, aCard.getClass());
    }

}
