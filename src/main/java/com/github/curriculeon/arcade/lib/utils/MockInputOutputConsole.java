package com.github.curriculeon.arcade.lib.utils;

import java.io.ByteArrayInputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by leon on 6/22/2020.
 * @ATTENTION_TO_STUDENTS - You are advised against modifying this class
 */
public class MockInputOutputConsole extends InputOutputConsole {
    public MockInputOutputConsole(Scanner input, PrintStream output) {
        super(input, output);
    }

    /**
     * Used to inject buffered-string into a console for testing purposes
     */
    public MockInputOutputConsole append(String val, Object... args) {
        StringBuilder bufferedText = new StringBuilder();
        getScanner().forEachRemaining(bufferedText::append);
        return new MockInputOutputConsole(new Scanner(new ByteArrayInputStream(bufferedText
                .append(String.format(val, args))
                .toString() 
                .getBytes())), getPrintStream());
    }
}
