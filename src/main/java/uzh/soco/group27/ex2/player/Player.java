package uzh.soco.group27.ex2.player;

import java.util.Comparator;

public class Player {
    private int score = 0;
    private final String name;

    public Player(String name){
        this.name = name;
    }
    public int getScore() {
        return score;
    }
    public void setScore(int aScore) {
        score += aScore;
    }
    public String getName() {
        return name;
    }

    public static Comparator<Player> nameComparator = (o1, o2) -> {
        String playerName1 = o1.getName();
        String playerName2 = o2.getName();
        return playerName1.compareTo(playerName2);
    };
    public static Comparator<Player> scoreComparator = (o1, o2) -> {
        int playerScore1 = o1.getScore();
        int playerScore2 = o2.getScore();
        return playerScore2 - playerScore1;
    };

    @Override
    public String toString() {
        return name;
    }

}
