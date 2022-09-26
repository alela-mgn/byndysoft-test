package com.byndyusoft.test.parser;

import com.byndyusoft.test.operation.OperationImpl;
import com.byndyusoft.test.validation.Validation;

import java.util.LinkedList;
import java.util.Stack;

public class ParserImpl implements Parser {

    OperationImpl operationImpls = new OperationImpl();
    Validation validation = new Validation();

    @Override
    public String getReversPolishNotation(String input) {
        LinkedList<String> opn = new LinkedList<>();
        Stack<String> stack = new Stack<>();

        for (String currentSymbol : input.split(" ")) {

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

}
