package com.company.otherFiles;

import java.util.Scanner;

public class Tools {
    private static final Scanner sc = new Scanner(System.in);

    public static void pressEnterToContinue(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Press enter to continue!");
        String s = scanner.nextLine();
    }

    public static void cls(){
        for(int i = 0; i < 300; i++)
            System.out.println("\b");
    }

    public static int ReadNumber(int border1, int border2){
        int number = sc.nextInt();

        while(number < border1 || number > border2){
            System.out.println("Enter the correct number : ");
            number = sc.nextInt();
        }

        return number;
    }
}
