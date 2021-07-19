package com.company.otherFiles;

import java.util.Scanner;

public class Tools {

    public static void pressEnterToContinue(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Press enter to continue!");
        String s = scanner.nextLine();

    }
}
