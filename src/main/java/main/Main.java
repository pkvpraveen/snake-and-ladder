package main;

import domain.Game;

import static java.util.Arrays.asList;

public class Main {
    public static void main(String[] args) {
        new Game(asList("A", "B", "C"))
                .autoPlay();
    }
}
