package uzh.soco.group27.ex2.card;

import org.junit.jupiter.api.Test;
import uzh.soco.group27.ex2.card.CardStack;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class CardStackTest {
    CardStack TestStack = new CardStack();

    @Test
    public void IsEmptyTest(){
        assertTrue(TestStack.isEmpty());
    }

    @Test
    public void oneCardGetsPushed() {
        CardMode card1 = new Fireworks();
        TestStack.push(card1);
        assertEquals(card1, TestStack.pop());
        assertTrue(TestStack.isEmpty());
    }

    @Test
    public void twoCardsOfDifferentTypeGetPushed() {
        CardMode card1 = new X2();
        CardMode card2 = new Straight();
        TestStack.push(card1);
        TestStack.push(card2);
        assertEquals(card1, TestStack.pop());
        assertEquals(card2, TestStack.pop());
        assertTrue(TestStack.isEmpty());
    }

    @Test
    public void twoCardsOfSameTypeGetPushed() {
        CardMode card1 = new X2();
        CardMode card2 = new X2();
        TestStack.push(card1);
        TestStack.push(card2);
        assertEquals(card1, TestStack.pop());
        assertEquals(card2, TestStack.pop());
        assertTrue(TestStack.isEmpty());
    }

    @Test
    public void printCards() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        TestStack.push(new Bonus(100));
        TestStack.push(new X2());
        TestStack.print();
        assertEquals("1 Bonus 100\r\n2 X2\r\n", out.toString());
    }
}
