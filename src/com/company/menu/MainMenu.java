package com.company.menu;

import com.company.otherFiles.Tools;

import java.util.Scanner;

public class MainMenu {
    private static final Scanner scanner = new Scanner(System.in);


    public static void mainMenu() {
        System.out.println("Welcome to the Quiz game!");
        System.out.println("Type 1 - Start new game\n" +
                "Type 2 - Results\n" +
                "Type 3 - Exit the game");


            int choice = Tools.ReadNumber(1, 3);

            switch (choice) {
                case 1:
                    System.out.println("Starting a new game");
                    ContestantMenu.contestantMenu();
                    break;
                case 2:
                    ContestantMenu.printPlayerResults();
                    break;
                case 3:
                    System.out.println("Quiting the game!");
                    System.exit(0);
                    break;
            }

    }

    /* Вопросы могут быть с вариантами ответа или с текстовым ответом.
Вопросы должны храниться в файле (например, json, xml).
Программа должна задавать пользователю вопрос, получать ответ и проверять его правильность.
После ответа на все вопросы надо вывести результат пользователя в баллах.
Ответы пользователя сохранять в файл (например, json, xml).

Кроме режима квиза сделать режим, в котором будет отображаться список пользователей,
которые прошли квиз и их баллы в порядке возрастания баллов. В этом режиме должна быть
возможность вывести на экран все ответы конкретного пользователя.
Выбор режима происходит при запуске программы. Из режима квиза можно вернуться после ответа на все вопросы.
Из режима списка пользователя можно вернуться всегда.

Если очень хочется, сделать что-то еще, то можно придумать что-то еще. Например, режим для создания вопросов,
можно позволить в нем и редактирование вопросов. Можно сделать подсказку 50/50, подсказку первой буквы.
И если придумаете что-то еще интересное, то тоже можете делать. Например, можно еще сделать unit тесты.

*/

}
