package com.company.menu;

import com.company.PlayerResult;
import com.company.otherFiles.Tools;

import java.util.*;
import java.util.function.Consumer;

public class ResultsMenu {

    public static Scanner scanner = new Scanner(System.in);

    public static void resultsMenu() {
        System.out.println("Type 1 - Table with results\n" +
                "Type 2 - Find a player by name\n");

        int choice = Tools.ReadNumber(1, 2);

        switch (choice) {
            case 1:
                getOrderedPlayersResults();
                backToMainMenu();
                break;
            case 2:
                findPlayer();
                backToMainMenu();
                break;
        }
    }

    public static void getOrderedPlayersResults() {
        Map<String, Integer> orderedPlayersResults = new HashMap<>();

        List<PlayerResult> playerResults = ContestantMenu.getPlayersResults();
        for (PlayerResult playerResult : playerResults) {
            orderedPlayersResults.put(playerResult.getName(), playerResult.getResult());
        }

        orderedPlayersResults.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(stringIntegerEntry ->
                        System.out.println("Name " + stringIntegerEntry.getKey() +
                                " result : " + stringIntegerEntry.getValue()));
    }

    public static void backToMainMenu() {
        System.out.println("\nType 1 - Back to menu\n" +
                "Type 2 - Exit the game\n");

        int choice = Tools.ReadNumber(1, 2);

        switch (choice) {
            case 1:
                MainMenu.mainMenu();
                break;
            case 2:
                System.out.println("Quiting the game!");
                System.exit(0);
                break;
        }
    }

    public static void findPlayer() {
        List<PlayerResult> playerResults = ContestantMenu.getPlayersResults();
        System.out.println("Enter player's name: ");
        String player = scanner.nextLine();
        boolean isFound = false;
        for (PlayerResult playerInfo : playerResults) {
            if (player.equals(playerInfo.getName())) {
                System.out.println("Name: " + playerInfo.getName());
                System.out.println("Result: " + playerInfo.getResult());
                System.out.println(playerInfo.getQuestionAnswer());
                isFound = true;
                break;
            }
        }
        if(!isFound) System.out.println("Player is not found!\nTry again");
    }
}


