package com.expression.calculator.service.impl;

import com.expression.calculator.service.CalculationService;
import com.expression.calculator.service.Operation;
import com.expression.calculator.service.model.ResultDto;

import static com.expression.calculator.view.Constants.OPERATION_EXCEPTION_MESSAGE;

public class CalculationServiceImpl implements CalculationService {

    private final Validator validator = new Validator();
    private final ParserImpl parser = new ParserImpl();
    private final Operation operation = new OperationImpl();

    @Override
    public ResultDto calculateExpression(String expression) {
        if (!validator.hasOnlyAllowedChars(expression)) {
            return ResultDto
                    .builder()
                    .errorMessage(OPERATION_EXCEPTION_MESSAGE)
                    .build();
        }
        String prepared = parser.preparingExpression(expression);
        String notation = parser.getReversPolishNotation(prepared).replaceAll("[()]", "");
        double result = operation.calculateResult(notation);

        return ResultDto.builder()
                .value(result)
                .build();
    }
}
