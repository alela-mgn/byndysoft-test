package com.expression.calculator.view;

import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputHandlerTest {
    InputStream sysInBackup = System.in;
    private ByteArrayInputStream input = new ByteArrayInputStream("My string".getBytes());

    @Test
    public void getUserInputLine() {
        System.setIn(input);
        InputHandler inputHandler = new InputHandler();
        assertEquals("My string", inputHandler.getUserInputLine());
        System.setIn(sysInBackup);

    }
}