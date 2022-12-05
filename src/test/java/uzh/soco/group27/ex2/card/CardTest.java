package uzh.soco.group27.ex2.card;

import org.junit.jupiter.api.Test;
import uzh.soco.group27.ex2.card.Card;
import uzh.soco.group27.ex2.card.Cloverleaf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CardTest {
    @Test
    public void getCardAssertions(){
        assertThrows(AssertionError.class,()-> Card.get(-1).getClass());
        assertThrows(AssertionError.class,()-> Card.get(100).getClass());

    }


    @Test
    public void isCloverleaf() {
        assertEquals(Cloverleaf.class, Card.get(0).getClass());
    }

    @Test
    public void isFireworks() {
        for (int i = 1; i < 6; i++) {
            assertEquals(Fireworks.class, Card.get(i).getClass());
        }
    }

    @Test
    public void isStop() {
        for (int i = 6; i < 16; i++) {
            assertEquals(Stop.class, Card.get(i).getClass());
        }
    }

    @Test
    public void isStraight() {
        for (int i = 16; i < 21; i++) {
            assertEquals(Straight.class, Card.get(i).getClass());
        }
    }

    @Test
    public void isPlusMinus() {
        for (int i = 21; i < 26; i++) {
            assertEquals(PlusMinus.class, Card.get(i).getClass());
        }
    }

    @Test
    public void isX2() {
        for (int i = 26; i < 31; i++) {
            assertEquals(X2.class, Card.get(i).getClass());
        }
    }

    @Test
    public void isBonus() {
        for (int i = 31; i < 56; i++) {
            assertEquals(Bonus.class, Card.get(i).getClass());
        }
    }
}
