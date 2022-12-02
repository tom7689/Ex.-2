package uzh.soco.group27.ex2.dice;

import org.junit.jupiter.api.Test;
import uzh.soco.group27.ex2.card.Bonus;
import uzh.soco.group27.ex2.card.Card;
import uzh.soco.group27.ex2.card.CardMode;
import uzh.soco.group27.ex2.dice.Dice;
import uzh.soco.group27.ex2.dice.DiceComp;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DiceCompTest {
    DiceComp diceComp = Dice.getDices();

    List<Dice> aDices = diceComp.getaDices();
    private DiceComp setup(int i,int j, int k,int l, int m, int n){
		diceComp.clear();
        aDices.get(0).setANumber(i);
        aDices.get(1).setANumber(j);
        aDices.get(2).setANumber(k);
        aDices.get(3).setANumber(l);
        aDices.get(4).setANumber(m);
        aDices.get(5).setANumber(n);
		return diceComp;
	}
    @Test
    public void isNull(){
        setup(2,2,4,4,6,6);

        assertTrue(diceComp.isNull());
    }
    @Test
    public void rollTest(){
        setup(1,1,1,1,1,1);
        DiceComp diceComp1 = new DiceComp();
        diceComp1.roll();
        assertNotEquals(diceComp,diceComp1);
    }
    @Test
    public void isNoTuttoTest(){
        setup(1,1,2,3,3,3);
        assertFalse(diceComp.isTutto());
    }
    @Test
    public void isNoStraightTest(){
        setup(1,1,2,3,4,5);
        assertFalse(diceComp.isStraight());
    }
}
