package com.expression.calculator.service.impl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidatorTest {

    @Test
    public void isNumber() {
        String number = "34";
        String number1 = "asdasdksa";
        Validator validator = new Validator();

        Boolean expected = validator.isNumber(number);
        Boolean expected1 = validator.isNumber(number1);

        assertEquals(expected, true);
        assertEquals(expected1, false);
    }

    @Test
    public void hasOnlyAllowedChars() {
        String chars = "0123456789()+/-* ";
        String chars1 = "fdklfd";
        Validator validator = new Validator();

        Boolean expected = validator.hasOnlyAllowedChars(chars);
        Boolean expected1 = validator.hasOnlyAllowedChars(chars1);

        assertEquals(expected, true);
        assertEquals(expected1, false);
    }
}