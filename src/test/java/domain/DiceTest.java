package domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class DiceTest {

    @Test
    public void shouldGetRandomNumberBetweenOneAndSixWhenRoll() {
        Dice dice = new Dice();
        for (int i = 0; i < 1000; i++) {
            int roll = dice.roll();
            assertTrue((1 <= roll && roll <= 6));
        }
    }
}