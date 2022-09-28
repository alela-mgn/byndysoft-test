package com.byndyusoft.test.controller;

import com.byndyusoft.test.service.CalculationService;
import com.byndyusoft.test.service.model.ResultDto;
import com.byndyusoft.test.view.InputHandler;
import com.byndyusoft.test.view.ViewUser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Optional;


public class CalculationController {

    private ViewUser viewUser = new ViewUser();
    private CalculationService calculationService = new CalculationService();
    private InputHandler inputHandler = new InputHandler();
    private String input = inputHandler.getUserInputLine();

    public void runCalc() {
        while (!input.equals("quit") && !input.equals(" ")) {

            ResultDto result = calculationService.calculateExpression(input);
            String output = Optional.ofNullable(result.getValue()).orElse(result.getErrorMessage());
            viewUser.outputOnDisplay();

//            String notation = parser.getReversPolishNotation(input);
//            double result = calculate.calculateResult(notation);
//            System.out.println("\nResult: " + result);

        }
        System.out.println("Работа программы завершена!");
    }
}

