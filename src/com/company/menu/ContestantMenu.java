package com.company.menu;

import com.company.Answer;
import com.company.Player;
import com.company.PlayerResult;
import com.company.Question;
import com.company.otherFiles.Tools;

import java.io.*;
import java.util.*;

public class ContestantMenu {
    private static final Scanner scanner = new Scanner(System.in);
    private static final File questionFile = new File("questions.txt");
    private static final int totalNumbersOfQuestions = 20;


    public static void contestantMenu() {
        System.out.println("What is your name?");
        String name = scanner.nextLine();

        System.out.println("Ok " + name + ", you can use 2 hints during the game. It's a:\n" +
                "25/75 and 50/50.\nYou have the right to 3 mistakes.\nLet's play!\n ");

        Player player = new Player(name);

        List<Question> questions = loadQuestion();

        Map<String, String> questionAnswer = new HashMap<>();

        for (Question questionV2 : questions) {
            printQuestion(questionV2);
            printAnswers(questionV2.getAnswers());

            System.out.print("Enter your choice : ");
            //TODO give player a choice to use hint
            int choice = Tools.ReadNumber(1, 4);

            Answer answer = questionV2.getAnswerById(choice);

            questionAnswer.put(questionV2.getQuestionText(), answer.getText());

            if (answer.isCorrect()) {
                System.out.println("Correct" + "\n");
                player.incrementResult();
                if (player.getResult() == totalNumbersOfQuestions) {
                    System.out.println("Congratulations! You won!");
                }
            } else {
                System.out.println("Incorrect" + "\n");

                int life = player.decrementAndGetLife();

                if (life == 0 && player.getResult() > 15) {
                    System.out.println("Good work! But you can better!");
                }
                if (life == 0) {
                    System.out.println("You lose.");
                    break;
                }
            }
        }

        System.out.println("Your result is " + player.getResult() + "\n");
        saveResultToFile(player, questionAnswer);

        System.out.println("Type 1 - Back to menu\n" +
                "Type 2 - Exit the game\n");

        int choice = Tools.ReadNumber(1, 3);

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

    public static List<Question> loadQuestion() {
        List<Question> questions = new ArrayList<>();
        int questionId = 1;
        try (Scanner fileSC = new Scanner(new FileReader(questionFile))) {

            do {

                String line = fileSC.nextLine();

                if (line.equalsIgnoreCase("question №" + questionId)) {
                    String questionText = fileSC.nextLine();
                    line = fileSC.nextLine();
                    List<Answer> answers = new ArrayList<>();
                    if (line.equalsIgnoreCase("answers " + questionId)) {
                        for (int i = 0; i < 4; i++) {
                            boolean correct = false;
                            String answerLine = fileSC.nextLine();
                            if (answerLine.contains("True")) {
                                correct = true;
                                answerLine = answerLine.replaceFirst("- True", "");
                            }
                            answers.add(new Answer(i + 1, answerLine, correct));
                        }
                    }

                    questions.add(new Question(questionId, questionText, answers));
                    questionId++;
                }


            } while (fileSC.hasNext());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return questions;
    }

    public static void printAnswers(List<Answer> answers) {
        System.out.println("Answers : ");
        for (Answer answer : answers) {
            System.out.println(answer.getText());
        }
    }

    public static void printQuestion(Question question) {
        System.out.println("Question № " + question.getQuestionID());
        System.out.println(question.getQuestionText());
    }

    public static void saveResultToFile(Player player, Map<String, String> questionAnswer) {
        String playerName = player.getName();

        String fileName = "Results/" + playerName + ".txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("Name: " + playerName);
            writer.newLine();
            writer.write("Result: " + player.getResult());
            writer.newLine();

            for (Map.Entry<String, String> entry : questionAnswer.entrySet()) {
                writer.newLine();
                writer.write("Question: " + entry.getKey());
                writer.newLine();
                writer.write("Answer: " + entry.getValue());
                writer.newLine();

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printPlayerResults() {
        List<PlayerResult> playerResults = getPlayersResults();
        for (PlayerResult playerResult : playerResults) {
            System.out.println("Name: " + playerResult.getName());
            System.out.println("Result: " + playerResult.getResult());
        }
    }


    public static String findNextLine(BufferedReader reader) throws IOException {
        while (true) {
            String line = reader.readLine();
            if (!line.equals("")) {
                return line;
            }
        }
        //todo check it!
    }

    public static List<PlayerResult> getPlayersResults() {
        List<PlayerResult> playerResults = new ArrayList<>();
        File resultsDirectory = new File("Results");
        List<File> files = List.of(resultsDirectory.listFiles());

        for (File file : files) {
            String name = null;
            String result = null;
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

                String line = findNextLine(reader);
                String nameTemplate = "Name: ";

                if (line.startsWith(nameTemplate)) {
                    name = line.substring(nameTemplate.length());
                }

                line = reader.readLine();

                String resultTemplate = "Result: ";
                if (line.startsWith(resultTemplate)) {
                    result = line.substring(resultTemplate.length());
                }
                playerResults.add(new PlayerResult(name, Integer.valueOf(result), null));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return playerResults;
    }
}
