package domain;

import java.util.HashMap;
import java.util.Map;

public class Board {
    public static final Integer FINISHING_POINT = 100;
    private Map<Integer, Integer> snakes = new HashMap<Integer, Integer>();
    private Map<Integer, Integer> ladders = new HashMap<Integer, Integer>();

    public Board() {
        this.ladders.put(4, 14);
        this.ladders.put(9, 31);
        this.ladders.put(20, 38);
        this.ladders.put(28, 84);
        this.ladders.put(40, 59);
        this.ladders.put(51, 67);
        this.ladders.put(63, 81);
        this.ladders.put(71, 91);

        this.snakes.put(93, 73);
        this.snakes.put(95, 75);
        this.snakes.put(99, 78);
        this.snakes.put(87, 24);
        this.snakes.put(64, 60);
        this.snakes.put(62, 19);
        this.snakes.put(54, 34);
        this.snakes.put(17, 7);
    }

    public int positionOnBoard(int i) {
        if (snakes.keySet().contains(i)) {
            System.out.println("Caught by Snake at " + i +" Going to " + snakes.get(i));
            return snakes.get(i);
        }else if (ladders.keySet().contains(i)) {
            System.out.println("Got ladder at " + i +" Going to " + ladders.get(i));
            return ladders.get(i);
        } else {
            return i;
        }
    }
}
