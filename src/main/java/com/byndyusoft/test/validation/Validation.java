package com.byndyusoft.test.validation;


import com.byndyusoft.test.exception.OperatorException;

public class Validation {
    public boolean isNumber(String currentSymbol) {
        try {
            Double.parseDouble(currentSymbol);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isOperator(String operator) {
        if(operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/")) {
            return true;
        } else {
            throw new OperatorException ("Введен не корректный символ! Допустим только +, -, *, /");
        }
    }
}
