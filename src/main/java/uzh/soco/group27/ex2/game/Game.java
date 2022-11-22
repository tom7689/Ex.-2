package uzh.soco.group27.ex2.game;

import uzh.soco.group27.ex2.card.CardStack;
import uzh.soco.group27.ex2.dice.Dice;
import uzh.soco.group27.ex2.dice.DiceComp;

import java.util.List;

public class Game {
    public static void main(String[] args) {

        DiceComp diceComp = Dice.getDices();
        diceComp.roll();
        System.out.println("Points: " + diceComp.getPoints());

        Input in = new Input();
        List<Integer> selectedDices = in.selectDices(diceComp);
        DiceComp split = diceComp.split(selectedDices);
        for (int i : selectedDices) {
            System.out.print(i + " ");
        }
    }
}
