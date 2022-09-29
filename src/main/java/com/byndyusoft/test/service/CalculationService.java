package com.byndyusoft.test.service;


import com.byndyusoft.test.service.model.ResultDto;

public interface CalculationService {
    ResultDto calculateExpression(String expression);

}
