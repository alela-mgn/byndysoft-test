package com.expression.calculator.controller;

import com.expression.calculator.service.CalculationService;
import com.expression.calculator.service.model.ResultDto;
import com.expression.calculator.view.InputHandler;
import com.expression.calculator.view.View;

import java.util.Optional;

import static com.expression.calculator.view.Constants.*;

public class CalculationController {

    private final View view;
    private final CalculationService calculationService;
    private final InputHandler inputHandler;

    public CalculationController(View view, CalculationService calculationService, InputHandler inputHandler) {
        this.view = view;
        this.calculationService = calculationService;
        this.inputHandler = inputHandler;
    }

    public void runCalc() {
        view.printMessage(MAIN_MENU_MESSAGE);
        String input = inputHandler.getUserInputLine();

        while (!input.equalsIgnoreCase(QUIT_COMMAND)) {
            ResultDto result = calculationService.calculateExpression(input);
            String output = Optional.ofNullable(result.getValue())
                    .map(String::valueOf)
                    .orElse(result.getErrorMessage());
            view.printMessage(RESULT_MESSAGE + output);
            input = inputHandler.getUserInputLine();
        }

        view.printMessage(EXIT_MESSAGE);
    }
}

