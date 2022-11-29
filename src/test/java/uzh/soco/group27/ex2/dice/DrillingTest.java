package uzh.soco.group27.ex2.testing.dice;

import org.junit.jupiter.api.Test;
import uzh.soco.group27.ex2.dice.Dice;
import uzh.soco.group27.ex2.dice.DiceComp;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
class DrillingTest {

    DiceComp diceComp = Dice.getDices();
    List<Dice> TripletsofOne = new ArrayList<>(3);
    List<Dice> TripletsofTwo = new ArrayList<>(3);
    List<Dice> TripletsofThree = new ArrayList<>(3);
    List<Dice> TripletsofFour = new ArrayList<>(3);
    List<Dice> TripletsofFive = new ArrayList<>(3);
    List<Dice> TripletsofSix = new ArrayList<>(3);
    Drillingtest() {
            setup();
        }
        public void setup() {
            for (int j=0; j<3; j++) {
                Dice aDice = new Dice;
                while (aDice.getPoints() != 1) {
                    aDice.roll()
                }
                TripletsofOne.add(aDice);
            }

            for (int j=0; j<3; j++) {
                Dice aDice = new Dice;
                while (aDice.getPoints() != 2) {
                    aDice.roll()
                }
                TripletsofTwo.add(aDice);
            }

            for (int j=0; j<3; j++) {
                Dice aDice = new Dice;
                while (aDice.getPoints() != 3) {
                    aDice.roll()
                }
                TripletsofThree.add(aDice);
            }

            for (int j=0; j<3; j++) {
                Dice aDice = new Dice;
                while (aDice.getPoints() != 4) {
                    aDice.roll()
                }
                TripletsofFour.add(aDice);
            }

            for (int j=0; j<3; j++) {
                Dice aDice = new Dice;
                while (aDice.getPoints() != 5) {
                    aDice.roll()
                }
                TripletsofFive.add(aDice);
            }

            for (int j=0; j<3; j++) {
                Dice aDice = new Dice;
                while (aDice.getPoints() != 6) {
                    aDice.roll()
                }
                TripletsofSix.add(aDice);
            }


        }
        @Test
        public void isDrillingOfOne() {
            assertEquals(Drilling(TripletsofOne).getPoints, 1000);
        }

    @Test
    public void isDrillingOfTwo() {
        assertEquals(Drilling(TripletsofTwo).getPoints, 200);
    }
    @Test
    public void isDrillingOfThree() {
        assertEquals(Drilling(TripletsofThree).getPoints, 300);
    }
    @Test
    public void isDrillingOfFour() {
        assertEquals(Drilling(TripletsofFour).getPoints, 400);
    }
    @Test
    public void isDrillingOfFive() {
        assertEquals(Drilling(TripletsofFive).getPoints, 500);
    }
    @Test
    public void isDrillingOfSix() {
        assertEquals(Drilling(TripletsofSix).getPoints, 600);
    }

}
