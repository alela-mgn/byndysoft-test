package com.expression.calculator.service.impl;

import com.expression.calculator.service.Operation;
import com.expression.calculator.service.model.ResultDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.expression.calculator.view.Constants.OPERATION_EXCEPTION_MESSAGE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CalculationServiceImplTest {

    @Mock
    Validator validator;

    @Mock
    ParserImpl parser;

    @Mock
    Operation operation;

    @InjectMocks
    CalculationServiceImpl service;

    @Test
    public void calculateExpression() {
        String string = "2+3";

        when(parser.getReversPolishNotation(string)).thenReturn("2 3 +");
        String notation = parser.getReversPolishNotation(string).replaceAll("[()]", "");
        operation.calculateResult(notation);

        ResultDto resultDto = service.calculateExpression(string);

        assertNotNull(resultDto);
        assertEquals(5, resultDto.getValue());
    }

    @Test
    public void calculateExpressionException() {
        String string = "fdfdf";
        lenient().when(validator.hasOnlyAllowedChars(string)).thenReturn(false);

        ResultDto resultDto = service.calculateExpression(string);

        assertNotNull(resultDto);
        assertEquals(OPERATION_EXCEPTION_MESSAGE, resultDto.getErrorMessage());
    }
}