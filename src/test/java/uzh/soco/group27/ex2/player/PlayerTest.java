package uzh.soco.group27.ex2.player;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlayerTest {

    Player player = new Player("Test");

    @Test
    public void correctName() {
        assertEquals("Test", player.getName());
    }

    @Test
    public void correctScore() {
        player.setScore(100);
        assertEquals(100, player.getScore());
    }


}
