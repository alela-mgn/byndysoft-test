package com.expression.calculator.service.model;

import com.expression.calculator.exception.OperatorException;

import java.util.EnumSet;

public enum Operator {
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/"),
    OPEN_BRACKET("("),
    CLOSE_BRACKET(")");

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
