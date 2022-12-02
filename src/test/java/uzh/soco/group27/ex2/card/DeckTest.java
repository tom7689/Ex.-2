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
        assertEquals(CardMode.class, TestMode.getClass());
    }
    @Test
    public void pushNullTest(){
        CardMode TestCard = null;
        TestDeck.push(TestCard);

        assertNull(TestDeck.isEmpty());
    }
}
