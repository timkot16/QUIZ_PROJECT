package com.company;

import com.company.otherFiles.Tools;

import java.io.IOException;
import java.util.Scanner;

public class Run {

    public static void main(String[] args) throws IOException {
        //TODO run method
        Tools.pressEnterToContinue();
        Tools.cls();
        System.out.println("new code");
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
    }
}
