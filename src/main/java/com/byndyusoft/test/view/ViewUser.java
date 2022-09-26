package com.byndyusoft.test.view;


import com.byndyusoft.test.calculate.Calculate;
import com.byndyusoft.test.parser.ParserImpl;

import java.util.Scanner;

public class ViewUser {
    public void keyboardReading() {
        System.out.println("Для начала работы калькулятора введите выржание." + "\n"
                + "Вводите каждый символ через пробел" + "\n"
                + "Для завершения работы программы введите quit или нажмите пробел" + "\n"
                + "Введите значение выражения: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        ParserImpl parser = new ParserImpl();
        Calculate calculate = new Calculate();

        while (!input.equals("quit") && !input.equals(" ")) {
            String notation = parser.getReversPolishNotation(input);
            double result = calculate.calculateResult(notation);
            System.out.println("\nResult: " + result);

            input = scanner.nextLine();
        }
        System.out.println("Работа программы завершена!");
    }
}
