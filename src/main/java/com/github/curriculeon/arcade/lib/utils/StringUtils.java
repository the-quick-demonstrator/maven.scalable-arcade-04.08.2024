package com.github.curriculeon.arcade.lib.utils;

/**
 * Created by leon on 6/22/2020.
 */
public class StringUtils {
    public static String repeatString(String stringToBeRepeated, int numberOfTimesToRepeat) {
        return new String(new char[numberOfTimesToRepeat])
                .replaceAll(String.valueOf(Character.MIN_VALUE), stringToBeRepeated);
    }
}
