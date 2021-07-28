package com.company.menu;

import com.company.PlayerResult;
import com.company.otherFiles.Tools;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ResultsMenu {

    public static void resultsMenu() {
        System.out.println("1 - вывести в порядке убывания\n" +
                "2 - найти пользователя");

        int choice = Tools.ReadNumber(1, 2);

        switch (choice) {
            case 1:
                getOrderedPlayersResults();
                break;
            case 2:

                break;
        }
        // TODO Result menu
    }

    public static void getOrderedPlayersResults() {
        Map<String, Integer> preResultList = new HashMap<>();
//        Map<String, Integer> orderedResultList = new HashMap<>();

        List<PlayerResult> playerResults = ContestantMenu.getPlayersResults();
        for (PlayerResult playerResult : playerResults) {
            preResultList.put(playerResult.getName(), playerResult.getResult());
        }

//        for (Map.Entry<String, Integer> entry : preResultList.entrySet()) {
//
//            String resultString = "Name: " + entry.getKey() + " | Result: " + entry.getValue();
//            System.out.println(resultString);
//        }

        preResultList.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(System.out::println);

    }

//    public static void



}
