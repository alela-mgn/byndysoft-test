package com.expression.calculator.view;

import com.expression.calculator.exception.ConsoleInputException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static com.expression.calculator.view.Constants.USER_INPUT_EXCEPTION_MESSAGE;

public class InputHandler {
    private static final BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

    public String getUserInputLine() {
        try {
            return consoleReader.readLine();
        } catch (IOException e) {
            throw new ConsoleInputException(USER_INPUT_EXCEPTION_MESSAGE);
        }
    }
}
