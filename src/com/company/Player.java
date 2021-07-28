package com.company;

public class Player {
    private final String name;
    private int result;
    private int life = 3;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getResult() {
        return result;
    }

    public void incrementResult() {
        this.result++;
    }

    public int decrementAndGetLife() {
        return --life;
    }
}
