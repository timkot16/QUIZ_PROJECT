package com.company.menu;

import java.util.Scanner;

public class ContestantMenu {
    private static final Scanner scanner = new Scanner(System.in);
    private static String name;

    public static void contestantMenu() {
        System.out.println("What is your name?");
        name = scanner.nextLine();
        System.out.println("Ok " + name + ", you can use 2 hints during the game. It's a:\n" +
                "25/70 and 50/50.");

    }
}
