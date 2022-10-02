package com.byndyusoft.test.service.impl;


import com.byndyusoft.test.exception.OperatorException;
import com.byndyusoft.test.service.model.Operator;

import java.util.List;
import java.util.stream.Collectors;

public class Validator {

    private static final String ALLOWED_SYMBOLS = "0123456789()+/-* ";

    public boolean isNumber(String currentSymbol) {
        try {
            Double.parseDouble(currentSymbol);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    //    public boolean isOperator(String operator) {
//        if (operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/")) {
//            return true;
//        } else {
////            throw new OperatorException ("Введен не корректный символ! Допустим только +, -, *, /");
//            return false;
//        }
//    }
    public boolean isOperator(String input) {
        try {
            Operator.getOperation(input);
            return true;
        } catch (OperatorException e) {
            return false;
        }
    }


    public boolean hasOnlyAllowedChars(String input) {

        List<String> characters = ALLOWED_SYMBOLS.chars().mapToObj(Character::toString).collect(Collectors.toList());
        return input.chars()
                .mapToObj(Character::toString)
                .allMatch(characters::contains);
    }
}
