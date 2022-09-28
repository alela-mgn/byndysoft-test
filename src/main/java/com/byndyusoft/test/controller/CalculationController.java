package com.byndyusoft.test.controller;

import com.byndyusoft.test.service.CalculationService;
import com.byndyusoft.test.service.model.ResultDto;
import com.byndyusoft.test.view.ViewUser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Optional;


public class CalculationController {
    public void inputHandler() throws IOException {
        ViewUser viewUser = new ViewUser();
        CalculationService calculationService = new CalculationService();
        BufferedReader reader =  new BufferedReader(new InputStreamReader(System.in));
           String input = reader.readLine();

        while (!input.equals("quit") && !input.equals(" ")) {
            ResultDto result = calculationService.calculateExpression(input);
            String output = Optional.ofNullable(result.getValue()).orElse(result.getErrorMessage);
            viewUser.outputOnDisplay();

//            String notation = parser.getReversPolishNotation(input);
//            double result = calculate.calculateResult(notation);
//            System.out.println("\nResult: " + result);

            input = reader.readLine();
        }
        System.out.println("Работа программы завершена!");
    }

}
