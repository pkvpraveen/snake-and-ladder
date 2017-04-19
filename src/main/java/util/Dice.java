package util;

import java.util.Random;

public class Dice {
    Random random = new Random();

    public int roll() {
        return 1 + random.nextInt(6);
    }
}
