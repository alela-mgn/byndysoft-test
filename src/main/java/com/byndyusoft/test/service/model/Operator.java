package com.byndyusoft.test.service.model;

import com.byndyusoft.test.exception.OperatorException;

import java.util.EnumSet;

public enum Operator {
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    private final String sign;

    Operator(String sign) {
        this.sign = sign;
    }

    public String getSign() {
        return sign;
    }

    public static Operator getOperation(String operator) {
        return EnumSet.allOf(Operator.class).stream()
                .filter(x -> x.getSign().equals(operator))
                .findFirst()
                .orElseThrow(() -> new OperatorException("Операция не поддерживается!"));
    }
}
