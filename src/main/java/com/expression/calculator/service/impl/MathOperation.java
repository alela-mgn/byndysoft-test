package com.expression.calculator.service.impl;

import com.expression.calculator.service.model.Operator;

public class MathOperation {

    public int resolveOperationPriority(String operator) {
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

    public double calculate(String operation, double first, double second) {
        double result = 0;
        switch (operation) {
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
        return result;
    }
}
