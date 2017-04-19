package main;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import util.Dice;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GameTest {

    private Game game;
    @Mock
    private Dice dice;

    @Before
    public void setUp() throws Exception {
        game = new Game(asList("A", "B"));
        game.setDice(dice);
    }

    @Test
    public void gameShouldHaveADice() throws Exception {
        assertNotNull(new Game(asList("A")).getDice());

    }

    @Test
    public void shouldHavePositionAsMinusOneInitially() {
        assertEquals(-1, game.getPosition("A"));
        assertEquals(-1, game.getPosition("B"));
    }

    @Test
    public void shouldReturnPositionAfterSettingIt() {
        int position = 15;
        game.setPosition("A", position);
        assertEquals(position, game.getPosition("A"));
    }

    @Test
    public void shouldTellWinnerIfGameOver() {
        game.setPosition("A", 100);
        assertTrue(game.isGameOver());
        assertEquals("A", game.winner());
    }

    @Test
    public void shouldNotTellWinnerIfGameNotOver() {
        game.setPosition("A", 99);
        assertFalse(game.isGameOver());
        assertNull(game.winner());
    }

    @Test
    public void shouldChangePositionWhenPlay() {
        when(dice.roll()).thenReturn(6);
        game.setPosition("A", 94);
        game.play("A");
        assertEquals(100, game.getPosition("A"));
    }

    @Test
    public void shouldGetIntoPosotionOneOnlyWhenDiceRollsOne() throws Exception {
        when(dice.roll()).thenReturn(2);
        game.play("A");
        assertEquals(-1, game.getPosition("A"));
        when(dice.roll()).thenReturn(1);
        game.play("A");
        assertEquals(1, game.getPosition("A"));
    }

    @Test
    public void shouldNotMoveWhenPlayerGetsPositionOutOfBoard() {
        game.setPosition("A", 96);
        when(dice.roll()).thenReturn(6);
        game.play("A");
        assertEquals(96, game.getPosition("A"));
    }

    @Test
    public void play() throws Exception {
        List<String> players = asList("A", "B", "C");
        Game game = new Game(players);
        System.out.println("winner " + play(players, game));
    }

    private String play(List<String> players, Game game) {
        while (!game.isGameOver()) {
            for (String player : players) {
                game.play(player);
                System.out.println("Position " + player + " " + game.getPosition(player));
                if (game.isGameOver()) {
                    return game.winner();
                }
            }
        }
        return null;
    }
}