package uzh.soco.group27.ex2.game;

import uzh.soco.group27.ex2.card.CardMode;
import uzh.soco.group27.ex2.card.Deck;
import uzh.soco.group27.ex2.dice.Dice;
import uzh.soco.group27.ex2.dice.DiceComp;
import uzh.soco.group27.ex2.player.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GameModel {

    private final Deck deck;
    private final DiceComp diceComp;
    private final Input in;

    private final int scoreToReach;
    private final int numberOfPlayers;
    private List<Player> playerList;

    public GameModel() {
        deck = new Deck();
        diceComp = Dice.getDices();
        in = new Input();
        numberOfPlayers = in.getNumberOfPlayers();
        System.out.println("Number of Players: " + numberOfPlayers);
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
                System.out.println("----------------------------------------");
                System.out.println("Current player: " +player);
                diceComp.clear();
                diceComp.setPointsToZero();
                if (in.displayScore(playerList)) {
                    CardMode mode = deck.draw();
                    System.out.println("Card: "+mode);
                    mode.play(diceComp, in);
                    deck.push(mode);
                    while (mode.isTutto()) {
                        if (in.toContinue()) {
                            diceComp.clear();
                            mode.setTuttoBack();
                            mode = deck.draw();
                            System.out.println("Card: " + mode);
                            mode.play(diceComp, in);
                            deck.push(mode);
                        } else {
                            mode.setTuttoBack();
                        }
                    }
                }
                if (diceComp.plusMinusTutto()) {
                    diceComp.setPlusMinusTuttoBack();
                    plusMinusTutto(player);
                }
                player.setScore(diceComp.getPoints());
                if (checkPlayersScore() || diceComp.isCloverleaf()) {
                    System.out.println("You won");
                    for (Player player1 : playerList) {
                        System.out.println(player1.getName() + ": " + player1.getScore());
                    }
                    return;
                }
            }
        }
    }
    private void addPlayers() {
        playerList = new ArrayList<>(numberOfPlayers);
        for (int i = 1; i <= numberOfPlayers; i++) {
            while (true) {
                try {
                    String name = in.getPlayerName(i);
                    for (Player player : playerList) {
                        if (Objects.equals(player.getName(), name)) {
                            throw new IllegalArgumentException();
                        }
                    }
                    playerList.add(new Player(name));
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println("name already chosen or not valid");
                }
            }
        }
    }

    private void sortPlayers() {
        playerList.sort(Player.nameComparator);
        for (Player player : playerList) {
            System.out.println("Player "+ (playerList.indexOf(player)+1) +": "+player);
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
    private List<Player> sortPlayersScore() {
        List<Player> Ranking = new ArrayList<>(playerList);
        Ranking.sort(Player.scoreComparator);
        System.out.println("Current ranking before Plus/Minus:");
        for (Player player : Ranking) {
            System.out.println(player + ": " + player.getScore());
        }
        return Ranking;
    }
    private void plusMinusTutto(Player aPlayer) {
        List<Player> Ranking = sortPlayersScore();
        int maxScore = Ranking.get(0).getScore();
        for (Player player : Ranking) {
            if (player.getScore() == maxScore && !player.equals(aPlayer)) {
                player.setScore(-1000);
            }
        }
    }
}