package com.sportradar.codingexercise;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class MainTest {
    @Test
    public void testMainTest() {
        MainTest helloWorld = new MainTest();
        assertEquals("Hello, World!", helloWorld.getMessage());
    }

    public String getMessage()
    {
        return "Hello, World!";
    }
}
