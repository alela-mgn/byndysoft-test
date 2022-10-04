package com.expression.calculator.service;

import com.expression.calculator.service.model.ResultDto;

public interface CalculationService {
    ResultDto calculateExpression(String expression);

}
