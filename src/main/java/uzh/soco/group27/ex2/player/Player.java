package uzh.soco.group27.ex2.player;

import javax.smartcardio.Card;

public class Player implements Players {
    private int score =0;
    private String name;
    public Player(String name){
        this.name = name;

    }

    @Override
    public Card drawCard() {
        return null;
    }

    @Override
    public int rollDice() {
        return 0;
    }

    @Override
    public int getScore() {
        return score;
    }

    @Override
    public void chooseDice() {

    }
}
