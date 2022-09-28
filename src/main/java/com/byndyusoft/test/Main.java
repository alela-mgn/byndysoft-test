package com.byndyusoft.test;

import com.byndyusoft.test.controller.CalculationController;
import com.byndyusoft.test.view.ViewUser;

import java.io.IOException;
import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {

        CalculationController calculationController = new CalculationController();
        calculationController.inputHandler();
    }
}

