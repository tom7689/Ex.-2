package uzh.soco.group27.ex2.card;

import org.junit.jupiter.api.Test;
import uzh.soco.group27.ex2.dice.Dice;
import uzh.soco.group27.ex2.dice.DiceComp;
import uzh.soco.group27.ex2.game.Input;
import uzh.soco.group27.ex2.game.InputAsker;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class X2Test {
    DiceComp diceComp = Dice.getDices();
    CardMode aCard = Card.get(26);
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
    Input in = new Input(new InputAsker(System.in));
    X2Test() {
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
    public void isNull(){
    }
    @Test
    public void isx2Card() {
        assertEquals(X2.class, aCard.getClass());
    }
    @Test
    public void play1() {
        InputStream inputStream = new ByteArrayInputStream("R".getBytes());
        System.setIn(inputStream);
        //aCard.play(diceComp, in);
        //in.toContinue();
    }
    @Test
    public void PointTest() {
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
        diceComp.addBonusPoints(diceComp.getPoints());
        assertEquals(800, diceComp.getPoints());
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
