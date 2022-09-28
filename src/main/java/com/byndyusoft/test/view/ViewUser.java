package com.byndyusoft.test.view;


import com.byndyusoft.test.controller.CalculationController;
import com.byndyusoft.test.service.impl.ParserImpl;

import java.util.Scanner;

public class ViewUser {
    public void outputOnDisplay() {
        System.out.println("Для начала работы калькулятора введите выржание." + "\n"
                + "Вводите каждый символ через пробел" + "\n"
                + "Для завершения работы программы введите quit или нажмите пробел" + "\n"
                + "Введите значение выражения: ");
    }
}
