package domain;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Player> players = new ArrayList<Player>();
    private boolean gameOver;
    private Dice dice = new Dice();
    private Board board = new Board();

    public Game(List<String> playerNames) {
        for (String name : playerNames) {
            players.add(new Player(name));
        }
    }

    public void autoPlay() {
        while (!this.gameOver) {
            for (Player player : this.players) {
                player.play(dice, board);
                if (player.isWinner()) {
                    this.gameOver = true;
                    System.out.println("Winner : " + player.getName());
                    return;
                }
            }
        }
    }
}
