package uzh.soco.group27.ex2.card;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DeckTest {
    Deck TestDeck = new Deck();
    @Test
    public void IsEmptyTest(){
        for (int i =0; i <56;i++){
            TestDeck.draw();
        }
        assertTrue(TestDeck.isEmpty());
    }

    @Test
    public void IsNotEmptyTest(){
        assertFalse(TestDeck.isEmpty());
    }
    @Test
    public void drawTest(){
        CardMode TestMode = TestDeck.draw();
        Class<?> interfaceType = TestMode.getClass();
        assertTrue(interfaceType.isAssignableFrom(TestMode.getClass()));
    }
    @Test
    public void pushNullTest(){
        CardMode TestCard = null;
        assertThrows(AssertionError.class, ()->TestDeck.push(TestCard));
    }
    @Test
    public void isGettingEmpty() {
        for (int i = 0; i < 56; i++) {
            TestDeck.draw();
        }
        assertTrue(TestDeck.isEmpty());
        assertThrows(AssertionError.class, ()->TestDeck.draw());
    }
    @Test
    public void notGettingEmpty() {
        for (int i = 0; i < 1000; i++) {
            CardMode cardMode = TestDeck.draw();
            TestDeck.push(cardMode);
        }
        assertFalse(TestDeck.isEmpty());
    }
    @Test
    public void differentCardAfter56Cards() {
        CardMode cardMode1 = TestDeck.draw();
        TestDeck.push(cardMode1);
        for (int i = 0; i < 55; i++) {
            CardMode cardMode2 = TestDeck.draw();
            TestDeck.push(cardMode2);
        }
        CardMode cardMode3 = TestDeck.draw();
        assertNotSame(cardMode1.getClass(), cardMode3.getClass());
        TestDeck.push(cardMode3);
    }
}
