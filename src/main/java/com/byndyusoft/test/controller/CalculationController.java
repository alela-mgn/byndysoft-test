package com.byndyusoft.test.controller;

import com.byndyusoft.test.service.CalculationService;
import com.byndyusoft.test.service.model.ResultDto;
import com.byndyusoft.test.view.InputHandler;
import com.byndyusoft.test.view.View;

import java.util.Optional;

import static com.byndyusoft.test.view.Constants.*;

public class CalculationController {

    private View view;
    private CalculationService calculationService;
    private InputHandler inputHandler;

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

