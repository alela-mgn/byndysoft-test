package com.byndyusoft.test.service;

import com.byndyusoft.test.service.impl.ParserImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApplicationTest {

    @Test
    void getReversPolishNotation() {
        ParserImpl parser = new ParserImpl();
        String expected = "222 3 + 3 4 + + ";
        String actual = parser.getReversPolishNotation("222 + 3 + ( 3 + 4 )");
        assertEquals(expected, actual);
    }


}
