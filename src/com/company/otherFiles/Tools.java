package com.company.otherFiles;

import java.util.Scanner;

public class Tools {

    public static void pressEnterToContinue(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Press enter to continue!");
        String s = scanner.nextLine();
    }

    public static void cls(){
        for(int i = 0; i < 300; i++)
            System.out.println("\b");
    }
}
