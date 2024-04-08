package com.github.curriculeon.arcade.lib.utils;

import java.util.*;

/**
 * Created by Leon on 2/4/2017.
 */
public final class RandomDataGenerator {
    private final Random random = new Random();

    /** @return true with the likelihood of specified percentage */
    public boolean createBoolean(double percentage) {
        return percentage > createDouble(0, 100);
    }

    /** @return a random float between the specified min and max numeric range */
    public Double createDouble(double min, double max) {
        return random.nextDouble() * (max - min) + min;
    }

    /** @return a random integer between the specified min and max numeric range */
    public Integer createInteger(int min, int max) {
        return createDouble(min, max).intValue();
    }

    /** @return a random element from the sepcified array */
    public <E> E selectElement(E[] array) {
        return array[createInteger(0, array.length - 1)];
    }
}