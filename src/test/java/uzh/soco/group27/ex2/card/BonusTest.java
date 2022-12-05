package uzh.soco.group27.ex2.card;

import org.junit.jupiter.api.Test;
import uzh.soco.group27.ex2.dice.Dice;
import uzh.soco.group27.ex2.dice.DiceComp;
import uzh.soco.group27.ex2.game.Input;
import uzh.soco.group27.ex2.game.InputAsker;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BonusTest {
    DiceComp diceComp = Dice.getDices();
    CardMode aCard = Card.get(55);

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

    @Test
    public void one1() {
        diceComp.setPointsToZero();
        List<Integer> i =  new ArrayList<>();
        i.add(0);
        diceComp.clear();
        aDices.get(0).setANumber(1);
        diceComp.split(i, new Bonus(100));
        assertEquals(100, diceComp.getPoints());
    }

    @Test
    public void tow1() {
        diceComp.setPointsToZero();
        List<Integer> i =  new ArrayList<>();
        i.add(0);
        i.add(2);
        diceComp.clear();
        aDices.get(0).setANumber(1);
        aDices.get(2).setANumber(1);
        diceComp.split(i, new Bonus(100));
        assertEquals(200, diceComp.getPoints());
    }

    @Test
    public void one1One5() {
        diceComp.setPointsToZero();
        List<Integer> i =  new ArrayList<>();
        i.add(0);
        i.add(2);
        diceComp.clear();
        aDices.get(0).setANumber(1);
        aDices.get(2).setANumber(5);
        diceComp.split(i, new Bonus(100));
        assertEquals(150, diceComp.getPoints());
    }

    @Test
    public void one5() {
        diceComp.setPointsToZero();
        List<Integer> i =  new ArrayList<>();
        i.add(0);
        diceComp.clear();
        aDices.get(0).setANumber(5);
        diceComp.split(i, new Bonus(100));
        assertEquals(50, diceComp.getPoints());
    }

    @Test
    public void drilling() {
        diceComp.setPointsToZero();
        List<Integer> i =  new ArrayList<>();
        i.add(0);
        i.add(1);
        i.add(2);
        diceComp.clear();
        aDices.get(0).setANumber(1);
        aDices.get(1).setANumber(1);
        aDices.get(2).setANumber(1);
        diceComp.split(i, new Bonus(100));
        assertEquals(1000, diceComp.getPoints());
    }

    @Test
    public void add100Bonus() {
        diceComp.setPointsToZero();
        diceComp.addBonusPoints(100);
        assertEquals(100, diceComp.getPoints());
    }

    @Test
    public void playerDoesNotContinue() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Bonus bonus = new Bonus(100);
        InputStream in = new ByteArrayInputStream("E".getBytes());
        Input input = new Input(new InputAsker(in));
        diceComp.setPointsToZero();
        bonus.play(diceComp, input);
        assertEquals("Press (R)oll or (E)nd your turn\r\n" +
                "Points saved: 0\r\n", out.toString());
    }
}
