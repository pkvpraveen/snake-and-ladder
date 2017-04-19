package main;

import util.Dice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {

    private final int OUT_OF_BOARD = -1;
    private final int MAX_BOARD_POSITION = 100;
    private Map<String, Integer> playerToPositionMap = new HashMap<String, Integer>();
    private String winner;
    private Dice dice = new Dice();

    public Game(List<String> players) {
        for (String player : players) {
            this.playerToPositionMap.put(player, OUT_OF_BOARD);
        }
    }

    public boolean isGameOver() {
        for (String player : playerToPositionMap.keySet()) {
            if (playerToPositionMap.get(player) == MAX_BOARD_POSITION) {
                this.winner = player;
                return true;
            }
        }
        return false;
    }

    public void setPosition(String playerName, int position) {
        playerToPositionMap.put(playerName, position);
    }

    public String winner() {
        return winner;
    }

    public int getPosition(String player) {
        return playerToPositionMap.get(player);
    }

    public void setDice(Dice dice) {
        this.dice = dice;
    }

    public void play(String player) {
        Integer currentPosition = playerToPositionMap.get(player);
        int roll = dice.roll();
        if (currentPosition != OUT_OF_BOARD) {
            int newPosition = currentPosition + roll;
            if (newPosition <= MAX_BOARD_POSITION) {
                playerToPositionMap.put(player, newPosition);
            }
        } else if (roll == 1) {
            playerToPositionMap.put(player, roll);
        }
    }

    public Dice getDice() {
        return dice;
    }
}
