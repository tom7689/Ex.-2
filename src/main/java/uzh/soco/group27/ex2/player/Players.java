package uzh.soco.group27.ex2.player;

import javax.smartcardio.Card;

public interface Players {
    Card drawCard();
    int rollDice();
    int getScore();
    void chooseDice();


}
