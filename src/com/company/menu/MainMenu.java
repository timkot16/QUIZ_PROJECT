package com.company.menu;

import java.util.Scanner;

public class MainMenu {
    private static final Scanner scanner = new Scanner(System.in);

    public static void mainMenu() {
        System.out.println("Welcome to the Quiz game!");
        System.out.println("Type 1 - Start new game\n" +
                "Type 2 - Get results by player name\n" +
                "Type 3 - Exit the game\n");

        int choice = scanner.nextInt();
        while (choice < 1 || choice > 3) {
            System.out.println("Enter the correct choice : ");
            choice = scanner.nextInt();
        }

        switch (choice) {
            case 1:
                System.out.println("Starting a new game");
                //TODO new game start
                break;
            case 2:
                System.out.println("Enter the name of player to search the results : ");
                //TODO search a player
                break;
            case 3:
                System.out.println("Quiting the game!");
                System.exit(0);
                break;
        }
    }

}
