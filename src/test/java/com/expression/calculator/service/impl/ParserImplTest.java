package com.expression.calculator.service.impl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParserImplTest {

    @Test
    public void getReversPolishNotation() {
        ParserImpl parser = new ParserImpl();
        String expected = "222 3 + 3 4 + ( + ) ";
        String actual = parser.getReversPolishNotation("222+3+(3+4)");

        assertEquals(expected, actual);
    }
}