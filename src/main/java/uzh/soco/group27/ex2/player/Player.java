package uzh.soco.group27.ex2.player;

import uzh.soco.group27.ex2.card.Card;


public class Player {
    private int score =0;
    private String name;
    public Player(String name){
        this.name = name;
    }

    public Card drawCard() {
        return null;
    }
    public int rollDice() {
        return 0;
    }
    public int getScore() {
        return score;
    }

    public void chooseDice() {

    }
}
