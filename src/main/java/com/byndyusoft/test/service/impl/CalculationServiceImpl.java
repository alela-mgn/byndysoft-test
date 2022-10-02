package com.byndyusoft.test.service.impl;

import com.byndyusoft.test.service.CalculationService;
import com.byndyusoft.test.service.Operation;
import com.byndyusoft.test.service.model.ResultDto;

import static com.byndyusoft.test.view.Constants.OPERATION_EXCEPTION_MESSAGE;

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
        String notation = parser.getReversPolishNotation(expression).replaceAll("[//(//)]", "");
        double result = operation.calculateResult(notation);

        return ResultDto.builder()
                .value(result)
                .build();
    }
}
