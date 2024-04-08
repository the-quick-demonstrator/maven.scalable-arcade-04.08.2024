package com.github.curriculeon.arcade.lib.utils;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by leon on 6/25/2020.
 * @ATTENTION_TO_STUDENTS - You are advised against modifying this class
 */
public interface InputOutputConsoleInterface {
    void setScanner(Scanner scanner);

    PrintStream getPrintStream();

    Scanner getScanner();

    default void print(String val, Object... args) {
        getPrintStream().format(val, args);
    }


    default void println(String val, Object... vals) {
        print(val + "\n", vals);
    }


    default String getStringInput(String prompt, Object... args) {
        println(prompt, args);
        return getScanner().nextLine();
    }


    default Double getDoubleInput(String prompt, Object... args) {
        String stringInput = getStringInput(prompt, args);
        try {
            Double doubleInput = Double.parseDouble(stringInput);
            return doubleInput;
        } catch (NumberFormatException nfe) {
            println("[ %s ] is an invalid user input!", stringInput);
            println("Try inputting a numeric value!");
            return getDoubleInput(prompt, args);
        }
    }


    default Long getLongInput(String prompt, Object... args) {
        String stringInput = getStringInput(prompt, args);
        try {
            Long longInput = Long.parseLong(stringInput);
            return longInput;
        } catch (NumberFormatException nfe) {
            println("[ %s ] is an invalid user input!", stringInput);
            println("Try inputting an integer value!");
            return getLongInput(prompt, args);
        }
    }


    default Integer getIntegerInput(String prompt, Object... args) {
        return getLongInput(prompt, args).intValue();
    }
}
