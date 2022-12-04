package uzh.soco.group27.ex2.game;

import org.junit.jupiter.api.Test;
import uzh.soco.group27.ex2.player.Player;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InputTest {

    @Test
    void selectDices() {
    }

    @Test
    void playerRolls() {
        InputStream in = new ByteArrayInputStream("R".getBytes());
        Input input = new Input(new InputAsker(in));
        assertTrue(input.toContinue());
    }

    @Test
    void playerEnds() {
        InputStream in = new ByteArrayInputStream("E".getBytes());
        Input input = new Input(new InputAsker(in));
        assertFalse(input.toContinue());
    }

    @Test
    void falseLetterThenEnds() {
        InputStream in = new ByteArrayInputStream("K\nE".getBytes());
        Input input = new Input(new InputAsker(in));
        assertFalse(input.toContinue());
    }

    @Test
    void twoPlayer() {
        InputStream in = new ByteArrayInputStream("2".getBytes());
        Input input = new Input(new InputAsker(in));
        assertEquals(2, input.getNumberOfPlayers());
    }

    @Test
    void threePlayer() {
        InputStream in = new ByteArrayInputStream("3".getBytes());
        Input input = new Input(new InputAsker(in));
        assertEquals(3, input.getNumberOfPlayers());
    }

    @Test
    void fourPlayer() {
        InputStream in = new ByteArrayInputStream("4".getBytes());
        Input input = new Input(new InputAsker(in));
        assertEquals(4, input.getNumberOfPlayers());
    }

    @Test
    void notEnoughPlayersThenThree() {
        InputStream in = new ByteArrayInputStream("1\n3".getBytes());
        Input input = new Input(new InputAsker(in));
        assertEquals(3, input.getNumberOfPlayers());
    }

    @Test
    void tooMuchPlayersThenTwo() {
        InputStream in = new ByteArrayInputStream("5\n2".getBytes());
        Input input = new Input(new InputAsker(in));
        assertEquals(2, input.getNumberOfPlayers());
    }

    @Test
    void getNameOfPlayerOne() {
        InputStream in = new ByteArrayInputStream("Max".getBytes());
        Input input = new Input(new InputAsker(in));
        assertEquals("Max", input.getPlayerName(1));
    }

    @Test
    void getNameOfPlayerTwo() {
        InputStream in = new ByteArrayInputStream("Moritz".getBytes());
        Input input = new Input(new InputAsker(in));
        assertEquals("Moritz", input.getPlayerName(2));
    }

    @Test
    void scoreToReach1000() {
        InputStream in = new ByteArrayInputStream("1000".getBytes());
        Input input = new Input(new InputAsker(in));
        assertEquals(1000, input.scoreToReach());
    }

    @Test
    void scoreToReach12345() {
        InputStream in = new ByteArrayInputStream("12345".getBytes());
        Input input = new Input(new InputAsker(in));
        assertEquals(12345, input.scoreToReach());
    }

    @Test
    void scoreToReach20000() {
        InputStream in = new ByteArrayInputStream("20000".getBytes());
        Input input = new Input(new InputAsker(in));
        assertEquals(20000, input.scoreToReach());
    }

    @Test
    void scoreToReachTooLowThen5000() {
        InputStream in = new ByteArrayInputStream("999\n5000".getBytes());
        Input input = new Input(new InputAsker(in));
        assertEquals(5000, input.scoreToReach());
    }

    @Test
    void scoreToReachTooHighThen5000() {
        InputStream in = new ByteArrayInputStream("20001\n5000".getBytes());
        Input input = new Input(new InputAsker(in));
        assertEquals(5000, input.scoreToReach());
    }

    @Test
    void displaysScoreThenRolls() {
        InputStream in = new ByteArrayInputStream("D\nR".getBytes());
        Input input = new Input(new InputAsker(in));
        List<Player> players = new ArrayList<>();
        players.add(new Player("Max"));
        players.add(new Player("Moritz"));
        assertTrue(input.displayScore(players));
    }
}