package com.company;

import com.company.menu.ContestantMenu;

import java.util.HashMap;
import java.util.Objects;

public class Contestant {
    private String name;
    private boolean result;

    public void contestantResult() {
        HashMap<String, Boolean> nameResult = new HashMap<>();
        nameResult.put(name, result);
    }


}
