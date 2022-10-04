package com.expression.calculator.service.impl;

import com.expression.calculator.service.Operation;

import java.util.Stack;

public class OperationImpl implements Operation {

    private final Validator validator = new Validator();

    @Override
    public double calculateResult(String expression) {
        Stack<String> stack = new Stack<>();

        for (String currentSymbol : expression.split(" ")) {
            if (validator.isNumber(currentSymbol)) {
                stack.push(currentSymbol);
                continue;
            }

            if (validator.isOperator(currentSymbol)) {
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
