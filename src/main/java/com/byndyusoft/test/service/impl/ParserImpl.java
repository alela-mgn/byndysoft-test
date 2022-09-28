package com.byndyusoft.test.service.impl;

import com.byndyusoft.test.service.Parser;
import com.byndyusoft.test.service.model.Operator;
import com.byndyusoft.test.validation.Validator;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import static java.util.stream.Collectors.toList;

public class ParserImpl implements Parser {

    OperationImpl operationImpls = new OperationImpl();
    Validator validation = new Validator();

    @Override
    public String getReversPolishNotation(String input) {
        LinkedList<String> opn = new LinkedList<>();
        Stack<String> stack = new Stack<>();

        List<String> chars = input.chars().mapToObj(Character::toString).collect(toList());
        for (String currentSymbol : chars) {

            if (validation.isNumber(currentSymbol)) {
                opn.add(currentSymbol + " ");
                continue;
            }

            if (currentSymbol.equals("(") || stack.empty()) {
                stack.push(currentSymbol);
                continue;
            }

            if (validation.isOperator(currentSymbol)) {
                while (!stack.isEmpty()
                        && operationImpls.priorityOfOperation(stack.peek()) >= operationImpls.priorityOfOperation(currentSymbol)) {
                    opn.add(stack.pop() + " ");
                }
                stack.push(currentSymbol);
                continue;
            }

            if (currentSymbol.equals(")")) {
                while (!stack.peek().equals("(")) {
                    opn.add(stack.pop() + " ");
                }
                stack.pop();
                continue;
            }
        }

        while (!stack.empty()) {
            opn.add(stack.pop() + " ");
        }

        StringBuilder sb = new StringBuilder();
        for (String s : opn) {
            sb.append(s);
        }

        return sb.toString();
    }

    private int resolveOperationPriority(Operator operator) {
        switch (operator) {
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
