package com.expression.calculator.service.impl;

import com.expression.calculator.service.Parser;
import com.expression.calculator.service.model.Operator;

import java.util.LinkedList;
import java.util.Stack;

public class ParserImpl implements Parser {

    private final Validator validator = new Validator();

    @Override
    public String getReversPolishNotation(String input) {
        LinkedList<String> operation = new LinkedList<>();
        Stack<String> stack = new Stack<>();

        String test = input.replaceAll("[-+*/()]", " $0 ").trim();
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
                        && resolveOperationPriority(stack.peek()) >= resolveOperationPriority(currentSymbol)) {
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

    private int resolveOperationPriority(String operator) {
        switch (Operator.getOperation(operator)) {
            case MULTIPLY:
            case DIVIDE:
                return 2;
            case PLUS:
            case MINUS:
                return 1;
            default:
                return 0;
        }
    }
}
