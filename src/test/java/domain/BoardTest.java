package domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class BoardTest {

    private Board board = new Board();

    @Test
    public void shouldBeAbleToPositionOnBoard() {
        assertEquals(2,board.positionOnBoard(2));
    }

    @Test
    public void shouldHaveLadders() {
        assertEquals(14,board.positionOnBoard(4));
        assertEquals(31,board.positionOnBoard(9));
        assertEquals(38,board.positionOnBoard(20));
        assertEquals(84,board.positionOnBoard(28));
        assertEquals(59,board.positionOnBoard(40));
        assertEquals(67,board.positionOnBoard(51));
        assertEquals(81,board.positionOnBoard(63));
        assertEquals(91,board.positionOnBoard(71));
    }


    @Test
    public void shouldHaveSnakes() {
        assertEquals(73,board.positionOnBoard(93));
        assertEquals(75,board.positionOnBoard(95));
        assertEquals(78,board.positionOnBoard(99));
        assertEquals(24,board.positionOnBoard(87));
        assertEquals(19,board.positionOnBoard(62));
        assertEquals(60,board.positionOnBoard(64));
        assertEquals(34,board.positionOnBoard(54));
        assertEquals(7,board.positionOnBoard(17));
    }

}