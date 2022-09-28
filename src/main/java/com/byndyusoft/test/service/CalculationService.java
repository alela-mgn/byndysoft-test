package com.byndyusoft.test.service;

import com.byndyusoft.test.service.impl.ParserImpl;
import com.byndyusoft.test.service.model.ResultDto;
import com.byndyusoft.test.validation.Validator;

public class CalculationService {

    Validator validator = new Validator();
    ParserImpl parser = new ParserImpl();

    public ResultDto calculateExpression(String expression) {
        if (!validator.hasOnlyAllowedChars()) {
            return ResultDto.builder().errorMessage("Выражение может содержать только символы: + / - * ( ) и цифры").build();
        }
        String notation = parser.getReversPolishNotation(expression);
        double result = calculate.calculateResult(notatin);

        return ResultDto.builder().value(result).build();
    }
}
