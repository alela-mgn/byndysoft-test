package com.byndyusoft.test.service;

import com.byndyusoft.test.service.impl.ParserImpl;
import com.byndyusoft.test.service.model.ResultDto;
import com.byndyusoft.test.validation.Validator;

public class CalculationService {

    private Validator validator = new Validator();
    private ParserImpl parser = new ParserImpl();
    private ResultDto resultDto = new ResultDto();

    public ResultDto calculateExpression(String expression) {
        if (!validator.hasOnlyAllowedChars(expression)) {
            return ResultDto.builder().errorMessage("Выражение может содержать только символы: + / - * ( ) и цифры").build();
        }
        String notation = parser.getReversPolishNotation(expression);
        double result = resultDto.calculateResult(notation);

        return ResultDto.builder().value(result).build();
    }
}
