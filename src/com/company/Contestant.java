package com.company;

import java.util.HashMap;

public class Contestant {
    private final String name;
    private int result;
    private int lifes;


    public Contestant(String name, int result) {
        this.name = name;
        this.result = result;
        lifes = 3;
    }

    public void contestantResult() {
//        HashMap<String, Integer> nameResult = new HashMap<>();
//        nameResult.put(name, result);
    }

    public int getLifes() {
        return lifes;
    }
}
