package com.byndyusoft.test.service.impl;

import com.byndyusoft.test.service.Parser;
import com.byndyusoft.test.service.model.Operator;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import static java.util.stream.Collectors.toList;

public class ParserImpl implements Parser {

    private final Validator validator = new Validator();

    @Override
    public String getReversPolishNotation(String input) {
        LinkedList<String> operation = new LinkedList<>();
        Stack<String> stack = new Stack<>();

        String test = input.replaceAll("[-+*/()]", " $0 ").replace("  ", " ").trim();
        //List<String> chars = input.chars().mapToObj(Character::toString).collect(toList());
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
