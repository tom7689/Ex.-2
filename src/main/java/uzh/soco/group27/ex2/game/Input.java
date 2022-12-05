package uzh.soco.group27.ex2.game;

import uzh.soco.group27.ex2.card.CardMode;
import uzh.soco.group27.ex2.dice.DiceComp;
import uzh.soco.group27.ex2.player.Player;

import java.util.ArrayList;
import java.util.List;

public class Input{
    private final InputAsker aInput;

    public Input (InputAsker pInput) {
        aInput = pInput;
    }

    public void selectDices(DiceComp pDiceComp, CardMode pCardMode) {
        List<Integer> indices = new ArrayList<>(6);
        System.out.println("Enter dices (separated by comma) to select: ");
        while (true) {
            String aLine = aInput.ask();
            try {
                assert aLine.length() <= pDiceComp.getLength()*2;
                while (!aLine.isEmpty()) {
                    if (aLine.charAt(0) == ',') {
                        if (aLine.length() > 1) {
                            aLine = aLine.substring(1);
                        } else {
                            break;
                        }
                    }
                    int i = parseIndex(aLine.charAt(0))-1;
                    if (!indices.contains(i) && 0 <= i && i < pDiceComp.getLength()) {
                        indices.add(i);
                    } else {
                        System.out.println("Index already chosen. Try again");
                        throw new IllegalArgumentException();
                    }
                    aLine = aLine.substring(1);
                }
                if (!pDiceComp.split(indices, pCardMode)) {
                    System.out.println("split is not possible");
                    throw new IllegalArgumentException();
                }
                return;
            } catch (IllegalArgumentException e){
                indices.clear();
            }
        }
    }

    private int parseIndex(char pChar) {

        int aIndex = Character.getNumericValue(pChar);

        if (aIndex > 6 || aIndex < 1) {
            System.out.println("Index is not valid or out of range");
            throw new IllegalArgumentException();
        }
        return aIndex;
    }

    public boolean toContinue() {
        while (true) {
            System.out.println("Press (R)oll or (E)nd your turn");
            String aLine = aInput.ask();
            if (aLine.equals("R")) {
                return true;
            } else if (aLine.equals("E")) {
                return false;
            }
        }
    }
    public int getNumberOfPlayers() {
        System.out.println("Enter number of Players (2-4):");
        while (true) {
            String aLine = aInput.ask();
            try {
                if (aLine.length() == 1) {
                    int q = aLine.charAt(0)-48;
                        if (q>=2&&q<=4) {
                            return aLine.charAt(0)-48;
                        } else {
                            System.out.println("not in range");
                        }
                    }
                } catch(Exception ignored) {
            }
        }
    }
    public String getPlayerName(int i) {
        System.out.println("Enter name of Player "+i+":");
        while (true) {
            String aLine = aInput.ask();
            try {
                if (aLine.length() < 1) {
                    throw new IllegalArgumentException();
                }
                return aLine;
            } catch (Exception ignored) {
            }
        }
    }
    public int scoreToReach() {
        System.out.println("Enter Score to reach (1000-20000):");
        while (true) {
            String aLine = aInput.ask();
            try {
                int score = Integer.parseInt(aLine);
                if (score >= 1000 && score <= 20000) {
                    return score;
                } else {
                    System.out.println("Score must be between 1000 and 20000");
                }
            } catch(Exception ignored) {
            }
        }
    }
    public boolean displayScore(List<Player> aPlayers) {
        System.out.println("Press (R)oll or (D)isplay current scores");
        while (true) {

            String aLine = aInput.ask();
            if (aLine.equals("R")) {
                return true;
            } else if (aLine.equals("D")) {
                for (Player player : aPlayers) {
                    System.out.println(player.getName() + ": " + player.getScore());
                }
            }
            System.out.println("Press (R)oll to roll the dices");
        }
    }
}

