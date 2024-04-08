package com.github.curriculeon.arcade.lib.utils;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by leon on 6/25/2020.
 * @ATTENTION_TO_STUDENTS - You are advised against modifying this class
 */
public class InputOutputConsole implements InputOutputConsoleInterface {
    public static final InputOutputConsoleInterface IO_CONSOLE = new InputOutputConsole();
    private Scanner input;
    private final PrintStream output;

    public InputOutputConsole(Scanner input, PrintStream output) {
        this.input = input;
        this.output = output;
    }

    public InputOutputConsole() {
        this(new Scanner(System.in), System.out);
    }

    @Override
    public void setScanner(Scanner scanner) {
        this.input = scanner;
    }

    @Override
    public PrintStream getPrintStream() {
        return output;
    }

    @Override
    public Scanner getScanner() {
        return input;
    }
}
