package com.byndyusoft.test;

import com.byndyusoft.test.controller.CalculationController;
import com.byndyusoft.test.service.CalculationService;
import com.byndyusoft.test.service.impl.CalculationServiceImpl;
import com.byndyusoft.test.view.InputHandler;
import com.byndyusoft.test.view.View;

public class Main {

    public static void main(String[] args) {

        CalculationService service = new CalculationServiceImpl();
        View view = new View();
        InputHandler inputHandler = new InputHandler();
        CalculationController calculationController = new CalculationController(view, service, inputHandler);

        calculationController.runCalc();
    }
}

