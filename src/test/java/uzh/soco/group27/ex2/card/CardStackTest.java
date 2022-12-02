package uzh.soco.group27.ex2.card;

import org.junit.jupiter.api.Test;
import uzh.soco.group27.ex2.card.CardStack;

import static org.junit.jupiter.api.Assertions.*;

class CardStackTest {
    CardStack TestStack = new CardStack();

    @Test
    public void IsEmptyTest(){

        assertTrue(TestStack.isEmpty());
    }


}
