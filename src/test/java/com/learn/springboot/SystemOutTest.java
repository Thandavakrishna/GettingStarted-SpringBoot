package com.learn.springboot;

import com.learn.springboot.controller.PerformDivision;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.Bean;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

import com.learn.springboot.controller.PerformDivision;

/**
 * Created by thand on 08-05-2017.
 */
public class SystemOutTest {
    public static ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    public static ByteArrayOutputStream errStream = new ByteArrayOutputStream();

    PerformDivision performDivision = new PerformDivision();

    int[] array15 = new int[16];

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outputStream));
        System.setErr(new PrintStream(errStream));
    }

    @Test
    public void testOutputStream(){
        System.out.print("Output Stream");
        assertEquals("Output Stream", outputStream.toString());
        performDivision.performDivisionByNumbers();
    }

    @Test
    public void divisibleBy15(){
        array15[14] = 14;
        performDivision.performDivisionUsingArrays(array15, 15);
        assertEquals("FizzBuzz", outputStream.toString());
    }

    @Test
    public void testErrorStream(){
        System.err.print("Error Stream");
        assertEquals("Error Stream", errStream.toString());
    }

    @After
    public void closeStreams(){
        System.setOut(null);
        System.setErr(null);
    }


}
