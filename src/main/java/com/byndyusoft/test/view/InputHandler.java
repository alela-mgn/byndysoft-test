package com.byndyusoft.test.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputHandler {

    public String getUserInputLine() {
        String expression = null;

       try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
           expression = reader.readLine();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
       return expression;
    }
}
