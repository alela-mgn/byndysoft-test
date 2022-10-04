package com.expression.calculator.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static com.expression.calculator.view.Constants.OPERATION_EXCEPTION_MESSAGE;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class ViewTest {
    private ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(output));
    }

    @Test
    public void printMessage() {
        View view = new View();
        String expected = OPERATION_EXCEPTION_MESSAGE;
        view.printMessage(expected);
        assertEquals(expected, output.toString().trim());
    }

    @AfterEach
    public void cleanUpStreams() {
        System.setOut(null);
    }
}