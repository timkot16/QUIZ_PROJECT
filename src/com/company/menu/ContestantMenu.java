package com.company.menu;

import com.company.Answer;
import com.company.Contestant;
import com.company.Question;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContestantMenu {
    private static final Scanner scanner = new Scanner(System.in);
    private final static File answers = new File("answers.txt");
    private final static File question = new File("questions.txt");
    private static final int questionsTotal = 20;

    private static final List<Contestant> participants = new ArrayList<>();

    public static void contestantMenu() {
        int currentQuestion = 1;
        System.out.println("What is your name?");
        String name = scanner.nextLine();
        System.out.println("Ok " + name + ", you can use 2 hints during the game. It's a:\n" +
                "25/75 and 50/50.");
        Contestant current_player = new Contestant(name, 0);
        participants.add(current_player);
        while(current_player.getLifes() > 0 && currentQuestion <= questionsTotal){
            loadQuestion(currentQuestion);
            currentQuestion++;
            //TODO load questions method

            // if correct -> currentQuestion++
            // if incorrect -> lifes-- && currentQuestion++
        }

    }

    public static boolean loadQuestion(int currentQuestion){
        try(Scanner fileSC = new Scanner(new FileReader(question))) {
            Question question = null;
            Answer answer = null;
            String questionText = "";
            String[] alternatives = new String[4];
            int correctAnswer = 0;

            do{
                    String line = fileSC.nextLine();
                    if(line.equalsIgnoreCase("question №" + currentQuestion)) {
                        questionText = fileSC.nextLine();
                    }
                    if(line.equalsIgnoreCase("answers " + currentQuestion)){
                        for (int i = 0; i < 4; i++) {
                            String alt = fileSC.nextLine();
                            if(alt.contains("True")) correctAnswer = i;
                            alternatives[i] = alt;
                        }
                    }
            }while (fileSC.hasNext());

            question = new Question(questionText, currentQuestion);
            answer = new Answer(alternatives, correctAnswer + 1);
            System.out.println("Question № " + currentQuestion);
            System.out.println(question.getQuestionText());
            System.out.println("Answers : ");
            printAnswers(answer);


            int choice;
            System.out.println("Enter your choice : ");
            choice = scanner.nextInt();
            while(choice < 1 || choice > 4){
                System.out.println("Enter the correct choice : ");
                choice = scanner.nextInt();
            }

            System.out.println();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static void printAnswers(Answer answer){
        for (int i = 0; i < 4; i++) {
            System.out.println(answer.getText()[i]);
        }
    }
}
