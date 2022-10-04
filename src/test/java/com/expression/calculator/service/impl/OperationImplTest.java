package com.expression.calculator.service.impl;

import com.expression.calculator.service.Operation;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class OperationImplTest {

    @Test
    public void calculateResultPlus() {
        ParserImpl parser = new ParserImpl();
        Operation operation = new OperationImpl();
        String expression = "222+3";
        String expressionRevers = parser.getReversPolishNotation(expression).replaceAll("[()]", "");

        double actual = operation.calculateResult(expressionRevers);
        double expected = 225;

        assertEquals(expected, actual);
    }

    @Test
    public void calculateResultMinus() {
        ParserImpl parser = new ParserImpl();
        Operation operation = new OperationImpl();
        String expression = "222-3";
        String expressionRevers = parser.getReversPolishNotation(expression).replaceAll("[()]", "");

        double actual = operation.calculateResult(expressionRevers);
        double expected = 219;

        assertEquals(expected, actual);
    }

    @Test
    public void calculateResultDivide() {
        ParserImpl parser = new ParserImpl();
        Operation operation = new OperationImpl();
        String expression = "(4+4)/2";
        String expressionRevers = parser.getReversPolishNotation(expression).replaceAll("[()]", "");

        double actual = operation.calculateResult(expressionRevers);
        double expected = 4;

        assertEquals(expected, actual);
    }

    @Test
    public void calculateResultMultiply() {
        ParserImpl parser = new ParserImpl();
        Operation operation = new OperationImpl();
        String expression = "(4+4)*2";
        String expressionRevers = parser.getReversPolishNotation(expression).replaceAll("[()]", "");

        double actual = operation.calculateResult(expressionRevers);
        double expected = 16;

        assertEquals(expected, actual);
    }
}