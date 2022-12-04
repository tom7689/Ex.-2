package uzh.soco.group27.ex2.game;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uzh.soco.group27.ex2.card.Bonus;
import uzh.soco.group27.ex2.dice.Dice;
import uzh.soco.group27.ex2.dice.DiceComp;
import uzh.soco.group27.ex2.player.Player;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InputTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream out = System.out;
    private final DiceComp dices = Dice.getDices();

    @BeforeEach
    public void setup() {
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    public void restore() {
        System.setOut(out);
    }

    @Test
    void selectSomeDices() {
        dices.clear();
        InputStream in = new ByteArrayInputStream("1,3".getBytes());
        Input input = new Input(new InputAsker(in));
        dices.getaDices().get(0).setANumber(1);
        dices.getaDices().get(2).setANumber(5);
        input.selectDices(dices, new Bonus(100));
        assertEquals("Enter dices (separated by comma) to select: \r\n", outputStream.toString());
    }

    @Test
    void selectADiceTwice() {
        dices.clear();
        InputStream in = new ByteArrayInputStream("1,1\n1".getBytes());
        Input input = new Input(new InputAsker(in));
        dices.getaDices().get(0).setANumber(1);
        dices.getaDices().get(2).setANumber(5);
        input.selectDices(dices, new Bonus(100));
        assertEquals("Enter dices (separated by comma) to select: \r\n" +
                "Index already chosen. Try again\r\n", outputStream.toString());
    }

    @Test
    void selectInvalidDice() {
        dices.clear();
        InputStream in = new ByteArrayInputStream("1\n3".getBytes());
        Input input = new Input(new InputAsker(in));
        dices.getaDices().get(0).setANumber(3);
        dices.getaDices().get(2).setANumber(5);
        input.selectDices(dices, new Bonus(100));
        assertEquals("Enter dices (separated by comma) to select: \r\n" +
                "split is not possible\r\n", outputStream.toString());
    }

    @Test
    void invalidIndex() {
        dices.clear();
        InputStream in = new ByteArrayInputStream("10\n1".getBytes());
        Input input = new Input(new InputAsker(in));
        dices.getaDices().get(0).setANumber(5);
        dices.getaDices().get(2).setANumber(5);
        input.selectDices(dices, new Bonus(100));
        assertEquals("Enter dices (separated by comma) to select: \r\n" +
                "Index is not valid or out of range\r\n", outputStream.toString());
    }

    @Test
    void playerRolls() {
        InputStream in = new ByteArrayInputStream("R".getBytes());
        Input input = new Input(new InputAsker(in));
        assertTrue(input.toContinue());
        assertEquals("Press (R)oll or (E)nd your turn\r\n", outputStream.toString());
    }

    @Test
    void playerEnds() {
        InputStream in = new ByteArrayInputStream("E".getBytes());
        Input input = new Input(new InputAsker(in));
        assertFalse(input.toContinue());
        assertEquals("Press (R)oll or (E)nd your turn\r\n", outputStream.toString());
    }

    @Test
    void falseLetterThenEnds() {
        InputStream in = new ByteArrayInputStream("K\nE".getBytes());
        Input input = new Input(new InputAsker(in));
        assertFalse(input.toContinue());
        assertEquals("Press (R)oll or (E)nd your turn\r\n" +
                "Press (R)oll or (E)nd your turn\r\n", outputStream.toString());
    }

    @Test
    void twoPlayer() {
        InputStream in = new ByteArrayInputStream("2".getBytes());
        Input input = new Input(new InputAsker(in));
        assertEquals(2, input.getNumberOfPlayers());
        assertEquals("Enter number of Players (2-4):\r\n", outputStream.toString());
    }

    @Test
    void threePlayer() {
        InputStream in = new ByteArrayInputStream("3".getBytes());
        Input input = new Input(new InputAsker(in));
        assertEquals(3, input.getNumberOfPlayers());
        assertEquals("Enter number of Players (2-4):\r\n", outputStream.toString());
    }

    @Test
    void fourPlayer() {
        InputStream in = new ByteArrayInputStream("4".getBytes());
        Input input = new Input(new InputAsker(in));
        assertEquals(4, input.getNumberOfPlayers());
        assertEquals("Enter number of Players (2-4):\r\n", outputStream.toString());
    }

    @Test
    void notEnoughPlayersThenThree() {
        InputStream in = new ByteArrayInputStream("1\n3".getBytes());
        Input input = new Input(new InputAsker(in));
        assertEquals(3, input.getNumberOfPlayers());
        assertEquals("Enter number of Players (2-4):\r\n" +
                "not in range\r\n", outputStream.toString());
    }

    @Test
    void tooMuchPlayersThenTwo() {
        InputStream in = new ByteArrayInputStream("5\n2".getBytes());
        Input input = new Input(new InputAsker(in));
        assertEquals(2, input.getNumberOfPlayers());
        assertEquals("Enter number of Players (2-4):\r\n" +
                "not in range\r\n", outputStream.toString());
    }

    @Test
    void noNumberGivenThenTwo() {
        InputStream in = new ByteArrayInputStream("\n2".getBytes());
        Input input = new Input(new InputAsker(in));
        assertEquals(2, input.getNumberOfPlayers());
        assertEquals("Enter number of Players (2-4):\r\n", outputStream.toString());
    }

    @Test
    void getNameOfPlayerOne() {
        InputStream in = new ByteArrayInputStream("Max".getBytes());
        Input input = new Input(new InputAsker(in));
        assertEquals("Max", input.getPlayerName(1));
        assertEquals("Enter name of Player 1:\r\n", outputStream.toString());
    }

    @Test
    void getNameOfPlayerTwo() {
        InputStream in = new ByteArrayInputStream("Moritz".getBytes());
        Input input = new Input(new InputAsker(in));
        assertEquals("Moritz", input.getPlayerName(2));
        assertEquals("Enter name of Player 2:\r\n", outputStream.toString());
    }

    @Test
    void noNameGivenThenMoritz() {
        InputStream in = new ByteArrayInputStream("\nMoritz".getBytes());
        Input input = new Input(new InputAsker(in));
        assertEquals("Moritz", input.getPlayerName(2));
        assertEquals("Enter name of Player 2:\r\n", outputStream.toString());
    }

    @Test
    void scoreToReach1000() {
        InputStream in = new ByteArrayInputStream("1000".getBytes());
        Input input = new Input(new InputAsker(in));
        assertEquals(1000, input.scoreToReach());
        assertEquals("Enter Score to reach (1000-20000):\r\n", outputStream.toString());
    }

    @Test
    void scoreToReach12345() {
        InputStream in = new ByteArrayInputStream("12345".getBytes());
        Input input = new Input(new InputAsker(in));
        assertEquals(12345, input.scoreToReach());
        assertEquals("Enter Score to reach (1000-20000):\r\n", outputStream.toString());
    }

    @Test
    void scoreToReach20000() {
        InputStream in = new ByteArrayInputStream("20000".getBytes());
        Input input = new Input(new InputAsker(in));
        assertEquals(20000, input.scoreToReach());
        assertEquals("Enter Score to reach (1000-20000):\r\n", outputStream.toString());
    }

    @Test
    void scoreToReachTooLowThen5000() {
        InputStream in = new ByteArrayInputStream("999\n5000".getBytes());
        Input input = new Input(new InputAsker(in));
        assertEquals(5000, input.scoreToReach());
        assertEquals("Enter Score to reach (1000-20000):\r\n" +
                "Score must be between 1000 and 20000\r\n", outputStream.toString());
    }

    @Test
    void scoreToReachTooHighThen5000() {
        InputStream in = new ByteArrayInputStream("20001\n5000".getBytes());
        Input input = new Input(new InputAsker(in));
        assertEquals(5000, input.scoreToReach());
        assertEquals("Enter Score to reach (1000-20000):\r\n" +
                "Score must be between 1000 and 20000\r\n", outputStream.toString());
    }

    @Test
    void scoreIsNotIntegerThen5000() {
        InputStream in = new ByteArrayInputStream("K\n5000".getBytes());
        Input input = new Input(new InputAsker(in));
        assertEquals(5000, input.scoreToReach());
        assertEquals("Enter Score to reach (1000-20000):\r\n", outputStream.toString());
    }

    @Test
    void displaysScoreThenRolls() {
        InputStream in = new ByteArrayInputStream("D\nR".getBytes());
        Input input = new Input(new InputAsker(in));
        List<Player> players = new ArrayList<>();
        players.add(new Player("Max"));
        players.add(new Player("Moritz"));
        assertTrue(input.displayScore(players));
        assertEquals("Press (R)oll or (D)isplay current scores\r\n" +
                "Max: 0\r\n" +
                "Moritz: 0\r\n" +
                "Press (R)oll to roll the dices\r\n", outputStream.toString());
    }
}