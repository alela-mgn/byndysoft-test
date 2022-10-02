package com.byndyusoft.test.view;

import com.byndyusoft.test.exception.ConsoleInputException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static com.byndyusoft.test.view.Constants.USER_INPUT_EXCEPTION_MESSAGE;

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
