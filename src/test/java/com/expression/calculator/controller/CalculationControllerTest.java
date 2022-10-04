package com.expression.calculator.controller;

import com.expression.calculator.service.impl.CalculationServiceImpl;
import com.expression.calculator.view.InputHandler;
import com.expression.calculator.view.View;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CalculationControllerTest {

    @Mock
    View view;

    @Mock
    CalculationServiceImpl calculationService;

    @Mock
    InputHandler inputHandler;

    @InjectMocks
    CalculationController calculationController;

    @Test
    void runCalc() {
        String test = "2+3";
       // verify(view).printMessage(anyString());
        when(inputHandler.getUserInputLine()).thenReturn(test);
        calculationController.runCalc();
        verify(inputHandler).getUserInputLine();
    }
}