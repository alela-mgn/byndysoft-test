package com.byndyusoft.test.service.model;

import com.byndyusoft.test.validation.Validator;

import java.util.Stack;

public class ResultDto {

    Validator validation = new Validator();


    public double calculateResult(String notation) {
        Stack<String> stack = new Stack<>();

        for (String currentSymbol : notation.split(" ")) {
            if (validation.isNumber(currentSymbol)) {
                stack.push(currentSymbol);
                continue;
            }

            if (validation.isOperator(currentSymbol)) {
                double result = 0;
                double first = Double.parseDouble(stack.pop());
                double second = Double.parseDouble(stack.pop());

                switch (currentSymbol) {
                    case "/":
                        result = second / first;
                        break;
                    case "*":
                        result = second * first;
                        break;
                    case "+":
                        result = second + first;
                        break;
                    case "-":
                        result = second - first;
                        break;
                }
                stack.push(String.valueOf(result));
            }
        }
        return Double.parseDouble(stack.pop());
    }

}
