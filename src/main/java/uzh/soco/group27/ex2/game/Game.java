package uzh.soco.group27.ex2.game;

import uzh.soco.group27.ex2.dice.Dice;
import uzh.soco.group27.ex2.dice.DiceComp;

public class Game {
    public static void main(String[] args) {
        DiceComp diceComp = Dice.getDices();
        Input in = new Input();
        while (true) {
            if (in.toContinue()) {
                diceComp.roll();
                if (diceComp.isNull()) {
                    System.out.println("You rolled a Null");
                    return;
                }
                if (diceComp.isTutto()) {
                    System.out.println("You have a Tutto");
                    return;
                }
                in.selectDices(diceComp);
                System.out.println("Points for this turn: " + diceComp.getPoints());
            } else {
                return;
            }
        }
    }
}
