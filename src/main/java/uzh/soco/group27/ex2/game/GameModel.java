package uzh.soco.group27.ex2.game;

import uzh.soco.group27.ex2.card.CardMode;
import uzh.soco.group27.ex2.card.Deck;
import uzh.soco.group27.ex2.dice.Dice;
import uzh.soco.group27.ex2.dice.DiceComp;
import uzh.soco.group27.ex2.player.Player;

import java.util.ArrayList;
import java.util.List;

public class GameModel {

    private final Deck deck;
    private final DiceComp diceComp;
    private final Input in;

    private final int scoreToReach;
    private final int amountOfPlayers;
    private List<Player> playerList;

    public GameModel() {
        deck = new Deck();
        diceComp = Dice.getDices();
        in = new Input();
        amountOfPlayers = in.getAmountOfPlayers();
        System.out.println(amountOfPlayers);
        addPlayers();
        sortPlayers();
        scoreToReach = in.scoreToReach();
        }

    public void start() {
        Tutto();
    }
    private void Tutto() {
        while (true) {
            for (Player player : playerList) {
                System.out.println("Current player: " +player);
                diceComp.clear();
                if (in.displayScore(player)) {
                    CardMode mode = deck.draw();
                    System.out.println("Card: "+mode);
                    int tempScore = 0;
                    tempScore += mode.play(diceComp, in);
                    while (mode.isTutto() && in.toContinue()) {
                        mode = deck.draw();
                        System.out.println(mode);
                        int addition = mode.play(diceComp, in);
                        if (addition > 0) {
                            tempScore += addition;
                        }
                        if (addition < 0) {
                            plusMinusTutto(addition);
                            tempScore -= addition;
                        } else {
                            tempScore = 0;
                        }
                    }
                    player.setScore(tempScore);
                    if (checkPlayersScore()) {
                        System.out.println("You won");
                        for (Player player1 : playerList) {
                            System.out.println(player1.getName() + ": " + player1.getScore());
                        }
                        return;
                    }
                }
            }
        }
    }
    private void addPlayers() {
    playerList = new ArrayList<>(amountOfPlayers);
    for (int i = 1; i <= amountOfPlayers; i++) {
        playerList.add(new Player(in.getPlayerName(i)));
        }
    }
    private void sortPlayers() {
        playerList.sort(Player.nameComparator);
        for (Player player : playerList) {
            System.out.println("Player "+(int)(playerList.indexOf(player)+1)+": "+player);
        }
    }
    private boolean checkPlayersScore() {
        for (Player player : playerList) {
            if (player.getScore() >= scoreToReach) {
                return true;
            }
        }
        return false;
    }
    private void sortPlayersScore() {
        playerList.sort(Player.scoreComparator);
        for (Player player : playerList) {
            System.out.println(player);
        }
    }
    private void plusMinusTutto(int malus) {
        sortPlayersScore();
        int maxScore = playerList.get(0).getScore();
        for (Player player : playerList) {
            if (player.getScore() == maxScore) {
                player.setScore(malus);
            }
        }
    }
}