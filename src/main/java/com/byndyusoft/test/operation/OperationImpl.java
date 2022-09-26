package com.byndyusoft.test.operation;

public class OperationImpl implements Operation {

    @Override
    public int priorityOfOperation(String temp) {
        switch (temp) {
            case "/":
            case "*":
                return 2;
            case "+":
            case "-":
                return 1;
            default:
                return 0;
        }
    }
}
