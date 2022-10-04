package com.expression.calculator;

import com.expression.calculator.controller.CalculationController;
import com.expression.calculator.service.CalculationService;
import com.expression.calculator.service.impl.CalculationServiceImpl;
import com.expression.calculator.view.InputHandler;
import com.expression.calculator.view.View;

public class Main {

    public static void main(String[] args) {

        CalculationService service = new CalculationServiceImpl();
        View view = new View();
        InputHandler inputHandler = new InputHandler();
        CalculationController calculationController = new CalculationController(view, service, inputHandler);

        calculationController.runCalc();
    }
}

