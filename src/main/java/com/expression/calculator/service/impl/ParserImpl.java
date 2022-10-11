package com.expression.calculator.service.impl;

import com.expression.calculator.service.Parser;

import java.util.LinkedList;
import java.util.Stack;

public class ParserImpl implements Parser {

    private final Validator validator = new Validator();
    private final MathOperation mathOperation = new MathOperation();

    @Override
    public String getReversPolishNotation(String input) {
        LinkedList<String> operation = new LinkedList<>();
        Stack<String> stack = new Stack<>();

        String test = input.replaceAll("[-+*/()%]", " $0 ").trim();
        for (String currentSymbol : test.split(" ")) {

            if (validator.isNumber(currentSymbol)) {
                operation.add(currentSymbol + " ");
                continue;
            }

            if (currentSymbol.equals("(") || stack.empty()) {
                stack.push(currentSymbol);
                continue;
            }

            if (validator.isOperator(currentSymbol)) {
                while (!stack.isEmpty()
                        && mathOperation.resolveOperationPriority(stack.peek()) >= mathOperation.resolveOperationPriority(currentSymbol)) {
                    operation.add(stack.pop() + " ");
                }
                stack.push(currentSymbol);
                continue;
            }

            if (currentSymbol.equals(")")) {
                while (!stack.peek().equals("(")) {
                    operation.add(stack.pop() + " ");
                }
                stack.pop();
            }
        }

        while (!stack.empty()) {
            operation.add(stack.pop() + " ");
        }

        StringBuilder string = new StringBuilder();
        for (String s : operation) {
            string.append(s);
        }

        return string.toString();
    }

    public String preparingExpression(String expression) {
        StringBuilder preparedExpression = new StringBuilder();
        for (int token = 0; token < expression.length(); token++) {
            char symbol = expression.charAt(token);
            if (symbol == '-') {
                if (token == 0) {
                    preparedExpression.append('0');
                } else if (expression.charAt(token - 1) == '(') {
                    preparedExpression.append('0');
                }
            }
            preparedExpression.append(symbol);
        }
        return preparedExpression.toString();
    }
}
