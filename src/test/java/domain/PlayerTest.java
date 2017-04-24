package domain;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PlayerTest {

    @Mock
    private Dice dice;
    @Mock
    private Board board;
    private Player player;

    @Before
    public void setUp() {
        player = new Player("PlayerName");
        simulateBoard();
    }

    @Test
    public void shouldNotEnterTheBoardInitially() {
        assertNull(player.getPosition());
    }

    @Test
    public void shouldNotEnterTheBoardIfDiceDidNotRollOne() {
        when(dice.roll()).thenReturn(2);
        player.play(dice, board);
        assertNull(player.getPosition());
    }

    @Test
    public void shouldEnterTheBoardWhenTheDiceRollsOne() {
        when(dice.roll()).thenReturn(1);
        player.play(dice, board);
        assertEquals(1, player.getPosition().intValue());
    }

    @Test
    public void shouldUpdateThePositionOnBoardWhenTheDiceRoll() {
        when(dice.roll()).thenReturn(1).thenReturn(6);
        player.play(dice, board);
        player.play(dice, board);
        assertEquals(7, player.getPosition().intValue());
        verify(board).positionOnBoard(1);
        verify(board).positionOnBoard(7);
    }

    @Test
    public void shouldNotGoOutOfTheBoard() {
        player.setPosition(96);
        when(dice.roll()).thenReturn(6);
        player.play(dice, board);
        assertEquals(96, player.getPosition().intValue());
    }

    @Test
    public void shouldSayIfWinner() {
        player.setPosition(Board.FINISHING_POINT);
        assertTrue(player.isWinner());
    }

    private void simulateBoard() {
        when(board.positionOnBoard(anyInt())).then(new Answer<Integer>() {
            public Integer answer(InvocationOnMock invocationOnMock) throws Throwable {
                Object[] args = invocationOnMock.getArguments();
                return (Integer) args[0];
            }
        });
    }
}