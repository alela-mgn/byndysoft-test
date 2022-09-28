package com.byndyusoft.test.validation;


public class Validator {

    private static final String ALLOWED_SYMBOLS = "0123456789()+/-*";



    public boolean isNumber(String currentSymbol) {
        try {
            Double.parseDouble(currentSymbol);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isOperator(String operator) {
        if (operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/")) {
            return true;
        } else {
//            throw new OperatorException ("Введен не корректный символ! Допустим только +, -, *, /");
            return false;
        }
    }
//    public boolean isOperator(String input) {
//        try {
//            Operator.getOperation(input);
//            return true;
//        } catch (OperatorException e){
//        return false;
//    }
//}
//
//    public boolean hasOnlyAllowedChars(String input) {
//        return ALLOWED_SYMBOLS.chars()
//                .mapToObj(Character::toString)
//                .anyMatch(symbol -> symbol.equals(input));
//    }

}
