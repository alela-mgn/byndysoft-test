package com.byndyusoft.test.service.impl;

import com.byndyusoft.test.service.Operation;

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
