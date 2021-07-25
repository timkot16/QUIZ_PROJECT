package com.company;


public class Contestant {
    private final String name;
    public int result = 0;
    private int lifes = 3;


    public Contestant(String name) {
        this.name = name;
    }

    public void contestantResult() {
//        HashMap<String, Integer> nameResult = new HashMap<>();
//        nameResult.put(name, result);
    }

    public int getLifes() {
        return lifes;
    }

    public void setLifes(int lifes) {
        this.lifes = lifes;
    }

    public String getName() {
        return name;
    }
}
